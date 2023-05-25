package OCT.com.Controller;

import OCT.com.Model.Rank;
import OCT.com.Model.Student;
import OCT.com.Validation.Validate;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ControllerStudent {
    private static final Scanner scan = new Scanner(System.in);
    private final ArrayList<Student> listStudents = new ArrayList<>();
    private final Validate validate = new Validate();


    public ControllerStudent() {

        listStudents.add(new Student(1, "Phạm Anh Dũng ", LocalDate.of(2003, 1, 19), 167.5f, 60f, "2010310060", "Uneti", "Thái Bình", 2020, 3.0f, rankStudent(3.0f)));
        listStudents.add(new Student(2, "Phạm Anh Dũng ", LocalDate.of(2003, 1, 19), 167.5f, 60f, "2010310062", "Uneti", "Thái Bình", 2020, 5.0f, rankStudent(5.0f)));
        listStudents.add(new Student(3, "Phạm Anh Dũng ", LocalDate.of(2003, 1, 19), 167.5f, 60f, "2010310063", "Uneti", "Thái Bình", 2020, 7.0f, rankStudent(7.0f)));
        listStudents.add(new Student(4, "Phạm Anh Dũng ", LocalDate.of(2003, 1, 19), 167.5f, 60f, "2010310061", "Uneti", "Thái Bình", 2020, 9.5f, rankStudent(9.5f)));
        listStudents.add(new Student(5, "Lê Quang Tiến ", LocalDate.of(2002, 1, 10), 167.5f, 60f, "2010310069", "Uneti", "Thái Bình", 2020, 5.0f, rankStudent(5.0f)));

    }


    public String inputName() {
        System.out.println("Nhập tên sinh viên: ");
        String name = scan.nextLine();
        if (!Validate.checkName(name)) {
            System.err.println("Không để trống tên hoặc nhở hơn " + Validate.MAX_LENGTH_NAME + " ký tự");
            return inputName();
        }
        return name;
    }

    public LocalDate inputBirthday() {
        System.out.println("Nhập ngày sinh ");
        LocalDate date = null;
        boolean flag = true;
        while (flag) {
            try {
                date = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                if (!Validate.checkDate(date)) {
                    System.err.println("Ngày sinh không tồn tại");
                } else {
                    flag = false;
                }
            } catch (DateTimeException e) {
                System.err.println("Sai định dạng");
            }
        }
        return date;
    }

    public String inputAddress() {
        System.out.println("Nhập địa chỉ: ");
        String address = scan.nextLine();

        if (!Validate.checkAddress(address)) {
            System.err.println("Không được để trống địa chỉ hoặc độ dài địa chỉ < " + Validate.MAX_LENGTH_ADDRESS + " ký tự");
            inputAddress();
        }
        return address;
    }


    public float inputHeight() {
        System.out.println("Nhập chiều cao: ");
        float height = Float.parseFloat(scan.nextLine());
        if (!Validate.checkHeight(height)) {
            System.out.println("Height từ 50.0 -> 300.0");
            inputHeight();
        }
        return height;
    }


    public float inputWeight() {
        System.out.println("Nhập cân nặng: ");
        float tempWeight = 0f;
        String input = scan.nextLine();
        if (input.contains(" ")) {
            System.out.println("Không được để trống");
            inputWeight();
        } else {
            float weight = Float.parseFloat(scan.nextLine());
            tempWeight = weight;
            if (!Validate.checkWeight(weight)) {
                System.out.println("Height từ 5.0 -> 1000.0");
                inputHeight();
            }
        }
        return tempWeight;
    }

    public String inputCode() {
        System.out.println("Nhap ma sinh vien");
        String code = scan.nextLine();
        for (Student x : listStudents) {
            if (x.getIdStudent().equals(code) || code.length() > Validate.LENGTH_ID_STUDENT) {
                System.out.println("Mã đã tồn tại hoặc mã > 10 ký tự");
                inputCode();
            }
        }
        return code;
    }

    public String inputSchool() {
        System.out.println("Nhập trường: ");
        String nameSchool = scan.nextLine();
        if (!Validate.checkNameSchool(nameSchool)) {
            System.out.println("không để rỗng và < " + Validate.MAX_NAME_SCHOOL + " ký tự");
            inputSchool();
        }
        return nameSchool;
    }

    public int inputStudentYearStart() {
        System.out.println("Nhập năm bắt đầu");
        boolean check_date = false;
        int date = 0;
        while (!check_date) {
            try {
                date = Integer.parseInt(scan.nextLine());
                if (Validate.checkStartYear(date)) {
                    check_date = true;
                } else {
                    System.out.println("Bạn nhâp sai định dạng ngày");
                }
            } catch (Exception e) {
                System.out.println("Lỗi  " + e.getLocalizedMessage());
            }

        }
        return date;
    }

    public float inputGPA() {
        System.out.println("Bạn nhập vào điểm GPA");
        float gpa = 0;
        boolean check_gpa = false;
        while (!check_gpa) {
            try {
                gpa = Float.parseFloat(scan.nextLine());
                if (Validate.checkGpa(gpa)) {
                    check_gpa = true;
                } else {
                    System.out.println("Điểm nằm trong phạm vi từ 0.0 < gpa < 10.0");
                }
            } catch (Exception e) {
                System.out.println("Bạn nhập sai kiểu của điểm");

            }
        }
        return gpa;
    }


    public Student createStudent() {
        int idStudent = listStudents.size() + 1;
        String name = inputName();
        LocalDate year = inputBirthday();
        String address = inputAddress();
        float heigh = inputHeight();
        float weight = inputWeight();
        String code = inputCode();
        String school = inputSchool();
        int dateStart = inputStudentYearStart();
        float gpa_ = inputGPA();
        Rank rank = rankStudent(gpa_);

        return new Student(idStudent, name, year, heigh, weight, code, school, address, dateStart, gpa_, rank);

    }

    public void showStudent() {
        if (listStudents.isEmpty()) {
            System.out.println("Danh sách sinh viên trống");
        } else {
            System.out.println("------- Danh sách sinh viên ----------");
            System.out.println();
            for (Student student : listStudents) {
                System.out.println(student);
            }
        }
    }

    public void addStudent() {
        Student student = createStudent();
        listStudents.add(student);

        showStudent();
    }

    public void findStudentByID() {
        if (listStudents.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            String idStudent;
            System.out.println("Nhập mã sinh viên bạn muốn tìm");
            idStudent = scan.nextLine();
            boolean flag = false;
            for (Student student : listStudents) {
                if (idStudent.equalsIgnoreCase(student.getIdStudent())) {
                    flag = true;
                    System.out.println(student);
                }
            }
            if (!flag) {
                System.out.println("Không tìm thấy sinh viên !!");
                System.out.println("Kiểm tra lại mã sinh viên");
            }
        }
    }

    public void updateStudent() {
        System.out.println("Nhập mã sinh viên bạn muốn sửa");
        String codeStudent = scan.nextLine();
        int index = 0;
        boolean flag_ = false;
        for (Student listStudent : listStudents) {
            if (codeStudent.equals(listStudent.getIdStudent())) {
                flag_ = true;
                index = listStudent.getId();
                System.out.println("1. Sửa Tên ");
                System.out.println("2. Sửa Ngày sinh ");
                System.out.println("3. Sửa chiều cao ");
                System.out.println("4. Sửa cân nặng");
                System.out.println("5. Sửa trường ");
                System.out.println("6. Sửa địa chỉ ");
                System.out.println("7. Sửa năm bắt đầu ");
                System.out.println("8. Sửa năm GPA ");
                System.out.println("9. Thoát");

                System.out.println("Mời bạn chọn: ");
                int choice = 0;
                boolean flag = false;
                do {
                    try {
                        choice = Integer.parseInt(scan.nextLine());
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("Bạn phải nhập số");
//                        flag = false;
                    }
                } while (!flag);

                switch (choice) {
                    case 1: {
                        String name = inputName();
                        listStudent.setName(name);
                        break;
                    }

                    case 2: {
                        LocalDate date = inputBirthday();
                        listStudent.setDate(date);
                        break;
                    }

                    case 3: {
                        float height = inputHeight();
                        listStudent.setHeight(height);
                        break;
                    }
                    case 4: {
                        float weight = inputWeight();
                        listStudent.setWeight(weight);
                        break;
                    }
                    case 5: {
                        String school = inputSchool();
                        listStudent.setSchool(school);
                        break;
                    }
                    case 6: {
                        String address = inputAddress();
                        listStudent.setAddress(address);
                        break;

                    }

                    case 7: {
                        int studentYearStart = inputStudentYearStart();
                        listStudent.setCollegeStartYear(studentYearStart);
                        break;
                    }
                    case 8: {
                        float gpa = inputGPA();
                        listStudent.setGpa(gpa);
                        break;
                    }

                    case 9:
                        break;
                }

            }

        }
        if (!flag_) {
            System.err.println("Không có mã sinh viên bạn muốn sửa ");
        } else {
            System.out.println("Thông tin sinh viên sau khi sửa là: \n");
            System.out.println(listStudents.get(index));
            System.out.println();
        }


    }


    public void deleteStudentByID() {
        if (listStudents.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            System.out.println("Nhập mã sinh viên bạn muốn xóa");
            String codeStudent = scan.nextLine();
            boolean flag = false;

            for (int i = 0; i < listStudents.size(); i++) {
                if (codeStudent.equals(listStudents.get(i).getIdStudent())) {
                    flag = true;
                    listStudents.remove(i);
                    for (int j = i; j < listStudents.size(); j++) {
                        listStudents.get(j).setId(listStudents.get(j).getId() - 1);
                    }
                }
            }
            if (!flag) {
                System.out.println("Không tìm thấy sinh viên");
            }

            System.out.println("Danh sách sinh viên sau khi xóa là:");
            for (Student student : listStudents) {
                System.out.println(student);
            }
        }
    }

    public static Rank rankStudent(float gpa) {
        if (gpa < 3)
            return Rank.POOR;
        else if (gpa < 5)
            return Rank.WEARK;
        else if (gpa < 6.5)
            return Rank.AVERAGE;
        else if (gpa < 7.5)
            return Rank.GOOB;
        else if (gpa < 9)
            return Rank.VERYGOOD;
        else if (gpa >= 9)
            return Rank.EXCELLENT;

        return null;
    }


    public void findStudentByGpa() {
        String rank;
        boolean check_gpa = false;

        System.out.println("Nhập rank bạn muốn tìm");

        rank = scan.nextLine();
        for (Student student : listStudents) {
            if (student.getRank().getValueRank().equalsIgnoreCase(rank)) {
                check_gpa = true;
                System.out.println(student);
            }
        }

        if (!check_gpa) {
            System.err.println("Bạn nhập sai Rank");
        }


    }

    public HashMap<String, Float> getPercentTypeStudent() {

        HashMap<String, Float> hashMap = new HashMap<>();
        int countPoor = 0;
        int countWeark = 0;
        int countAverage = 0;
        int countGoob = 0;
        int countVeryGood = 0;
        int countExcellent = 0;

        for (Student student : listStudents) {
            if (student.getGpa() < 3) countPoor++;
            else if (student.getGpa() < 5) countWeark++;
            else if (student.getGpa() < 6.5) countAverage++;
            else if (student.getGpa() < 7.5) countGoob++;
            else if (student.getGpa() < 9) countVeryGood++;
            else countExcellent++;
        }

        int totalStudent = listStudents.size();
        hashMap.put(String.valueOf(Rank.POOR), 100f * countPoor / totalStudent);
        hashMap.put(String.valueOf(Rank.WEARK), 100f * countWeark / totalStudent);
        hashMap.put(String.valueOf(Rank.AVERAGE), 100f * countAverage / totalStudent);
        hashMap.put(String.valueOf(Rank.GOOB), 100f * countGoob / totalStudent);
        hashMap.put(String.valueOf(Rank.VERYGOOD), 100f * countVeryGood / totalStudent);
        hashMap.put(String.valueOf(Rank.EXCELLENT), 100f * countExcellent / totalStudent);

        return hashMap;
    }

    public void showPercentTypeStudent() {
        HashMap<String, Float> mapStudent = getPercentTypeStudent();
        mapStudent.forEach((key, value) -> System.out.println(key + ": " + value + "%"));

    }

    public void outputStream() throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fos = new FileOutputStream("test.txt");
            objectOutputStream = new ObjectOutputStream(fos);
            objectOutputStream.writeObject(listStudents);

            System.out.println("Lưu danh sách");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert fos != null;
            fos.close();
            assert objectOutputStream != null;
            objectOutputStream.close();

        }

    }

    public void sortStudentByGPA() {
        Map<Rank, Integer> mapGPA = new HashMap<>();
        int allStudent = listStudents.size();

        for (Student student : listStudents) {
            Rank rank = student.getRank();
            mapGPA.put(rank, mapGPA.getOrDefault(rank, 0) + 1);

        }

        System.out.println("Danh sách học lực của các sinh viên theo % là");
        List<Map.Entry<Rank, Integer>> sortedLevel = new ArrayList<>(mapGPA.entrySet());
        sortedLevel.sort(Collections.reverseOrder(Comparator.comparingDouble(entry -> (entry.getValue() * 100.0 / allStudent))));
        for (Map.Entry<Rank, Integer> level : sortedLevel) {
            double percentage = level.getValue() * 100f / allStudent;
            System.out.println("- " + level.getKey().getValueRank() + ": " + String.format("%.2f%%", percentage));
        }


    }


}//  Class
