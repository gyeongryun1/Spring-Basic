package spring.spring_basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.spring_basic.member.Grade;
import spring.spring_basic.member.Member;
import spring.spring_basic.member.Service;
import spring.spring_basic.order.Order;
import spring.spring_basic.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        Service memberService = appConfig.Service();
//        OrderService orderService = appConfig.orderService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Service memberService = applicationContext.getBean("Service", Service.class);
        OrderService orderService = applicationContext.getBean("OderService", OrderService.class);
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 100000);
        System.out.println("order = " + order);
    }
}
