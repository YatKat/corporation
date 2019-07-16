package yat.kat.corporation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yat.kat.corporation.model.Employee;
import yat.kat.corporation.model.Project;
import yat.kat.corporation.repository.EmployeeRepository;
import yat.kat.corporation.service.EmployeeService;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, Employee employee) {
        Employee oldEmployee = employeeRepository.findById(id).get();
        employee.setId(oldEmployee.getId());
        employeeRepository.delete(oldEmployee);
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeeByProject(Project project) {
        return employeeRepository.getEmployeesByProject(project);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
