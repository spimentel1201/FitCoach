package com.idnp.fitcoach.models;

public class Routine {
    private int idRoutine;
    private String description;

    public Routine(){

    }
    public Routine(int idRoutine, String description) {
        this.idRoutine = idRoutine;
        this.description = description;
    }

    public int getIdRoutine() {
        return idRoutine;
    }

    public void setIdRoutine(int idRoutine) {
        this.idRoutine = idRoutine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
