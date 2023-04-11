package myrecipe;

import java.util.Set;

public class Food {

    public String foodname;

    public Set<String> material;

    public String recipe;

    public Food() {
    }

    private Food(String foodname, Set<String> material, String recipe) {
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
}
