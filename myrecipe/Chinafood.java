package myrecipe;

public class Chinafood extends Food {


    public Chinafood() {
    }


    @Override
    public String toString() {
        return "중식[" +
                "음식명='" + foodname + '\'' +
                ", 재료=" + material +
                ", 조리법='" + recipe + '\'' +
                ", 카테고리='" + Category + '\'' +
                ", 작성자='" + writerName + '\'' +
                ']';
    }
}
