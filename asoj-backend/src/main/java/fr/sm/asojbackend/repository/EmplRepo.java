package fr.sm.asojbackend.repository;

import fr.sm.asojbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmplRepo extends JpaRepository<Employee, Long> {

}