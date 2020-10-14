package com.example.appnhac.Model;

public class Album_QL {
    Integer idAlbum;
    String TenAlbum,TenCaSiAlbum,HinhAlbum;

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getTenAlbum() {
        return TenAlbum;
    }

    public void setTenAlbum(String tenAlbum) {
        TenAlbum = tenAlbum;
    }

    public String getTenCaSiAlbum() {
        return TenCaSiAlbum;
    }

    public void setTenCaSiAlbum(String tenCaSiAlbum) {
        TenCaSiAlbum = tenCaSiAlbum;
    }

    public String getHinhAlbum() {
        return HinhAlbum;
    }

    public void setHinhAlbum(String hinhAlbum) {
        HinhAlbum = hinhAlbum;
    }

    public Album_QL(Integer idAlbum, String tenAlbum, String tenCaSiAlbum, String hinhAlbum) {
        this.idAlbum = idAlbum;
        TenAlbum = tenAlbum;
        TenCaSiAlbum = tenCaSiAlbum;
        HinhAlbum = hinhAlbum;
    }
}
