import com.sun.security.jgss.GSSUtil;

import java.util.List;

public class PhoneBookService {
    GlobalDirectoryServices globalDirectoryServices;
    UserPhoneBookService userPhoneBookService;
    private static PhoneBookService INSTANCE;
    private PhoneBookService(){
        this.globalDirectoryServices = GlobalDirectoryServices.getInstance();
        this.userPhoneBookService = new UserPhoneBookService();
    }

    public static PhoneBookService getInstance(){
        if(INSTANCE==null){
            synchronized (PhoneBookService.class){
                if(INSTANCE==null){
                    INSTANCE = new PhoneBookService();
                }
            }
        }
        return INSTANCE;
    }

    public void blockContactNumber(String username,String contactNumber){
        userPhoneBookService.blockContactNumber(username,contactNumber);
    }

    public void unblockContactNumber(String username,String contactNumber){
        userPhoneBookService.unblockContactNumber(username,contactNumber);
    }

    public boolean isContactBlocked(String username,String contactNumber){
        return userPhoneBookService.isContactBlocked(username,contactNumber);
    }

    public List<User> searchByUsername(User user, String searchingUsername){
        List<User> localUserList = userPhoneBookService.searchByUsername(user.username,searchingUsername);
        if(user.isPrime){
            localUserList.addAll(globalDirectoryServices.searchUserByUsername(searchingUsername));
        }
        return  localUserList;
    }

    public User searchUserByContactNumber(User user,String contactNumber){
        User searchedUser = userPhoneBookService.searchUserByContactNumber(user.username,contactNumber);
        if(searchedUser!=null){
            System.out.println("User found is user contacts");
            return searchedUser;
        }
        searchedUser = globalDirectoryServices.searchUserByContactNumber(contactNumber);
        if(searchedUser!=null){
            System.out.println("User found in global directory");
            return searchedUser;
        }
        System.out.println("User not found");
        return searchedUser;
    };

    public void addUserContact(User user){
        userPhoneBookService.addUser(user);
        addUserToGlobalDirectory(user);
    };

    public void addUserContactForAUser(String username, User user){
        userPhoneBookService.addUserContactForAUser(username,user);
        addUserToGlobalDirectory(user);
    }

    private void addUserToGlobalDirectory(User user){
        globalDirectoryServices.addUserToGlobalDirectory(user);
    }

}
