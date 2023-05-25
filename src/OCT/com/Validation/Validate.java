package OCT.com.Validation;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class Validate {
    Scanner sc = new Scanner(System.in);

    public static final int MAX_LENGTH_NAME = 100;
    public static final LocalDate MIN_YEAR = LocalDate.of(1900,1,1);
    public static final LocalDate MAX_YEAR = LocalDate.now();
    public static final int MAX_LENGTH_ADDRESS = 300;
    public static final float MIN_HEIGHT = 50.0F;
    public static final float MAX_HEIGHT = 300.0F;
    public static final float MIN_WEIGHT = 5.0F;
    public static final float MAX_WEIGHT= 1000.0F;

    // validate sinh viên
    public static final int LENGTH_ID_STUDENT = 10;

    public static final int MAX_NAME_SCHOOL = 200;
    public static final int MAX_COLLEGE_START_YEAR= Calendar.getInstance().get(Calendar.YEAR);

    public static final double MIN_GPA = 0.0;
    public static final double MAX_GPA = 10.0;

    public static boolean checkName(String name){
        return !name.contains(" ") && !name.isEmpty() && name.length() <= MAX_LENGTH_NAME;
    }


    public static boolean checkAddress(String address){
        return !address.contains(" ") && !address.isEmpty() && address.length() <= MAX_LENGTH_ADDRESS;
    }

    public static boolean checkDate(LocalDate brithDate){
        return brithDate.isAfter(MIN_YEAR) && brithDate.isBefore(MAX_YEAR);
    }

    public static boolean checkHeight(float height){
        return !(height < MIN_HEIGHT) && !(height > MAX_HEIGHT);
    }

    public static boolean checkWeight(float weight){
        return !(weight < MIN_WEIGHT) && !(weight > MAX_WEIGHT);
    }


//    public static boolean checkIdStudent(String id_student){
//        return id_student.matches(FORMAT_ID_STUDENT) || id_student.length() == LENGTH_ID_STUDENT;
//    }

    public static boolean checkNameSchool(String nameSchool){
        return !nameSchool.isEmpty() && nameSchool.length() < MAX_NAME_SCHOOL;
    }

    public static boolean checkStartYear(int year){
        String yearString = String.valueOf(year);
        return yearString.length() == 4 && year >= 1900 && year <= MAX_COLLEGE_START_YEAR;
    }
    public static boolean checkGpa(double gpa){
        return gpa >= MIN_GPA && gpa <= MAX_GPA;
    }


}
