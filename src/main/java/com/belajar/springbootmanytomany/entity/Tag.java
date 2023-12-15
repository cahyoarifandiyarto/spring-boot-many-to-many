package com.belajar.springbootmanytomany.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

@Entity
@Table(name = "tags")
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tags_id_seq")
    @SequenceGenerator(name = "tags_id_seq", sequenceName = "tags_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Tutorial> tutorials;

}
