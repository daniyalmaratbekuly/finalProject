package kz.orynbek.restApiFinalProject;

import kz.orynbek.restApiFinalProject.Dto.EmployeeDTO;
import kz.orynbek.restApiFinalProject.entities.Department;
import kz.orynbek.restApiFinalProject.entities.Employee;
import kz.orynbek.restApiFinalProject.entities.Leave;
import kz.orynbek.restApiFinalProject.entities.Role;
import kz.orynbek.restApiFinalProject.repositories.DepartmentRepository;
import kz.orynbek.restApiFinalProject.repositories.EmployeeRepository;
import kz.orynbek.restApiFinalProject.repositories.LeaveRepository;
import kz.orynbek.restApiFinalProject.repositories.RoleRepository;
import kz.orynbek.restApiFinalProject.service.DepartmentService;
import kz.orynbek.restApiFinalProject.service.EmployeeService;
import kz.orynbek.restApiFinalProject.service.LeaveService;
import kz.orynbek.restApiFinalProject.service.RoleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestApiFinalProjectApplicationTests {
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private LeaveService leaveService;
	@Autowired
	private LeaveRepository leaveRepository;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleRepository roleRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllDepartmentsTesting() {
		List<Department> departments = departmentService.getAllDepartments();
		assertNotNull(departments);
		List<Department> jbDepartment = departmentRepository.findAll();
		assertEquals(departments.size(), jbDepartment.size());
		for (int i = 0; i < departments.size(); i++) {
			assertEquals(departments.get(i).getId(), jbDepartment.get(i).getId());

		}
	}

	@Test
	public void testCreateDepartment() {
		Department department = new Department();
		department.setName("IT department");
		department.setEmployees("Doni");
		departmentRepository.deleteAll();
		departmentService.createDepartment(department);
		List<Department> departmentList = departmentRepository.findAll();
		Department finalDepartment = departmentList.get(0);
		assertEquals(departmentList.get(0).getId(), finalDepartment.getId());
		assertEquals(department.getName(), finalDepartment.getName());
		assertEquals(department.getEmployees(), finalDepartment.getEmployees());
	}
	@Test
		 public  void testGetDepartmentById() {
			Department department = new Department();
			department.setName("HR");
			department = departmentRepository.save(department);
			Department result = departmentService.getDepartmentById(department.getId());
			assertNotNull(result);
			assertEquals(department.getId(), result.getId());
			assertEquals("HR", result.getName());
		}
@Test
	public void testUpdateDepartment() {
		Department department = new Department();
		department.setName("Finance");
		department = departmentRepository.save(department);
		department.setName("Updated Finance");
		departmentService.updateDepartment(department);
		Department updatedDepartment = departmentRepository.findById(department.getId()).orElse(null);
		assertNotNull(updatedDepartment);
		assertEquals("Updated Finance", updatedDepartment.getName());
	}
	@Test
	public void testDeleteDepartment() {
		Department department = new Department();
		department.setName("Marketing");
		department = departmentRepository.save(department);
		departmentService.deleteDepartment(department.getId());
		assertFalse(departmentRepository.findById(department.getId()).isPresent());
	}
	@Test
	public void testGetAllEmployee() {
		List<EmployeeDTO> employees = employeeService.getAllEmployees();
		assertNotNull(employees);
		List<Employee> employeeList = employeeRepository.findAll();
		assertEquals(employees.size(), employeeList.size());
		for (int i = 0; i < employees.size(); i++) {
			assertEquals(employees.get(i).getId(), employeeList.get(i).getId());
		}
	}
	@Test
	public void testGetEmployeeById() {
				Employee employee = new Employee();
				employee.setFullName("Doni");
				employee = employeeRepository.save(employee);
				EmployeeDTO result = employeeService.getEmployeeById(employee.getId());
				assertNotNull(result);
				assertEquals(employee.getId(), result.getId());
				assertEquals("Doni", result.getFullName());
			}
			@Test
			public void testUpdateEmployee() {
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setFullName("Doni Orynbekov");
				employeeDTO.setPosition("Developer");
				employeeDTO.setPhoneNumber("123-456-7890");
				employeeDTO.setEmail("doni@example.com");
				Employee employee = new Employee();
				employee.setFullName(employeeDTO.getFullName());
				employee.setPosition(employeeDTO.getPosition());
				employee.setPhoneNumber(employeeDTO.getPhoneNumber());
				employee.setEmail(employeeDTO.getEmail());
				employee = employeeRepository.save(employee);
				employeeDTO.setFullName("Daniyal Maratbekuly");
				employeeDTO.setId(employee.getId()); // Не забываем передать ID
				employeeService.updateEmployee(employeeDTO);
				Employee updatedEmployee = employeeRepository.findById(employee.getId()).orElse(null);
				assertNotNull(updatedEmployee);
				assertEquals("Daniyal Maratbekuly", updatedEmployee.getFullName());
			}
			@Test
	public void testDeleteEmployee() {
		Employee employee = new Employee();
		employee.setFullName("Doni");
		employee = employeeRepository.save(employee);
		employeeService.deleteEmployee(employee.getId());
		assertFalse(employeeRepository.findById(employee.getId()).isPresent());
			}
			@Test
			public void testGetAllLeaves() {
		List<Leave> leaves = leaveService.getAllLeaves();
		assertNotNull(leaves);
		List<Leave> leaveList = leaveRepository.findAll();
		assertEquals(leaves.size(), leaveList.size());
		for (int i = 0; i < leaves.size(); i++) {
			assertEquals(leaves.get(i).getId(), leaveList.get(i).getId());
		}
			}
			@Test
	public void testGetLeaveById() {
		Leave leave = new Leave();
		leave.setStatus("approved");
		leave = leaveRepository.save(leave);
		Leave result = leaveService.getLeaveById(leave.getId());
		assertNotNull(result);
		assertEquals("approved", result.getStatus());
		assertEquals("approved", leave.getStatus());
			}
			@Test
	public void testCreatLeave() {
		Leave leave = new Leave();
		leave.setStatus("approved");
		leave.setEmployee("daniyal");
		leaveRepository.deleteAll();
		leaveService.createLeave(leave);
		List<Leave> leaveList = leaveRepository.findAll();
		Leave finalLeave = leaveList.get(0);
		assertEquals(leaveList.get(0).getId(), finalLeave.getId());
		assertEquals(leave.getStatus(), finalLeave.getStatus());
		assertEquals(leave.getEmployee(), finalLeave.getEmployee());
			}



			@Test
			public void testUpdateLeave() {
		Leave leave = new Leave();
		leave.setStatus("approved");
		leave = leaveRepository.save(leave);
		leave.setStatus("not approved");
		leaveService.updateLeave(leave);
		Leave updatedLeave = leaveRepository.findById(leave.getId()).orElse(null);
		assertNotNull(updatedLeave);
		assertEquals("not approved", updatedLeave.getStatus());
			}

			@Test
	public void testDeleteLeave() {
		Leave leave = new Leave();
		leave.setStatus("approved");
		leave = leaveRepository.save(leave);
		leaveService.deleteLeaveById(leave.getId());
		assertFalse(leaveRepository.findById(leave.getId()).isPresent());
			}
			@Test
	public void getAllRoles() {
		List<Role> roles = roleService.getAllRoles();
		assertNotNull(roles);
		List<Role> roleList = roleRepository.findAll();
		assertEquals(roles.size(), roleList.size());
		for (int i = 0; i < roles.size(); i++) {
			assertEquals(roles.get(i).getId(), roleList.get(i).getId());
		}
			}
			@Test
	public void testGetRoleById() {
		Role role = new Role();
		role.setName("middle");
		role.setEmployees("dani");
		roleRepository.deleteAll();
		roleService.createRole(role);
		List<Role> roleList = roleRepository.findAll();
		Role finalRole = roleList.get(0);
		assertEquals(roleList.get(0).getId(), finalRole.getId());
		assertEquals(roleList.get(0).getName(), finalRole.getName());
		assertEquals(roleList.get(0).getEmployees(), finalRole.getEmployees());
			}
			@Test
			public void testUpdateRole() {
		Role role = new Role();
		role.setName("middle");
		role = roleRepository.save(role);
		role.setName("intern");
		roleService.updateRole(role);
		Role updatedRole = roleRepository.findById(role.getId()).orElse(null);
		assertNotNull(updatedRole);
		assertEquals("intern", updatedRole.getName());
			}
			@Test
	public void testDeleteRole() {
		Role role = new Role();
		role.setName("middle");
		role = roleRepository.save(role);
		roleService.deleteRole(role.getId());
		assertFalse(roleRepository.findById(role.getId()).isPresent());
			}
}
