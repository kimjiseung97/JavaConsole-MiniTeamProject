package myrecipe;

public class Chinafood extends Food {


    public Chinafood() {
    }


    @Override
    public String toString() {
        return "중식[" +
                "음식이름='" + foodname + '\'' +
                ", 재료=" + material +
                ", 조리법='" + recipe + '\'' +
                ']'+"\n";
    }
}
