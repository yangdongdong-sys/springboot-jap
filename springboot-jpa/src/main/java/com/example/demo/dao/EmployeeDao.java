package com.example.demo.dao;

import com.example.demo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,String> {
    /**
     * jpa的第一种查询方式 根据命名规范来查询
     * @param name
     * @param password
     * @return
     */
    Employee findByNameAndPassword(String name,String password);

    /**
     * HQL 查询，根据实体进行查询
     * @param name
     * @param password
     * @return
     */
    @Query(value = "select e from Employee e where name =?1 and password=?2")
    Employee findQueryHql(String name,String password);

    /**
     * 原生sql进行查询
     * @param name
     * @param email
     * @return
     */
    @Query(value = "select * from employee  where name =?1 and email=?2",nativeQuery =true)
    Employee findByQuery(String name,String email);

    /**
     * 复杂查询
     * @param spec
     * @param pageable
     * @return
     */
    Page<Employee> findAll(Specification<Employee> spec, Pageable pageable);
}
