package springboot.start.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springboot.start.member.Grade;
import springboot.start.member.Member;
import springboot.start.member.MemberService;
import springboot.start.member.MemberServiceImpl;

public class OrderServiceTest {
    MemberService memberService=new MemberServiceImpl();
    OrderService orderService=new OrderServiceImpl();

    @Test
    void createOrder() {
        long memberId=1L;
        Member member=new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
