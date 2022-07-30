package com.idnp.fitcoach.models;

public class Student extends User {
    private int idStudent;
    private int age;
    private float height;
    private float weight;

    public Student(int idUser, String user_name, String password, String name, Character gender, String email,int idSt, int age, float he, float we ) {
        super(idUser, user_name, password, name, gender, email);
        this.idStudent = idSt;
        this.age = age;
        this.height = he;
        this.weight = we;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
