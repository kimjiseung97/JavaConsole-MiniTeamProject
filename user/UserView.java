package user;

import myrecipe.Foodview;

import java.util.*;

public class UserView {
    static Scanner sc = new Scanner(System.in);
    private static Repository rt;
    private static Map<String, UserData> memberList = new HashMap<>();
    private static UserData userData;
    static {
        rt = new Repository();
    }

    // 처음 초기화면
    // 메인 시작
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
                case "1":   // 로그인
                    UserLogin();
                    break;
                case "2":   // 회원가입
                    createAccount();
                    break;
                case "3":   // 종료
                    System.out.println("@@@@ 종료되었습니다. @@@@");
                    System.exit(0);
                    break;
                default:
                    System.out.println("번호를 다시 입력해주세요!!");
            }
        }

    }

    private static void UserLogin() {
        Foodview foodview = new Foodview();
        // 로그인
        while (true){
            System.out.print("아이디 : ");
            String inputId = sc.nextLine();
            if (memberList.containsKey(inputId)){   // 아이디 값이 존재하는지 존재하면 true
                //userData = memberList.get(inputId); // memberList배열안에 imputId의 값을 리턴해서 userData에 넣어줌 (쓸모없는 기능)
                System.out.print("비밀번호 : ");
                String inputPwd = sc.nextLine();
                if (userData.getUserPassword().equals(inputPwd)){
                    System.out.println("@@@@ 로그인 성공! @@@@");
                    foodview.selectmenu();
                    break;
                }else {
                    System.out.println("@@@@ 비밀번호가 틀립니다. @@@@");
                }
            }else {
                System.out.println("@@@@ 아이디가 존재하지 않습니다. @@@@");
            }
            System.out.println(memberList);
//            System.out.println(data);
            break;
        }


    }

    private static boolean redundancyCheck(String makeId) { // 중복아이디 확인
        for (UserData value : memberList.values()) {
            if (value.getUserAccount().equals(makeId)){ // 아이디값이 중복하면 true
                return true;
            }
        }

        return false;
    }
    private static void createAccount() {   // 회원가입

        System.out.print("아이디를 입력해주세요 : ");
        String makeId = sc.nextLine();
        if (!redundancyCheck(makeId)){  // 중복확인 아이디가 중복하면 true값을 !true == false로
            System.out.print("비밀번호를 입력해주세요 : ");
            String makePwd = sc.nextLine();
            System.out.print("닉네임을 입력해주세요 : ");
            String makeName = sc.nextLine();

            userData = new UserData(makeId, makePwd, makeName);
            rt.register(userData);  // 유저를 등록하는 기능 (View에 static UserData userData를 만들어서 쓸모없는 기능)
            memberList.put(makeId,userData);    // makeId를 중복 안되게 해줌 makeId가 같으면 userData 값에 안넣어줌
            System.out.println("@@@@ "+userData.getUserName()+"님 환영합니다! @@@@");
        }else {
            System.out.println("@@@@ 아이디가 존재합니다. @@@@");
        }


    }
}
