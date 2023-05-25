package OCT.com.Test;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestReadObSinge {
    public static void main(String[] args) throws FileNotFoundException {
        //dđọc file bằng ObjectInputStream
        Object obj = null;
        try {
            FileInputStream fis = new FileInputStream("student.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            // đọc đối tượng

            obj = ois.readObject();

            fis.close();
            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (obj == null){
            System.out.println("Không cos gì");
        }else {
            System.out.println(obj);
        }


    }
}
