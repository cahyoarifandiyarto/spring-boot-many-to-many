package com.belajar.springbootmanytomany.repository;

import com.belajar.springbootmanytomany.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

    @Query("SELECT a FROM Tutorial a JOIN FETCH a.tags b")
    List<Tutorial> findAllJoinTag();

    @Query("SELECT a FROM Tutorial a JOIN FETCH a.tags b WHERE a.id = ?1")
    Optional<Tutorial> findJoinTagById(Long id);

}
