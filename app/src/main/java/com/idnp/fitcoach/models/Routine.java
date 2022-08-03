package com.idnp.fitcoach.models;

public class Routine {
    private int idRoutine;
    private String description;
    private String track1;
    private String track2;
    private String track3;
    private String track4;
    private String track5;
    private String track6;

    public Routine(){

    }
    public Routine(int idRoutine, String description, String t1, String t2, String t3, String t4, String t5, String t6) {
        this.idRoutine = idRoutine;
        this.description = description;
        this.track1 = t1;
        this.track2 = t2;
        this.track3 = t3;
        this.track4 = t4;
        this.track5 = t5;
        this.track6 = t6;
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

    public String getTrack1() {
        return track1;
    }

    public void setTrack1(String track1) {
        this.track1 = track1;
    }

    public String getTrack2() {
        return track2;
    }

    public void setTrack2(String track2) {
        this.track2 = track2;
    }

    public String getTrack3() {
        return track3;
    }

    public void setTrack3(String track3) {
        this.track3 = track3;
    }

    public String getTrack4() {
        return track4;
    }

    public void setTrack4(String track4) {
        this.track4 = track4;
    }

    public String getTrack5() {
        return track5;
    }

    public void setTrack5(String track5) {
        this.track5 = track5;
    }

    public String getTrack6() {
        return track6;
    }

    public void setTrack6(String track6) {
        this.track6 = track6;
    }
}
