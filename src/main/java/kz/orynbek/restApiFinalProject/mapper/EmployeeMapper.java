package kz.orynbek.restApiFinalProject.mapper;

import kz.orynbek.restApiFinalProject.Dto.EmployeeDTO;
import kz.orynbek.restApiFinalProject.entities.Employee;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO mapToDto(Employee employee);
    Employee mapToEntity(EmployeeDTO employeeDTO);
    List<EmployeeDTO>mapToDto(List<Employee>employees);
    List<Employee>mapToEntity(List<EmployeeDTO>employeeDTOS);

}
