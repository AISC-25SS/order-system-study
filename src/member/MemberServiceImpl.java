package member;

import java.util.List;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean isLoginIdDuplicate(String loginId) {
        // TODO: 은혜 담당 회원가입 중복 여부 확인
        //  해당 부분에 로그인 중복 검사 구현, 성공시 true 아니면 false
        //  중복 검사 시에는 memberRepository.findByLoginId() 호출 필요.
        return true;
    }

    @Override
    public void join(Member member) {
        // TODO: 은혜 담당 회원 가입 로직 구현
        //  회원가입 등록시 Member 객체에서 memberID 만 null 로 들어감
        //  따라서 Member 객체 생성해서 repository 에 저장할건데
        //  이때 memberId 는 memberRepository.nextId() 로 받아올 수 있음
        //  MemoryMemberRepository 메소드 참고 바람
        //  오류시 처리: throw new IllegalArgumentException("이미 사용 중인 로그인 ID입니다.");
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
        //  오류시 처리: throw new IllegalArgumentException("로그인 실패: ID 또는 비밀번호가 일치하지 않습니다.");
        //  파이팅 !!
        return null; // 성공시 Member 리턴 아니면 null
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}