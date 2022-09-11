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

import java.util.List;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmplServiceTest {

    private final Employee emp = new Employee();
    private final EmplService emplService;

    @Autowired
    EmplServiceTest(EmplService emplService) {
        this.emplService = emplService;
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
        List<Employee> employees = emplService.getAll();
        assertThat(employees).hasSize(5);
    }

    @Test
    @Order(2)
    void getOne() {
        Employee emp = emplService.getOne(2);
        assertThat(emp.getName()).isEqualTo("empl_2");
    }

    @Test
    @Order(3)
    void deleteEmployee() {
        emplService.deleteEmployee(2);
        assertThat(emplService.getAll()).hasSize(4);
    }

    @Test
    @Order(4)
    void addEmployee() {
        emp.setName("Sulaiman");
        emp.setAge(45);
        emp.setGender("Male");
        emp.setRole("Administrator");
        emp.setCountry("United States");
        emplService.addEmployee(emp);
        Employee newEmp = emplService.getOne(emp.getId());
        assertThat(newEmp).isNotNull();
    }

    @Test
    @Order(5)
    void updateEmployee() {
        Employee emp = emplService.getOne(5);
        emp.setAge(45);
        assertThat(emp.getAge()).isEqualTo(45);
    }
}