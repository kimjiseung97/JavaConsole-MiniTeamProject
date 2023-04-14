package myrecipe;

public class Koreafood extends Food {

    public Koreafood() {
    }

//    private Koreafood(String foodname, Set<String> material, String recipe) {
//        super.foodname = foodname;
//        super.material = material;
//        super.recipe = recipe;
//    }
//
//    public String getFoodname() {
//        return super.foodname;
//    }
//
//    public void setFoodname(String foodname) {
//        super.foodname = foodname;
//    }
//
//    public Set<String> getMaterial(Set<String> material) {
//        return super.material;
//    }
//
//    public void setMaterial(Set<String> material) {
//        super.material = material;
//    }
//
//    public String getRecipe() {
//        return recipe;
//    }
//
//    public void setRecipe(String recipe) {
//        super.recipe = recipe;
//    }


    @Override
    public String toString() {
        return "한식[" +
                "음식명='" + foodname + '\'' +
                ", 재료=" + material +
                ", 조리법='" + recipe + '\'' +
                ", 카테고리='" + Category + '\'' +
                ", 작성자='" + writerName + '\'' +
                ']';
    }
}
