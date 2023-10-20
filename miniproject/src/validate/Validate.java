package validate;

import model.User;

import java.util.List;
import java.util.Scanner;

import static service.UserService.userFileService;

public class Validate {
   public static Scanner scanner = new Scanner(System.in);

   // validate Role
   public static int validateRole() {
      do {
         try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
               case 1:
                  return 1;
               case 2:
                  return 2;
               default:
                  System.out.println("Lựa chọn không hợp lệ, mời chọn lại quyền sử dụng : 1: ADMIN 2: USER");
            }
         } catch (NumberFormatException e) {
            System.out.println("Lựa chọn không hợp lệ; mời chọn lại quyền sử dụng bằng cách nhập số");
         }
      } while (true);
   }

   //validate fullName
   public static String validateFullName() {
      String userNameInput;
      do {
         userNameInput = scanner.nextLine();
         if (!userNameInput.isEmpty()) {
            if (userNameInput.length() > 6) {
               return userNameInput;
            } else {
               System.out.println("Tên tài khoản phải lớn hơn 6 kí tự, xin mời nhập lại");
            }
         } else {
            System.out.println("Tên không được để trống, xin mời nhập tên tài khoản");
         }
      }while (true);
   }
   //validate userName
   public static String validateUserName() {
      String userNameInput;
      do {
         userNameInput = scanner.nextLine();
         if (!userNameInput.isEmpty()) {
            if (userNameInput.length() > 3) {
               if(!isUserNameExists(userNameInput)){
                  return userNameInput;
               }else {
                  System.out.println("UserName đã có người sử dụng, vui lòng nhập lại");
               }

            } else {
               System.out.println("Tên tài khoản phải lớn hơn 3 kí tự, xin mời nhập lại");
            }
         } else {
            System.out.println("Tên không được để trống, xin mời nhập tên tài khoản");
         }
      }while (true);
   }

   public static boolean isUserNameExists(String name) {
      List<User> userList = userFileService.getAllUser();
      for (User user : userList) {
         if (user.getUsername().equals(name)) {
            return true;
         }
      }
      return false;
   }

   // validate Email

   public static String validateEmail() {
      String emailInput;
      do {
         emailInput = scanner.nextLine();
         if (!emailInput.isEmpty()) {
            if (checkRegexEmail(emailInput)) {
               if (!isEmailExists(emailInput)) {
                  return emailInput;
               } else {
                  System.out.println("Email đã được sử dụng, xin mời nhập lại");
               }
            } else {
               System.out.println("Email không đúng định dạng, xin mời nhập lại");
            }

         } else {
            System.out.println("Email không được để trống");
         }
      }while (true);
   }

   public static boolean checkRegexEmail(String email) {
      String regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*$";
      if (!email.matches(regex)) {
         return false;
      }
      return true;
   }


   public static boolean isEmailExists(String email) {
      List<User> userList = userFileService.getAllUser();
      for (User user : userList) {
         if (user.getEmail().equals(email)) {
            return true;
         }
      }
      return false;
   }


   // VALIDATE PASSWORD
   public static String validatePassword() {
      String passInput;
      do {
         passInput = scanner.nextLine();
         if (!passInput.isEmpty()) {
            if (checkRegexPassword(passInput)) {
               return passInput;
            } else {
               System.out.println("Mật khẩu phải chứa ít nhất một chữ số, chữ in hoa và kí tự đặc biệt");
            }

         } else {
            System.out.println("Mật khẩu không được để trống");
         }
      }while (true);
   }

   public static boolean checkRegexPassword(String password) {
      String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()*\\[\\]{}:;',?/*~$^+=<>]).{6,20}$";
      if (!password.matches(regex)) {
         return false;
      }
      return true;
   }

   // VALIDATE Address
   public static String validateAdress() {
      String AdressInput;
      do {
         AdressInput = scanner.nextLine();
         if (!AdressInput.isEmpty()) {
               return AdressInput;
         } else {
            System.out.println("Tên không được để trống, xin mời nhập tên tài khoản");
         }
      }while (true);
   }

   // VALIDATE PHONE

   public static String validatePhone() {
      String phoneInput;
      do {
         phoneInput = scanner.nextLine();
         if (!phoneInput.isEmpty()) {
            if (checkRegexPhoneNumber(phoneInput)) {
               if (!isPhoneExists(phoneInput)) {
                  return phoneInput;
               }else {
                  System.out.println("Số điện thoại đã được sử dụng");
               }
            } else {
               System.out.println("SĐT không đúng định dạng của số đt việt nam");
            }

         } else {
            System.out.println("Số điện thoại không được để trống");
         }
      }while (true);
   }

   public static boolean checkRegexPhoneNumber(String password) {
      String regex = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
      if (!password.matches(regex)) {
         return false;
      }
      return true;
   }
   public static boolean isPhoneExists(String phone) {
      List<User> userList = userFileService.getAllUser();
      for (User user :userList) {
         if (user.getPhone().equals(phone)) {
            return true;
         }
      }
      return false;
   }
}
