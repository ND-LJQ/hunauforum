package edu.hunau.controller;

import edu.hunau.entity.Company;
import edu.hunau.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping(value = {"/getCompany/{deptno}"})
    public Company getCompany(@PathVariable Integer deptno) throws  Exception{
        return this.companyService.getCompany(deptno);
    }



}
