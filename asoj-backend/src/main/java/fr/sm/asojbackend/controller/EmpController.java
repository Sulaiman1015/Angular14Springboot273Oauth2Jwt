package fr.sm.asojbackend.controller;

import fr.sm.asojbackend.entity.Employee;
import fr.sm.asojbackend.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/empls")
@Validated
public class EmpController {

    private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
    private final EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }


    @GetMapping()
    public List<Employee> getEmpls() {
        return empService.getAll();
    }

    //get one by id
    @GetMapping("/{id}")
    public Employee getEmpl(@PathVariable("id") Integer id){
        return empService.getOne(id);
    }


    //delete one by id
    @DeleteMapping("/del/{id}")
    public void deleteEmpl(@PathVariable("id") Integer id) {
        empService.deleteEmployee(id);
    }

    //update
    @PutMapping("/update")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Employee updateEmpl(@RequestBody Employee emp) {
        return empService.updateEmployee(emp);
    }

    //save
    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Employee addEmpl(@Valid @RequestBody Employee emp) {
         return empService.addEmployee(emp);
    }


}
