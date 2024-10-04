package kz.orynbek.restApiFinalProject.Dto;

import kz.orynbek.restApiFinalProject.entities.Department;
import kz.orynbek.restApiFinalProject.entities.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private Long id;
    private String fullName;
    private String position;
    private String department;
    private String phoneNumber;
    private String email;
    private Department department1;
    private List<Task>tasks;
}
