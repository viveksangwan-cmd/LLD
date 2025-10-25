import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class GlobalDirectory {
    public HashMap<String, List<User>> userNameToUserMapping;
    public HashMap<String,User> contactNumberToUserMapping;

    public GlobalDirectory(){
        this.contactNumberToUserMapping = new HashMap<>();
        this.userNameToUserMapping = new HashMap<>();
    }

    public void addUserToDirectory(User user){
        if(contactNumberToUserMapping.containsKey(user.contactNumber)) return;
        contactNumberToUserMapping.put(user.contactNumber,user);
        if(!userNameToUserMapping.containsKey(user.username)){
            userNameToUserMapping.put(user.username,new ArrayList<>());
        }
        userNameToUserMapping.get(user.username).add(user);
    }

    public void addNoToSpam(String contactNumber) {
        if(contactNumberToUserMapping.containsKey(contactNumber)){
            contactNumberToUserMapping.get(contactNumber).isSpam = true;
        }
    }

    public List<User> searchUserByUsername(String username) {
        if(userNameToUserMapping.containsKey(username)) return userNameToUserMapping.get(username);
        return new ArrayList<>();
    }

    public User searchUserByContactNumber(String contactNumber) {
        if(contactNumberToUserMapping.containsKey(contactNumber)) return contactNumberToUserMapping.get(contactNumber);
        return null;
    }
}
