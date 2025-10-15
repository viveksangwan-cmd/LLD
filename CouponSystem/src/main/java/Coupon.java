import java.util.List;

public class Coupon {
    List<Rules> rules;

    public Coupon(List<Rules> rules){
        this.rules = rules;
    }

    boolean isApplicable(Order order){

        return rules.stream().allMatch(rule -> {
            System.out.println("Checking for rule : "+rule.getClass());
            return rule.isApplicable(order);
        });
    }

    int getDiscount(Order order){
        return order.getCard().getCartItems().stream().filter( cartItem -> cartItem.getProduct().getCategory().equalsIgnoreCase("electronics")).findFirst().get().getPrice()/2;
    }
}

