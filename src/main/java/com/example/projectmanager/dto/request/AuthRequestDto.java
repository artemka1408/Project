package com.example.projectmanager.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthRequestDto {

    @NotNull
    @Pattern(regexp = "[A-Za-z0-9]{3,100}")
    @Size(min = 3, max = 100)
    private String login;

    @NotNull
    @Size(min = 7, max = 64)
    private String password;
}
