package myrecipe;

import java.util.Set;

public class Japanfood extends Food {

    public Japanfood() {
    }

    private Japanfood(String foodname, Set<String> material, String recipe) {
        this.foodname = foodname;
        this.material = material;
        this.recipe = recipe;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Set<String> getMaterial() {
        return material;
    }

    public void setMaterial(Set<String> material) {
        this.material = material;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "일식[" +
                "음식명='" + foodname + '\'' +
                ", 재료=" + material +
                ", 조리법='" + recipe + '\'' +
                ']'+"\n";
    }
}
