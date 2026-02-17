package com.codingshuttle.projects.lovable_clone.dto.project;

import com.codingshuttle.projects.lovable_clone.dto.auth.UserProfileResonse;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResonse owner)

{

}
