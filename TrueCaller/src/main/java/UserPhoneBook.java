import java.util.*;

public class UserPhoneBook {
    public HashMap<String,User> contactNumberToUserMapping;
    public HashMap<String,List<User>> usernameToUserMapping;
    public Set<String> blockedUsers;

    public UserPhoneBook(){
        this.contactNumberToUserMapping = new HashMap<>();
        this.usernameToUserMapping = new HashMap<>();
        this.blockedUsers = new HashSet<>();
    }

    public void blockContactNumber(String contactNumber) {
        blockedUsers.add(contactNumber);
    }

    public void unblockContactNumber(String contactNumber){
        blockedUsers.remove(contactNumber);
    }

    public boolean isBlockedContactNumber(String contactNumber) {
        return false;
    }

    public List<User> getUsersByUsername(String username) {
        if(usernameToUserMapping.containsKey(username)) return usernameToUserMapping.get(username);
        return new ArrayList<>();
    }

    public User getUserByContactNumber(String contactNumber) {
        if(contactNumberToUserMapping.containsKey(contactNumber)) return contactNumberToUserMapping.get(contactNumber);
        return null;
    }

    public void addUserContact(User user) {
        contactNumberToUserMapping.put(user.contactNumber,user);
        if(!usernameToUserMapping.containsKey(user.username)) usernameToUserMapping.put(user.username,new ArrayList<>());
        usernameToUserMapping.get(user.username).add(user);
    }
}



//- UserPhoneBook // Represents each users own phonebook
//	- User user;
//	- HashMap<Integer,User> contantNumberMapping; // Represents User mapped to a unique contact number, which can be used as a cache
//	- HashMap<String,User> usernameMapping; // Represents Use mapped to a unique username, which can be used as a cache
//	- Set<Integer> blockedNumbers; // Collection of numbers which are blocked by the respected user;