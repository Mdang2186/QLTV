package dao;

import model.ChiTietPhieuMuon;
import ConnectionUtility.DBUltil;

import java.sql.*;
import java.util.*;

public class ChiTietPhieuMuonDAO {
    private static final String SELECT_BY_MAPHIEU =
        "SELECT * FROM chitietphieumuon WHERE MaPhieuMuon = ?";

    public List<ChiTietPhieuMuon> findByMaPhieuMuon(String maPhieu) {
        List<ChiTietPhieuMuon> list = new ArrayList<>();
        try (Connection conn = DBUltil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_MAPHIEU)) {
            ps.setString(1, maPhieu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ChiTietPhieuMuon(
                    rs.getString("MaPhieuMuon"),
                    rs.getString("MaSach"),
                    rs.getInt("TinhTrang"),
                    rs.getDate("NgayTraSach"),
                    rs.getBigDecimal("TienPhat"),
                    rs.getString("MaNhanVienNhanTraSach")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
