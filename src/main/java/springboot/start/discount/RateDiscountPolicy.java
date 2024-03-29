package springboot.start.discount;

import springboot.start.member.Grade;
import springboot.start.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent=10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade()== Grade.VIP) {
            return price * discountPercent /100;
        } else {
            return 0;
        }
    }
}
