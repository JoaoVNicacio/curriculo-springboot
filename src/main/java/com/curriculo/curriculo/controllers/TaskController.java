package com.curriculo.curriculo.controllers;

import com.curriculo.curriculo.dtos.ResumeDTO;
import com.curriculo.curriculo.entities.Resume;
import com.curriculo.curriculo.services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/resumes")
public class TaskController {
  @Autowired()
  private final ResumeService taskService;

  public TaskController(ResumeService taskService) {
    this.taskService = taskService;
  }

  @GetMapping()
  public ResponseEntity<List<Resume>> getAllTasks() {
    var tasks = taskService.getAllTasks();

    if(tasks.size() > 0){
      return ResponseEntity.ok(tasks);
    }

    return ResponseEntity.noContent().build();
  }

  @GetMapping("{id}")
  public ResponseEntity<Resume> getTaskById(@PathVariable Long id) {
    var task = taskService.getTaskById(id);

    if(task == null){
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(task);
  }

  @PostMapping()
  public void createTask(@RequestBody ResumeDTO taskDTO) {
    taskService.createTask(taskDTO);
  }

  @PutMapping("{id}/status")
  public ResponseEntity<Resume> completedTask(@PathVariable Long id) {
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> DeleteTask(@PathVariable Long id) {
    taskService.deleteTask(id);

    return ResponseEntity.ok().build();
  }
}
