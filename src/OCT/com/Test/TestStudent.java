package OCT.com.Test;

import OCT.com.Model.Student;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static OCT.com.Controller.ControllerStudent.rankStudent;


public class TestStudent {
    public static void main(String[] args) throws FileNotFoundException {
        // đọc ghi 1 đối tượng đơn vào file

        // ghi file
//        ArrayList<Student>  students = new ArrayList<>();

        Student student =new Student(2, "Phạm Anh Dũng ", LocalDate.of(2003, 1, 19), 167.5f, 60f, "2010310060", "Uneti", "Thái Bình", 2020, 3.0f, rankStudent(3.0f));



        try {
            FileOutputStream fos = new FileOutputStream("student.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // ghi file
            oos.writeObject(student);

            fos.close();
            oos.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
