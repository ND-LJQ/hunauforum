package edu.hunau.service;



import edu.hunau.entity.Dept;
import edu.hunau.entity.Emp;


import java.util.List;

public interface MyService {
    public Dept queryDeptByDeptno(Integer deptno) throws Exception;
    public List<Dept> queryDeptByNos(List<Integer> nos) throws  Exception;
    public List<Emp> queryAllEmp() throws Exception;
    public boolean addEmp(Emp emp) throws Exception;

}
