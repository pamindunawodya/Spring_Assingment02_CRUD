package lk.ijse.spring.api;

import lk.ijse.spring.dto.ProjectDTO;
import lk.ijse.spring.service.ProjectService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/project")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil getAllProjects(){

        return new ResponseUtil(200, "Get", projectService.getAllProjects());
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil saveProject(@RequestBody ProjectDTO projectDTO){

        return new ResponseUtil(200, "save", projectService.saveProject(projectDTO));
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil updateProject(@RequestBody ProjectDTO projectDTO){

        return new ResponseUtil(200, "update", projectService.updateProject(projectDTO));
    }

    @DeleteMapping(params = {"projectId"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil deleteProject(@RequestParam int projectId){

        projectService.deleteProjectByPk(projectId);
        return new ResponseUtil(200, "delete", null);
    }

    @GetMapping(path = {"/{projectId}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil searchProjectByProjectId(@PathVariable int projectId){

        return new ResponseUtil(200, "search", projectService.searchProjectByPk(projectId));
    }
}
