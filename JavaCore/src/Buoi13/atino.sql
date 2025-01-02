create database atino;
use atino;

-- bang categories (danh sach danh muc san pham)
create table categories (
    id integer auto_increment primary key ,
    name nvarchar(255) ,
    description text
);

-- bang product (danh sach san pham)
create table product (
    id integer auto_increment primary key ,
    name VARCHAR(255) ,
    price DECIMAL(10, 2) ,
    discount_price DECIMAL(10, 2),
    image_url VARCHAR(255),
    category_id INT,
    description TEXT,
    foreign key (category_id) references categories(id)
);

INSERT INTO categories (name, description) VALUES
('Áo Thu Đông', 'Áo khoác, nỉ, len và các sản phẩm thu đông.'),
('Áo Xuân Hè', 'Các sản phẩm áo xuân hè như sơ mi, polo, phông.'),
('Quần', 'Quần dài, quần short và các loại khác.'),
('Phụ Kiện', 'Phụ kiện như túi, giày, dây lưng, tất.');


INSERT INTO product(name, price, discount_price, image_url, category_id, description) VALUES
('Áo Sơ Mi Slim L.3.4474', 265000, 119000, 'https://link_to_image1.jpg', 2, 'Áo sơ mi slim fit.'),
('Áo Sơ Mi Slim L.4.4471', 215000, NULL, 'https://link_to_image2.jpg', 2, 'Áo sơ mi slim fit dài tay.'),
('Áo Sơ Mi Slim L.4.4478', 259000, NULL, 'https://link_to_image3.jpg', 2, 'Áo sơ mi slim fit kiểu dáng thời trang.'),
('Áo Sơ Mi Regular L.3.4470', 239000, NULL, 'https://link_to_image4.jpg', 2, 'Áo sơ mi regular thoải mái.'),
('Áo Sơ Mi Slim L.4.4476', 269000, NULL, 'https://link_to_image5.jpg', 2, 'Áo sơ mi slim fit thiết kế mới.');


SELECT * FROM categories;


SELECT p.id, p.name AS product_name, p.price, p.discount_price, p.image_url, c.name AS category_name, p.description
FROM product p
JOIN categories c ON p.category_id = c.id
WHERE p.id = p.id;
