package com.curriculo.curriculo.services;

import com.curriculo.curriculo.dtos.DTOConverter;
import com.curriculo.curriculo.dtos.ResumeDTO;
import com.curriculo.curriculo.entities.Resume;
import com.curriculo.curriculo.repositories.IResumeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService implements IResumeService {
  private final IResumeRepository resumeRepository;

  @Autowired
  public ResumeService(IResumeRepository taskRepository) {
    this.resumeRepository = taskRepository;
  }

  @Override
  public List<Resume> getAllTasks() {
    return resumeRepository.findAll();
  }

  @Override
  public Resume getTaskById(long id) {
    var task = resumeRepository.findById(id);

    if(task.isPresent()){
      return task.get();
    }

    return null;
  }

  @Override
  public Resume createTask(ResumeDTO resumeDTO) {
    var newTask = DTOConverter.convertToResume(resumeDTO);

    return resumeRepository.save(newTask);
  }

  @Override
  public void deleteTask(Long id) {
    var existingTaskOptional = resumeRepository.findById(id);
    var existingTask = existingTaskOptional.get();

    resumeRepository.delete(existingTask);
  }
}
