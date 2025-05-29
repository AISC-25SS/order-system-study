package member;

import java.util.List;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean isLoginIdDuplicate(String loginId) {
        Member member = memberRepository.findByLoginId(loginId);

        return member != null;
    }

    @Override
    public void join(Member member) {
        if (isLoginIdDuplicate(member.getLoginId())) {
            throw new IllegalArgumentException("이미 사용 중인 로그인 ID입니다.");
        }

        MemoryMemberRepository repo = (MemoryMemberRepository) memberRepository;
        Long newId = repo.nextId();

        Member newMember = new Member(
                newId,
                member.getLoginId(),
                member.getLoginPw(),
                member.getName(),
                member.getGrade()
        );

        memberRepository.save(newMember);
    }

    @Override
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public Member login(String loginId, String loginPw) {
        Member member = memberRepository.findByLoginId(loginId);
        if (member == null || !member.getLoginPw().equals(loginPw)) {
            throw new IllegalArgumentException("로그인 실패: ID 또는 비밀번호가 일치하지 않습니다.");
        }

        return member;
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}