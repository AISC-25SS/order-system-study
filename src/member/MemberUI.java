package member;

import java.util.List;
import java.util.Scanner;

public class MemberUI {
    private final MemberService memberService;
    private final Scanner scanner = new Scanner(System.in);
    private Member currentMember = null; // 로그인 상태 저장

    public MemberUI(MemberService memberService) {
        this.memberService = memberService;
    }

    private void showMenu() {
        System.out.println("\n[회원 메뉴]");
        System.out.println("1. 회원 가입");
        System.out.println("2. 로그인");
        System.out.println("3. 로그아웃");
        System.out.println("4. 내 정보 보기");
        System.out.println("5. 전체 회원 목록");
        System.out.println("0. 뒤로가기");
        System.out.print("메뉴 선택: ");
    }

    // 회원가입 처리
    private void handleJoin() {
        System.out.print("로그인 ID 입력: ");
        String loginId = scanner.nextLine();

        System.out.print("비밀번호 입력: ");
        String loginPw = scanner.nextLine();

        System.out.print("이름 입력: ");
        String name = scanner.nextLine();

        Grade grade = chooseGrade();

        try {
            Member member = new Member(null, loginId, loginPw, name, grade);
            memberService.join(member);
            showSuccessMessage(name);
        } catch (IllegalArgumentException e) {
            showErrorMessage(e.getMessage());
        }
    }

    // 로그인 처리
    private void handleLogin() {
        System.out.print("로그인 ID 입력: ");
        String loginId = scanner.nextLine();

        System.out.print("비밀번호 입력: ");
        String loginPw = scanner.nextLine();

        try {
            Member member = memberService.login(loginId, loginPw);
            currentMember = member;
            showSuccessMessage(member.getName());
        } catch (IllegalArgumentException e) {
            showErrorMessage(e.getMessage());
        }
    }

    // 로그아웃 처리
    private void handleLogout() {
        if (currentMember == null) {
            showErrorMessage("현재 로그인된 사용자가 없습니다.");
        } else {
            System.out.println("[안내] " + currentMember.getName() + "님, 로그아웃 되었습니다.");
            currentMember = null;
        }
    }

    // 회원 목록 출력
    private void showAllMembers() {
        List<Member> members = memberService.findAll();
        System.out.println("\n[회원 목록]");

        if (members.isEmpty()) {
            showErrorMessage("등록된 회원이 없습니다.");
            return;
        }

        for (Member member : members) {
            System.out.println(member);
        }
    }


    private void showCurrentMember() {
        if (currentMember == null) {
            showErrorMessage("현재 로그인된 사용자가 없습니다.");
        } else {
            System.out.println("\n[내 정보]");
            System.out.println(currentMember);
        }
    }

    private void showSuccessMessage(String name) {
        System.out.println("[성공] " + name + "님, 환영합니다!");
    }

    private void showErrorMessage(String message) {
        System.out.println("[오류] " + message);
    }

    private Grade chooseGrade() {
        System.out.print("등급 선택 (1: BASIC, 2: VIP): ");
        String input = scanner.nextLine();
        return input.equals("2") ? Grade.VIP : Grade.BASIC; // 2 이외 입력시 일반
    }

    public void run() {
        while (true) {
            showMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> handleJoin();
                case "2" -> handleLogin();
                case "3" -> handleLogout();
                case "4" -> showCurrentMember();
                case "5" -> showAllMembers();
                case "0" -> {
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    return;
                }
                default -> showErrorMessage("잘못된 입력입니다.");
            }
        }
    }

    // 다른 UI에서 로그인 상태가 필요할 경우를 위한 getter
    public Member getCurrentMember() {
        return currentMember;
    }
}
