create database antino;
use antino;
create table company_info
(
    id      int primary key auto_increment,
    name    nvarchar(255),
    address nvarchar(500),
    phone   nvarchar(11)
);

create table social
(
    id   int primary key auto_increment,
    name nvarchar(255), -- name 1: facebook, tiktok -- name 2: ffffacebookkkk, ig
    link varchar(255)
);


create table branch
(
    id      int primary key auto_increment,
    name    nvarchar(255),
    mail    varchar(255),
    address nvarchar(500),
    phone   varchar(11)
);


create table category
(
    id        int primary key auto_increment,
    name      nvarchar(255),
    parent_id int
);

create table image
(
    id        int primary key auto_increment,
    path      nvarchar(255),
    extension varchar(255)
);

create table size
(
    id   int primary key auto_increment,
    name nvarchar(255),
    type varchar(50),
    code varchar(50)
);

create table color
(
    id   int primary key auto_increment,
    name nvarchar(255),
    code varchar(50)
);

use antino;
create table production (
    id int primary key auto_increment,
    name nvarchar(255),
    price float,
    description text,
    total int
);

create table productionModel
(
    id          int primary key auto_increment,
    name        nvarchar(255),
    price       float,
    description text,
    total       int
);

create table production_detail
(
    id            int primary key auto_increment,
    production_id int,
    size_id       int,
    color_id      int,
    image_id      int,
    quality       int,
    foreign key (production_id) references productionModel(id),
    foreign key (size_id) references size(id),
    foreign key (color_id) references color(id),
    foreign key (image_id) references image(id)
);

ALTER TABLE production_detail DROP FOREIGN KEY production_detail_ibfk_1;
-- production_detail_ibfk_1 là tên mặc định, có thể khác — bạn nên dùng lệnh bên dưới để tìm tên thật:
-- SHOW CREATE TABLE production_detail;

INSERT INTO production (name, price, description, total)
VALUES ('Áo Phông Oversize L.3.2880', 149000, 'Ao Phong', 12);

ALTER TABLE production_detail
    ADD FOREIGN KEY (production_id) REFERENCES production(id);


alter table category add foreign key (parent_id) references category(id);

insert into category (name, parent_id)
values ('Áo Phông',null),
       ('Áo Phông Mùa Hè',1);

insert into image (path, extension)
values ('image/read.png','.png'),
       ('image/black.png','.png'),
       ('image/white.png','.png');
insert into color(name, code)
values ('Màu đỏ','C001'),
       ('Màu đen','C002'),
       ('Màu trắng','C003');

insert into size(name, type, code)
values ('To Nhat','T001','2XL'),
       ('To','T001','XL'),
       ('Vua','T001','L'),
       ('Nho','T001','M');

insert into productionModel(name, price, description, total)
values ('Áo Phông Oversize L.3.2880',149.000,'Ao Phong',12);

insert into production_detail(production_id, size_id, color_id, image_id, quality)
values (1,1,1,1,10),
       (1,1,2,2,10),
       (1,1,3,3,10),
       (1,2,1,1,10),
       (1,2,2,2,10),
       (1,2,3,3,10),
       (1,3,1,1,10),
       (1,3,2,2,10),
       (1,3,3,3,10),
       (1,4,1,1,10),
       (1,4,2,2,10),
       (1,4,3,3,10);
use antino;
select * from productionModel;

use antino;
select production_detail.production_id,color.name,size.name,image.path from production_detail
                    inner join color on production_detail.color_id = color.id
                    inner join size on production_detail.size_id = size.id
                    inner join image on production_detail.image_id = image.id
                    where production_id in (1,2)