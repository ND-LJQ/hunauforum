package edu.hunau.controller;

import edu.hunau.entity.Dept;
import edu.hunau.entity.Emp;
import edu.hunau.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mycontroller")
public class MyController {
    @Autowired
    private MyService myService;

    @PostMapping(value = {"/dept/{deptno}"})
    public Dept queryDept(@PathVariable Integer deptno, String name, Integer age) throws  Exception{
        System.out.println("7070 provider");
        System.out.println("name:"+name);
        System.out.println("age:"+age);
        //Thread.sleep(3000);//测试超时时间 人为延长时间测试
        return this.myService.queryDeptByDeptno(deptno);
    }

    //测试Hystrix时  多个no查询合并成一个方法 ，接收多个 no参数
    @GetMapping(value = {"/depts"})
    public List<Dept> queryDepts(@RequestParam(value = "no") List<Integer> nos) throws  Exception{
        return this.myService.queryDeptByNos(nos);
    }

    @GetMapping(value = {"/emps"})
    public List<Emp> queryEmps() throws  Exception{
        Thread.sleep(3000);
        return this.myService.queryAllEmp();
    }

    //@PostMapping(value = {"/emp"})
    //配置了feign httpClient连接池之后 可以使用get请求传递对象 依然使用@RequestBody模式
    @PostMapping(value = {"/emp"})
    public boolean addEmp(@RequestBody  Emp emp) throws Exception{
        return this.myService.addEmp(emp);
    }
}
