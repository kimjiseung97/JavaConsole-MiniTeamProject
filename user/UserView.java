package user;

import myrecipe.Foodview;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserView implements Serializable {
    static Scanner sc = new Scanner(System.in);
    //리파지토리클래스 함수 사용하기위해서 객체배열 초기화
    private static Repository rt;

    //유저데이터 객체배열
    public static ArrayList<UserData> memberList;
    //현재 로그인한 유저데이터객체
    public static UserData currentLoginUserData;

    //세이브 경로
    private final  static String savePath;

    static {
        rt = new Repository();
        memberList = new ArrayList<>();
        savePath = "D:/UserData";
        currentLoginUserData = new UserData();
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
        loadUserDataFile();
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
                if (iscontaianpw(inputPwd)){
                    System.out.println("@@@@ 로그인 성공! @@@@");
//                  System.out.println(indexNum);
                    System.out.println(memberList.get(indexNum).getUserName() + "님 환영합니다");
                    currentLoginUserData = new UserData("inputId","inputPwd",memberList.get(indexNum).getUserName());
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


    private static boolean iscontaianpw(String inputPwd) {
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
            saveUserDataFile();
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
        String userName = currentLoginUserData.getUserName();
        return userName;
    }



    //로그인유저 세이브파일저장
    public static void saveUserDataFile(){

        File fileInfo = new File("D:/UserData");
        if(!fileInfo.exists())fileInfo.mkdir();
        try (FileOutputStream fos = new FileOutputStream(savePath+"/userData.sav")){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(memberList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //세이브파일 로드함수
    public static void loadUserDataFile(){
        try (FileInputStream fis
                     = new FileInputStream(
                savePath+"/userData.sav")) {

            // 객체를 불러올 보조스트림
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<UserData> object = (List<UserData>) ois.readObject();
            memberList = (ArrayList<UserData>) object;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
