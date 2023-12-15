package com.belajar.springbootmanytomany.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

@Entity
@Table(name = "tutorials")
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutorials_id_seq")
    @SequenceGenerator(name = "tutorials_id_seq", sequenceName = "tutorials_id_seq", allocationSize = 1)
    private Long id;

    private String title;

    private String description;

    private Boolean published;

    @ManyToMany
    @JoinTable(
            name = "tutorial_tags",
            joinColumns = @JoinColumn(name = "tutorial_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

}
