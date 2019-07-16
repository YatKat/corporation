package yat.kat.corporation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yat.kat.corporation.model.Project;
import yat.kat.corporation.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @ResponseBody
    @GetMapping(value = "/")
    public List<Project> getAllProjects(){
        return projectService.getAll();
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id){
        Project project = projectService.getProjectById(id);
        if (project == null) {
            return new ResponseEntity("No Project found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(project, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(value = "/")
    public ResponseEntity<Project> addProject(@RequestBody Project project){
        Project createdProject = projectService.create(project);
        return new ResponseEntity<>(createdProject, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Project> editProjectById(@PathVariable Long id){
        Project oldProject = projectService.getProjectById(id);
        if (null == oldProject) {
            return new ResponseEntity("No Project found for ID " + id, HttpStatus.NOT_FOUND);
        }
        projectService.updateProject(id, oldProject);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable Long id){
        Project project = projectService.getProjectById(id);
        if (null == project) {
            return new ResponseEntity("No Project found for ID " + id, HttpStatus.NOT_FOUND);
        }
        projectService.deleteProjectById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
