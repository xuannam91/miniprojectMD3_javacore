package service;

import fileservice.ProductFileService;
import model.Catagory;
import model.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


import static constant.Constant.ProductStatus.CON_HANG;
import static constant.Constant.ProductStatus.HET_HANG;
import static validate.ValidateProduct.*;

public class ProductService {
    public static ProductFileService productFileService = new ProductFileService();
    public static List<Product> productList = productFileService.getAllProduct();

    // Hiển thị danh sách sản phẩm
    public static void displayProductList(){
        if(!productList.isEmpty()){
            for (Product p: productList) {
                System.out.println(p);
            }
        }else {
            System.out.println("Chưa có sản phẩm nào tồn tại");
        }
    }

    // Tạo mới một sản phẩm
    public static void saveProduct(){
        Product product = newProduct();
        productFileService.saveToFileProduct(product);
        System.out.println("Đã thêm mới sản phẩm thành công");
    }
    public static Product newProduct(){
        Product product = new Product();
        System.out.println("Nhập vào tên sản phẩm");
        product.setProductName(validateNameProduct());

        product.setCategory(validateCataToProduct());

        System.out.println("Nhập mô tả sản phẩm");
        product.setDescription(validateDescriptionProduct());

        System.out.println("Nhập giá sản phẩm");
        product.setUnitPrice(validatePriceProduct());

        System.out.println("Nhập số lượng");
        product.setStock(validateStockProduct());

        product.setProductStatus(CON_HANG);

        product.setProductId(autoIdProduct());

        return product;
    }


    // Chỉnh sửa thông tin sản phẩm.

    public static void updateProduct(Scanner scanner){
        try{
            System.out.println(" Nhập mã ID sản phẩm cần thay đổi thông tin");
            int updateIdProduct = Integer.parseInt(scanner.nextLine());
            Product productUpdate = productFileService.findByIdProduct(updateIdProduct);
            if(productUpdate != null){
                System.out.println("Nhập tên sản phẩm mới muốn thay đổi");
                productUpdate.setProductName(validateNameProduct());

                productUpdate.setCategory(validateCataToProduct());

                System.out.println("Nhập mô tả sản phẩm mới");
                productUpdate.setDescription(validateDescriptionProduct());

                System.out.println("Nhập giá sản phẩm mới");
                productUpdate.setUnitPrice(validatePriceProduct());

                System.out.println("Nhập số lượng mới");
                productUpdate.setStock(validateStockProduct());

                productUpdate.setProductStatus(CON_HANG);


                productFileService.saveToFileProduct(productUpdate);
                System.out.println("Đã đổi thông tin sản phẩm thành công");

            }else {
                System.err.println("Không tìm thấy sản phẩm cần thay đổi thông tin");
            }
        }catch (InputMismatchException | NumberFormatException e){
            System.err.println("Nhập không đúng yêu cầu");
            updateProduct(scanner);
        }
    }


    // Ẩn sản phẩm theo mã sản phẩm
    public static void changeProductStatus(Scanner scanner) {
        try {
            System.out.println("Hãy nhập mã Id Sản phẩm muốn thay đổi trạng thái");
            int productID = Integer.parseInt(scanner.nextLine());
            Product productUpdateStatus = productFileService.findByIdProduct(productID);
            if (productUpdateStatus != null) {
                try {
                    System.out.println("Nhập vào trạng thái người dùng muốn thay đổi (0: HET_HANG, 1: CON_HANG)");
                    int statusIntProduct = Integer.parseInt(scanner.nextLine());
                    productUpdateStatus.setProductStatus(statusIntProduct == 1 ? CON_HANG : HET_HANG);

                    productFileService.saveToFileProduct(productUpdateStatus);
                    System.out.println("Đã đổi trạng thái sản phẩm thành công");
                } catch (InputMismatchException | NumberFormatException e) {
                    System.err.println("Nhập không đúng yêu cầu.");
                    changeProductStatus(scanner);
                }

            } else {
                System.err.println("Không thể tìm thấy sản phẩm cần ẩn khi hết hàng");
            }

        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println("Nhập không đúng yêu cầu.");
            changeProductStatus(scanner);
        }

    }

    //Tìm kiếm sản phẩm theo tên
    public static void searchProduct(Scanner scanner) {
        System.out.println("Nhập tên sản phẩm bạn muốn tìm kiếm:");
        String productName = scanner.nextLine();

        List<Product> filteredProducts = new ArrayList<>();
        for (Product p : productList) {
            if (p.getProductName().toLowerCase().contains(productName.toLowerCase())) {
                filteredProducts.add(p);
            }
        }
        if(filteredProducts.isEmpty()){
            System.out.println("Không tìm thấy sản phẩm với từ khoá: "+ productName);
        }else {
            System.out.println("Kết quả tìm kiếm sản phẩm");
            for (Product product : filteredProducts) {
                System.out.println(product);
            }
        }
    }


}
