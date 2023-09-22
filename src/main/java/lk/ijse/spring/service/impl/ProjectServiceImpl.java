package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ProjectDTO;
import lk.ijse.spring.entity.Project;
import lk.ijse.spring.repo.ProjectRepo;
import lk.ijse.spring.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO) {

        return modelMapper.map(projectRepo.save(modelMapper.map(projectDTO, Project.class)), ProjectDTO.class);
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO) {

        if (!projectRepo.existsById(Integer.valueOf(projectDTO.getProjectId())))
            throw new RuntimeException(projectDTO.getProjectId() + " Project id doesn't exist !");

        return modelMapper.map(projectRepo.save(modelMapper.map(projectDTO, Project.class)), ProjectDTO.class);
    }

    @Override
    public void deleteProjectByPk(int pk) {

        if (!projectRepo.existsById(Integer.valueOf(pk)))
            throw new RuntimeException(pk + " Project id doesn't exist !");

        projectRepo.deleteById(Integer.valueOf(pk));
    }

    @Override
    public List<ProjectDTO> getAllProjects() {

        return modelMapper.map(projectRepo.findAll(), new TypeToken<List<ProjectDTO>>(){}.getType());
    }

    @Override
    public ProjectDTO searchProjectByPk(int pk) {

        if (!projectRepo.existsById(Integer.valueOf(pk)))
            throw new RuntimeException(pk + " Project id doesn't exist !");

        return modelMapper.map(projectRepo.findById(Integer.valueOf(pk)).get(), ProjectDTO.class);
    }
}
