package OCT.com.Model;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.io.Serializable;
import java.time.LocalDate;

public class Nguoi implements Serializable {
    private Integer id;
    private String name;
    private LocalDate date;
    private Float height;
    private Float weight;

    public Nguoi() {}
    public Nguoi(Integer id, String name, LocalDate date, Float height, Float weight) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.height = height;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public Float getHeight() {
        return height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ID: " + getId()
                + ", Tên: " + getName()
                + ", Ngày sinh: " + getDate()
                + ", Chiều cao: " + getHeight()
                + ",Cân nặng: " + getWeight();

    }
}
