package spring.spring_basic.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ServiceTest {

    Service memberService;
    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findById(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}