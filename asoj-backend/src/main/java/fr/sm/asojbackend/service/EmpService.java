package fr.sm.asojbackend.service;

import fr.sm.asojbackend.entity.Employee;
import fr.sm.asojbackend.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpService {

    private final EmpRepo empRepo;

    @Autowired
    public EmpService(EmpRepo empRepo) {
        this.empRepo = empRepo;
    }

    public List<Employee> getAll() {
        return empRepo.findAll();
    }

    public Employee getOne(Integer id) {
        return empRepo.findById(id).orElseThrow(()->new IllegalStateException("No such employee"));
    }

    public void deleteEmployee(Integer id) {
        Employee emp = getOne(id);
        if (emp == null) {
            throw new IllegalStateException("Employee not found");
        }else{
            empRepo.deleteById(id);
        }

    }

    public Employee addEmployee(Employee employee) {
        Employee emp = new Employee();
        emp.setName(employee.getName());
        emp.setGender(employee.getGender());
        emp.setTitle(employee.getTitle());
        emp.setBirthDay(employee.getBirthDay());
        emp.setHireDate(employee.getHireDate());
        return empRepo.save(employee);
    }

    public Employee updateEmployee(Employee emp) {
        /*Employee emp = getOne(employee.getId());
        emp.setName(emp.getName());
        emp.setGender(emp.getGender());
        emp.setAge(emp.getAge());
        emp.setCountry(emp.getCountry());
        emp.setRole(emp.getRole());*/
        return empRepo.save(emp);

    }
/**********************************************************/
    /*public Employee updateEmployee(Integer id) {
        Employee emp = getOne(id);
        emp.setName(emp.getName());
        emp.setGender(emp.getGender());
        emp.setAge(emp.getAge());
        emp.setCountry(emp.getCountry());
        emp.setRole(emp.getRole());
        return empRepo.save(emp);
    }*/



}
