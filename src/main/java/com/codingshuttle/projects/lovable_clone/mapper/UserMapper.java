package com.codingshuttle.projects.lovable_clone.mapper;


import com.codingshuttle.projects.lovable_clone.dto.auth.SignupRequest;
import com.codingshuttle.projects.lovable_clone.dto.auth.UserProfileResonse;
import com.codingshuttle.projects.lovable_clone.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest signupRequest);

    UserProfileResonse toUserProfileresponse(User user);
}
