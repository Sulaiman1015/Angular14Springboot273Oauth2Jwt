package fr.sm.asojbackend.service;

import fr.sm.asojbackend.entity.Employee;
import fr.sm.asojbackend.repository.EmplRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class EmplServiceImpl implements EmplService {

    @Resource
    private EmplRepo emplRepo;

    @Override
    public List<Employee> findEmployees() {
        return emplRepo.findAll();
    }

    @Override
    public Optional<Employee> findEmployee(Long id) {
        return emplRepo.findById(id);
    }

    @Override
    @Transactional
    public String deleteEmpl(Long id) {
        emplRepo.deleteById(id);
        return "/empls";
    }


}
