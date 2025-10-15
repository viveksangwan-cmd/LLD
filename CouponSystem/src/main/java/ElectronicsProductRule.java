public class ElectronicsProductRule implements Rules{

    @Override
    public boolean isApplicable(Order order) {
        return order.getCard().getCartItems().stream().anyMatch(cartItem -> cartItem.getProduct().getCategory().equalsIgnoreCase("electronics"));
    }
}
