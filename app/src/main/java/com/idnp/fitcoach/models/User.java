package com.idnp.fitcoach.models;

public class User {
    private int idUser;
    private String user_name;
    private String password;
    private String name;
    private Character gender;
    private String email;

    public User(int idUser, String user_name, String password, String name, Character gender, String email) {
        this.idUser = idUser;
        this.user_name = user_name;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
