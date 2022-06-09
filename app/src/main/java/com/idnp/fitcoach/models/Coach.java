package com.idnp.fitcoach.models;

public class Coach extends User{
    private int idCoach;
    private String speciality;
    private int ratingScale;
    private String schedule;

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

    public int getRatingScale() {
        return ratingScale;
    }

    public void setRatingScale(int ratingScale) {
        this.ratingScale = ratingScale;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
