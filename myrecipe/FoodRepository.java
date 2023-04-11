package myrecipe;

import java.util.ArrayList;

public class FoodRepository {

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
    public void addnewfoodrecipe(Food foodrecipe){
        FoodRecipeList.add(foodrecipe);
    }

    public void showfoodlist(){
        for (Food food : FoodRecipeList) {
            System.out.println(food);
        }
    }

    //레시피 목록이 비었는지 확인하는 함수
    public boolean isempy() {
        return FoodRecipeList!=null;
    }
}
