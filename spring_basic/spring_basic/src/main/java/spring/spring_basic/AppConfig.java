package spring.spring_basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.spring_basic.discount.DiscountPolicy;
import spring.spring_basic.discount.FixedDiscountPolicy;
import spring.spring_basic.discount.RateDiscountPolicy;
import spring.spring_basic.member.MemoryRepository;
import spring.spring_basic.member.Service;
import spring.spring_basic.member.ServiceImpl;
import spring.spring_basic.order.OrderService;
import spring.spring_basic.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public Service service() {
        return new ServiceImpl(repository());
        }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                repository(), discountPolicy());
    }
    @Bean
    public MemoryRepository repository() {
        return new MemoryRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
//        return new FixedDiscountPolicy();
    }

}
