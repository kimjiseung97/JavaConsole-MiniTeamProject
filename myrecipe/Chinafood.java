package myrecipe;

public class Chinafood extends Food {


    public Chinafood() {
    }


    @Override
    public String toString() {
        return "Chinafood{" +
                "username='" + username + '\'' +
                ", foodname='" + foodname + '\'' +
                ", material=" + material +
                ", recipe='" + recipe + '\'' +
                ", Category='" + Category + '\'' +
                ", writerName='" + writerName + '\'' +
                '}';
    }
}
