package edu.hunau.service.impl;


import edu.hunau.entity.Company;
import edu.hunau.entity.Dept;
import edu.hunau.entity.Emp;
import edu.hunau.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//Consumer通过Service层 http远程访问Provider的Controller
@Service
public class CompanyServiceImpl implements CompanyService {
    //HTTP访问时 用于传递请求参数的对象
    private HttpEntity<MultiValueMap<String,Object>> httpEntity;

    //1 //2
    @Autowired
    private RestTemplate restTemplate;
    //1
    @Autowired
    private DiscoveryClient discoveryClient;
    //2
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    public Company getCompany(Integer deptno) {
        //定义请求需要传递的参数对象
        MultiValueMap<String,Object> params = new LinkedMultiValueMap<String,Object>();
        params.add("name","jack");
        params.add("age",20);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        this.httpEntity = new HttpEntity<MultiValueMap<String,Object>>(params,httpHeaders);



        Company company = new Company();
        company.setName("MyCompany");
//        company.setDept(this.getDeptByDiscoveryClient(deptno));
//        company.setEmpList(this.getEmpsByDiscoveryClient());

//        company.setDept(this.getDeptByLoadBalancerClient(deptno));
//        company.setEmpList(this.getEmpsByByLoadBalancerClient());

        company.setDept(this.getDeptByLoadBalancerAnnotation(deptno));
        company.setEmpList(this.getEmpsByLoadBalancerAnnotation());
        return company;
    }

    //1 discoveryClient 调用provider
    private Dept getDeptByDiscoveryClient(Integer deptno){
        //获取服务列表
        List<String> serviceIDS = this.discoveryClient.getServices();
        if(CollectionUtils.isEmpty(serviceIDS)){
            return null;
        }
        //根据服务应用名称定位服务
        List<ServiceInstance> serviceInstances =
                discoveryClient.getInstances("serviceProvider");
        if(CollectionUtils.isEmpty(serviceInstances)){
            return null;
        }
        //获取服务URL
        ServiceInstance  serviceInstance = serviceInstances.get(0);
        StringBuffer sb = new StringBuffer();
        sb.append("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/mycontroller/dept/"+deptno);
        String url = sb.toString();

        //获取数据
        ResponseEntity<Dept> responseEntity =
                this.restTemplate.exchange(url, HttpMethod.POST, httpEntity,
                        new ParameterizedTypeReference<Dept>() {});
        return responseEntity.getBody();
    }


    private List<Emp> getEmpsByDiscoveryClient(){
        //获取服务列表
        List<String> serviceIDS = this.discoveryClient.getServices();
        if(CollectionUtils.isEmpty(serviceIDS)){
            return null;
        }

        //根据服务应用名称定位服务
        List<ServiceInstance> serviceInstances =
                discoveryClient.getInstances("serviceProvider");
        if(CollectionUtils.isEmpty(serviceInstances)){
            return null;
        }
        //获取服务URL
        ServiceInstance  serviceInstance = serviceInstances.get(0);
        StringBuffer sb = new StringBuffer();
        sb.append("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/mycontroller/emps");
        String url = sb.toString();
        //获取数据
        ResponseEntity<List<Emp>> responseEntity =
                this.restTemplate.exchange(url, HttpMethod.GET, null
                        , new ParameterizedTypeReference<List<Emp>>() {});

        return responseEntity.getBody();//将Provider的Controller传递来的JSON格式数据再次转回Object

    }

    //2 loadBalancerClient
    public Dept getDeptByLoadBalancerClient(Integer deptno){
        //定位服务
        ServiceInstance si = this.loadBalancerClient.choose("serviceProvider");
        if(si==null){
            return null;
        }
        //URL
        StringBuffer sb = new StringBuffer();
        sb.append("http://"+si.getHost()+":"+si.getPort()+"/mycontroller/dept/"+deptno);
        String url = sb.toString();
        //获取数据
        ResponseEntity<Dept> responseEntity =
                this.restTemplate.exchange(url, HttpMethod.POST, httpEntity,
                        new ParameterizedTypeReference<Dept>() {});
        return responseEntity.getBody();
    }
    public List<Emp> getEmpsByByLoadBalancerClient(){
        //定位服务
        ServiceInstance si = this.loadBalancerClient.choose("serviceProvider");
        if(si==null){
            return null;
        }
        //URL
        StringBuffer sb = new StringBuffer();
        sb.append("http://"+si.getHost()+":"+si.getPort()+"/mycontroller/emps");
        String url = sb.toString();
        //获取数据
        ResponseEntity<List<Emp>> responseEntity =
                this.restTemplate.exchange(url, HttpMethod.GET, null
                        , new ParameterizedTypeReference<List<Emp>>() {});

        return responseEntity.getBody();
    }

    //3 LoadBalancerAnnotaion
    public Dept getDeptByLoadBalancerAnnotation(Integer deptno){
        ResponseEntity<Dept> responseEntity =
                this.restTemplate.exchange(
                        "http://serviceProvider/mycontroller/dept/"+deptno,
                        HttpMethod.POST,
                        httpEntity,
                        new ParameterizedTypeReference<Dept>() {}
                );
        return responseEntity.getBody();
    }
    public List<Emp> getEmpsByLoadBalancerAnnotation(){
        ResponseEntity<List<Emp>> responseEntity =
                this.restTemplate.exchange(
                        "http://serviceProvider/mycontroller/emps",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Emp>>() {}
                );
        return responseEntity.getBody();
    }
}
