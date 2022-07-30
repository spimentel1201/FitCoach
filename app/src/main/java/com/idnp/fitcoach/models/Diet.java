package com.idnp.fitcoach.models;

public class Diet {

    private int idDiet;
    private String breakfast;
    private String lunch;
    private String dinner;
    private String midMorning;
    private String midAfternoon;
    private String imgURLD;
    private String imgURLMM;
    private String imgURLL;
    private String imgURLMA;
    private String imgURLDD;

    public Diet(){

    }

    public Diet(int idDiet, String breakfast, String lunch, String dinner, String midMorning, String midAfternoon, String imgUrlB, String imgUrlMM, String imgUrlL, String imgUrlMA, String imgUrlDD) {
        this.idDiet = idDiet;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.midMorning = midMorning;
        this.midAfternoon = midAfternoon;
        this.imgURLD = imgUrlB;
        this.imgURLMM = imgUrlMM;
        this.imgURLL = imgUrlL;
        this.imgURLMA = imgUrlMA;
        this.imgURLDD = imgUrlDD;
    }

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

    public String getImgURLD() {
        return imgURLD;
    }

    public void setImgURLD(String imgURLD) {
        this.imgURLD = imgURLD;
    }

    public String getImgURLMM() {
        return imgURLMM;
    }

    public void setImgURLMM(String imgURLMM) {
        this.imgURLMM = imgURLMM;
    }

    public String getImgURLL() {
        return imgURLL;
    }

    public void setImgURLL(String imgURLL) {
        this.imgURLL = imgURLL;
    }

    public String getImgURLMA() {
        return imgURLMA;
    }

    public void setImgURLMA(String imgURLMA) {
        this.imgURLMA = imgURLMA;
    }

    public String getImgURLDD() {
        return imgURLDD;
    }

    public void setImgURLDD(String imgURLDD) {
        this.imgURLDD = imgURLDD;
    }
}
