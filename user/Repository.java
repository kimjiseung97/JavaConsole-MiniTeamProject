package user;

public class Repository {
    private static UserData userData;

    // 유저를 등록하는 기능 (View에 static UserData userData를 만들어서 쓸모없는 기능)
    public void register(UserData userInfo) {
        userData = userInfo;
    }

    // 여기에 있는 userData 정보 리턴
    public UserData findUser() {
        return userData;
    }
}
