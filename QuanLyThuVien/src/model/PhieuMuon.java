/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class PhieuMuon {
    private String maPhieuMuon;
    private String maNhanVienLapPhieu;
    private String ngayLapPhieu;
    private String maDocGia;
    private String sachMuon;
    private int soLuongMuon;

    // Constructor
    public PhieuMuon(String maPhieuMuon, String maNhanVienLapPhieu, String ngayLapPhieu,
                     String maDocGia, String sachMuon, int soLuongMuon) {
        this.maPhieuMuon = maPhieuMuon;
        this.maNhanVienLapPhieu = maNhanVienLapPhieu;
        this.ngayLapPhieu = ngayLapPhieu;
        this.maDocGia = maDocGia;
        this.sachMuon = sachMuon;
        this.soLuongMuon = soLuongMuon;
    }

    // Getters
    public String getMaPhieuMuon() { return maPhieuMuon; }
    public String getMaNhanVienLapPhieu() { return maNhanVienLapPhieu; }
    public String getNgayLapPhieu() { return ngayLapPhieu; }
    public String getMaDocGia() { return maDocGia; }
    public String getSachMuon() { return sachMuon; }
    public int getSoLuongMuon() { return soLuongMuon; }
}

