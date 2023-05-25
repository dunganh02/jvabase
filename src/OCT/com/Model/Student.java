package OCT.com.Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Student extends Nguoi implements Serializable {
    private String idStudent;
    private String school;
    private Integer collegeStartYear;
    private  String address;
    private Float gpa;
    private Rank rank;

    public Student(String idStudent, String school,String address, Integer collegeStartYear, Float gpa,Rank rank ) {
        this.idStudent = idStudent;
        this.school = school;
        this.address = address;
        this.collegeStartYear = collegeStartYear;
        this.gpa = gpa;
        this.rank = rank;
    }

    public Student(Integer id, String name, LocalDate date, Float height, Float weight, String idStudent, String school, String address,Integer collegeStartYear, Float gpa, Rank rank) {
        super(id, name, date, height, weight);
        this.idStudent = idStudent;
        this.school = school;
        this.address = address;
        this.collegeStartYear = collegeStartYear;
        this.gpa = gpa;
        this.rank = rank;
    }


    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getCollegeStartYear() {
        return collegeStartYear;
    }

    public void setCollegeStartYear(Integer collegeStartYear) {
        this.collegeStartYear = collegeStartYear;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return  "Student:{"
                + super.toString()
                +", Mã SV: "+ getIdStudent()
                +", Tên trường: "+ getSchool()
                +", Năm bắt đầu: "+getCollegeStartYear()
                +", GPA: "+ getGpa()
                +", Học lực: "+getRank()
                +"}";
    }
}
