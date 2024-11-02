package com.neo.dsapathway.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @Pattern(regexp = "^\\+?[0-9]{10}$", message = "Invalid phone number")
    private String mobile;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email address")
    private String email;

    private String leetcodeId;
    private String gfgId;
    private String codeforcesId;

    // One-to-many relationship with Course
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonIgnoreProperties("user")  // Prevents recursion when serializing to JSON
//    private List<Course> courses;

    @CreationTimestamp
    private Date addedOn;

    @UpdateTimestamp
    private Date updatedOn;
}
