package springboot.start.order;

import springboot.start.discount.DiscountPolicy;
import springboot.start.discount.FixDiscountPolicy;
import springboot.start.member.Member;
import springboot.start.member.MemberRepository;
import springboot.start.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository=new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy=new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);
        int discountPrice=discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
