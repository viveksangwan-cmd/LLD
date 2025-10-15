import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addCartItems(List<CartItem> cartItems) {
        this.cartItems.addAll(cartItems);
    }

    public void addCartItems(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public void addProductToCart(Product product,int quantity){
        cartItems.add(new CartItem(product,quantity));
    }

}
