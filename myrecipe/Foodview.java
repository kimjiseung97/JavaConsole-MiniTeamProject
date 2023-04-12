package myrecipe;

import java.util.HashSet;
import java.util.Set;

import static myrecipe.Util.Utility.input;


public class Foodview {

    private static FoodRepository foodRepository;

    static {
        foodRepository = new FoodRepository();
    }
    public void selectmenu(){
      showmenu();
    }


    private void showmenu() {
        while(true){
            System.out.println("-------------나만의 요리 레시피-------------");
            System.out.println("1. 레시피 추가 하기");
            System.out.println("2. 레시피 전체 보기");
            System.out.println("3. 특정 음식 요리 검색하기");
            System.out.println("4. 요리종류별로 보기");
            System.out.println("5. 음식 이름으로 검색하기");
            System.out.println("6. 레시피 삭제하기");
            System.out.println("7. 레시피 수정하기");
            System.out.println("8 종료하기");
            System.out.println("-------------------------------------------");
            String menuNum = input(">>");
            while (true){
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
                        //재료가 포함된 음식찾기
                        String findmaterial = input("찾고자하는 음식에 들어가는 재료를 입력해주세요 : ");
                        foodRepository.findbymaterial(findmaterial);
                        break;
                    case "4":
                        String findCategory = input("찾고자하는 음식 카테고리를 입력해주세요 : [한식 : kr/ 중식 : ch/ 일식 : jp/ 양식 : we]");
                        if(findCategory.equals("kr")||findCategory.equals("ch")||findCategory.equals("jp")||findCategory.equals("we")){
                            foodRepository.findbyCategory(findCategory);
                        }else{
                            System.out.println("올바른 카테고리를 입력해주세요!");
                        }
                        break;
                    case "5":
                        break;
                    case "6":
                        String removeFoodname = input("삭제하고자하는 레시피를 입력해주세요 : ");
                        foodRepository.removeRecipe(removeFoodname);
                        break;
                    case "7":
//                        String modifyFoodname = input("수정하고자하는 레시피를 입력해주세요 : ");
//                        foodRepository.modifyRecipe(modifyFoodname);
                        break;
                    case"8":
                        System.out.println("종료합니다!");
                        System.exit(0);
                    default:
                        System.out.println("메뉴를 똑바로 입력해주세요!");
                }
                break;
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
        String foodname = input("음식이름 : ");
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

        foodRepository.addnewfoodrecipe(jp);
        System.out.println("메뉴추가가 완료되었습니다!");
    }

    private void addwesternfood() {
        //양식 추가하는 메뉴
        //음식이름과 재료 레시피를 입력받고 생성자 호출하는 함수
        String foodname = input("음식이름 : ");
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

        foodRepository.addnewfoodrecipe(we);
        System.out.println("메뉴추가가 완료되었습니다!");
    }

    private void addchinafood() {
        //중국음식 추가하는 메뉴
        //음식이름과 재료 레시피를 입력받고 생성자 호출하는 함수
        String foodname = input("음식이름 : ");
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

        foodRepository.addnewfoodrecipe(ch);
        System.out.println("메뉴추가가 완료되었습니다!");
    }

    private void addkoreafood() {
        //한국음식 추가하는 메뉴
        //음식이름과 재료 레시피를 입력받고 생성자 호출하는 함수
        String foodname = input("음식이름 : ");
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

        foodRepository.addnewfoodrecipe(kr);

        System.out.println("메뉴추가가 완료되었습니다!");

    }
}
