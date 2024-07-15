package org.example.taskmanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.example.taskmanagementsystem.model.UserRoles;

import java.util.Set;

@Getter
@Setter
public class AppUserGetDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    private Set<UserRoles> roles;
}
