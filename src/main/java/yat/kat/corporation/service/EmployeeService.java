package yat.kat.corporation.service;

import yat.kat.corporation.model.Employee;
import yat.kat.corporation.model.Project;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);
    Employee getById(Long id);
    void delete(Long id);
    void update(Long id, Employee employee);
    List<Employee> getEmployeeByProject(Project project);
    List<Employee> getAllEmployees();
}
