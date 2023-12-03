package com.curriculo.curriculo.services;

import com.curriculo.curriculo.dtos.ResumeDTO;
import com.curriculo.curriculo.entities.Resume;
import java.util.List;

public interface IResumeService {
  List<Resume> getAllTasks();
  Resume getTaskById(long id);
  Resume createTask(ResumeDTO resumeDTO);
  void deleteTask(Long id);
}
