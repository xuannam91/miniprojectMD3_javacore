package model;

import java.io.Serializable;

import static constant.Constant.Atc.ON;
import static constant.Constant.Role.ADMIN;
import static constant.Constant.Status.ACTIVE;

public class CartItem implements Serializable {
    private static final long serialVersionUID = 5l;
    private int cartItemID;
    private Product product;
    private int quantity;

    public CartItem() {
    }

    public CartItem(int cartItemID, Product product, int quantity) {
        this.cartItemID = cartItemID;
        this.product = product;
        this.quantity = quantity;
    }

    public int getCartItemID() {
        return cartItemID;
    }

    public void setCartItemID(int cartItemID) {
        this.cartItemID = cartItemID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("CartItem{");
        sb.append("cartItemID: ").append(cartItemID);
        sb.append(", Product: '").append(product.getProductName()).append('\'');
        sb.append(", Price: '").append(product.getUnitPrice()).append('\'');
        sb.append(", Quantity: '").append(quantity).append('\'');
        sb.append(", TotalAmout: '").append(quantity*product.getUnitPrice()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
