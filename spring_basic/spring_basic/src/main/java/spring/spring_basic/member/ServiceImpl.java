package spring.spring_basic.member;

public class ServiceImpl implements Service {

    private final Repository repository;

    public ServiceImpl(Repository repository) {
        this.repository = repository;
    }

    public void join(Member member) {
        repository.save(member);
         }

    public Member findById(Long memberId) {
        return repository.findById(memberId);
    }
}
