package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private final Map<Long, Member> memberStore = new HashMap<>();
    private long sequence = 1L;


    @Override
    public void save(Member member) {
        memberStore.put(member.getMemberId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return memberStore.get(memberId);
    }

    @Override
    public Member findByLoginId(String loginId) {
        for (Member member: memberStore.values()) {
            if (member.getLoginId().equals(loginId)){
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(memberStore.values());
    }

    public Long nextId() {
        return sequence++;
    }
}