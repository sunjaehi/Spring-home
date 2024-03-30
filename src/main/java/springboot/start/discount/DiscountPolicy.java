package springboot.start.discount;

import springboot.start.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);

}
//애플리케이션 실행 시점에서 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결되는 것을
//'의존 관계 주입'이라고 한다