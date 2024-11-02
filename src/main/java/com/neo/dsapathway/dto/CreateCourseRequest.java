package com.neo.dsapathway.dto;

import com.neo.dsapathway.model.Course;
import com.neo.dsapathway.model.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCourseRequest {

    @NotBlank(message = "Topic cannot be blank")
    private String topic;

    private String concept;
    private String question;
    private String link;
    private String note;

    private Integer userId;  // Reference to the User entity by ID

    @Enumerated(value = EnumType.STRING)
    private Status status;

    public Course toCourse() {
        return Course.builder()
                .topic(topic)
                .addedOn(new Date(System.currentTimeMillis()))
                .concept(concept)
                .link(link)
                .note(note)
                .userId(userId)
                .question(question)
                .status(status)
                .build();
    }
}
