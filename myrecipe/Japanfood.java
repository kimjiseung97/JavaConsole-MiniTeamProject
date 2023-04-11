package myrecipe;

public class Japanfood extends Food {

    public Japanfood() {
    }


    @Override
    public String toString() {
        return "일식 : [" +
                "음식이름='" + foodname + '\'' +
                ", 재료=" + material +
                ", 조리법='" + recipe + '\'' +
                ", 분류코드='" + Category + '\'' +
                ']'+"\n";
    }
}
