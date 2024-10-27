package com.harini.Video.Conferencing.user;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "users")
public class User {

    @Id
    private String username;
    private String email;
    private String password;
    private String status;
}
