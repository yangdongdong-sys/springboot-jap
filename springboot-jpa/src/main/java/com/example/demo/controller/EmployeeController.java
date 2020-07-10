package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/emp/save")
    public Employee save(Employee emp){
        return employeeService.saveEmp(emp);
    }
    @PutMapping("/emp")
    public Employee update(Employee emp){
        return employeeService.updateEmp(emp);
    }

    @GetMapping("/emp/findByNameAndPassword")
    public Employee findByNameAndPassword(String name,String password){
        return employeeService.findByNameAndPassword(name,password);
    }
    @GetMapping("/emp/findQueryHql")
    public Employee findQueryHql(String name,String password){
        return employeeService.findQueryHql(name,password);
    }
    @GetMapping("/emp/findByQuery")
    public Employee findByQuery(String name, String email){
        return employeeService.findByQuery(name,email);
    }

    /**
     *
     * @param page 由于page是从0开始的，但是前端是从1 开始的  所以要减一
     * @param size
     * @param id
     * @return
     */
    @GetMapping("/emp/findAll")
    public Page<Employee> findAll(int page, int size, int id){
        page =page -1;
        return employeeService.findAll(page,size, id);
    }
    /**
     * 调用jpa封装好的 查询所有方法
     * @return
     */
    @GetMapping("/emp/all")
    public List<Employee> findJpaAll(){
        return employeeService.findAll();
    }

    @DeleteMapping("/emp/delete")
    public void deleteEmp(String name,String password){
        employeeService.deleteEmp(employeeService.findByNameAndPassword(name, password));
    }

    @RequestMapping("/emp")
    public List<Employee> getAllEmp(){
        return employeeService.findAll();
    }
}
