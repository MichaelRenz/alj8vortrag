/**
 * Created by frank.vogel on 16.06.2015.
 */
public class User {
    private String firstNames[] = {"Adrian","Austin","Barb","Bev","Brendon","Carin","Carmine","Carry","Catarina","Cathie","Celesta","Clora","Cristi","Daina","Dalila","Damien","Darell","Delicia","Deshawn","Dominica","Elida","Elna","Elyse","Emelina","Fidel","Forest","Francisca","Frankie","Haywood","Helaine","Helga","Isis","Jacki","Jackson","Jacquelynn","Jame","Jesusita","Jinny","Jonah","Jude","Juliet","Kai","Karole","Kathaleen","Keli","Kera","Lahoma","Lauralee","Lavada","Lavon","Leonor","Letty","Lorita","Loyd","Luciana","Madalyn","Maren","Marielle","Mathilda","Maudie","Mavis","Melita","Melony","Migdalia","Misha","Nakesha","Nakita","Napoleon","Nicky","Nilda","Noble","Nolan","Odell","Ofelia","Pasty","Patience","Patria","Perla","Rebeca","Refugia","Richie","Rocco","Rodrick","Sallie","Sarita","Saundra","Shara","Suzie","Tajuana","Teddy","Tempie","Teofila","Terra","Un","Valorie","Vanna","Wally","Yan","Ying","Zella"};
    private String lastNames[] = {"Adame","Aguiar","Anglin","Arrington","Ashley","Barone","Bauer","Beattie","Beeler","Belt","Bernard","Berryman","Beyer","Bills","Block","Bourque","Bowlin","Braden","Brinkley","Brito","Brower","Bueno","Busby","Christman","Chun","Cockrell","Corbitt","Dill","Dooley","Dorsey","Dowell","Driver","Drury","Duval","Eller","Forman","Forsyth","Forsythe","Frick","Gilliland","Guenther","Hoff","Hutchison","Hyatt","Joyce","Kerr","Kohler","Kuhn","Lafferty","Lake","Ligon","Lofton","Lutz","Ma","Macias","Marcotte","Mayfield","Mayhew","Mcintyre","Mckinley","Mcknight","Mcmahon","Mcmanus","Mcneely","Means","Musser","Oglesby","Olivas","Orr","Osullivan","Portillo","Reddick","Ritter","Roland","Sanderson","Sands","Saxon","Scoggins","Segura","Shea","Shores","Shrader","Slack","Sprague","Springer","Staggs","Stanfield","Steen","Stiltner","Swan","Swank","Taggart","Thibodeaux","Tierney","Toliver","Towns","Trask","Trimble","Turney","Wester"};
    private String firstName;
    private String lastName;
    private int age;
    private int userId;
    private UserStatus userStatus = UserStatus.ACTIVE;

    public User() {
        lastName = lastNames[((int) (Math.random() * firstNames.length))];
        firstName = firstNames[((int) (Math.random() * lastNames.length))];
        age = (int) (Math.random() * 98 + 1 ); // 1 - 99
        userId = (int) (Math.random() * 10000) + 5000;
        userStatus = UserStatus.values()[(int) ((Math.random()) * UserStatus.values().length)];
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.userStatus = userStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public int getAge() {
        return age;

    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", userId=" + userId +
                ", userStatus=" + userStatus +
                '}';
    }
}
