package springboot.start;

import springboot.start.member.Grade;
import springboot.start.member.Member;
import springboot.start.member.MemberService;
import springboot.start.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig=new AppConfig();
        MemberService memberService=appConfig.memberService();
        //MemberService memberService=new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = "+member.getName());
        System.out.println("findMember = "+findMember.getName());
    }
}
