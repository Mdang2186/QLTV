package ConnectionUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

    // Thiết lập kết nối cơ sở dữ liệu
    public static Connection getConnection() {
        try {
            // Đảm bảo driver MySQL đã được nạp vào
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/thuviendb"; // Thay đổi nếu cần thiết
            String user = "root"; // Thay đổi nếu cần thiết
            String password = ""; // Thay đổi nếu cần thiết
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy driver MySQL!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Lỗi khi kết nối tới cơ sở dữ liệu: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    // Phương thức thực thi câu lệnh SQL SELECT (Truy vấn dữ liệu)
    public static ResultSet executeQuery(String sql, Object... params) throws SQLException {
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("Không thể kết nối tới cơ sở dữ liệu!");
        }
        PreparedStatement pst = conn.prepareStatement(sql);

        // Đặt giá trị cho các tham số trong câu lệnh SQL
        for (int i = 0; i < params.length; i++) {
            pst.setObject(i + 1, params[i]);
        }

        return pst.executeQuery();
    }

    // Phương thức thực thi câu lệnh SQL INSERT, UPDATE, DELETE
    public static int executeUpdate(String sql, Object... params) throws SQLException {
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("Không thể kết nối tới cơ sở dữ liệu!");
        }
        PreparedStatement pst = conn.prepareStatement(sql);

        // Đặt giá trị cho các tham số trong câu lệnh SQL
        for (int i = 0; i < params.length; i++) {
            pst.setObject(i + 1, params[i]);
        }

        return pst.executeUpdate();
    }
}
