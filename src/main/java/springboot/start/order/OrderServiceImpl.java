package springboot.start.order;

import springboot.start.discount.DiscountPolicy;
//import springboot.start.discount.FixDiscountPolicy;
//import springboot.start.discount.RateDiscountPolicy;
import springboot.start.member.Member;
import springboot.start.member.MemberRepository;
import springboot.start.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    //private final DiscountPolicy discountPolicy=new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy=new RateDiscountPolicy();
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository=memberRepository;
        this.discountPolicy=discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);
        int discountPrice=discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
