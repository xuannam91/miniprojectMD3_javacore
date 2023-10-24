package service;

import model.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static constant.Constant.ProductStatus.CON_HANG;
import static service.ProductService.productFileService;
import static service.ProductService.productList;

public class HomeService {


    // Tìm kiếm sản phẩm còn hàng theo tên
    public static void searchProductInStock(Scanner scanner){
        System.out.println("Nhập tên sản phẩm bạn muốn tìm kiếm:");
        String productName = scanner.nextLine();

        List<Product> filteredProducts = new ArrayList<>();
        for (Product p : productList) {
            if (p.getProductName().toLowerCase().contains(productName.toLowerCase())) {
                filteredProducts.add(p);
            }
        }
        List<Product> seaProducts = new ArrayList<>();
        for (Product product : filteredProducts) {
            if(product.isProductStatus() == CON_HANG){
                seaProducts.add(product);
            }
        }
        if(seaProducts.isEmpty()){
            System.out.println("Không tìm thấy sản phẩm");
        }else {
            for (Product p : seaProducts) {
                System.out.println(p);
            }
        }
    }

    // Hiển thị 5 sản phẩm  mới nhất
    public static void famous(){
        int size = productList.size();
        if(size >= 5){
            List<Product> famousProducts = productList.subList(size - 5, size);
            for (Product p : famousProducts) {
                System.out.println(p);
            }
        }
    }

    // Hiển thị từng nhóm sản phẩm theo danh mục

    public static void searchProductByCategory(Scanner scanner){
        try {
            System.out.println("Nhập mã danh mục để tìm sản phẩm");
            int idcate = Integer.parseInt(scanner.nextLine());
            List<Product> products= new ArrayList<>();
            for (Product p: productList) {
                if(p.getCategory().getCatelogId() == idcate){
                    products.add(p);
                }
            }
            if(products.isEmpty()){
                System.out.println("Không tìm thấy sản phẩm nào trong danh mục này.");
            }else {
                for (Product p : products) {
                    System.out.println(p);
                }
            }
        }catch (InputMismatchException | NumberFormatException e){
            System.err.println("Nhập không đúng yêu cầu");
            searchProductByCategory(scanner);
        }
    }

    //  Hiển thị danh sách sắp xếp theo giá tăng dần
    public static void sortPriceUP() {
        productList.sort((p1, p2) -> Double.compare(p1.getUnitPrice(), p2.getUnitPrice()));
        for (Product element : productList) {
            System.out.println(element);
        }
    }


}
