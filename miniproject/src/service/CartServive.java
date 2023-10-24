package service;

import model.CartItem;
import model.Product;
import model.User;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static service.ProductService.productFileService;
import static service.ProductService.productList;
import static service.UserService.userFileService;

public class CartServive {

    // ĐẶT HÀNG
    public static void addToCart(Scanner scanner, User user) {
        try {
            System.out.println("Nhập id của sản phẩm cần mua");
            int idPro = Integer.parseInt(scanner.nextLine());
            Product product = findByIdPro(idPro);
            if (product == null) {
                System.err.println("Sản phẩm không tồn tại");
                return;
            }
            if (product.getStock() <= 0) {
                System.err.println("Sản phẩm hết hàng");
                return;
            }

            try {
                int quantity;
                do {
                    System.out.println("Nhập số lượng cần mua thêm");
                    quantity = Integer.parseInt(scanner.nextLine());
                    if (quantity <= product.getStock()) {
                        break;
                    } else {
                        System.err.println("số lượng trong kho chỉ còn " + product.getStock() + ", vui lòng giảm số lương");
                    }
                }while (true);

                boolean isExists = false;
                for (CartItem cartItem : listCart(user)) {
                    if (cartItem.getProduct().getProductId() == idPro) {
                        cartItem.setQuantity(cartItem.getQuantity() + quantity);
                        userFileService.saveToFile(user);
                        isExists = true;
                        break;
                    }
                }
                if (!isExists) {
                    CartItem cartItem = new CartItem();
                    cartItem.setCartItemID(autoIdCartItem(user));
                    cartItem.setProduct(product);
                    cartItem.setQuantity(quantity);
                    listCart(user).add(cartItem);
                    userFileService.saveToFile(user);
                }

                // giảm stock sản phẩm
                product.setStock(product.getStock() - quantity);
                productFileService.saveToFileProduct(product);

            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Nhập không đúng yêu cầu");
                addToCart(scanner, user);
            }

        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println("Nhập không đúng yêu cầu");
            addToCart(scanner, user);
        }

    }

    //list cart
    public static List<CartItem> listCart(User user) {
        return user.getCart();
    }



    // tăng id cart auto
    public static int autoIdCartItem(User user) {
        int max = 0;
        for (CartItem ca : user.getCart()) {
            if (max < ca.getCartItemID()) {
                max = ca.getCartItemID();
            }
        }
        return max + 1;
    }


    // tìm sản phẩm theo id
    public static Product findByIdPro(int id) {
        for (Product product : productList) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }


    // HIỂN THỊ DANH SÁCH GIỎ HÀNG
    public static void displayListCart(User user) {

        if (!user.getCart().isEmpty()) {
            for (CartItem ca : user.getCart()) {
                System.out.println(ca);
            }
        } else {
            System.out.println("Giỏ hàng rỗng");
        }
    }

}
