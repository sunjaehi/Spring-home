package springboot.start;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() { //생성자 주입
        //빈 이름:memberService 빈객체:MemberServiceImpl
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        //빈 이름:memberRepository 빈객체:MemoryMemberRepository
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        //빈 이름:orderService 빈객체:OrderServiceImpl
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        //빈 이름:discountPolicy 빈객체:RateDiscountPolicy
        return new RateDiscountPolicy();
    }
}
