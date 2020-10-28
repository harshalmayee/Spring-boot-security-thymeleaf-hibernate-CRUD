package com.javaguides.model;

import com.javaguides.constants.ROLE;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "RoleName")
    private String name;

    public Role(String name) {
        this.name = name;
    }


}
