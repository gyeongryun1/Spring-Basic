package spring.spring_basic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spring.spring_basic.member.Grade;
import spring.spring_basic.member.Member;
import spring.spring_basic.member.Service;
import spring.spring_basic.member.ServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    Service memberService;

    OrderServiceImpl orderService;
    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
//        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    } }

