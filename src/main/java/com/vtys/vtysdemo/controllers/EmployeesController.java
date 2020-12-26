package com.vtys.vtysdemo.controllers;

import com.vtys.vtysdemo.models.Employee;
import com.vtys.vtysdemo.repositories.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeesController {
    private final EmployeeRepository _employeeRepository;

    public EmployeesController(EmployeeRepository employeeRepository) {
        _employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> list(){
        return _employeeRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public  Employee get(@PathVariable Long id){
        return _employeeRepository.getOne(id);
    }

    @PostMapping
    public Employee create(@RequestBody final Employee employee){
        return _employeeRepository.saveAndFlush(employee);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        _employeeRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Employee update(@PathVariable Long id, @RequestBody Employee employee){
        Employee model = _employeeRepository.getOne(id);
        BeanUtils.copyProperties(employee, model, "id");
        return _employeeRepository.saveAndFlush(employee);
    }


}
