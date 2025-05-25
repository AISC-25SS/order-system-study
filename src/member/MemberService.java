package member;

import java.util.List;

public interface MemberService {

    // 회원 가입
    void join(Member member);

    // Member ID 회원 조회
    Member findById(Long memberId);

    // 로그인
    Member login(String loginId, String loginPw);

    // 전체 회원 목록 조회
    List<Member> findAll();

}
