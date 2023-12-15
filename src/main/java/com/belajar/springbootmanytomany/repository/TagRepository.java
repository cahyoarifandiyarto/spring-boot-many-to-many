package com.belajar.springbootmanytomany.repository;

import com.belajar.springbootmanytomany.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
