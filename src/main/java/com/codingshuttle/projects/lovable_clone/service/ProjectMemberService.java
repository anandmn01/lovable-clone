package com.codingshuttle.projects.lovable_clone.service;

import com.codingshuttle.projects.lovable_clone.dto.member.InviteMemberRequest;
import com.codingshuttle.projects.lovable_clone.dto.member.MemberResponse;
import org.hibernate.mapping.List;

public class ProjectMemberService {

    public List getProjectMembers(Long projectId, Long userId) {
    }

    public MemberResponse inviteMember() {
    }

    public Object inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
    }

    public MemberResponse updateMemberRole(Long projectId, Long memberId, InviteMemberRequest request, Long userId) {
    }

    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
    }
}
