package com.FirstProject.Job.Application.company.Impl;

import com.FirstProject.Job.Application.company.Company;
import com.FirstProject.Job.Application.company.CompanyRepository;
import com.FirstProject.Job.Application.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class serviceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }
}
