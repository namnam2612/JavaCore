package Buoi13;

import java.sql.*;

public class Main {
    // thông tin kết nối đến cơ sở dữ liệu
    public static final String url = "jdbc:mysql://localhost:3306/quanlynhansu";
    public static final String username = "root";
    public static final String password = "namnam2612";

    public static void main(String[] args) {
        // tạo connection đến database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username,password);
            System.out.println("Connected to database");
            showAllDepartment(connection);

            System.out.println("bắt đầu thêm dữ liệu mới");
            String sqlInsert = "INSERT INTO departments (department_id, department_name, location) VALUES (?, ?, ?)";
            System.out.println("tạo ra câu sql thực thi trong database" + sqlInsert);
            PreparedStatement preparedStatementInsert = connection.prepareStatement(sqlInsert);
            System.out.println("Bắt đầu set các dữ liệu vào các tham số ? theo thứ tự từ trái qua phải, bắt đầu từ 1");
            preparedStatementInsert.setInt(1,4); // paramentrIndex : index thứ tự tương ứng department_id, 5: value truyền vào
            preparedStatementInsert.setString(2, "IT"); // 2: index tương ứng department_name, "AI" value truyền vào
            preparedStatementInsert.setString(3, "Hà Nội");

            int numberRowInserted = preparedStatementInsert.executeUpdate(); // thực thi câu query
            System.out.println("Số lượng data vừa thêm là " + numberRowInserted);
            showAllDepartment(connection);
        } catch (SQLException e) {
            System.out.println("connect failed");
            throw new RuntimeException(e);
        } finally {
            // đóng connection sau khi thực hiện thành công, QUAN TRỌNG !
            if (connection != null) {
                try{
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static void showAllDepartment(Connection connection) throws SQLException {
        System.out.println("tạo ra câu query");
        String sql = "select * from departments";
        System.out.println("biến String " + sql + " thành câu sql");
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("thực hiện query trong database ");
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("query tới database thành công, đã nhận được kết qua, tực hiện duyệt kết quả");
        while (resultSet.next()) {
            int depId = resultSet.getInt("department_id");
            System.out.println("department_id" + depId);
            String depName = resultSet.getString("department_name");
            System.out.println("department_name" + depName);
            String location = resultSet.getString("location");
            System.out.println("location" + location);
        }
    }
}
