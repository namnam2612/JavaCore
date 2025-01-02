create database quanlynhansu2;

use quanlynhansu2;
create table nhan_vien (
    id integer auto_increment primary key,
    ma_nhan_vien varchar(30),
    ho_ten nvarchar(100),
    ngay_sinh date,
    dia_chi nvarchar(200),
    chuc_vu nvarchar(50)
);

create table phong_ban (
    id integer auto_increment primary key,
    ma_phong_ban varchar(30),
    ten_phong_ban nvarchar(50)
);

create table du_an (
    id integer auto_increment primary key ,
    ma_du_an nvarchar(30) ,
    ten_du_an nvarchar(100)
);

/*
nhan vien - phong ban  ( n - 1 )
-> trong bang nhan vien them cot department_id dong vai tro la khoa ngoai tham chieu
tu bang nhan vien -> phong ban
*/

alter table nhan_vien
    add column department_id integer;

-- config khoa ngoai cho department_id
alter table nhan_vien add foreign key (department_id) references phong_ban(id);


/*
phong ban - du an ( n - 1 )
tuong tu nhu nhan vien - phong ban
*/

alter table du_an
    add column department_id integer;

-- config khoa ngoai cho department_id
alter table du_an add foreign key (department_id) references phong_ban(id);

/*
nhan vien - du an ( n - n )
+) 1 nhan vien co the lam nhieu du an
+) 1 du an co the lam bao nhieu nhan vien

de the hien duoc moi quan he nhieu nhieu se tao them bang phu ten nhan_vien_du_an voi moi
quan he
nhan_vien_du_an - nhan vien ( n - 1 )
nhan_vien_du_an - du an ( n - 1 )

bang nhan vien du an se co 2 cot
nhan_vien_id : khoa ngoai tham chieu toi bang nhan vien
du_an_id: khoa ngoai tham chieu toi bang du an
*/

create table nhan_vien_du_an (
    nhan_vien_id integer ,
    du_an_id integer
);
alter table nhan_vien_du_an add foreign key (nhan_vien_id) references nhan_vien(id);
alter table nhan_vien_du_an add foreign key (du_an_id) references  du_an(id);