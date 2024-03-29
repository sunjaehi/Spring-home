package springboot.start;

import springboot.start.discount.DiscountPolicy;
import springboot.start.discount.FixDiscountPolicy;
import springboot.start.discount.RateDiscountPolicy;
import springboot.start.member.MemberRepository;
import springboot.start.member.MemberService;
import springboot.start.member.MemberServiceImpl;
import springboot.start.member.MemoryMemberRepository;
import springboot.start.order.OrderService;
import springboot.start.order.OrderServiceImpl;

//애플리케이션 전체를 구성
//실제 동작에 필요한 '구현 객체'를 생성
//생성한 객체 인스턴스의 참조(레퍼런스)를 '생성자를 통해서 주입(연결)'

//리팩토링-바로 역할이 보이게끔
public class AppConfig {
    public MemberService memberService() { //생성자 주입
        return new MemberServiceImpl(memberRepository());
    }
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
