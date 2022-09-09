package fr.sm.asojbackend.service;

import fr.sm.asojbackend.entity.Employee;
import java.util.List;
import java.util.Optional;

public interface EmplService {
    List<Employee> findEmployees();
    Optional<Employee> findEmployee(Long id);
    String deleteEmpl(Long id);
}
