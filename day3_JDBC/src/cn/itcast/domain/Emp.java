package cn.itcast.domain;

import java.util.Date;
//封装好的数据库对象
public class Emp {
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private Double salary;
    private Date entry_date;
    private Integer resume_text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public Integer getResume_text() {
        return resume_text;
    }

    public void setResume_text(Integer resume_text) {
        this.resume_text = resume_text;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", salary=" + salary +
                ", entry_date=" + entry_date +
                ", resume_text=" + resume_text +
                '}';
    }
}
