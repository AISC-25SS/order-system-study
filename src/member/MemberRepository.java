package member;

import java.util.List;

public interface MemberRepository {

    // 회원 저장
    void save(Member member);

    // 회원 ID로 조회
    Member findById(Long memberId);

    // 로그인 ID로 회원 조회(중복 확인)
    Member findByLoginId(String loginId);

    // 전체 회원 목록 조회
    List<Member> findAll();

}