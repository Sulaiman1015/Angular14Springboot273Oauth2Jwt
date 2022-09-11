package fr.sm.asojbackend.service;

import fr.sm.asojbackend.entity.Employee;
import fr.sm.asojbackend.repository.EmplRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmplService {

    private final  EmplRepo emplRep;

    @Autowired
    public EmplService(EmplRepo emplRep) {
        this.emplRep = emplRep;
    }

    public List<Employee> getAll() {
        return emplRep.findAll();
    }

    public Employee getOne(Integer id) {
        return emplRep.findById(id).orElseThrow(()->new IllegalStateException("No such employee"));
    }

    public void deleteEmployee(Integer id) {
        Employee emp = getOne(id);
        if (emp == null) {
            throw new IllegalStateException("Employee not found");
        }else{
            emplRep.deleteById(id);
        }

    }

    public Employee addEmployee(Employee employee) {
        Employee emp = new Employee();
        emp.setName(employee.getName());
        emp.setGender(employee.getGender());
        emp.setAge(employee.getAge());
        emp.setCountry(employee.getCountry());
        emp.setRole(employee.getRole());
        return emplRep.save(employee);
    }

    public Employee updateEmployee(Employee emp) {
        /*Employee emp = getOne(employee.getId());
        emp.setName(emp.getName());
        emp.setGender(emp.getGender());
        emp.setAge(emp.getAge());
        emp.setCountry(emp.getCountry());
        emp.setRole(emp.getRole());*/
        return emplRep.save(emp);

    }
/**********************************************************/
    /*public Employee updateEmployee(Integer id) {
        Employee emp = getOne(id);
        emp.setName(emp.getName());
        emp.setGender(emp.getGender());
        emp.setAge(emp.getAge());
        emp.setCountry(emp.getCountry());
        emp.setRole(emp.getRole());
        return emplRep.save(emp);
    }*/



}
