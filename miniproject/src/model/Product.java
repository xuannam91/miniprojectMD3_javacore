package model;

import java.io.Serializable;

import static constant.Constant.ProductStatus.CON_HANG;

public class Product implements Serializable {
    private static final long serialVersionUID = 3l;
    private int productId;
    private  String productName;
    private Catagory category;
    private String description;
    private double unitPrice;
    private int stock;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, Catagory category, String description, double unitPrice, int stock, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.description = description;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Catagory getCategory() {
        return category;
    }

    public void setCategory(Catagory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }


    public String toString() {
        final StringBuilder product = new StringBuilder("Product{");
        product.append("Mã sản phẩm: ").append(productId);
        product.append(", Tên sản phẩm: '").append(productName).append('\'');
        product.append(", Tên danh mục: '").append(category.getCatelogName()).append('\'');
        product.append(", Mô tả sản phẩm: '").append(description).append('\'');
        product.append(", Đơn giá: '").append(unitPrice).append('\'');
        product.append(", Số lượng: '").append(stock).append('\'');
        product.append(", Trạng thái sản phẩm: ").append(productStatus == CON_HANG ? "'CON_HANG'" : "'HET_HANG'");
        product.append('}');
        return product.toString();
    }
}
