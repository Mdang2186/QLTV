package model;



public class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;

    public Sach(String maSach, String tenSach, String tacGia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    @Override
    public String toString() {
        return tenSach; // để hiển thị trên comboBox
    }
}
