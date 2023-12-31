package service;

import fileservice.UserFileService;
import model.User;

import java.util.*;


import static constant.Constant.Status.BLOCK;
import static constant.Constant.Status.ACTIVE;

public class UserService {
    public static UserFileService userFileService = new UserFileService();
    public static List<User> listedUsers = userFileService.getAllUser();


    // Hiển thị danh sách người dùng đã sắp xếp theo tên
    public static void displayUserList() {
        Collections.sort(listedUsers, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getUsername().compareTo(o2.getUsername());
            }
        });
        for (User user : listedUsers) {
            System.out.println(user);
        }
    }


    // Tìm kiếm danh sách người dùng theo tên
    static void displayUserListByUsername(Scanner scanner) {
        System.out.println("Nhập từ khoá tên bạn muốn tìm kiếm:");
        String username = scanner.nextLine();
        List<User> filteredUsers = new ArrayList<>();

        for (User user : listedUsers) {
            if (user.getUsername().toLowerCase().contains(username.toLowerCase())) {
                filteredUsers.add(user);
            }
        }
        if (filteredUsers.isEmpty()) {
            System.out.println("Không tìm thấy người dùng nào với tên người dùng chứa từ khoá: " + username);
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (User user : filteredUsers) {
                System.out.println(user);
            }
        }
    }


    // Đổi trạng thái status người dùng
    static void changeUserStatus(Scanner scanner) {
        try {
            System.out.println("Hãy nhập mã Id người dùng muốn thay đổi trạng thái");
            int userID = Integer.parseInt(scanner.nextLine());
            User user = userFileService.findById(userID);
            if (user != null && user.getRole() == 2) {
                try {
                    System.out.println("Nhập vào trạng thái người dùng muốn thay đổi (0: BLOCK, 1: ACTIVE)");
                    int statusInt = Integer.parseInt(scanner.nextLine());
                    user.setStatus(statusInt == 1 ? ACTIVE : BLOCK);
                    userFileService.saveToFile(user);
                    System.out.println("Thay đổi trạng thái thành công!");
                } catch (InputMismatchException | NumberFormatException e) {
                    System.err.println("Nhập không đúng yêu cầu.");
                    changeUserStatus(scanner);
                }

            } else {
                System.err.println("Không thể thay đổi trạng thái người dùng này, hoặc người dùng không tồn tại");

            }

        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println("Nhập không đúng yêu cầu.");
            changeUserStatus(scanner);
        }

    }
}
