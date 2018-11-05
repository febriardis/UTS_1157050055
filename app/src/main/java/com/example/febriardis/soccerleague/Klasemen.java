package com.example.febriardis.soccerleague;

public class Klasemen {
    private int id;
    private String club;
    private int skor;
    private int logoClub;

    public Klasemen(int id, String club, int skor, int logoClub) {
        this.id = id;
        this.club = club;
        this.skor = skor;
        this.logoClub = logoClub;
    }

    public int getId() {
        return id;
    }

    public String getClub() {
        return club;
    }

    public int getSkor() {
        return skor;
    }

    public int getLogoClub() {
        return logoClub;
    }
}
