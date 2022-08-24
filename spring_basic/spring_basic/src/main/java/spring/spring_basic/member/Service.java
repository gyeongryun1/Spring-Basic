package spring.spring_basic.member;

public interface Service {

    public void join(Member member);

    public Member findById(Long memberId);
}
