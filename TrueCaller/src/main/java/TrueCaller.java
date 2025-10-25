public class TrueCaller {
    public static void main(String[] args) throws Exception {
        User user1 = new UserBuilder().setContactNumber("1234").setUsername("test").build();
        User user1Frnd = new UserBuilder().setContactNumber("2345").setUsername("test's frnd").build();
        PhoneBookService phoneBookService = PhoneBookService.getInstance();
        phoneBookService.addUserContact(user1);
        phoneBookService.addUserContactForAUser(user1.username,user1Frnd);
        User findFrnd = phoneBookService.searchUserByContactNumber(user1,user1Frnd.contactNumber);
        System.out.println(user1.userId+" "+ user1.username+" "+user1.contactNumber);
        System.out.println(findFrnd.userId+" "+ findFrnd.username+" "+findFrnd.contactNumber);

        User user2 = new UserBuilder().setContactNumber("45676").setUsername("user2").build();
        User globalSearch = phoneBookService.searchUserByContactNumber(user2,user1Frnd.contactNumber);
        System.out.println(globalSearch.userId+" "+globalSearch.username+" "+globalSearch.contactNumber);

    }

}
