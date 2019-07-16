package yat.kat.corporation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yat.kat.corporation.model.Employee;
import yat.kat.corporation.model.Project;
import yat.kat.corporation.repository.ProjectRepository;
import yat.kat.corporation.service.ProjectService;

import java.util.List;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project create(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    @Transactional
    public void updateProject(Long id, Project newProject) {
        Project oldProject = projectRepository.findById(id).get();
        newProject.setId(oldProject.getId());
        projectRepository.delete(oldProject);
        projectRepository.save(newProject);
    }

    @Override
    @Transactional
    public void deleteProjectById(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void addEmployeeToProject(Project project, Employee newEmployee) {
        project.getEmployeeList().add(newEmployee);
        updateProject(project.getId(), project);
    }

    @Override
    @Transactional
    public void deleteEmployeeFromProject(Long projectId, Long employeeId) {
        Project oldProject = projectRepository.findById(projectId).get();
        List<Employee> emploeeToDelete = oldProject.getEmployeeList();
        //TODO realize eployee delete
    }
}
