package spring.spring_basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.spring_basic.member.Grade;
import spring.spring_basic.member.Member;
import spring.spring_basic.member.Service;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        Service memberService = appConfig.Service();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Service memberService = applicationContext.getBean("Service", Service.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findById(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
