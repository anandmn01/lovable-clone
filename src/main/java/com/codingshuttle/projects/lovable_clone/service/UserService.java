package com.codingshuttle.projects.lovable_clone.service;

import com.codingshuttle.projects.lovable_clone.dto.auth.UserProfileResonse;

public interface UserService {
    UserProfileResonse getProfile(Long userId);
}
