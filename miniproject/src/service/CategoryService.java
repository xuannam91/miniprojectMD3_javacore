package service;

import fileservice.CategoryFileService;
import model.Catagory;
import model.Product;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


import static constant.Constant.CateStatus.APPEAR;
import static constant.Constant.CateStatus.HIDDEN;
import static service.ProductService.productFileService;
import static service.ProductService.productList;
import static validate.ValidateCatalog.autoIdCate;
import static validate.ValidateCatalog.validateCategoryName;

public class CategoryService {
    public static CategoryFileService categoryFileService = new CategoryFileService();
    public static List<Catagory> catagoryList = categoryFileService.getAllCategory();

    // Hiển thị danh sách danh mục
    public static void displayCatalogList(){
        if(!catagoryList.isEmpty()){
            for (Catagory cate: catagoryList) {
                System.out.println(cate);
            }
        }else {
            System.out.println("Chưa có danh mục nào tồn tại");
        }

    }

    // Tạo mới một danh mục
    public static void saveCategory(){
       Catagory category = newCategory();
        categoryFileService.saveToFileCategory(category);
        System.out.println("Đã thêm mới danh mục thành công");
    }
    public static Catagory newCategory(){
        Catagory catagory = new Catagory();
        System.out.println("Nhập vào tên danh mục");
        catagory.setCatelogName(validateCategoryName());

        catagory.setCateStatus(APPEAR);

        catagory.setCatelogId(autoIdCate());

        return catagory;
    }



    //Tìm kiếm danh mục theo tên
    static void searchCategory(Scanner scanner) {
        System.out.println("Nhập tên danh mục bạn muốn tìm kiếm:");
        String categoryName = scanner.nextLine();
        List<Catagory> filteredCatelogs = new ArrayList<>();

        for (Catagory ca : catagoryList) {
            if (ca.getCatelogName().toLowerCase().contains(categoryName.toLowerCase())) {
                filteredCatelogs.add(ca);
            }
        }
        if(filteredCatelogs.isEmpty()){
            System.out.println("Không tìm thấy danh mục với từ khoá: "+ categoryName);
        }else {
            System.out.println("Kết quả tìm kiếm category");
            for (Catagory ca : filteredCatelogs) {
                System.out.println(ca);
            }
        }

    }

    // Chỉnh sửa thông tin danh mục
    public static void updateCategoy(Scanner scanner){
        try{
            System.out.println(" Nhập mã ID danh mục cần thay đổi thông tin");
            int updateIdCate = Integer.parseInt(scanner.nextLine());
            Catagory catagoryUpdate = categoryFileService.findByIdCategory(updateIdCate);
            if(catagoryUpdate != null){
                System.out.println("Nhập tên danh mục mới muốn thay đổi");
                catagoryUpdate.setCatelogName(validateCategoryName());

                categoryFileService.saveToFileCategory(catagoryUpdate);
                System.out.println("Đã đổi tên danh mục thành công");

                // đổi category trong sản phẩm
                for (Product p: productList) {
                    if(p.getCategory().getCatelogId() == updateIdCate){
                        p.setCategory(catagoryUpdate);
                        productFileService.saveToFileProduct(p);
                    }
                }

            }else {
                System.err.println("Không tìm thấy danh mục cần thay đổi thông tin");
            }
        }catch (InputMismatchException | NumberFormatException e){
            System.err.println("Nhập không đúng yêu cầu");
            updateCategoy(scanner);
        }
    }

    // Ẩn danh mục theo mã danh mục
    public static void changeCategoryStatus(Scanner scanner) {
        try {
            System.out.println("Hãy nhập mã Id Danh mục muốn thay đổi trạng thái");
            int categoryID = Integer.parseInt(scanner.nextLine());
            Catagory catagoryUpdateStatus = categoryFileService.findByIdCategory(categoryID);
            if (catagoryUpdateStatus != null) {
                try {
                    System.out.println("Nhập vào trạng thái người dùng muốn thay đổi (0: HIDDEN, 1: APPEAR)");
                    int statusIntCate = Integer.parseInt(scanner.nextLine());
                    catagoryUpdateStatus.setCateStatus(statusIntCate == 1 ? APPEAR : HIDDEN);

                    categoryFileService.saveToFileCategory(catagoryUpdateStatus);
                    System.out.println("Đã đổi trạng thái danh mục thành công");
                } catch (InputMismatchException | NumberFormatException e) {
                    System.err.println("Nhập không đúng yêu cầu.");
                    changeCategoryStatus(scanner);
                }

            } else {
                System.err.println("Không thể tìm thấy danh mục cần ẩn");
            }

        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println("Nhập không đúng yêu cầu.");
            changeCategoryStatus(scanner);
        }

    }
}
