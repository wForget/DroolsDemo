package cn.wangz.drools.module;

/**
 * Created by hadoop on 2018/10/18.
 */
public class Student {

    private String name;
    private int age;
    private double score;

    public Student() {}

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    private String adult;   //underage:<18 adult:>=18
    private String grade;   //poor:0-60 good:60-80 excellent:80-100

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
