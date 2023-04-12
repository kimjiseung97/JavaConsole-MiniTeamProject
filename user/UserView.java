package user;

import myrecipe.Foodview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserView {
    static Scanner sc = new Scanner(System.in);
    private static Repository rt;
    public static ArrayList<UserData> memberList;
    public static UserData currentLoginUserData;
    static {
        rt = new Repository();
        memberList = new ArrayList<>(
                List.of(
                        new UserData("abcd","1234","홍길동"),
                        new UserData("bbbb","1234","이순신"),
                        new UserData("cccc","1234","강감찬")
                )
        );
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
            if (iscontainId(inputId)){   // 아이디 값이 존재하는지 존재하면 true

                int indexNum = 0;
                indexNum = gettargetIndexnum(inputId);

                System.out.print("비밀번호 : ");
                String inputPwd = sc.nextLine();
                if (iscotianpw(inputPwd)){
                    System.out.println("@@@@ 로그인 성공! @@@@");
//                  System.out.println(indexNum);
                    System.out.println(memberList.get(indexNum).getUserName() + "님 환영합니다");
                    foodview.selectmenu();
                    break;
                }else {
                    System.out.println("@@@@ 비밀번호가 틀립니다. @@@@");
                }
            }else {
                System.out.println("@@@@ 아이디가 존재하지 않습니다. @@@@");
            }
//            System.out.println(memberList);
//            System.out.println(data);
            break;
        }


    }

    private static int gettargetIndexnum(String inputPwd) {
        for (UserData data : memberList) {
            if(data.getUserAccount().equals(inputPwd)){
                return memberList.indexOf(data);
            }
        }
        return -1;
    }


    private static boolean iscotianpw(String inputPwd) {
        for (UserData data : memberList) {
            if (data.getUserPassword().equals(inputPwd)){
                return true;
            }
        }
        return false;
    }

    private static boolean iscontainId(String inputId) {
        for (UserData data : memberList) {
            if(data.getUserAccount().equals(inputId)){
                return true;
            }
        }
        return false;
    }




    private static void createAccount() {   // 회원가입

        System.out.print("아이디를 입력해주세요 : ");
        String makeId = sc.nextLine();
        if (!isDuplicate(makeId)){  // 중복확인 아이디가 중복하면 true값을 !true == false로
            System.out.print("비밀번호를 입력해주세요 : ");
            String makePwd = sc.nextLine();
            System.out.print("닉네임을 입력해주세요 : ");
            String makeName = sc.nextLine();

            currentLoginUserData = new UserData(makeId, makePwd, makeName);
//            rt.register(currentLoginUserData);  // 유저를 등록하는 기능 (View에 static UserData userData를 만들어서 쓸모없는 기능)
            memberList.add(currentLoginUserData);    // makeId를 중복 안되게 해줌 makeId가 같으면 userData 값에 안넣어줌
            System.out.println("@@@@ "+currentLoginUserData.getUserName()+"님 가입완료 @@@@");
//            for (UserData data : memberList) {
//                System.out.println(data);   //userdata 배열에 잘들어갔는지 확인용 반복문
//            }

        }else {
            System.out.println("@@@@ 아이디가 중복됩니다. @@@@");
        }


    }

    private static boolean isDuplicate(String makeId) {
        for (UserData data : memberList) {
            if(data.getUserAccount().contains(makeId)){
                return true;
            }
        }
        return false;
    }

    // 로그인한 유저 이름 얻기
    public String getLoginUserName() {
        String userName = currentLoginUserData.userName;
        return userName;
    }
}
