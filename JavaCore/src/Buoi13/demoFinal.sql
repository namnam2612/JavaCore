create database QL_SINHVIEN;

use QL_SINHVIEN;

create table  sinh_vien(
                           id int primary key  auto_increment,
                           ho_ten nvarchar(50) not null ,
                           ngay_sinh date,
                           gioi_tinh varchar(10),
                           dia_chi varchar(10),
                           email varchar(50) unique, -- unique là duy nhất, k trùng
                           diem_trung_binh decimal
);

create table mon_hoc (
                         id int primary key auto_increment,
                         ten_mon nvarchar(255),
                         so_tin_chi integer
);

create table diem_thi(
                         id int primary key auto_increment,
                         id_sinh_vien int,
                         id_mon int,
                         diem decimal
);

alter table  diem_thi
    add foreign key (id_sinh_vien) references sinh_vien(id);
alter table  diem_thi
    add foreign key (id_mon) references mon_hoc(id);

use QL_SINHVIEN;
-- 3.	Thêm dữ liệu vào các bảng:
insert into sinh_vien (ho_ten, ngay_sinh, gioi_tinh, dia_chi, email, diem_trung_binh)
values
    ('Nguyễn Văn A','1998-01-02','Male','Hà Nội','a@gmail.com',7),
    ('Lê Anh B','1999-01-02','Female','Thanh Hóa','b@gmail.com',8),
    ('Hồ Văn C','1994-01-02','Male','Nghệ An','c@gmail.com',9),
    ('Vương Thị D','1995-01-02','Female','Bình Định','d@gmail.com',5),
    ('Nguyễn Thị R','1998-03-02','Female','Yên Bài','e@gmail.com',6);

INSERT INTO ql_sinhvien.mon_hoc (id, ten_mon, so_tin_chi) VALUES (1, 'Cấu trúc dữ liệu', 3);
INSERT INTO ql_sinhvien.mon_hoc (id, ten_mon, so_tin_chi) VALUES (2, 'Lập trình Java', 2);
INSERT INTO ql_sinhvien.mon_hoc (id, ten_mon, so_tin_chi) VALUES (3, 'Thể dục', 1);

INSERT INTO ql_sinhvien.diem_thi (id, id_sinh_vien, id_mon, diem) VALUES (1, 1, 1, 5);
INSERT INTO ql_sinhvien.diem_thi (id, id_sinh_vien, id_mon, diem) VALUES (2, 2, 2, 6);
INSERT INTO ql_sinhvien.diem_thi (id, id_sinh_vien, id_mon, diem) VALUES (3, 3, 3, 7);
INSERT INTO ql_sinhvien.diem_thi (id, id_sinh_vien, id_mon, diem) VALUES (4, 3, 1, 8);
INSERT INTO ql_sinhvien.diem_thi (id, id_sinh_vien, id_mon, diem) VALUES (5, 2, 2, 9);
INSERT INTO ql_sinhvien.diem_thi (id, id_sinh_vien, id_mon, diem) VALUES (6, 1, 3, 10);

-- 4. Sử dụng câu lệnh update

-- 5.	Truy vấn dữ liệu:
-- 5.1
select * from sinh_vien;
-- 5.2
select * from mon_hoc;

-- 5.3 o	Hiển thị tên sinh viên, môn học và điểm thi của sinh viên đó từ bảng SinhVien  sử dụng join
-- inner join vd:
select * from sinh_vien
-- chỉ lấy những bản ghi có id vừa tồn tại ở bảng sinh viên và vừa tồn tại ở column id_sinh_vien bảng diem_thi
                  inner join diem_thi on sinh_vien.id = diem_thi.id_sinh_vien ;

-- Tìm sinh viên có điểm trung bình > 8.0
SELECT * FROM sinh_vien
WHERE diem_trung_binh > 8.0;

-- Liệt kê các môn học mà sinh viên có điểm thi dưới 5.0
SELECT DISTINCT mh.ten_mon
FROM diem_thi dt
         JOIN mon_hoc mh ON dt.id_mon = mh.id
WHERE dt.diem < 7;

-- Đếm số sinh viên có điểm thi môn học trên 6.0
SELECT sv.*, dt.diem
FROM diem_thi dt
         JOIN sinh_vien sv ON dt.id_sinh_vien = sv.id
WHERE dt.diem > 6.0;

-- Sinh viên có điểm TB từ 7.0 đến 8.5 và giới tính là "Nam"
SELECT * FROM sinh_vien
WHERE diem_trung_binh BETWEEN 7.0 AND 8.5
  AND gioi_tinh = 'Male';

-- Sinh viên có email chứa "gmail.com" hoặc "yahoo.com"
SELECT * FROM sinh_vien
WHERE email LIKE '%gmail.com%' OR email LIKE '%yahoo.com%';

-- Sinh viên có điểm TB > 6.5 và có ít nhất 1 môn điểm < 5.0
SELECT DISTINCT sv.*
FROM sinh_vien sv
         JOIN diem_thi dt ON sv.id = dt.id_sinh_vien
WHERE sv.diem_trung_binh > 6.5
  AND dt.diem < 5;

-- Đếm số sinh viên có điểm môn học > 6.0, nhóm theo môn học
SELECT mh.ten_mon, COUNT(DISTINCT dt.id_sinh_vien) AS so_sinh_vien
FROM diem_thi dt
         JOIN mon_hoc mh ON dt.id_mon = mh.id
WHERE dt.diem > 6.0
GROUP BY mh.ten_mon;

-- Tính số sinh viên thi lại (điểm < 5.0) cho từng môn
SELECT mh.ten_mon, COUNT(*) AS so_sinh_vien_thi_lai
FROM diem_thi dt
         JOIN mon_hoc mh ON dt.id_mon = mh.id
WHERE dt.diem < 5.0
GROUP BY mh.ten_mon;
