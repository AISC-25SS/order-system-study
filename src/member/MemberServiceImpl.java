package member;

import java.util.List;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        // TODO: 은혜 담당 회원 가입 로직 구현
        //  해당 부분에 로그인 중복 검사 구현 후 성공시 Member 객체 생성,
        //  중복 검사 시에는 memberRepository.findByLoginId() 호출 필요.
        //  회원가입 등록시 Member 객체를 생성하면 되는데
        //  이때 memberId 는 memberRepository.nextId() 로 받아올 수 있음
        //  MemoryMemberRepository 메소드 참고 바람
    }

    @Override
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public Member login(String loginId, String loginPw) {
        // TODO: 은혜 담당 로그인 구현
        //  loginId, loginPw 입력 받아 수행
        //  id 확인시에는 memberRepository.findByLoginId(loginId) 사용
        //  비밀번호 확인시는 member.getLoginPw() 로 비밀번호를 받아올 수 있음
        //  파이팅 !!
        return null;
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}