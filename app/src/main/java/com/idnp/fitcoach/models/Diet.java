package com.idnp.fitcoach.models;

public class Diet {

    private int idDiet;
    private String breakfast;
    private String lunch;
    private String dinner;
    private String midMorning;
    private String midAfternoon;

    public int getIdDiet() {
        return idDiet;
    }

    public void setIdDiet(int idDiet) {
        this.idDiet = idDiet;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getMidMorning() {
        return midMorning;
    }

    public void setMidMorning(String midMorning) {
        this.midMorning = midMorning;
    }

    public String getMidAfternoon() {
        return midAfternoon;
    }

    public void setMidAfternoon(String midAfternoon) {
        this.midAfternoon = midAfternoon;
    }
}
