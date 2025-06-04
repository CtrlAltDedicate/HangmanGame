import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserStorage {
    private static List<User> users = new ArrayList<>();

    public static boolean register(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return false; // user exists
            }
        }
        users.add(new User(username, password));
        return true;
    }

    public static User login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public static List<User> getLeaderboard() {
        users.sort(Comparator.comparingInt(User::getScore).reversed());
        return users;
    }
}
