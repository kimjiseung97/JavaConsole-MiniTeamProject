package user;

import myrecipe.Food;
import myrecipe.FoodRepository;
import myrecipe.Foodview;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static myrecipe.Util.Utility.input;

public class UserView implements Serializable {
    static Scanner sc = new Scanner(System.in);
    //리파지토리클래스 함수 사용하기위해서 객체배열 초기화
    private static Repository rt;

    private static FoodRepository fr;

    private static  ArrayList<Food> FoodRecipeList;

    //유저데이터 객체배열
    public static ArrayList<UserData> memberList;
    //현재 로그인한 유저데이터객체
    public static UserData currentLoginUserData;

    //세이브 경로
    private final  static String savePath;

    private final static UserData adminUser;


    static {
        memberList = new ArrayList<>();
        savePath = "D:/UserData";
        currentLoginUserData = new UserData();
        adminUser = new UserData("admin","7777","관리자");
        FoodRecipeList = new ArrayList<>();
        fr = new FoodRepository();
    }

    // 처음 초기화면
    // 메인 시작
    public static void start() {
        loadUserDataFile();
        while (true) {
            System.out.println("------------로그인창 입니다 -------------");
            System.out.println("-----------번호를 선택하세요-------------");
            System.out.println("# 1. 로그인");
            System.out.println("# 2. 회원가입");
            System.out.println("# 3. 관리자 로그인");
            System.out.println("# 4. 종료하기");
            System.out.println("----------------------------------------");
            System.out.print(">>");
            String num = sc.nextLine();

            switch (num) {
                case "1":   // 로그인
                    UserLogin();
                    break;
                case "2":   // 회원가입
                    createAccount();
                    break;
                case "3":
                    loginadmin();
                    break;
                case "4":
                    // 종료
                    System.out.println("--------------프로그램을 종료합니다------------");
                    System.exit(0);
                    break;
                default:
                    System.out.println("번호를 다시 입력해주세요!!");
            }
        }

    }


    private static void loginadmin() {

        System.out.println("----------------관리자 로그인 화면------------------");
        String adminId = input("관리자 아이디를 입력하세요 : ");
        if(adminUser.getUserAccount().equals(adminId)){
            String adminPw = input("관리자 비밀번호를 입력하세요 : ");
            if(adminUser.getUserPassword().equals(adminPw)){
                System.out.println("로그인 성공");
                System.out.println(adminUser.getUserName() + "님 어서오십시오");
                amdinmenuview();
            }else {
                System.out.println("비밀번호가 틀렸습니다!");
            }
        }else{
            System.out.println("올바르지않은 아이디입니다");
        }
    }

    private static void amdinmenuview() {
        System.out.println("-----관리자 전용 메뉴------");
        System.out.println("# 1 : 전체 유저정보 확인");
        System.out.println("# 2 : 전체 레시피 리스트 확인");
        System.out.println("# 3 : 레시피 일괄삭제하기");
        System.out.println("# 4 : 유저정보 일괄삭제");
        System.out.println("# 5 : 로그아웃");
        System.out.println("-------------------------");
        String selectNum = input(">>");
        switch (selectNum){
            case "1":
                if(!memberList.isEmpty()){
                    System.out.println("---------현재 가입된 전체 유저리스트-------------");
                    for (UserData userData : memberList) {
                        System.out.println(userData);
                    }
                    System.out.println("---------------------------------------------");
                    input("엔터를 눌러 계속...........");
                }else{
                    System.out.println("저장된 유저정보가 없습니다 회원가입을 해주세요");
                    input("엔터를 눌러 계속...........");
                }
                amdinmenuview();
                break;
            case"2":
                loadUserfoodDataFile();
                if(!FoodRecipeList.isEmpty()){
                    List<Food> foodList = FoodRecipeList.stream().collect(Collectors.toUnmodifiableList());
                    for (Food food : foodList) {
                        System.out.println("["+food.getFoodname() +"/"+ food.getWriterName()+ "/"+food.getCategory()+"]");
                    }
                }else{
                    System.out.println("저장된 레시피가 없습니다");
                }
                input("엔터를 눌러 계속...........");
                amdinmenuview();
                break;
            case "3":
                if(FoodRecipeList.size()!=0) {
                    FoodRecipeList.clear();
                    saveUserfoodFile();
                    System.out.println("레시피 일괄삭제 완료......");
                    input("엔터를 눌러 계속...........");
                }else{
                    System.out.println("저장된 레시피리스트가 없습니다!");
                    input("엔터를 눌러 계속...........");
                }
                amdinmenuview();
                break;
            case"4":
                memberList.clear();
                saveUserDataFile();
                System.out.println("유저정보 일괄삭제 완료.........");
                input("엔터를 눌러 계속...........");
                amdinmenuview();
                break;
            case "5":
                System.out.println("정말 로그아웃 하시겠습니까?");
                String select = input("[y/n] : ");
                if(select.toLowerCase().charAt(0) == 'y'){
                    System.out.println("로그아웃합니다");
                    start();
                }else if(select.toLowerCase().charAt(0) == 'n'){
                    System.out.println("로그아웃 하지않습니다.");
                    amdinmenuview();
                    break;
                }
            default:
                System.out.println("올바른 메뉴를입력해주세요!");
                amdinmenuview();
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
                    System.out.println("---------- 로그인 성공! ------------");
//                  System.out.println(indexNum);
                    System.out.println(memberList.get(indexNum).getUserName() + "님 환영합니다");
                    currentLoginUserData = new UserData("inputId","inputPwd",memberList.get(indexNum).getUserName());
                    foodview.selectmenu();
                    break;
                }else {
                    System.out.println("-------------- 비밀번호가 틀립니다. ---------------");
                }
            }else {
                System.out.println("---------------- 아이디가 존재하지 않습니다.--------------");
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
        if(makeId.equals("")){
            System.out.println("아이디가공백입니다 아이디를 입력해주세요");
            return;
        }
        if (!isDuplicate(makeId)){  // 중복확인 아이디가 중복하면 true값을 !true == false로
            System.out.print("비밀번호를 입력해주세요 : ");
            String makePwd = sc.nextLine();
            if(makePwd.equals("")){
                System.out.println("비밀번호가공백입니다 비밀번호를 입력해주세요");
                return;
            }
            System.out.print("닉네임을 입력해주세요 : ");
            String makeName = sc.nextLine();
            if(!isDuplicateNickname(makeName)){
                System.out.println("사용할 수 있는 닉네임 입니다.");
            }else {
                System.out.println("닉네임이 중복됩니다");
                return;
            }
            if(makeName.equals("")){
                System.out.println("닉네임이 공백입니다 닉네임을 입력해주세요");
                return;
            }

            currentLoginUserData = new UserData(makeId, makePwd, makeName);
//            rt.register(currentLoginUserData);  // 유저를 등록하는 기능 (View에 static UserData userData를 만들어서 쓸모없는 기능)
            memberList.add(currentLoginUserData);    // makeId를 중복 안되게 해줌 makeId가 같으면 userData 값에 안넣어줌
            saveUserDataFile();
            System.out.println("--------------"+currentLoginUserData.getUserName()+"님 가입완료 -------------");
//            for (UserData data : memberList) {
//                System.out.println(data);   //userdata 배열에 잘들어갔는지 확인용 반복문
//            }

        }else {
            System.out.println("-------------- 아이디가 중복됩니다. ----------------");
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
    private static boolean isDuplicateNickname(String makename) {
        for (UserData data : memberList) {
            if(data.getUserName().contains(makename)){
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
//            e.printStackTrace();
            System.out.println("현재 저장된 유저데이터가 없습니다 회원가입을 진행해주세요");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void loadUserfoodDataFile(){
        try (FileInputStream fis
                     = new FileInputStream(
                savePath+"/userfoodData.sav")) {

            // 객체를 불러올 보조스트림
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Food> object = (ArrayList<Food>) ois.readObject();
            FoodRecipeList = object;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void saveUserfoodFile(){

        File fileInfo = new File("D:/UserData");
        if(!fileInfo.exists())fileInfo.mkdir();
        try (FileOutputStream fos = new FileOutputStream(savePath+"/userfoodData.sav")){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(FoodRecipeList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
