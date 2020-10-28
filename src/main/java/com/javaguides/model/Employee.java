package com.javaguides.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;

    @Column(name = "Emp_Name")
    private String empName;

    @Column(name = "Emp_Address")
    private String empAddress;

    @Column(name = "Emp_EmailId")
    private String empEmailId;
}
