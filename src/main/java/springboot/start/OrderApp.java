package springboot.start;

import springboot.start.member.Grade;
import springboot.start.member.Member;
import springboot.start.member.MemberService;
//import springboot.start.member.MemberServiceImpl;
import springboot.start.order.Order;
import springboot.start.order.OrderService;
//import springboot.start.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig=new AppConfig();
        MemberService memberService=appConfig.memberService();
        OrderService orderService=appConfig.orderService();
        //MemberService memberService=new MemberServiceImpl();
        //OrderService orderService=new OrderServiceImpl();

        Long memberId=1L;
        Member member=new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId,"itemA",10000);
        System.out.println("order = " + order.toString());
    }
}
