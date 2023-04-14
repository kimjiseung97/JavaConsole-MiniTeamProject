package myrecipe;

public class Japanfood extends Food {

    public Japanfood() {
    }



    @Override
    public String toString() {
        return "일식[" +
                "음식명='" + foodname + '\'' +
                ", 재료=" + material +
                ", 조리법='" + recipe + '\'' +
                ", 카테고리='" + Category + '\'' +
                ", 작성자='" + writerName + '\'' +
                ']';
    }
}
