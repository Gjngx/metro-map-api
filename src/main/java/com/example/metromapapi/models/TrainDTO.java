package com.example.metromapapi.models;

import java.sql.Time;

public class TrainDTO {
    private int sTTGa;
    private String tenGa;
    private Time thoiGian;
    private String diaChi;
    private Double lat;
    private Double lng;
    private String moTa;
    private boolean trangThai;
    private Long trainLineId;

    public TrainDTO(int sTTGa, String tenGa, Time thoiGian, String diaChi, Double lat, Double lng, String moTa, boolean trangThai, Long trainLineId) {
        this.sTTGa = sTTGa;
        this.tenGa = tenGa;
        this.thoiGian = thoiGian;
        this.diaChi = diaChi;
        this.lat = lat;
        this.lng = lng;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.trainLineId = trainLineId;
    }

    public int getsTTGa() {
        return sTTGa;
    }

    public void setsTTGa(int sTTGa) {
        this.sTTGa = sTTGa;
    }

    public String getTenGa() {
        return tenGa;
    }

    public void setTenGa(String tenGa) {
        this.tenGa = tenGa;
    }

    public Time getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Time thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Long getTrainLineId() {
        return trainLineId;
    }

    public void setTrainLineId(Long trainLineId) {
        this.trainLineId = trainLineId;
    }

}
