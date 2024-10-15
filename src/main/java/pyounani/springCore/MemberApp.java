package pyounani.springCore;

import pyounani.springCore.member.Grade;
import pyounani.springCore.member.Member;
import pyounani.springCore.member.MemberService;
import pyounani.springCore.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member);
        System.out.println("find member = " + findMember);

    }
}
