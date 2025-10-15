public class User {
    private String name;
    private int age;
    private boolean isPremiumUser;

    public User(String name, int age, boolean isPremiumUser) {
        this.name = name;
        this.age = age;
        this.isPremiumUser = isPremiumUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isPremiumUser() {
        return isPremiumUser;
    }

    public void setPremiumUser(boolean premiumUser) {
        isPremiumUser = premiumUser;
    }
}
