package yat.kat.corporation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yat.kat.corporation.model.Employee;
import yat.kat.corporation.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @GetMapping(value = "/")
    public List<Employee> getAll(){
        return employeeService.getAllEmployees();
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.getById(id);
        if (employee == null) {
            return new ResponseEntity("No Employee found by ID " + id, HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(value = "/")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee newEmployee){
        Employee savedEmployee = employeeService.create(newEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> editEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.getById(id);
        if (null == employee) {
            return new ResponseEntity("No Employee found by ID " + id, HttpStatus.NOT_FOUND);
        }
        employeeService.update(id, employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Employee> deleteEmplloyee(@PathVariable Long id){
        Employee employee = employeeService.getById(id);
        if (null == employee) {
            return new ResponseEntity("No Employee found by ID " + id, HttpStatus.NOT_FOUND);
        }
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
