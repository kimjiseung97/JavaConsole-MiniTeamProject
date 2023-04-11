package cookingrecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CookView {
    static Scanner sc = new Scanner(System.in);
    private static UserData userData = new UserData();
    private final static Repository rt;
    private static final List<UserData> memberList = new ArrayList<>();

    static {
        rt = new Repository();
    }

    public static void start() {
        while (true) {
            System.out.println("***********로그인창 입니다 ************");
            System.out.println("************번호룰 선택하세요************");
            System.out.println("# 1. 로그인");
            System.out.println("# 2. 회원가입");
            System.out.println("# 3. 종료하기");
            System.out.print(">>");
            String num = sc.nextLine();

            switch (num) {
                case "1":
                    break;
                case "2":
                    createAccount();
                    break;
                case "3":
                    System.out.println("종료되었습니다.");
                    System.exit(0);
                    break;
            }
        }

    }
    private static void createAccount() {
        System.out.println("아이디를 입력해주세요 : ");
        String inputId = sc.nextLine();
        System.out.println("비밀번호를 입력해주세요 : ");
        String inputPwd = sc.nextLine();
        System.out.println("닉네임을 입력해주세요 : ");
        String inputName = sc.nextLine();
        userData = new UserData(inputId, inputPwd, inputName);
        memberList.add(userData);



    }
}
