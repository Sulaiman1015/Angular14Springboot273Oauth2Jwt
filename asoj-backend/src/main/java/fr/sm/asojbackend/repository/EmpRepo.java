package fr.sm.asojbackend.repository;

import fr.sm.asojbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
