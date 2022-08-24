package spring.spring_basic.discount;

import spring.spring_basic.member.Grade;
import spring.spring_basic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountRate = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price*discountRate/100;
        }
        return 0;
    }
}
