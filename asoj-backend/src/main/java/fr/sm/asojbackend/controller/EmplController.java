package fr.sm.asojbackend.controller;

import fr.sm.asojbackend.entity.Employee;
import fr.sm.asojbackend.service.EmplService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping
public class EmplController {

    @Resource
    private EmplService emplService;

    @GetMapping("/empls")
    public List<Employee> getAllEmpls() {
        return emplService.findEmployees();
    }


    @GetMapping("/empls/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id) {
        return emplService.findEmployee(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteEmp(@PathVariable("id") Long id) {
        //Employee emp = emplService.findEmployee(id).orElseThrow(ResourceNotFoundException::new);
        emplService.deleteEmpl(id);
        return "/empls";
    }



}
