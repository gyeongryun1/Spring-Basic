package spring.spring_basic.member;

public interface Repository {

    void save(Member member);

    Member findById(Long memberId);

}
