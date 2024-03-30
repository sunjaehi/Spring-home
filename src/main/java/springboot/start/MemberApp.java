package springboot.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springboot.start.member.Grade;
import springboot.start.member.Member;
import springboot.start.member.MemberService;
import springboot.start.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig=new AppConfig();
        //MemberService memberService=appConfig.memberService();
        //MemberService memberService=new MemberServiceImpl();
        //ApplicationContext=스프링 컨테이너
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService=applicationContext.getBean("memberService",MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = "+member.getName());
        System.out.println("findMember = "+findMember.getName());
    }
}
