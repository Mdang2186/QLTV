package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Admin
 */
public class TacGia {
    private String maTacGia;
    private String tenTacGia;

    public TacGia(String maTacGia, String tenTacGia) {
        this.maTacGia = maTacGia;
        this.tenTacGia = tenTacGia;
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    @Override
    public String toString() {
        return tenTacGia; // Hiển thị tên trên comboBox
    }
}
