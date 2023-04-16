package myrecipe;

import user.UserView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static myrecipe.Util.Utility.input;
import static user.UserView.start;


public class Foodview {

    private static final FoodRepository foodRepository;

    private static final UserView userView;

    private static ArrayList<Food> foodRecipeList;



    static {
        foodRepository = new FoodRepository();
        userView = new UserView();
    }
    public void selectmenu(){
        showmenu();
    }


    private void showmenu() {
        while(true){
            System.out.println("-------------나만의 요리 레시피-------------");
            System.out.println("1. 레시피 추가 하기");
            System.out.println("2. 레시피 전체 보기");
            System.out.println("3. 특정 재료 요리 검색하기");
            System.out.println("4. 요리카테고리별[kr/ch/we/jp] 별로 보기");
            System.out.println("5. 음식 이름으로 검색하기");
            System.out.println("6. 레시피 삭제하기");
            System.out.println("7. 레시피 수정하기");
            System.out.println("8. 로그아웃");
            System.out.println("9. 종료하기");
            System.out.println("-------------------------------------------");
            String menuNum = input(">>");

            switch(menuNum){
                case "1":
                    selectfoodnation();
                    break;
                case "2":
                    //전체음식 보여주는 함수
                    if(!foodRepository.isempy()) {
                        foodRepository.showfoodlist();
                    }else{
                        System.out.println("레시피목록이 없습니다!");

                    }
                    break;
                case "3":
                    //입력한 재료가 포함이 되어있으면 음식리스트를 리턴하는 함수
                    String findmaterial = input("찾고자하는 음식에 들어가는 재료를 입력해주세요 : ");
                    foodRepository.findbymaterial(findmaterial);
                    break;
                case "4":
                    String findCategory = input("찾고자하는 음식 카테고리를 입력해주세요 : [한식 : kr/ 중식 : ch/ 일식 : jp/ 양식 : we] : ");
                    //음식 카테고리로 리스트를 반환하는 함수
                    if(findCategory.equals("kr")||findCategory.equals("ch")||findCategory.equals("jp")||findCategory.equals("we")){
                        foodRepository.findbyCategory(findCategory);
                    }else{
                        System.out.println("올바른 카테고리를 입력해주세요!");
                    }
                    break;
                case "5":
                    String findfoodname = input("찾고자하는 음식의 이름을 입력해주세요 : ");
                    //이름으로 음식을 찾는 함수
                    foodRepository.SearchRecipe(findfoodname);
                    break;
                case "6":
                    String removefoodname = input("삭제하고자 하는 음식의 이름을 입력해주세요 : ");
                    foodRepository.RemoveRecipe(removefoodname);
                    break;
                case "7":
                    String modifyfoodname;
                    while (true) {
                        modifyfoodname = input("수정하고자 하는 음식의 이름을 입력해주세요 : ");;
                        if(modifyfoodname.equals("")){
                            System.out.println("공백입니다 다시입력해주세요.");
                            continue;
                        }
                        break;
                    }
                    foodRepository.ChangeRecipe(modifyfoodname);
                    break;
                case "8":
                    String isLogout = input("정말 로그아웃 하시겠습니까 ? [y/n] : ");
                    if(isLogout.toLowerCase().charAt(0) == 'y'){
                        System.out.println("로그아웃 되셨습니다.");
                        start();
                    }else{
                        System.out.println("로그아웃 하지않습니다.");
                    }
                    break;
                case"9":
                    System.out.println("종료합니다!");
                    System.exit(0);
                default:
                    System.out.println("메뉴를 똑바로 입력해주세요!");
            }
        }
    }

    private void selectfoodnation() {
        //음식의 종류(어디음식인지) 선택하는 함수
        System.out.println("음식의 종류를 골라주세요! [1.한식/2. 중식/3. 양식/4. 일식]");
        String str = input(">>");
        switch (str){
            case "1":
                addkoreafood();
                break;
            case"2":
                addchinafood();
                break;
            case"3":
                addwesternfood();
                break;
            case"4":
                addjapanfood();
                break;
            default:
                System.out.println("메뉴를 다시골라주세요!");
        }
    }

    private void addjapanfood() {
        //양식 추가하는 메뉴
        //음식이름과 재료 레시피를 입력받고 생성자 호출하는 함수
        String foodname;
        while (true) {
            foodname = input("음식이름 : ");
            if(foodname.equals("")){
                System.out.println("공백입니다 다시입력해주세요.");
                continue;
            }
            break;
        }
        Set<String> material = new HashSet<>();
        while(true){
            System.out.println("음식재료를 입력해주세요! [엔터입력시 종료]");
            String meterialname = input("재료 : ");
            if(meterialname.equals("")) break;
            material.add(meterialname);
        }
        String recipe = input("조리법 : ");

//        System.out.println(foodname); //잘 들어갔나 확인용
//        System.out.println(material);
//        System.out.println(recipe);
        Food jp = new Japanfood();
        jp.setCategory("jp");
        jp.setFoodname(foodname);
        jp.setMaterial(material);
        jp.setRecipe(recipe);
        jp.setWriterName(userView.getLoginUserName());

        foodRepository.addnewfoodrecipe(jp);
        FoodRepository.saveUserfoodFile();
        System.out.println("메뉴추가가 완료되었습니다!");
    }

    private void addwesternfood() {
        //양식 추가하는 메뉴
        //음식이름과 재료 레시피를 입력받고 생성자 호출하는 함수
        String foodname;
        while (true) {
            foodname = input("음식이름 : ");
            if(foodname.equals("")){
                System.out.println("공백입니다 다시입력해주세요.");
                continue;
            }
            break;
        }
        Set<String> material = new HashSet<>();
        while(true){
            System.out.println("음식재료를 입력해주세요! [엔터입력시 종료]");
            String meterialname = input("재료 : ");
            if(meterialname.equals("")) break;
            material.add(meterialname);
        }
        String recipe = input("조리법 : ");

//        System.out.println(foodname); //잘 들어갔나 확인용
//        System.out.println(material);
//        System.out.println(recipe);
        Food we = new Westernfood();
        we.setCategory("we");
        we.setFoodname(foodname);
        we.setMaterial(material);
        we.setRecipe(recipe);
        we.setWriterName(userView.getLoginUserName());

        foodRepository.addnewfoodrecipe(we);
        FoodRepository.saveUserfoodFile();
        System.out.println("메뉴추가가 완료되었습니다!");
    }


    private void addchinafood() {
        //중국음식 추가하는 메뉴
        //음식이름과 재료 레시피를 입력받고 생성자 호출하는 함수
        String foodname;
        while (true) {
            foodname = input("음식이름 : ");
            if(foodname.equals("")){
                System.out.println("공백입니다 다시입력해주세요.");
                continue;
            }
            break;
        }
        Set<String> material = new HashSet<>();
        while(true){
            System.out.println("음식재료를 입력해주세요! [엔터입력시 종료]");
            String meterialname = input("재료 : ");
            if(meterialname.equals("")) break;
            material.add(meterialname);
        }
        String recipe = input("조리법 : ");

//        System.out.println(foodname); //잘 들어갔나 확인용
//        System.out.println(material);
//        System.out.println(recipe);
        Food ch = new Chinafood();
        ch.setCategory("ch");
        ch.setFoodname(foodname);
        ch.setMaterial(material);
        ch.setRecipe(recipe);
        ch.setWriterName(userView.getLoginUserName());

        foodRepository.addnewfoodrecipe(ch);
        FoodRepository.saveUserfoodFile();
        System.out.println("메뉴추가가 완료되었습니다!");
    }

    private void addkoreafood() {
        //한국음식 추가하는 메뉴
        //음식이름과 재료 레시피를 입력받고 생성자 호출하는 함수
        String foodname;
        while (true) {
            foodname = input("음식이름 : ");
            if(foodname.equals("")){
                System.out.println("공백입니다 다시입력해주세요.");
                continue;
            }
            break;
        }
        Set<String> material = new HashSet<>();
        while(true){
            System.out.println("음식재료를 입력해주세요! [엔터입력시 종료]");
            String meterialname = input("재료 : ");
            if(meterialname.equals("")) break;
            material.add(meterialname);
        }
        String recipe = input("조리법 : ");

//        System.out.println(foodname); //잘 들어갔나 확인용
//        System.out.println(material);
//        System.out.println(recipe);
        Food kr = new Koreafood();
        kr.setCategory("kr");
        kr.setFoodname(foodname);
        kr.setMaterial(material);
        kr.setRecipe(recipe);
        kr.setWriterName(userView.getLoginUserName());
        foodRepository.addnewfoodrecipe(kr);
        FoodRepository.saveUserfoodFile();
        System.out.println("메뉴추가가 완료되었습니다!");

    }

}
