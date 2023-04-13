package user;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File fileInfo = new File("D:/UserData");
        if(!fileInfo.exists())fileInfo.mkdir();
        UserView cv = new UserView();
        cv.start();
    }
}
