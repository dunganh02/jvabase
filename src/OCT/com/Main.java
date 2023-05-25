package OCT.com;

import OCT.com.Controller.ControllerStudent;
import OCT.com.Validation.Validate;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        ControllerStudent controllerStudent = new ControllerStudent();
        Menu menu = new Menu();

        while (true) {
            menu.menuMain();
            System.out.print("Mời bạn chọn chức năng: ");
            int choice;
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: {
                    controllerStudent.showStudent();
                    break;
                }
                case 2: {
                    controllerStudent.addStudent();
                    break;
                }
                case 3: {
                    System.out.println("tìm kiếm");
                    controllerStudent.findStudentByID();
                    break;
                }
                case 4: {
                    // xóa
                    System.out.println("xóa");
                    controllerStudent.deleteStudentByID();
                    break;
                }
                case 5: {
//                    sửa
                    System.out.println("sửa");
                    controllerStudent.updateStudent();
                    break;
                }
                case 6: {
                    // Tìm các sinh viên theo học lực nhập từ bàn phím
                    System.out.println("tìm kiếm học lực");
                    controllerStudent.findStudentByGpa();
                    break;
                }
                case 7: {
                    //Sắp xếp theo học lực
                    System.out.println("sắp xếp học lục");
                    controllerStudent.sortStudentByGPA();
                    break;
                }
                case 8: {
                    //Hiển thị % điểm trung bình
                    System.out.println("Hiển thị % điểm trung bình");
                    controllerStudent.showPercentTypeStudent();
                    break;
                }
                case 0: {
                    System.out.println("Lưu thông tin");
                    controllerStudent.outputStream();
                    break;
                }

            }


        }


    }
}
