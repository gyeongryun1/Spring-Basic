package spring.spring_basic.order;

import spring.spring_basic.discount.DiscountPolicy;
import spring.spring_basic.discount.FixedDiscountPolicy;
import spring.spring_basic.member.Member;
import spring.spring_basic.member.MemoryRepository;
import spring.spring_basic.member.Repository;


public class OrderServiceImpl implements OrderService {

    private final Repository repository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(Repository repository, DiscountPolicy discountPolicy) {
        this.repository = repository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = repository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
