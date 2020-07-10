package com.example.demo.service.impl;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.Predicate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee findByNameAndPassword(String name, String password) {
        return employeeDao.findByNameAndPassword(name, password);
    }

    @Override
    public Employee findQueryHql(String name, String password) {
        return employeeDao.findQueryHql(name, password);
    }

    @Override
    public Employee findByQuery(String name, String email) {
        return employeeDao.findByQuery(name, email);
    }

    @Override
    public Page<Employee> findAll(int page,int size,int id) {
        Pageable pageable =new PageRequest(page,size,new Sort(Sort.Direction.DESC,"id"));
        return employeeDao.findAll((Specification<Employee>) (root, query, cb) -> {
            Predicate p1 = cb.like(root.get("id").as(String.class),"%"+id+"%");
            return cb.and(p1);
        },pageable);
    }

    @Override
    public Employee saveEmp(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Employee updateEmp(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public void deleteEmp(Employee employee){
         employeeDao.delete(employee);
    }
}
