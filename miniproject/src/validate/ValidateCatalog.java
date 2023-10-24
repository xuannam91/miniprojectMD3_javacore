package validate;

import model.Catagory;
import model.User;

import java.util.List;
import java.util.Scanner;

import static service.CategoryService.catagoryList;

public class ValidateCatalog {
    public static Scanner scanner = new Scanner(System.in);

    //VALIDATE ID CATEGORY
    public static int autoIdCate() {
        int max = 0;
        for (Catagory cata : catagoryList) {
            if (max < cata.getCatelogId()) {
                max = cata.getCatelogId();
            }
        }
        return max + 1;
    }

    // VALIDATE NAME CATEGORY
    public static String validateCategoryName() {
        String categoryNameInput;
        do {
            categoryNameInput = scanner.nextLine();
            if (!categoryNameInput.isEmpty()) {
                if (!isCategoryNameExists(categoryNameInput)) {
                    return categoryNameInput;
                } else {
                    System.err.println("Tên danh mục đã có người sử dụng, vui lòng nhập lại");
                }
            } else {
                System.err.println("Tên danh mục không được để trống");
            }
        } while (true);
    }

    public static boolean isCategoryNameExists(String name) {
        List<Catagory> catagoriesList = catagoryList;
        for (Catagory catagory : catagoriesList) {
            if (catagory.getCatelogName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
