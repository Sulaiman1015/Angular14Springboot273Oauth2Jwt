package fr.sm.asojbackend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "AUTHORITY")
public class Authority {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTHORITY_SEQ")
    @SequenceGenerator(name = "AUTHORITY_SEQ", sequenceName = "AUTHORITY_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "AUTHORITY_NAME", length = 50, nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private List<User> users;
}
