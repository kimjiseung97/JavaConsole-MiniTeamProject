package myrecipe;

import java.io.Serializable;
import java.util.Set;

public class Food implements Serializable {

    public String foodname;
    public Set<String> material;

    public String recipe;

    public String Category;

    public String writerName;

    public Food() {
    }

    public Food(String foodname, Set<String> material, String recipe, String category, String writerName) {
        this.foodname = foodname;
        this.material = material;
        this.recipe = recipe;
        Category = category;
        this.writerName = writerName;
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

    public void setCategory(String category) {
        this.Category = category;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodname='" + foodname + '\'' +
                ", material=" + material +
                ", recipe='" + recipe + '\'' +
                ", Category='" + Category + '\'' +
                ", writerName='" + writerName + '\'' +
                '}';
    }
}

