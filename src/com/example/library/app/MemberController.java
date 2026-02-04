package com.example.library.app;

import java.util.List;

public class MemberController {

    private final Repository<Member> memberRepo;

    public MemberController(Repository<Member> memberRepo) {
        this.memberRepo = memberRepo;
    }

    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

    public Member getMember(String id) {
        return memberRepo.findById(id);
    }
}

