package com.example.appnhac.Model;

import java.io.Serializable;

public class BaiHat_QL implements Serializable {

    String TenBaiHat,HinhBaiHat,Casi,LinkBaiHat;
    Integer idBaiHat,LuotThich;

    public String getTenBaiHat() {
        return TenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        TenBaiHat = tenBaiHat;
    }

    public String getHinhBaiHat() {
        return HinhBaiHat;
    }

    public void setHinhBaiHat(String hinhBaiHat) {
        HinhBaiHat = hinhBaiHat;
    }

    public String getCasi() {
        return Casi;
    }

    public void setCasi(String casi) {
        Casi = casi;
    }

    public String getLinkBaiHat() {
        return LinkBaiHat;
    }

    public void setLinkBaiHat(String linkBaiHat) {
        LinkBaiHat = linkBaiHat;
    }

    public Integer getIdBaiHat() {
        return idBaiHat;
    }

    public void setIdBaiHat(Integer idBaiHat) {
        this.idBaiHat = idBaiHat;
    }

    public Integer getLuotThich() {
        return LuotThich;
    }

    public void setLuotThich(Integer luotThich) {
        LuotThich = luotThich;
    }

    public BaiHat_QL(String tenBaiHat, String hinhBaiHat, String casi, String linkBaiHat, Integer idBaiHat, Integer luotThich) {
        TenBaiHat = tenBaiHat;
        HinhBaiHat = hinhBaiHat;
        Casi = casi;
        LinkBaiHat = linkBaiHat;
        this.idBaiHat = idBaiHat;
        LuotThich = luotThich;
    }
}
