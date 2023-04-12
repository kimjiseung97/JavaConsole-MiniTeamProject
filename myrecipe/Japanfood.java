package myrecipe;

public class Japanfood extends Food {

    public Japanfood() {
    }


    @Override
    public String toString() {
        return "Japanfood{" +
                "username='" + username + '\'' +
                ", foodname='" + foodname + '\'' +
                ", material=" + material +
                ", recipe='" + recipe + '\'' +
                ", Category='" + Category + '\'' +
                ", writerName='" + writerName + '\'' +
                '}';
    }
}
