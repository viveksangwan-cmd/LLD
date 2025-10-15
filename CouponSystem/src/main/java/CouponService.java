import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CouponService {
    private final List<Coupon> couponList;

    public CouponService(){
        couponList = new ArrayList<>();
    }

    public void addCoupon(Coupon coupon){
        couponList.add(coupon);
    }
    public List<Coupon> getApplicableCoupons(Order order){
        return couponList.stream().filter(coupon -> coupon.isApplicable(order)).collect(Collectors.toList());
    }
}
