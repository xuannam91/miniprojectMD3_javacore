package fileservice;

import data.Data;
import model.Catagory;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductFileService {
    private static List<Product> products;
    private Data<Product> ProductData = new Data();
    public ProductFileService() {
        List<Product> productList = ProductData.readFromFile(Data.PRODUCT_DATA);
        if (productList == null) {
            productList = new ArrayList<>();
        }
        this.products = productList;
    }
    // lấy ra một danh sách sản phẩm
    public List<Product> getAllProduct() {
        return products;
    }


    // hàm nạp dữ liệu vào file product
    public void saveToFileProduct(Product product) {
        if (findByIdProduct(product.getProductId()) == null) {
            products.add(product);
        } else {
            products.set(products.indexOf(findByIdProduct(product.getProductId())), product);
        }
        ProductData.writeToFile(products, Data.PRODUCT_DATA);

    }


    // Tìm kiếm sản phẩm theo Id
    public Product findByIdProduct(int id) {
        for (Product product : products) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }

    // Tìm kiếm sản phẩm theo Tên
    public Product findByNameProduct(String name) {
        for (Product product : products) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}
