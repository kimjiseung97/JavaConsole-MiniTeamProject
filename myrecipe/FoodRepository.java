package myrecipe;

import user.UserView;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static myrecipe.Util.Utility.input;

public class FoodRepository implements Serializable {

    private final  static String savePath;
    public static ArrayList<Food> FoodRecipeList;

    public static UserView userView;

    static {
        userView = new UserView();
        FoodRecipeList = new ArrayList<Food>();
        savePath =  "D:/UserData";
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
        if(FoodRecipeList.size()==0){
            return true;
        }else{
            return false;
        }
    }

    //재료이름으로 음식을 찾는 함수
    public void findbymaterial(String findmaterial) {

        for (Food food : FoodRecipeList) {
            if (food.material.contains(findmaterial)){
                System.out.println(food);
                return;
            }else{
                System.out.println(findmaterial+"이 들어가는 음식을 찾지못했습니다.");
            }
        }
    }

    public void findbyCategory(String findCategory) {
        for (Food food : FoodRecipeList) {
            if(food.Category.equals(findCategory)){
                System.out.println(food);
            }
            return;
        }
        System.out.println(findCategory+"카테고리 음식을 찾지 못했습니다.");
    }


    public void RemoveRecipe(String removefoodname) {
        int num = gettargetIndexnum(removefoodname);
        for (Food food : FoodRecipeList) {
            if(food.getFoodname().equals(removefoodname)){
                FoodRecipeList.remove(num);
                System.out.println(food.getFoodname()+"가 삭제되었습니다.");
                return;
            }
        }
        System.out.println(removefoodname+"를 찾을수 없습니다.");
    }

    public void ChangeRecipe(String change) {
        int num = gettargetIndexnum(change);
        for (Food food : FoodRecipeList) {
            if(food.getFoodname().equals(change)){
                if (food.Category.equals("kr")) {
                    String foodname = input("음식이름 : ");
                    Set<String> material = new HashSet<>();
                    while(true){
                        System.out.println("음식재료를 입력해주세요! [엔터입력시 종료]");
                        String meterialname = input("재료 : ");
                        if(meterialname.equals("")) break;
                        material.add(meterialname);
                    }
                    String recipe = input("조리법 : ");
                    Food fd = new Koreafood();
                    fd.setCategory(food.Category);
                    fd.setFoodname(foodname);
                    fd.setMaterial(material);
                    fd.setRecipe(recipe);
                    fd.setWriterName(userView.getLoginUserName());
                    FoodRecipeList.set(num, fd);
                    System.out.println("레시피 수정이 완료되었습니다!");
                    return;
                }else if(food.Category.equals("ch")){
                    String foodname = input("음식이름 : ");
                    Set<String> material = new HashSet<>();
                    while(true){
                        System.out.println("음식재료를 입력해주세요! [엔터입력시 종료]");
                        String meterialname = input("재료 : ");
                        if(meterialname.equals("")) break;
                        material.add(meterialname);
                    }
                    String recipe = input("조리법 : ");
                    Food fd = new Chinafood();
                    fd.setCategory(food.Category);
                    fd.setFoodname(foodname);
                    fd.setMaterial(material);
                    fd.setRecipe(recipe);
                    fd.setWriterName(userView.getLoginUserName());
                    FoodRecipeList.set(num, fd);
                    System.out.println("레시피 수정이 완료되었습니다!");
                    return;
                }else if(food.Category.equals("we")){
                    String foodname = input("음식이름 : ");
                    Set<String> material = new HashSet<>();
                    while(true){
                        System.out.println("음식재료를 입력해주세요! [엔터입력시 종료]");
                        String meterialname = input("재료 : ");
                        if(meterialname.equals("")) break;
                        material.add(meterialname);
                    }
                    String recipe = input("조리법 : ");
                    Food fd = new Westernfood();
                    fd.setCategory(food.Category);
                    fd.setFoodname(foodname);
                    fd.setMaterial(material);
                    fd.setRecipe(recipe);
                    fd.setWriterName(userView.getLoginUserName());
                    FoodRecipeList.set(num, fd);
                    System.out.println("레시피 수정이 완료되었습니다!");
                    return;
                }else if(food.Category.equals("jp")){
                    String foodname = input("음식이름 : ");
                    Set<String> material = new HashSet<>();
                    while(true){
                        System.out.println("음식재료를 입력해주세요! [엔터입력시 종료]");
                        String meterialname = input("재료 : ");
                        if(meterialname.equals("")) break;
                        material.add(meterialname);
                    }
                    String recipe = input("조리법 : ");
                    Food fd = new Japanfood();
                    fd.setCategory(food.Category);
                    fd.setFoodname(foodname);
                    fd.setMaterial(material);
                    fd.setRecipe(recipe);
                    fd.setWriterName(userView.getLoginUserName());
                    FoodRecipeList.set(num, fd);
                    System.out.println("레시피 수정이 완료되었습니다!");
                    return;
                }
            }

        }
        System.out.println("레시피가 존재하지 않습니다 다시입력해주세요!");
    }


    private static int gettargetIndexnum(String foodname) {
        for (Food data : FoodRecipeList) {
            if(data.getFoodname().equals(foodname)){
                return FoodRecipeList.indexOf(data);
            }
        }
        return -1;
    }


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


    //세이브파일 로드함수
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

}
