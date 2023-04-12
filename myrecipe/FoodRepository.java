package myrecipe;

import java.util.ArrayList;


public class FoodRepository extends Food {

    public static ArrayList<Food> FoodRecipeList;

    static {
        FoodRecipeList = new ArrayList<>();
    }

    public ArrayList<Food> getFoodRecipeList() {
        return FoodRecipeList;
    }

    private void setFoodRecipeList(ArrayList<Food> foodRecipeList) {
        FoodRecipeList = foodRecipeList;
    }

    public FoodRepository() {
    }

    private FoodRepository(ArrayList<Food> foodRecipe) {
        FoodRecipeList = foodRecipe;
    }

    //각각의 food객체 추가하는 함수
    public void addnewfoodrecipe(Food foodrecipe) {
        FoodRecipeList.add(foodrecipe);
    }

    public void showfoodlist() {
        for (Food food : FoodRecipeList) {
            System.out.println(food);
        }
    }

    //레시피 목록이 비었는지 확인하는 함수
    public boolean isempy() {
        if (FoodRecipeList.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    //재료이름으로 음식을 찾는 함수
    public void findbymaterial(String findmaterial) {
        for (Food food : FoodRecipeList) {
            if (food.material.contains(findmaterial)) {
                System.out.println(food);
            } else {
                System.out.println(findmaterial + "이 들어가는 음식을 찾지못했습니다.");
            }
        }
    }

    public void findbyCategory(String findCategory) {
        for (Food food : FoodRecipeList) {
            if (food.Category.contains(findCategory)) {
                System.out.println(food);
            } else {
                System.out.println(findCategory + "카테고리 음식을 찾지 못했습니다.");
            }
        }
    }
    private static int gettargetIndexnum(String foodname) {
        for (Food data : FoodRecipeList) {
            if(data.getFoodname().equals(foodname)){
                return FoodRecipeList.indexOf(data);
            }
        }
        return -1;
    }

    // 레시피를 삭제하는 함수
    public static void removeRecipe(String foodname) {
        int num = gettargetIndexnum(foodname);
        for (Food data : FoodRecipeList) {
            if(data.getFoodname().equals(foodname)){
                FoodRecipeList.remove(num);
                System.out.println(foodname + "삭제 되었습니다.");
                return;
            }
        }
        System.out.println(foodname + "찾지 못하였습니다.");
    }
            /*if (FoodRecipeList.contains(foodname)) {
                System.out.println("[ "+foodname+" ] 레시피가 삭제되었습니다.");
                FoodRecipeList.remove(num);

            } else {
                System.out.println("다시 입력해주세요.");
                FoodRecipeList.remove(num);
            }*/

//        while (true) {
//            if (FoodRecipeList.equals(foodname)) {
//                String a = String.valueOf(FoodRecipeList.equals(foodname));
//                System.out.println("[ "+foodname+" ] 레시피가 삭제되었습니다.");
//                FoodRecipeList.remove(a);
//                break;
//            } else {
//                System.out.println("다시 입력해주세요.");
//            }
//        }
    }

