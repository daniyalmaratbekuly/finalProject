package kz.orynbek.restApiFinalProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String position;
    private String department;
    private String phoneNumber;
    private String email;
    @ManyToOne(fetch = FetchType.EAGER)
    private Department department1;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Task>tasks;
    private String departmentId;
}
