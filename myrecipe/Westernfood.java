package myrecipe;

public class Westernfood extends Food {



    @Override
    public String toString() {
        return "양식 : [" +
                "음식이름='" + foodname + '\'' +
                ", 재료=" + material +
                ", 조리법='" + recipe + '\'' +
                ", 분류코드='" + Category + '\'' +
                ']'+"\n";
    }
}
