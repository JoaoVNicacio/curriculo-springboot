package com.curriculo.curriculo.repositories;

import com.curriculo.curriculo.entities.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface IResumeRepository extends JpaRepository<Resume, Long> {
  List<Resume> findAll();
  Resume save(Resume task);
  Optional<Resume> findById(Long id);
  void delete(Resume task);
}
