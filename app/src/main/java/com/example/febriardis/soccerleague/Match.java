package com.example.febriardis.soccerleague;

public class Match {
    private int logo1;
    private String namaclub1;
    private int score1;
    private int logo2;
    private String namaclub2;
    private int score2;

    public Match(int logo1, String namaclub1, int score1, int logo2, String namaclub2, int score2) {
        this.logo1 = logo1;
        this.namaclub1 = namaclub1;
        this.score1 = score1;
        this.logo2 = logo2;
        this.namaclub2 = namaclub2;
        this.score2 = score2;
    }

    public int getLogo1() {
        return logo1;
    }

    public String getNamaclub1() {
        return namaclub1;
    }

    public int getScore1() {
        return score1;
    }

    public int getLogo2() {
        return logo2;
    }

    public String getNamaclub2() {
        return namaclub2;
    }

    public int getScore2() {
        return score2;
    }
}
