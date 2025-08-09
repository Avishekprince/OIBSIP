import java.util.HashMap;

public class Bank {
    private HashMap<String, User> users;

    public Bank() {
        users = new HashMap<>();
        // Add sample users
        users.put("user1", new User("user1", "1234"));
        users.put("user2", new User("user2", "2345"));
        users.put("user3", new User("user3", "3456"));
    }

    public User login(String userId, String pin) {
        User user = users.get(userId);
        if (user != null && user.validatePin(pin)) {
            return user;
        }
        return null;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }
}
