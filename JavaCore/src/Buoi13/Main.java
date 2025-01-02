package Buoi13;

import java.sql.*;

public class Main {
    // thông tin kết nối đến cơ sở dữ liệu
    public static final String url = "jdbc:mysql://localhost:3306/quanlynhansu2";
    public static final String username = "root";
    public static final String password = "namnam2612";

    public static void main(String[] args) {
        // tạo connection đến database

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username,password);
            System.out.println("Connected to database");
            System.out.println("tạo ra câu query");

            String sql = "select * from departments";
            System.out.println("biến String " + sql + " thành câu sql");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            System.out.println("thực hiện query trong database ");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("query tới database thành công, đã nhận được kết qua, tực hiện duyệt kết quả");
        } catch (SQLException e) {
            System.out.println("connect failed");
            throw new RuntimeException(e);
        }


    }
}
