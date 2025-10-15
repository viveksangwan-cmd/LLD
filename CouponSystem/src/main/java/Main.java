import java.util.Arrays;
import java.util.List;

public class Main {
    static void main() {
        User user = new User("Vivek",25,true);
//        Builder
        Product productLGTV = new Product("LG TV",10,10000,"electronics");
        CartItem cartItem = new CartItem(productLGTV,1);

        Cart cart = new Cart();
        cart.addCartItems(cartItem);

        Order order = new Order(user,cart);

//        Singleton
        CouponService couponService = new CouponService();
        couponService.addCoupon(new Coupon(List.of(new ElectronicsProductRule())));
        List<Coupon> couponList = couponService.getApplicableCoupons(order);
        System.out.println("Applicable coupon count : "+couponList.size());
        couponList.stream().forEach(coupon -> System.out.println(coupon.getDiscount(order)));
    }
}
