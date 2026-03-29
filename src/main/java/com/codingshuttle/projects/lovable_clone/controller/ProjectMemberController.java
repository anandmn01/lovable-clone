package com.codingshuttle.projects.lovable_clone.controller;
import com.codingshuttle.projects.lovable_clone.dto.member.InviteMemberRequest;
import com.codingshuttle.projects.lovable_clone.dto.member.MemberResponse;
import com.codingshuttle.projects.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.codingshuttle.projects.lovable_clone.entity.ProjectMember;
import com.codingshuttle.projects.lovable_clone.service.ProjectMemberService;
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

  @GetMapping
 public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable Long projectId){
      Long userId=1L;
      return ResponseEntity.ok((List<MemberResponse>) projectMemberService.getProjectMembers(projectId,userId));
  }

 @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(

         @PathVariable Long projectId,
         @RequestBody InviteMemberRequest request
         ){
     Long userId=1L;
     return ResponseEntity.status(HttpStatus.CREATED).body(
             (MemberResponse) projectMemberService.inviteMember(projectId ,request,userId));
 }

 @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(

         @PathVariable Long projectId,
         @PathVariable Long memberId,
         @RequestBody UpdateMemberRoleRequest request){
      Long userId=1L;
      return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId,memberId,request,userId));
 }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> removeMember(

            @PathVariable Long projectId,
            @PathVariable Long memberId){
        Long userId=1L;
        projectMemberService.removeProjectMember(projectId,memberId,userId);
        return ResponseEntity.noContent().build();
    }
}
