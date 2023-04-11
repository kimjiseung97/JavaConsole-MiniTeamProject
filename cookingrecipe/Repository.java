package cookingrecipe;

public class Repository {
    private static UserData userData;

    // 유저를 등록하는 기능
    public void register(UserData userInfo) {
        userData = userInfo;
    }

    // 여기에 있는 userData 정보 리턴
    public UserData findBookUser() {
        return userData;
    }
}
