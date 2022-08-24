package spring.spring_basic.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryRepository implements Repository {

    private static Map<Long, Member> store = new HashMap<>();

    /** static 없으면 NullPointerException 뜨는데 why?
     */


    @Override
    public void save(Member member) {
        store.put(member.getId(), member );
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);

    }
}
