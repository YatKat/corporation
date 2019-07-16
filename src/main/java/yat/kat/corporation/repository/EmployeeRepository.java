package yat.kat.corporation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yat.kat.corporation.model.Employee;
import yat.kat.corporation.model.Project;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> getEmployeesByProject(Project project);
}
