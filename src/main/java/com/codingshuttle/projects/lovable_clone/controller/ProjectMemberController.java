package com.codingshuttle.projects.lovable_clone.controller;


import com.codingshuttle.projects.lovable_clone.entity.ProjectMember;
import com.codingshuttle.projects.lovable_clone.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

  @GetMapping
 public ResponseEntity<List<ProjectMember>> getProjectMembers(@PathVariable Long projectId){
      Long userId=1L;
      return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId,userId));
  }


}
