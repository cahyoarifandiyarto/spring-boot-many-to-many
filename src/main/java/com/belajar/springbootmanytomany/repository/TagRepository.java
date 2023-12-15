package com.belajar.springbootmanytomany.repository;

import com.belajar.springbootmanytomany.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("SELECT a FROM Tag a JOIN FETCH a.tutorials b")
    List<Tag> findAllJoinTutorial();

}
