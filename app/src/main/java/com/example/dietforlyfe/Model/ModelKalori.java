package com.example.dietforlyfe.Model;

public class ModelKalori {

    private String bmr;
    private String kalori;

    public ModelKalori(){

    }
    public ModelKalori(String bmr, String kalori){
        this.bmr = bmr;
        this.kalori = kalori;
    }

    public String getBmr() {
        return bmr;
    }

    public void setBmr(String bmr) {
        this.bmr = bmr;
    }

    public String getKalori() {
        return kalori;
    }

    public void setKalori(String kalori) {
        this.kalori = kalori;
    }
}
