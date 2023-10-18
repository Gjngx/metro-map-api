package com.example.metromapapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Time;
import java.util.List;

@Data
@Entity
@Table(name = "trainLine")
public class TrainLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String soTuyenTau;
    private String tenTuyenTau;
    private Double doDaiTuyenTau;
    private Time thoiGianBatDau;
    private Time thoiGianKetThuc;
    private int giaVe;
    private String khuVuc;
    private String moTa;
    private boolean trangThai;

    @OneToMany(mappedBy = "trainLine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Train> trainList;

    public TrainLine() {
    }

    public TrainLine(String soTuyenTau, String tenTuyenTau, Double doDaiTuyenTau, Time thoiGianBatDau, Time thoiGianKetThuc, int giaVe, String khuVuc, String moTa, boolean trangThai) {
        this.soTuyenTau = soTuyenTau;
        this.tenTuyenTau = tenTuyenTau;
        this.doDaiTuyenTau = doDaiTuyenTau;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.giaVe = giaVe;
        this.khuVuc = khuVuc;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoTuyenTau() {
        return soTuyenTau;
    }

    public void setSoTuyenTau(String soTuyenTau) {
        this.soTuyenTau = soTuyenTau;
    }

    public String getTenTuyenTau() {
        return tenTuyenTau;
    }

    public void setTenTuyenTau(String tenTuyenTau) {
        this.tenTuyenTau = tenTuyenTau;
    }

    public Double getDoDaiTuyenTau() {
        return doDaiTuyenTau;
    }

    public void setDoDaiTuyenTau(Double doDaiTuyenTau) {
        this.doDaiTuyenTau = doDaiTuyenTau;
    }

    public Time getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Time thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Time getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Time thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public int getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(int giaVe) {
        this.giaVe = giaVe;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
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

    @Override
    public String toString() {
        return "TrainLine{" +
                "id=" + id +
                ", soTuyenTau='" + soTuyenTau + '\'' +
                ", tenTuyenTau='" + tenTuyenTau + '\'' +
                ", doDaiTuyenTau=" + doDaiTuyenTau +
                ", thoiGianBatDau=" + thoiGianBatDau +
                ", thoiGianKetThuc=" + thoiGianKetThuc +
                ", giaVe=" + giaVe +
                ", khuVuc='" + khuVuc + '\'' +
                ", moTa='" + moTa + '\'' +
                ", trangThai=" + trangThai +
                ", trainList=" + trainList +
                '}';
    }
}

