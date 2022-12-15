package edu.hunau.service.impl;

import edu.hunau.entity.Dept;
import edu.hunau.entity.Emp;
import edu.hunau.service.MyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class MyServiceImpl implements MyService {
    @Override
    public Dept queryDeptByDeptno(Integer deptno) throws Exception {
        Dept  dept = new Dept(deptno,"dept","dept");
        return dept;
    }

    @Override
    public List<Dept> queryDeptByNos(List<Integer> nos) throws Exception {
        List<Dept> deptList = new ArrayList<Dept>();
        for(Integer no : nos){
            Dept  dept = new Dept(no,"dept"+no,"dept"+no);
            deptList.add(dept);
        }
        return deptList;
    }

    @Override
    public List<Emp> queryAllEmp() throws Exception {
        Emp emp1 = new Emp(1234,"emp1","clerk",1234,new Date(),1.0f,1.0f,1234);
        Emp emp2 = new Emp(5678,"emp2","clerk",1234,new Date(),1.0f,1.0f,1234);
        List<Emp> empList = new ArrayList<Emp>();
        empList.add(emp1);
        empList.add(emp2);
        return empList;
    }

    @Override
    public boolean addEmp(Emp emp) throws Exception {
        System.out.println("emp:"+emp);
        return true;
    }
}
