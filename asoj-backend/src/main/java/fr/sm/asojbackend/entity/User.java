package fr.sm.asojbackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "USERS_USERNAME", columnNames = {"USERNAME"}),
        @UniqueConstraint(name = "USERS_EMAIL", columnNames = {"EMAIL"})})
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ", allocationSize = 1)
    private Integer id;

    @Column(name = "USERNAME", length = 50, nullable = false)
    @NotNull
    @Size(min = 4, max = 50)
    private String username;

    @Column(name = "PASSWORD", length = 100, nullable = false)
    @NotNull
    @Size(min = 4, max = 100)
    private String password;

    @Column(name = "EMAIL", length = 50, nullable = false)
    @NotNull
    @Size(min = 4, max = 50)
    private String email;

    @Column(name = "ENABLED")
    @NotNull
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_AUTHORITY", joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_USER_ID"))},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_AUTHORITY_ID"))})
    private List<Authority> authorities;
}
