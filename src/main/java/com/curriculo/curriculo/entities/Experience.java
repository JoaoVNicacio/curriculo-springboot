package com.curriculo.curriculo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name= "Experiences")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String title;

    @Column(columnDefinition = "text")
    private String institution;

    @Column(columnDefinition = "text")
    private String experienceType;

    @Column(columnDefinition = "text")
    private String extraInfo;

    @Column()
    private boolean isCurrent;

    @Column()
    private Date startedIn;

    @Column()
    private Date endedIn;

    @ManyToOne()
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
