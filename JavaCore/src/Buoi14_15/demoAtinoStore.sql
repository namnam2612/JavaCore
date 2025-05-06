/*
Cách thiết kế database
- đề bài thiết kế database phục vụ chức năng trang home, detail sản phẩm của hệ thống https://atino.vn/

 b1. Tìm hiểu hệ thống, trong thực tế cần đọc tài liệu mô tả yêu cầu, hoặc giao diện Ui của chức năng nếu có, tham khảo
 các hệ thống tương tự có sẵn

 b2. Xác định các loại dữ liệu cần lưu vào hệ thống, đây là các dữ liệu thông tin từ cộ sống thực tế
    - dữ liệu về menu loại sản phẩm
    - sản phẩm, giá cả, chi tiết sản phẩm, ảnh sản phẩm, tên sản phẩm
    - Hệ thống cửa hàng
    - Thông tin công ty
    - thông tin mạng xã hội

 b3 xác định ra các thuc thể từ các dữ liệu đã được xác định của bước 2
    * entity ( chính là các đối tượng ngoài đời sống, dữ liệu được ánh xạ vào trong lập trình
        - Loại sản phẩm (category) : chuyên lưu trữ thông tin của loại sản phẩm
                                    + tên
                                    + ngày tạo
        - Sản phẩm (Production) : Chuyên lưu trữ các thông tin về sản phẩm
                                    + tên, giá, ảnh, kích thước, màu sắc, số lượng, mô tả
        - Hệ thống cửa hàng (Branch): lưu trữ thông tin về các chi nhánh hệ thống cửa hàng
                                + tên, địa chỉ, mail, số điện thoại
        - Hệ thống cửa hàng (Company Info): Lưu trữ thông tin công ty
                                + Tên, địa chỉ, hotline, logo, mã số doanh nghiệp, mail
        - thông tin mạng xã hội (social): Lưu trữ thông tin về các trang mạng xã hội, phục vụ maketing
                                + tên, logo, link, admin
        - Hình ảnh (Image) : Lưu trữ thông tin hình ảnh, logo, của hệ thống
                                + tên, định dạng, đường dẫn lưu
        - Mau sac (Colors): Luu tru thong tin ve mau sac
                            + ten, hinh anh
        - kich thuoc (size): Luu tru thong tin ve kich thuoc
                            + ten

 b4 Xác định mối quan hệ của các thực thể và xây dựng sơ đồ thực thể liên kết (Entity Relationship diagram) từ thông tin các thực thể ở bước 3
    - Cac moi quan he
        1 - n : 1 nhieu
        n - 1: nhieu 1
        n - n: nhieu nhieu
        1 - 1:
    Xac dinh quan he giua cac thuc the

        Thực thể 1	    Mối quan hệ	    Thực thể 2	        Ghi chú
        Category	    1 - N	        Product	        Một loại sản phẩm có nhiều sản phẩm
        CompanyInfo	    1 - N	        Branch	        Một công ty có nhiều chi nhánh
        CompanyInfo	    1 - N	        Social	        Một công ty có nhiều mạng xã hội
        Product	        1 - N	        Image	        Một sản phẩm có thể có nhiều hình ảnh
        Branch	    Không liên kết	    Product	        Không có mối quan hệ trực tiếp (trừ khi mở rộng: sản phẩm có ở chi nhánh nào)

 b5 tư sơ đồ thực thể liên kế (Entity Relationship diagram ) -> chuyển sang các table trong database với quy tắc
    - các thực thể tương tứng với các table
    - thuộc tính của thực thể => các colum table
    - mối quan hệ của các thực thể -> khóa ngoại của table

 b6 viết sql tạo table Cách thiết kế database
- đề bài thiết kế database phục vụ chức năng trang home, detail sản phẩm của hệ thống https://atino.vn/

 b1. Tìm hiểu hệ thống, trong thực tế cần đọc tài liệu mô tả yêu cầu, hoặc giao diện Ui của chức năng nếu có, tham khảo
 các hệ thống tương tự có sẵn

 b2. Xác định các loại dữ liệu cần lưu vào hệ thống, đây là các dữ liệu thông tin từ cộ sống thực tế
    - dữ liệu về menu loại sản phẩm
    - sản phẩm, giá cả, chi tiết sản phẩm, ảnh sản phẩm, tên sản phẩm
    - Hệ thống cửa hàng
    - Thông tin công ty
    - thông tin mạng xã hội

 b3 xác định ra các thuc thể từ các dữ liệu đã được xác định của bước 2
    * entity ( chính là các đối tượng ngoài đời sống, dữ liệu được ánh xạ vào trong lập trình
        - Loại sản phẩm (category) : chuyên lưu trữ thông tin của loại sản phẩm
                                    + tên
                                    + ngày tạo
        - Sản phẩm (Production) : Chuyên lưu trữ các thông tin về sản phẩm
                                    + tên, giá, ảnh, kích thước, màu sắc, số lượng, mô tả
        - Hệ thống cửa hàng (Branch): lưu trữ thông tin về các chi nhánh hệ thống cửa hàng
                                + tên, địa chỉ, mail, số điện thoại
        - Hệ thống cửa hàng (Company Info): Lưu trữ thông tin công ty
                                + Tên, địa chỉ, hotline, logo, mã số doanh nghiệp, mail
        - thông tin mạng xã hội (social): Lưu trữ thông tin về các trang mạng xã hội, phục vụ maketing
                                + tên, logo, link, admin
        - Hình ảnh (Image) : Lưu trữ thông tin hình ảnh, logo, của hệ thống
                                + tên, định dạng, đường dẫn lưu

 b4 Xác định mối quan hệ của các thực thể và xây dựng sơ đồ thực thể liên kết (Entity Relationship diagram) từ thông tin các thực thể ở bước 3

 b5 tư sơ đồ thực thể liên kế (Entity Relationship diagram ) -> chuyển sang các table trong database với quy tắc
    - các thực thể tương tứng với các table
    - thuộc tính của thực thể => các colum table
    - mối quan hệ của các thực thể -> khóa ngoại của table

 b6 viết sql tạo table Cách thiết kế database
- đề bài thiết kế database phục vụ chức năng trang home, detail sản phẩm của hệ thống https://atino.vn/

 b1. Tìm hiểu hệ thống, trong thực tế cần đọc tài liệu mô tả yêu cầu, hoặc giao diện Ui của chức năng nếu có, tham khảo
 các hệ thống tương tự có sẵn

 b2. Xác định các loại dữ liệu cần lưu vào hệ thống, đây là các dữ liệu thông tin từ cộ sống thực tế
    - dữ liệu về menu loại sản phẩm
    - sản phẩm, giá cả, chi tiết sản phẩm, ảnh sản phẩm, tên sản phẩm
    - Hệ thống cửa hàng
    - Thông tin công ty
    - thông tin mạng xã hội

 b3 xác định ra các thuc thể từ các dữ liệu đã được xác định của bước 2
    * entity ( chính là các đối tượng ngoài đời sống, dữ liệu được ánh xạ vào trong lập trình
        - Loại sản phẩm (category) : chuyên lưu trữ thông tin của loại sản phẩm
                                    + tên
                                    + ngày tạo
        - Sản phẩm (Production) : Chuyên lưu trữ các thông tin về sản phẩm
                                    + tên, giá, ảnh, kích thước, màu sắc, số lượng, mô tả
        - Hệ thống cửa hàng (Branch): lưu trữ thông tin về các chi nhánh hệ thống cửa hàng
                                + tên, địa chỉ, mail, số điện thoại
        - Hệ thống cửa hàng (Company Info): Lưu trữ thông tin công ty
                                + Tên, địa chỉ, hotline, logo, mã số doanh nghiệp, mail
        - thông tin mạng xã hội (social): Lưu trữ thông tin về các trang mạng xã hội, phục vụ maketing
                                + tên, logo, link, admin
        - Hình ảnh (Image) : Lưu trữ thông tin hình ảnh, logo, của hệ thống
                                + tên, định dạng, đường dẫn lưu

 b4 Xác định mối quan hệ của các thực thể và xây dựng sơ đồ thực thể liên kết (Entity Relationship diagram) từ thông tin các thực thể ở bước 3

 b5 tư sơ đồ thực thể liên kế (Entity Relationship diagram ) -> chuyển sang các table trong database với quy tắc
    - các thực thể tương tứng với các table
    - thuộc tính của thực thể => các colum table
    - mối quan hệ của các thực thể -> khóa ngoại của table

 b6 viết sql tạo table
*/

create database atino_final;


use atino_final;
create table company_info (
    id int auto_increment primary key,
    name varchar(100),
    address varchar(255),
    phone varchar(13)
);

create table social (
    id int auto_increment primary key,
    name varchar(100),
    link varchar(255),
    company_id int,
    foreign key (company_id) references company_info(id)
);

create table branch (
    id int auto_increment primary key,
    name varchar(100),
    phone varchar(13),
    address varchar(255),
    email varchar(100)
);

create table category (
    id int auto_increment primary key,
    name varchar(100),
    parent_id int,
    foreign key (parent_id) references category(id)
);

create table branch_category (
    branch_id int,
    category_id int,
    primary key (branch_id, category_id),
    foreign key (branch_id) references branch(id),
    foreign key (category_id) references category(id)
);

create table productionModel (
    id int auto_increment primary key,
    name varchar(100),
    price decimal(10,2),
    description text,
    total_quantity int,
    category_id int,
    foreign key (category_id) references category(id)
);

create table color(
    id int auto_increment primary key,
    name varchar(50),
    code varchar(20)
);

create table size(
    id int auto_increment primary key,
    name varchar(50),
    code varchar(20),
    type varchar(50)
);

create table image (
    id int auto_increment primary key,
    path varchar(255),
    extention varchar(20)
);

create table product_detail (
    id int auto_increment primary key,
    product_id int,
    quantity int,
    foreign key (product_id) references productionModel(id)
);

create table production_detail_size (
    detail_id int,
    size_id int,
    primary key (detail_id, size_id),
    foreign key (detail_id) references product_detail(id),
    foreign key (size_id) references size(id)
);

create table production_detail_color(
    detail_id int,
    color_id int,
    primary key (detail_id, color_id),
    foreign key (detail_id) references  product_detail(id),
    foreign key (color_id) references color(id)
);

create table production_detail_image(
    detail_id int,
    image_id int,
    primary key (detail_id, image_id),
    foreign key (detail_id) references product_detail(id),
    foreign key (image_id) references image(id)
);



-- INSERT DU LIEU MAU

INSERT INTO company_info (name, address, phone)
VALUES ('Atino Co., Ltd.', '123 Đường Lớn, Quận 1, TP.HCM', '0123456789');

INSERT INTO social (name, link, company_id)
VALUES
    ('Facebook', 'https://facebook.com/atino', 1),
    ('Instagram', 'https://instagram.com/atino', 1),
    ('TikTok', 'https://tiktok.com/@atino', 1);

INSERT INTO branch (name, phone, address, email)
VALUES
    ('Atino Quận 1', '0987654321', '456 Lê Lai, Quận 1, TP.HCM', 'q1@atino.vn'),
    ('Atino Hà Nội', '0988123456', '789 Hoàn Kiếm, Hà Nội', 'hn@atino.vn');

INSERT INTO category (name, parent_id)
VALUES
    ('Thời trang nam', NULL),
    ('Áo', 1),
    ('Quần', 1),
    ('Áo thun', 2),
    ('Quần jean', 3);

INSERT INTO branch_category (branch_id, category_id)
VALUES
    (1, 2),
    (1, 3),
    (2, 4),
    (2, 5);

INSERT INTO productionModel (name, price, description, total_quantity, category_id)
VALUES
    ('Áo thun basic', 199000, 'Áo thun chất liệu cotton co giãn', 150, 4),
    ('Quần jean rách gối', 350000, 'Form slimfit, co giãn tốt', 100, 5);

INSERT INTO color (name, code)
VALUES
    ('Đen', '#000000'),
    ('Trắng', '#FFFFFF'),
    ('Xanh dương', '#0000FF');

INSERT INTO size (name, code, type)
VALUES
    ('S', 'S', 'Nam'),
    ('M', 'M', 'Nam'),
    ('L', 'L', 'Nam');

INSERT INTO image (path, extention)
VALUES
    ('/images/ao-thun-basic.jpg', 'jpg'),
    ('/images/quan-jean-rach.jpg', 'jpg');

INSERT INTO product_detail (product_id, quantity)
VALUES
    (1, 50),
    (2, 40);

INSERT INTO production_detail_size (detail_id, size_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2),
    (2, 3);

INSERT INTO production_detail_color (detail_id, color_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 3);

INSERT INTO production_detail_image (detail_id, image_id)
VALUES
    (1, 1),
    (2, 2);
