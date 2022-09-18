package fr.sm.asojbackend.service;

import fr.sm.asojbackend.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmpServiceTest {

    private final Employee emp = new Employee();
    private final EmpService empService;

    @Autowired
    EmpServiceTest(EmpService empService) {
        this.empService = empService;
    }

   /* @BeforeEach
    void setUp() {
        log.info("setUp");
    }

    @AfterEach
    void tearDown() {
        log.info("tearDown");
    }*/

    @Test
    @Order(1)
    void getAll() {
        List<Employee> employees = empService.getAll();
        assertThat(employees).hasSize(5);
    }

    @Test
    @Order(2)
    void getOne() {
        Employee emp = empService.getOne(2);
        assertThat(emp.getName()).isEqualTo("empl_2");
    }

    @Test
    @Order(3)
    void deleteEmployee() {
        empService.deleteEmployee(2);
        assertThat(empService.getAll()).hasSize(4);
    }

    @Test
    @Order(4)
    void addEmployee() {
        emp.setName("Sulaiman");
        emp.setBirthDay("01-07-2019");
        emp.setGender("Male");
        emp.setTitle("Manager");
        emp.setHireDate(new Date());
        empService.addEmployee(emp);
        Employee newEmp = empService.getOne(emp.getId());
        assertThat(newEmp).isNotNull();
    }

    @Test
    @Order(5)
    void updateEmployee() {
        Employee emp = empService.getOne(5);
        emp.setBirthDay("01-07-2019");
        assertThat(emp.getBirthDay()).isEqualTo("01-07-2019");
    }
}