package springboot.start.discount;

import springboot.start.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);

}
