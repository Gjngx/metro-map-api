package com.example.metromapapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "train")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int sTTGa;
    private String tenGa;
    private Time thoiGian;
    private String diaChi;
    private Double lat;
    private Double lng;
    private String moTa;
    private boolean trangThai;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "trainLine_id")
    private TrainLine trainLine;

    public Train() {
    }

    public Train(TrainLine trainLine, int sTTGa, String tenGa, Time thoiGian, String diaChi, Double lat, Double lng, String moTa, boolean trangThai) {
        this.trainLine = trainLine;
        this.sTTGa = sTTGa;
        this.tenGa = tenGa;
        this.thoiGian = thoiGian;
        this.diaChi = diaChi;
        this.lat = lat;
        this.lng = lng;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public Train(int sTTGa, String tenGa, Time thoiGian, String diaChi, Double lat, Double lng, String moTa, boolean trangThai) {
        this.sTTGa = sTTGa;
        this.tenGa = tenGa;
        this.thoiGian = thoiGian;
        this.diaChi = diaChi;
        this.lat = lat;
        this.lng = lng;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TrainLine getTrainLine() {
        return trainLine;
    }

    public void setTrainLine(TrainLine trainLine) {
        this.trainLine = trainLine;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", sTTGa=" + sTTGa +
                ", tenGa='" + tenGa + '\'' +
                ", thoiGian=" + thoiGian +
                ", diaChi='" + diaChi + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", moTa='" + moTa + '\'' +
                ", trangThai=" + trangThai +
                ", trainLine=" + trainLine +
                '}';
    }
}
