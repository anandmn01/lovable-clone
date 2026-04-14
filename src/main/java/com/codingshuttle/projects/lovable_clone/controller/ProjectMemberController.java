package com.codingshuttle.projects.lovable_clone.controller;
import com.codingshuttle.projects.lovable_clone.dto.member.InviteMemberRequest;
import com.codingshuttle.projects.lovable_clone.dto.member.MemberResponse;
import com.codingshuttle.projects.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.codingshuttle.projects.lovable_clone.entity.ProjectMember;
import com.codingshuttle.projects.lovable_clone.security.AuthUtil;
import com.codingshuttle.projects.lovable_clone.service.ProjectMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;
   private final AuthUtil authUtil;

  @GetMapping
 public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable Long projectId){
      Long userId = authUtil.getCurrentUserId();
      return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId));
  }

 @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(

         @PathVariable Long projectId,
         @RequestBody @Valid InviteMemberRequest request
         ){
     Long userId = authUtil.getCurrentUserId();
     return ResponseEntity.status(HttpStatus.CREATED).body(
             (MemberResponse) projectMemberService.inviteMember(projectId ,request));
 }

 @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(

         @PathVariable Long projectId,
         @PathVariable Long memberId,
         @RequestBody @Valid UpdateMemberRoleRequest request){
     Long userId = authUtil.getCurrentUserId();
      return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId,memberId,request));
 }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> removeMember(

            @PathVariable Long projectId,
            @PathVariable Long memberId){
        Long userId = authUtil.getCurrentUserId();
        projectMemberService.removeProjectMember(projectId,memberId,userId);
        return ResponseEntity.noContent().build();
    }
}
