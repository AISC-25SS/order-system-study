package tempMember;

// tempMember.Member.java
public class Member {
    private Long memberId;         // 고유 회원 ID
    private String loginId;       // 로그인 ID
    private String loginPw;       // 로그인 PW
    private String name;          // 이름
    private Grade grade;          // BASIC or VIP

    public Member(Long memberId, String loginId, String loginPw, String name, Grade grade)
    {
        this.memberId = memberId;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.name = name;
        this.grade = grade;
    }

    // getter 우선 입력만
    public Long getMemberId() { return memberId; }
    public String getLoginId() { return loginId; }
    public String getLoginPw() { return loginPw; }
    public String getName() { return name; }
    public Grade getGrade() { return grade; }


    @Override
    public String toString() {
        return "ID: " + memberId + ", 이름: " + name + " , 등급: '" + grade + "'";
    }
}