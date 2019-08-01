package com.example.dietforlyfe.Model;
/*
 * Tanggal Pengerjaan : 03-05-2019
 * NIM      : 10116055
 * Nama     : Qidam Zola Farhan
 * Kelas    : IF-2 / AKB-2
 */
public class ModelIMT {

    private int id;
    private String bbi,imt,ket;

    public ModelIMT(){

    }

    public ModelIMT(String bbi, String imt, String ket){
        this.bbi = bbi;
        this.imt = imt;
        this.ket = ket;
    }


    public String getBbi() {
        return bbi;
    }

    public void setBbi(String bbi) {
        this.bbi = bbi;
    }

    public String getImt() {
        return imt;
    }

    public void setImt(String imt) {
        this.imt = imt;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }
}
