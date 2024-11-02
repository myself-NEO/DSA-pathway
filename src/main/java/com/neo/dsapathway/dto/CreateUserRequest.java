package com.neo.dsapathway.dto;

import com.neo.dsapathway.model.Users;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {

    @NotBlank
    private String name;

    @Pattern(regexp = "^\\+?[0-9]{10}$", message = "Invalid phone number")
    private String mobile;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email address")
    private String email;

    private String leetcodeId;
    private String gfgId;
    private String codeforcesId;

    public Users toUser() {
        return Users.builder()
                .addedOn(new Date(System.currentTimeMillis()))
                .name(name)
                .mobile(mobile)
                .email(email)
                .gfgId(gfgId)
                .leetcodeId(leetcodeId)
                .codeforcesId(codeforcesId)
                .build();
    }
}
