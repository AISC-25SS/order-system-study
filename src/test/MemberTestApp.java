package test;

import member.*;

public class MemberTestApp {
    public static void main(String[] args) {
        // 수동으로 Repository와 Service 생성
        MemberRepository memberRepository = new MemoryMemberRepository();
        MemberService memberService = new MemberServiceImpl(memberRepository);

        // UI 생성 및 실행
        MemberUI memberUI = new MemberUI(memberService);
        memberUI.run();
    }
}


