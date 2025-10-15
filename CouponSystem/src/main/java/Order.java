import java.util.List;

public class Order {
    public User user;
    public Cart card;
    public List<Coupon> recommendedCoupon;

    public Order(User user, Cart card) {
        this.user = user;
        this.card = card;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart getCard() {
        return card;
    }

    public void setCard(Cart card) {
        this.card = card;
    }

    public List<Coupon> getRecommendedCoupon() {
        return recommendedCoupon;
    }
}
