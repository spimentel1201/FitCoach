package com.idnp.fitcoach.models;

public class Coach{
    private int idCoach;
    private String speciality;
    private String nameC;
    private int rating;
    private String schedule;
    private String imgUrlC;

    private int idUser;
    private String user_name;
    private String password;
    private String name;
    private Character gender;
    private String email;

    public Coach(){

    }

    public Coach(int idCoach, String speciality, int ratingScale, String schedule, String imgUrlC, String nameC){
        this.idCoach = idCoach;
        this.speciality = speciality;
        this.rating = ratingScale;
        this.schedule = schedule;
        this.imgUrlC = imgUrlC;
        this.nameC = nameC;
    }

    public int getIdCoach() {
        return idCoach;
    }

    public void setIdCoach(int idCoach) {
        this.idCoach = idCoach;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int ratingScale) {
        this.rating = ratingScale;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getImgUrlC() {
        return imgUrlC;
    }

    public void setImgUrlC(String imgUrlC) {
        this.imgUrlC = imgUrlC;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

}
