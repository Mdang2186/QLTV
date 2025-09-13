package model;

import java.math.BigDecimal;
import java.sql.Date;

public class ChiTietPhieuMuon {
    private String maPhieuMuon;
    private String maSach;
    private int tinhTrang;
    private Date ngayTraSach;
    private BigDecimal tienPhat;
    private String maNhanVienNhanTraSach;

    // constructor đầy đủ, getters + setters...
    public ChiTietPhieuMuon(String maPhieuMuon, String maSach, int tinhTrang,
            Date ngayTraSach, BigDecimal tienPhat, String maNV) {
        this.maPhieuMuon = maPhieuMuon;
        this.maSach = maSach;
        this.tinhTrang = tinhTrang;
        this.ngayTraSach = ngayTraSach;
        this.tienPhat = tienPhat;
        this.maNhanVienNhanTraSach = maNV;
    }
    // ... getters và setters ở đây
}
