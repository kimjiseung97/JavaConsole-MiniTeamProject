package myrecipe;

import user.UserView;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static myrecipe.Util.Utility.input;

public class FoodRepository implements Serializable {

    private final  static String savePath;
    public static ArrayList<Food> FoodRecipeList;

    public static UserView userView;

    static {
        userView = new UserView();
        FoodRecipeList = new ArrayList<>();
        savePath =  "D:/UserData";
    }

    private static boolean test(Food food) {
        return food.getWriterName().equals(userView.getLoginUserName());
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
        loadUserfoodDataFile();
        System.out.println("---------------전체 레시피 리스트------------------");
        for (Food food : FoodRecipeList) {
            System.out.println(food);
        }
        System.out.println("---------------------------------------------");
        input("엔터를 눌러 계속...........");
    }

    //레시피 목록이 비었는지 확인하는 함수
    public boolean isempy() {
        loadUserfoodDataFile();
        if(FoodRecipeList.size()==0){
            return true;
        }else{
            return false;
        }
    }

    //재료이름으로 음식을 찾는 함수
    public void findbymaterial(String findmaterial) {

        for (Food food : FoodRecipeList) {
            if (food.material.contains(findmaterial)) {
                System.out.println(food);
                return;
            }
        }
        System.out.println(findmaterial+"이 들어가는 음식을 찾지못했습니다.");
        input("엔터를 눌러 계속...........");
    }


    //카테고리로 레시피를 반환받는 함수
    public void findbyCategory(String findCategory) {
        ArrayList<Food> findfoodListByCategory = new ArrayList<>();

        for (Food food : FoodRecipeList) {
            if (food.getCategory().equals(findCategory)){
                findfoodListByCategory.add(food);
            }
        }
        if(findfoodListByCategory.isEmpty()) {
            System.out.println(findCategory + "카테고리 이름을 발견하지 못했습니다.");
            input("엔터를 눌러 계속...........");
        }else{
            System.out.println(findCategory + "음식리스트");
            for (Food food : findfoodListByCategory) {
                System.out.println(food);
            }
            input("엔터를 눌러 계속...........");
        }
    }


    //음식이름으로 레시피 삭제하는 함수
    public void RemoveRecipe(String removefoodname) {
        for (Food food : FoodRecipeList) {
            if(food.getFoodname().equals(removefoodname)&&food.getWriterName().equals(userView.getLoginUserName())){
                    int targetIndexnum = gettargetIndexnum(removefoodname);
                    FoodRecipeList.remove(targetIndexnum);
                    System.out.println(food.getFoodname()+"가 삭제되었습니다.");
                    //삭제한뒤에 세이브파일 저장 변경내용을 적용해야하기 때문에
                    saveUserfoodFile();
                    input("엔터를 눌러 계속...........");
                    return;
            }
        }
        System.out.println(removefoodname+"레시피는 \t" + userView.getLoginUserName()+"님이 작성한 글이 아니기때문에 삭제할 수없습니다");
        input("엔터를 눌러 계속...........");
    }


    //변경하고자 하는 음식이름으로 변경하는함수 카테고리는 그대로 가져감 (추후 수정예정)
    public void ChangeRecipe(String modifyfoodname) {
        for (Food food : FoodRecipeList) {
            if(food.getFoodname().equals(modifyfoodname) && food.getWriterName().equals(userView.getLoginUserName())){
                int num = gettargetIndexnum(modifyfoodname);
                if (food.Category.equals("kr")) {
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
                    Food fd = new Koreafood();
                    fd.setCategory(food.Category);
                    fd.setFoodname(foodname);
                    fd.setMaterial(material);
                    fd.setRecipe(recipe);
                    fd.setWriterName(userView.getLoginUserName());
                    FoodRecipeList.set(num, fd);
                    System.out.println("레시피 수정이 완료되었습니다!");
                    saveUserfoodFile();
                    input("엔터를 눌러 계속...........");
                    return;
                }else if(food.Category.equals("ch")){
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
                    Food fd = new Chinafood();
                    fd.setCategory(food.Category);
                    fd.setFoodname(foodname);
                    fd.setMaterial(material);
                    fd.setRecipe(recipe);
                    fd.setWriterName(userView.getLoginUserName());
                    FoodRecipeList.set(num, fd);
                    System.out.println("레시피 수정이 완료되었습니다!");
                    saveUserfoodFile();
                    input("엔터를 눌러 계속...........");
                    return;
                }else if(food.Category.equals("we")){
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
                    Food fd = new Westernfood();
                    fd.setCategory(food.Category);
                    fd.setFoodname(foodname);
                    fd.setMaterial(material);
                    fd.setRecipe(recipe);
                    fd.setWriterName(userView.getLoginUserName());
                    FoodRecipeList.set(num, fd);
                    System.out.println("레시피 수정이 완료되었습니다!");
                    saveUserfoodFile();
                    input("엔터를 눌러 계속...........");
                    return;
                }else if(food.Category.equals("jp")){
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
                    Food fd = new Japanfood();
                    fd.setCategory(food.Category);
                    fd.setFoodname(foodname);
                    fd.setMaterial(material);
                    fd.setRecipe(recipe);
                    fd.setWriterName(userView.getLoginUserName());
                    FoodRecipeList.set(num, fd);
                    System.out.println("레시피 수정이 완료되었습니다!");
                    saveUserfoodFile();
                    input("엔터를 눌러 계속...........");
                    return;
                }
            }

        }
        System.out.println(userView.getLoginUserName()+"\t님이 작성한 레시피가 존재하지 않습니다 다시입력해주세요!");
        input("엔터를 눌러 계속...........");
    }


    private static int gettargetIndexnum(String foodname) {
        for (Food data : FoodRecipeList) {
            if(data.getFoodname().equals(foodname)){
                return FoodRecipeList.indexOf(data);
            }
        }
        return -1;
    }



//    public static void removeRecipe(String foodname) {
//        int num = gettargetIndexnum(foodname);
//        for (Food data : FoodRecipeList) {
//            if(data.getFoodname().equals(foodname)){
//                FoodRecipeList.remove(num);
//                System.out.println(foodname + "삭제 되었습니다.");
//                return;
//            }
//        }
//        System.out.println(foodname + "찾지 못하였습니다.");
//    }


    //변경된 파일들을 저장하는 함수 객체배열을 sav파일 형식으로 저장한다.
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

    public void SearchRecipe(String search) {
        List<Food> foodNameFind = FoodRecipeList.stream()
                .filter(t -> t.getFoodname().equalsIgnoreCase(search))
                .collect(Collectors.toList());
        for (Food food : foodNameFind) {
            if(food.getFoodname().equalsIgnoreCase(search)){
                System.out.println(food);
                input("엔터를 눌러 계속...........");
                return;
            }
        }
        System.out.println("찾는 음식이름이 존재하지 않습니다.");
        input("엔터를 눌러 계속...........");

    }


    //세이브파일 로드함수 sav파일을 객체배열로 로드해서 화면에 뿌려줍니다.
    public static void loadUserfoodDataFile(){
        try (FileInputStream fis
                     = new FileInputStream(
                savePath+"/userfoodData.sav")) {

            // 객체를 불러올 보조스트림
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Food> object = (ArrayList<Food>) ois.readObject();
            FoodRecipeList = object;

        } catch (FileNotFoundException e) {
            System.out.println("현재 저장된 음식 데이터가 존재하지않습니다 데이터를 등록해주세요!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
