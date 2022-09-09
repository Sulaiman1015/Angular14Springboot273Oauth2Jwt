package fr.sm.asojbackend.init;

import fr.sm.asojbackend.entity.Employee;
import fr.sm.asojbackend.repository.EmplRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitData implements CommandLineRunner {

    private final EmplRepo emplRep;

    @Override
    public void run(String... args) throws Exception {
        addEmpls();

    }



    private void addEmpls() {

        for (int i =1; i <= 5; i++) {
            Employee employee = new Employee();
            employee.setName("empl_"+i);

            if(i%2==0) {
                employee.setGender("male");
            }else {employee.setGender("female");};

            employee.setAge(20+i);
            employee.setCountry("country_"+i);

            if(i==5) {
                employee.setRole("admin");
            }else {employee.setRole("user");};

            emplRep.save(employee);
        }

    }
}
