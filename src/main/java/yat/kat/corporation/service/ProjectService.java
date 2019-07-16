package yat.kat.corporation.service;

import yat.kat.corporation.model.Employee;
import yat.kat.corporation.model.Project;

import java.util.List;

public interface ProjectService {
    Project create(Project project);
    Project getProjectById(Long id);
    List<Project> getAll();
    void updateProject(Long id, Project newProject);
    void deleteProjectById(Long id);
    void addEmployeeToProject(Project project, Employee employee);
    void deleteEmployeeFromProject(Long projectId, Long employeeId);
}
