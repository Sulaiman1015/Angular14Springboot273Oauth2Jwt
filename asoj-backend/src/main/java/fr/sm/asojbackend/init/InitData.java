package fr.sm.asojbackend.init;

import fr.sm.asojbackend.entity.Employee;
import fr.sm.asojbackend.repository.EmpRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class InitData implements CommandLineRunner {

    private final EmpRepo empRepo;

    @Override
    public void run(String... args) throws Exception {
        addEmpls();

    }



    private void addEmpls() {

        for (int i =1; i <= 5; i++) {
            Employee employee = new Employee();
            employee.setName("emp_"+i);

            if(i%2==0) {employee.setGender("male");
            }else {employee.setGender("female");};

            employee.setBirthDay("01-07-2019");
            employee.setTitle("sales"+i);
            employee.setHireDate(new Date());

            empRepo.save(employee);
        }

    }
}
