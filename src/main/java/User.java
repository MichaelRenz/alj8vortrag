/**
 * Created by frank.vogel on 16.06.2015.
 */
public class User {
    private String userNames[] = {"Zachery Haley", "Destiny Gil", "Berenice Kidd", "Clotilde Shelley", "Verdell Grice", "Nida Irwin", "Jospeh Mchenry", "Tomi Creamer", "Hildegard Bunnell", "Vern Fenton", "Tamekia Merrick", "Tashia Daly", "Elizebeth Finch", "Donny Fong", "Salina Champion", "Ngan Blocker", "Donya Cornett", "Jene Williford", "Orpha Gibbons", "Meridith Holman", "Odessa Keith", "Carmine Weeks", "Delinda Shank", "Son Crooks", "Timika Winkler"};
    private String userName;
    private int userId;
    private UserStatus userStatus = UserStatus.ACTIVE;

    public User() {
        userName = userNames[((int) (Math.random()*10))];
        userId = (int) (Math.random()*10000)+5000;
        userStatus = UserStatus.values()[(int) ((Math.random()) * UserStatus.values().length)];
        this.userName = userName;
        this.userId = userId;
        this.userStatus = userStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userId=" + userId +
                ", userStatus=" + userStatus +
                '}';
    }
}
