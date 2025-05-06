package Buoi14_15;

import buoi16.model.ProductionModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*
        Lay danh sach san pham tu mysql len java
        b1. tao connection
        b2. tao cau sql select * from production
        b3. gui cau sql den db, query lay ra du lieu
        b4. nhan du lieu dang resultset, convert du lieu sang resultset thanh class java
        b5. hien thi du lieu tu class java
        */
        /*
        b1. tao connection
        username
        password
        database
        url
        driver name
        */

        System.out.println("b1. Tao Connection");
        String url = "jdbc:mysql://localhost:3306/antino";
        String username = "root";
        String password = "namnam2612";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,username,password);

            System.out.println("B2. tao cau sql select * from production");
            String sql = "select * from productionModel";
            PreparedStatement statement = connection.prepareStatement(sql);

            System.out.println("B3. gui cau sql den db, query lay ra du lieu, nhan du lieu dang resultset");
            ResultSet resultSet = statement.executeQuery();

            System.out.println("B4. convert du lieu sang resultset thanh class java");
            List<ProductionModel> productionsResult = new ArrayList<ProductionModel>();
            int count = 1;
            while (resultSet.next()) {

                System.out.println("Doc du lieu ban ghi thu" + count);

                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Float price = resultSet.getFloat("price");
                String description = resultSet.getString("description");
                Integer total = resultSet.getInt("total");

                System.out.println("set du lieu vao class");

                ProductionModel productionModel = new ProductionModel();
                productionModel.setId(id);
                productionModel.setName(name);
                productionModel.setPrice(price);
                productionModel.setDescription(description);
                productionModel.setTotal(total);

                System.out.println("Luu production vao danh sach ket qua " + count);
                productionsResult.add(productionModel);
                count++;
            }

            System.out.println("B5. Hien thi ra du lieu vua doc duoc tu db");
            productionsResult.forEach(System.out::println);
            List<Integer> idProduction = productionsResult.stream().map(ProductionModel::getId).collect(Collectors.toList());
            System.out.println("Lay thong tin detail");
            String sqlDetail = "select production_detail.production_id,color.name,size.name,image.path from production_detail\n" +
                    "                    inner join color on production_detail.color_id = color.id\n" +
                    "                    inner join size on production_detail.size_id = size.id\n" +
                    "                    inner join image on production_detail.image_id = image.id\n" +
                    "                    where production_id in (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDetail);
            System.out.println("set value to where condition with index ?,?");
            for (int i = 0; i < idProduction.size(); i++) {
                preparedStatement.setInt(i + 1, idProduction.get(i));
            }
            ResultSet resultSetDetail = preparedStatement.executeQuery();
            while (resultSetDetail.next()) {
                System.out.println(resultSetDetail.getString("production_detail.production_id"));
                System.out.println(resultSetDetail.getString("color.name"));
                System.out.println(resultSetDetail.getString("size.name"));
                System.out.println(resultSetDetail.getString("image.path"));

            }

        } catch (SQLException e) {
            System.out.println("Connection error" + e.getMessage());
        }



    }
}