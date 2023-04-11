package cookingrecipe;

import java.util.*;

public class CookView {
    static Scanner sc = new Scanner(System.in);
    private static Repository rt;
    private static Map<String, UserData> memberList = new HashMap<>();
    private static UserData userData;
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
                    UserLogin();
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

    private static void UserLogin() {

        while (true){
            System.out.println("아이디 : ");
            String inputId = sc.nextLine();
            if (memberList.containsKey(inputId)){
                userData = memberList.get(inputId);
                System.out.println("비밀번호 : ");
                String inputPwd = sc.nextLine();
                if (userData.getUserPassword().equals(inputPwd)){
                    System.out.println("로그인 성공!");
                    break;
                }else {
                    System.out.println("비밀번호가 틀립니다.");
                }
            }else {
                System.out.println("아이디가 존재하지 않습니다.");
            }
//            System.out.println(memberList);
//            System.out.println(data);
            break;
        }


    }

    private static boolean redundancyCheck(String makeId) {
        for (UserData value : memberList.values()) {
            if (value.getUserAccount().equals(makeId)){
                return true;
            }
        }

        return false;
    }
    private static void createAccount() {

        System.out.println("아이디를 입력해주세요 : ");
        String makeId = sc.nextLine();
        if (!redundancyCheck(makeId)){
            System.out.println("비밀번호를 입력해주세요 : ");
            String makePwd = sc.nextLine();
            System.out.println("닉네임을 입력해주세요 : ");
            String makeName = sc.nextLine();

            userData = new UserData(makeId, makePwd, makeName);
            rt.register(userData);
            memberList.put(makeId,userData);

        }else {
            System.out.println("아이디가 존재합니다.");
        }



    }
}
