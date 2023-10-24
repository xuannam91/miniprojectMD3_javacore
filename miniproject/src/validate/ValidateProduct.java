package validate;

import model.Catagory;
import model.Product;
import model.User;
import service.CategoryService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static constant.Constant.CateStatus.APPEAR;
import static service.CategoryService.catagoryList;
import static service.ProductService.productList;

public class ValidateProduct {
    public static Scanner scanner = new Scanner(System.in);


    //VALIDATE ID PRODUCT AUTO
    public static int autoIdProduct() {
        int max = 0;
        for (Product p : productList) {
            if (max < p.getProductId()) {
                max = p.getProductId();
            }
        }
        return max + 1;
    }

    // VALIDATE NAME PRODUCT
    public static String validateNameProduct() {
        String productNameInput;
        do {
            productNameInput = scanner.nextLine();
            if (!productNameInput.isEmpty()) {
                return productNameInput;
            } else {
                System.err.println("Tên sản phẩm không được để trống");
            }
        } while (true);
    }


    // VALIDATE DANH MỤC CHO SẢN PHẨM

    public static Catagory validateCataToProduct() {
        System.out.println("Hãy chọn mã danh mục cho sản phẩm");
        Catagory catagory = null;
        int productCataIdInput;

        if (catagoryList.isEmpty()) {
            System.out.println("Danh mục chưa tồn tại, hãy nhập danh mục");
            CategoryService.saveCategory();
            try {
                do {
                    System.out.println("Hãy chọn mã danh mục cho sản phẩm");
                    for (Catagory catalog : catagoryList) {
                        if (catalog.isCateStatus() == APPEAR) {
                            System.out.println(catalog.getCatelogId() + " - " + catalog.getCatelogName());
                        }
                    }

                    productCataIdInput = Integer.parseInt(scanner.nextLine());


                    for (int i = 0; i < catagoryList.size(); i++) {
                        if (catagoryList.get(i).getCatelogId() == productCataIdInput) {
                            catagory = catagoryList.get(i);
                            break;
                        }
                    }
                    if (catagory != null) {
                        return catagory;
                    } else {
                        System.out.println("Yêu cầu nhập đúng Mã danh mục tồn tại");
                    }
                } while (true);
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Nhập không đúng yêu cầu");
                validateCataToProduct();
            }

        } else {
            try {
                do {
                    for (Catagory catalog : catagoryList) {
                        if (catalog.isCateStatus() == APPEAR) {
                            System.out.println(catalog.getCatelogId() + " - " + catalog.getCatelogName());
                        }
                    }

                    productCataIdInput = Integer.parseInt(scanner.nextLine());


                    for (int i = 0; i < catagoryList.size(); i++) {
                        if (catagoryList.get(i).getCatelogId() == productCataIdInput) {
                            catagory = catagoryList.get(i);
                            break;
                        }
                    }
                    if (catagory != null) {
                        return catagory;
                    } else {
                        System.out.println("Yêu cầu nhập đúng Mã danh mục tồn tại");
                    }
                } while (true);
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Nhập không đúng yêu cầu");
                validateCataToProduct();
            }
        }
        return null;
    }


    // VALIDATE  DESCRIPTION

    public static String validateDescriptionProduct() {
        String productDescriptionInput;
        do {
            productDescriptionInput = scanner.nextLine();
            if (!productDescriptionInput.isEmpty()) {
                return productDescriptionInput;
            } else {
                System.err.println("Mô tả sản phẩm không được để trống");
            }
        } while (true);
    }

    // VALIDATE  PRICE

    public static double validatePriceProduct() {
        double productPriceInput;
        do {
            try {
                productPriceInput = Double.parseDouble(scanner.nextLine());
                if (productPriceInput >= 0) {
                    return productPriceInput;
                } else {
                    System.err.println("Giá phải lớn hơn hoặc bằng 0");
                }
            }catch (InputMismatchException | NumberFormatException e){
                System.err.println("Vui lòng nhập một số hợp lệ.");
            }

        } while (true);
    }


    // VALIDATE  STOCK

    public static int validateStockProduct() {
        int productStockInput;
        do {
            try {
                productStockInput = Integer.parseInt(scanner.nextLine());
                if (productStockInput >= 0) {
                    return productStockInput;
                } else {
                    System.err.println("Số lượng phải lớn hơn hoặc bằng 0");
                }
            }catch (InputMismatchException | NumberFormatException e){
                System.err.println("Vui lòng nhập một số hợp lệ.");
            }

        } while (true);
    }



}
