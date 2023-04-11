package myrecipe;

import java.util.Set;

public class Koreafood extends Food {

    private String foodname;

    private Set<String> material;

    private String recipe;

    public Koreafood() {
    }

    private Koreafood(String foodname, Set<String> material, String recipe) {
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

    public Set<String> getMaterial(Set<String> material) {
        return this.material;
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
