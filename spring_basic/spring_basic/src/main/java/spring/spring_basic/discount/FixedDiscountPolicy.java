package spring.spring_basic.discount;

import spring.spring_basic.member.Grade;
import spring.spring_basic.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy {
    final int discountPrice = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
           return discountPrice;
    } else return 0;
}
}
