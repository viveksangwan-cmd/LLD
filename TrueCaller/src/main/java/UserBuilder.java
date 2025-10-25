public class UserBuilder {
    User user;
    public UserBuilder(){
        this.user = new User();
    }

    public UserBuilder setUsername(String username){
        this.user.username = username;
        return this;
    }
    public UserBuilder setContactNumber(String contactNumber){
        this.user.contactNumber = contactNumber;
        return this;
    }
    public UserBuilder setPrime(Boolean isPrime){
        this.user.isPrime = isPrime;
        return this;
    }

    public User build() throws Exception {
        if(this.user.username.isBlank() || this.user.contactNumber.isBlank()) throw new Exception("Invalid User");
        return user;
    }

}
