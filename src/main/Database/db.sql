create database shop_book;
use shop_book;
CREATE TABLE production
(
    id               INT AUTO_INCREMENT PRIMARY KEY,
    title            VARCHAR(255),
    author           VARCHAR(255),
    description      TEXT,
    genre            VARCHAR(100),
    publisher        VARCHAR(100),
    publication_year INT,
    page_count       INT,
    price            DECIMAL(10, 2),
    discount_percent DECIMAL(5, 2),
    stock_quantity   INT,
    category         VARCHAR(100)
);

INSERT INTO production (title, author, description, genre, publisher, publication_year, page_count, price,
                        discount_percent, stock_quantity, category)
VALUES ('Dune: Hành Tinh Cát', 'Frank Herbert',
        'Một thiên tiểu thuyết khoa học viễn tưởng lấy bối cảnh trên hành tinh sa mạc Arrakis, nơi diễn ra cuộc đấu tranh quyền lực giữa các gia tộc.',
        'Khoa học viễn tưởng', 'NXB Trẻ', 2022, 688, 180000.00, 10.00, 20, 'Sách Văn học'),
       ('Sapiens: Lược Sử Loài Người', 'Yuval Noah Harari',
        'Cuốn sách trình bày quá trình tiến hóa của loài người từ thời nguyên thủy đến xã hội hiện đại, với góc nhìn mới mẻ và hấp dẫn.',
        'Phi hư cấu', 'NXB Thế Giới', 2021, 512, 200000.00, 15.00, 35, 'Lịch sử'),
       ('Hoàng Tử Bé', 'Antoine de Saint-Exupéry',
        'Một câu chuyện ngụ ngôn đầy chất thơ về cuộc hành trình của một hoàng tử nhỏ qua các hành tinh, khám phá ý nghĩa của tình bạn và cuộc sống.',
        'Thiếu nhi', 'NXB Kim Đồng', 2020, 96, 85000.00, 5.00, 50, 'Thiếu nhi'),
       ('1984', 'George Orwell',
        'Tiểu thuyết phản địa đàng nổi tiếng mô tả một xã hội bị kiểm soát chặt chẽ, nơi sự thật bị bóp méo và con người mất đi tự do cá nhân.',
        'Chính trị viễn tưởng', 'NXB Văn Học', 2023, 328, 120000.00, 20.00, 15, 'Sách Văn học');

use shop_book;
-- Bảng categories
CREATE TABLE categories (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            categoryName VARCHAR(255),
                            description VARCHAR(255)
);

-- Bảng products
CREATE TABLE products (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          book_title VARCHAR(255),
                          author VARCHAR(255),
                          page_count INT,
                          publisher VARCHAR(100),
                          publication_year VARCHAR(100),
                          genre VARCHAR(100),
                          price DOUBLE,
                          discount DOUBLE,
                          stock_quantity DOUBLE,
                          description TEXT,
                          category_id BIGINT,
                          FOREIGN KEY (category_id) REFERENCES categories(id)
);

-- Bảng users
CREATE TABLE users (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       username VARCHAR(255),
                       password VARCHAR(255)
);

-- Bảng roles
CREATE TABLE roles (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       role_name VARCHAR(255)
);

-- Bảng user_roles
CREATE TABLE user_roles (
                            user_id BIGINT,
                            role_id BIGINT,
                            PRIMARY KEY (user_id, role_id),
                            FOREIGN KEY (user_id) REFERENCES users(id),
                            FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Bảng identity_cards
CREATE TABLE identity_cards (
                                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                full_name VARCHAR(255),
                                identity_number VARCHAR(255),
                                date_of_birth VARCHAR(255),
                                address VARCHAR(255),
                                user_id BIGINT,
                                FOREIGN KEY (user_id) REFERENCES users(id)
);

ALTER TABLE products ADD COLUMN bookTitle VARCHAR(255);
ALTER TABLE products ADD COLUMN image VARCHAR(255);
ALTER TABLE products ADD COLUMN pageCount INT;
ALTER TABLE products ADD COLUMN publicationYear INT;
ALTER TABLE products ADD COLUMN stockQuantity INT;
