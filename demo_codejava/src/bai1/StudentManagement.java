package bai1;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author codevn
 */
public class StudentManagement {
    // Em hãy viết một chương trình quản lý sinh viên theo phương pháp hướng đối tượng. 
    //Trong đó thông tin sinh viên gồm: mã sinh viên, tên sinh viên, kỳ học, môn học.
    //Chương trình cho phép nhập, tìm, sửa thông tin, xóa, xuất thông tin sinh viên với giao diện như sau: 
    //CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN: 1. Nhập thông tin sinh viên 2. Tìm và sắp xếp 3. Cập nhật/ xóa 
//4. Xuất thông tin 5. Thoát Yêu cầu cụ thể: 1. Nhập thông tin sinh viên: nhập từ phím các sinh viên 
//2. Tìm và sắp xếp: cho phép tìm theo một phần tên của sinh viên và sắp xếp theo thứ tự tăng dần các sinh viên 
//3. Cập nhật/ xóa: chương trình cho phép nhập mã sinh viên cần thao tác. 
    //Nếu có thông tin mã sinh viên chương trình sẽ hiển thị tin nhắn “Bạn muốn cập nhật (C) hay xóa (X) ?”. 
    //Chọn “C” hoặc “X” để thực hiện chức năng tương ứng 
//4. Xuất thông tin: hiển thị toàn bộ thông tin sinh viên đã được nhập 
//5. Thoát : thoát khỏi chương trình 
    //Yêu cầu lập trình: – Đối với lớp dùng để tạo các đối tượng sinh viên: 
//+ Các thuộc tính khai báo ở chế độ bảo mật (private) + Chương trình có các hàm getter/setter tương ứng

    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("CHUONG TRINH QUAN LY SINH VIEN\n"
                    + "1. Nhập thông tin sinh viên\n"
                    + "2. Tìm và sắp xếp\n"
                    + "3. Cập nhật/ xóa\n"
                    + "4. Xuất thông tin\n"
                    + "5. Thoát"
            );
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    searchStudent();
                    sortStudent();
                    break;
                case 3:
                    System.out.println("1.EDIT\n"
                            + "2. DELETE"
                    );
                    int key = Integer.parseInt(sc.nextLine());
                    if (key == 1) {
                        updateStudent();
                    } else if (key == 2) {
                        deleteStudent();
                    }
                    
                    break;
                case 4:
                    findStudent();
                    break;
                case 5:
                    System.exit(1);
                    break;
                
            }
        }
    }

    private static void addStudent() {
        System.out.println("input id");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("input name");
        String name = sc.nextLine();
        System.out.println("input semester");
        String semester = sc.nextLine();
        System.out.println("input major");
        String major = sc.nextLine();
        Student student = new Student(id, name, semester, major);
        studentList.add(student);
    }

    private static void searchStudent() {
        System.out.println("Input name to find:");
        String find = sc.nextLine();
        for (Student student : studentList) {
            if (student.getStudent_name().contains(find)) {
                System.out.println(student.toString());
            }
        }
    }

    private static void sortStudent() {
        for (int i = 0; i < studentList.size(); i++) {
            for (int j = i; j < studentList.size(); j++) {
                if (studentList.get(i).getStudent_name().compareTo(studentList.get(j).getStudent_name()) > 0) {
                    Student temp = new Student(studentList.get(i).getStudent_id(), studentList.get(i).getStudent_name(), studentList.get(i).getStudent_semester(), studentList.get(i).getStudent_major());
                    studentList.set(i, studentList.get(j));
                    studentList.set(j, temp);
                }
            }
        }
        System.out.println(studentList.toString());
    }

    private static void updateStudent() {
        System.out.println("input id to edit:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("input name");
        String name = sc.nextLine();
        System.out.println("input semester");
        String semester = sc.nextLine();
        System.out.println("input major");
        String major = sc.nextLine();
        for (int i = 0; i < studentList.size(); i++){
            if (studentList.get(i).getStudent_id() == id) {
                Student student4 = new Student(id, name, semester, major);
                studentList.set(i,student4);
                return;
            }
        }
        System.out.println("Edit failed");
             
    }

    private static void findStudent() {
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

    private static void deleteStudent() {
        System.out.println("input id to delete:");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < studentList.size(); i++){
            if (studentList.get(i).getStudent_id() == id) {
                studentList.remove(i);
                return;
            }
        }
        System.out.println("Delete failed");
    }

}
