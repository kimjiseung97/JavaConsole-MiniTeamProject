package myrecipe;

import java.util.HashSet;
import java.util.Set;

import static myrecipe.Util.Utility.input;


public class Foodview {

    public void selectmenu(){
       showmenu();
    }

    public static Food fd;


    static {

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

            switch(menuNum){
                case "1":
                    selectfoodnation();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case"8":
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
            case"2":
                addchinafood();
                break;
            case"3":
                break;
            case"4":
                break;
            default:
                System.out.println("메뉴를 다시골라주세요!");
        }
    }

    private void addchinafood() {

    }

    private void addkoreafood() {
        //한국음식 추가하는 메뉴
        //음식이름과 재료 레시피를 입력받고 생성자 호출하는 함수
        String foodname = input("음식이름 : ");
        Set<String> material = new HashSet<>();
        while(true){
            System.out.println("음식재료를 입력해주세요! [그만 입력시 종료됌]");
            String meterialname = input("재료 : ");
            material.add(meterialname);
            if(meterialname.equals("그만")) break;
        }
        String recipe = input("조리법 : ");

        Koreafood kr = new Koreafood();
        kr.setFoodname(foodname);
        kr.setMaterial(material);
        kr.setRecipe(recipe);


    }
}
