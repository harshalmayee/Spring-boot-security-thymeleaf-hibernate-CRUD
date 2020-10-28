package com.javaguides.model;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name="users",uniqueConstraints = @UniqueConstraint(columnNames = "emailId"))
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "EmailId")
    private String emailId;

    @Column(name = "Password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
               name = "users_roles",
               joinColumns = @JoinColumn(
                       name = "user_id",referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(
                       name = "role_id",referencedColumnName = "id"))
    private Collection<Role> roles;

    public User(String firstName, String lastName, String emailId, String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
        this.roles = roles;
    }
}
