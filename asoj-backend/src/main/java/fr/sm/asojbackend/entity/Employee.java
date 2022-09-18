package fr.sm.asojbackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "EMPLS",uniqueConstraints = {@UniqueConstraint(name = "EMPLOYEE_NAME", columnNames = {"EMP_NAME"})})
public class Employee {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMP_SEQ")
    @SequenceGenerator(name = "EMP_SEQ", sequenceName = "EMP_SEQ", allocationSize = 1)
    private Integer id;

    @Column(name = "EMP_NAME", length = 30, nullable = false)
    private String name;

    @Column(name = "GENDER", length = 10, nullable = false)
    private String gender;

    @Column(name = "BIRTHDAY", length = 30, nullable = false)
    private String birthDay;

    @Column(name = "TITLE", length = 20, nullable = false)
    private String title;

    @Column(name = "HIRE_DATE", updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;

}
