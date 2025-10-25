import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserPhoneBookService {
    HashMap<String,UserPhoneBook> userToUserPhoneBookMapping;

    public UserPhoneBookService(){
        this.userToUserPhoneBookMapping = new HashMap<>();
    }

    public void blockContactNumber(String username,String contactNumber){
        userToUserPhoneBookMapping.get(username).blockContactNumber(contactNumber);
    }

    public void unblockContactNumber(String username,String contactNumber){
        userToUserPhoneBookMapping.get(username).unblockContactNumber(contactNumber);
    }

    public boolean isContactBlocked(String username,String contactNumber){
        if(userToUserPhoneBookMapping.containsKey(username)) return false;
        return userToUserPhoneBookMapping.get(username).isBlockedContactNumber(contactNumber);
    }

    public List<User> searchByUsername(String username,String searchingUsername){
        if(userToUserPhoneBookMapping.containsKey(username)) return new ArrayList<>();
        return userToUserPhoneBookMapping.get(username).getUsersByUsername(searchingUsername);
    }

    public User searchUserByContactNumber(String username,String contactNumber){
        if(!userToUserPhoneBookMapping.containsKey(username)) return null;
        return userToUserPhoneBookMapping.get(username).getUserByContactNumber(contactNumber);
    };

    public void addUserContactForAUser(String username, User user){
        if(!userToUserPhoneBookMapping.containsKey(username)) return;
        if(!userToUserPhoneBookMapping.containsKey(user.username)) userToUserPhoneBookMapping.put(user.username,new UserPhoneBook());
        userToUserPhoneBookMapping.get(username).addUserContact(user);
    };

    public void addUser(User user) {
        if(userToUserPhoneBookMapping.containsKey(user.username)) return;
        userToUserPhoneBookMapping.put(user.username, new UserPhoneBook());
    }
}


//- UserPhoneBookService // Singleton
//	- HashMap<int,UserPhoneBook> userPhoneBook;
//
//    Methods
//    addUser(User user);
//    blockNumber(User user,int number) // Blocks in userPhoneBookService
//    unblockNumber(User user,int number) // Unblocks in userPhoneBookService
//    isContactNumberBlocked(User user,int contactNumber): Boolean;
//    searchByUsername(User user,Sting username): User;
//    searchUserByContanctNumber(User user,int contactNumber): User