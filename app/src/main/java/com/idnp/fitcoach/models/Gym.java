package com.idnp.fitcoach.models;

import android.net.Uri;

public class Gym {
    private int idGym;
    private String imgUrl;
    private long latitude;
    private long longitude;
    private String name;
    private String city;
    private String country;

    public int getIdGym() {
        return idGym;
    }

    public void setIdGym(int idGym) {
        this.idGym = idGym;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
