import java.util.List;

public class GlobalDirectoryServices {
    private static GlobalDirectoryServices INSTANCE;
    GlobalDirectory globalDirectory;
    private GlobalDirectoryServices(){
        this.globalDirectory = new GlobalDirectory();
    }

    public static GlobalDirectoryServices getInstance(){
        if(INSTANCE==null){
            synchronized (GlobalDirectoryServices.class){
                if(INSTANCE==null){
                    INSTANCE = new GlobalDirectoryServices();
                }
            }
        }
        return INSTANCE;
    }


    public void addUserToGlobalDirectory(User user){
        globalDirectory.addUserToDirectory(user);
    }

    public void addNoToSpam(String contactNumber){
        globalDirectory.addNoToSpam(contactNumber);
    }

    public List<User> searchUserByUsername(String username){
        return globalDirectory.searchUserByUsername(username);
    }

    public User searchUserByContactNumber(String contactNumber){
        return globalDirectory.searchUserByContactNumber(contactNumber);
    }
}


//- GlobalDirectoryService // which will perform operations on  GlobalDirectory // Singleton
//	- GlobalDirectory globalDirectory;
//
//    Methods
//    addUserToGlobalDirectory(User user): Void;
//    addNoToSpam(Integer number): Void;
//    searchUserByUsername(String username): User;
//    searchUserByContanctNumber(int contactNumber): User;