package com.neo.dsapathway.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.neo.dsapathway.model.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String topic;

    private String concept;
    private String question;
    private String link;
    private String note;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @CreationTimestamp
    private Date addedOn;

    @UpdateTimestamp
    private Date updatedOn;
}
