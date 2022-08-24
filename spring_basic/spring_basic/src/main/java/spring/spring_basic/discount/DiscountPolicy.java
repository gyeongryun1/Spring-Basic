package spring.spring_basic.discount;

import spring.spring_basic.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
