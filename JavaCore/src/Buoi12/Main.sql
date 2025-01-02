create database hethongquanly;
use hethongquanly;
create table student1(
                        id integer primary key auto_increment, -- Mã sinh viên, khóa chính, tự động tăng
                        first_name varchar(50), -- tên sinh viên
                        last_name varchar(50), -- họ sinh viên
                        birth_date date, -- ngày tháng năm sinh
                        email varchar(100) -- email
);



create table course1 (
                        id integer primary key auto_increment, -- Mã khóa học, khóa chính, tự động tăng
                        course_name varchar(50), -- tên khóa học
                        course_description text -- mô tả khóa học
);


use hethongquanly;
create table enrollments1 (
                             id integer primary key auto_increment, -- Mã đăng ký, khóa chính, tự động tăng
                             student_id INT, -- mã sinh viên
                             course_id INT, -- mã khóa học
                             enrollment_date date, -- ngày đăng ký khóa học
                             FOREIGN KEY (student_id) REFERENCES student1(id), -- Khóa ngoại tham chiếu đến bảng Students
                             FOREIGN KEY (course_id) REFERENCES course1(id) -- Khóa ngoại tham chiếu đến bảng Courses
);

insert into student1 (id, first_name, last_name, birth_date, email)
    value (1,'Nam', 'Hoang','2003-12-26','danghoangnam@gmail.com');
insert into student1 (id, first_name, last_name, birth_date, email)
    value (2,'Thao', 'Huyen','2005-07-15','thaohuyen@gmail.com');
insert into student1 (id, first_name, last_name, birth_date, email)
    value (3,'Phong', 'Le','2004-04-11','phongle@gmail.com');
insert into student1 (id, first_name, last_name, birth_date, email)
    value (4,'Thang', 'Nguyen','2004-11-15','huythang@gmail.com');
insert into student1 (id, first_name, last_name, birth_date, email)
    value (5,'Thao', 'Phuong','2005-10-26','thaophuong@gmail.com');

insert into course1 (course_name, course_description)
    value ('lap trinh C','lap trinh c co ban');
insert into course1 (course_name, course_description)
    value ('lap trinh java','lap trinh java co ban');
insert into course1 ( course_name, course_description)
    value ('lap trinh javascript','lap trinh javascript co ban');
insert into course1 ( course_name, course_description)
    value ( 'lap trinh co ban', 'lap trinh cho nguoi moi bat dau');

insert into enrollments1 (student_id, course_id, enrollment_date)
    value (1, 1, '2024-02-12');
insert into enrollments1 (student_id, course_id, enrollment_date)
    value (2, 2, '2024-01-12');
insert into enrollments1 (student_id, course_id, enrollment_date)
    value (3, 3, '2024-03-12');
insert into enrollments1 (student_id, course_id, enrollment_date)
    value (4, 4, '2024-04-12');

select * from student1;
select * from course1;
select * from enrollments1;

-- group by
select count(*), last_name from student1 group by last_name;

-- having: đếm số lượng student theo last_name mà số lượng std co cung laster > 1
select count(*), last_name from student1 group by last_name having count(*) > 1;

/*
inner join:

**/

create table employees (
    employee_id int primary key,
    first_name varchar(50),
    last_name varchar(50),
    department_id int,
    salary decimal(10,2)

);
create table departments (
    department_id int primary key,
    department_name varchar(50)
);

insert into employees (employee_id, first_name, last_name, department_id, salary)
value
(1,'join', 'doe',1, 60000.00),
(2,'jane', 'smith',2, 75000.00),
(3,'alice', 'johnson',1, 80000.00),
(4,'bob', 'brown',3, 55000.00),
(5,'charlie', 'davis',2, 72000.00);

insert into departments (department_id, department_name)
value
(1,'HR'),
(2,'engineering'),
(3,'sales');

alter table employees add foreign key (department_id) references departments (department_id);

-- kết hợp dữ liệu từ bảng employees và department, chỉ lấy ra các employees có thuộc về department

select emp.employee_id,emp.first_name, dept.department_name from employees emp -- ket hop 2 bang
    inner join departments dept
on emp.department_id = dept.department_id; -- chi lay ra cac ban ghi o ban empl va dept co cung dept id

/*
left join
    lay toan bo du lieu table A
    chi lay du lieu thoa man o table b
*/
 select * from employees;
select * from employees left join departments
on employees.department_id = departments.department_id;

/*
c1: chuc nang tim kiem nhan vien, hien thi thong tin last_name cua nhan vien va phong ban cua nhan vien
meu nhan vien khong co phong ban hien thi null

c2: chuc nang tim kiem nhan vien, hien thi thong tin last_name cua nhan vien, va phong ban cua nhan vien, chi lay ra cac
nhan vien co phong ban
*/

-- c1
-- neu khong co department thi se null
select emp.last_name, dept.department_name
from employees emp left join departments dept
on emp.department_id = dept.department_id;

/*
right join:
    table a,b
    luon lay toan bo du lieu table b, chi lay du lieu thoa man table a
*/

select * from employees emp right join departments dept
on emp.department_id = dept.department_id;

/*
self join:
    ket hop du lieu voi chinh no qua khoa ngoai long
*/

create table category (
    id int primary key auto_increment,
    name nvarchar(50),
    parent_id int -- khoa ngoại tham chieu truc tiep toi id cua chinh bang category, luu lai id cua category cha
);
alter table category add foreign key (parent_id) references category(id);

insert into category (name, parent_id)  -- them 2 category cha to nhat
value
    ('nam', null),
    ('tre em', null),
    ('nu', null), -- cac category con cua nu
    ('tre so sinh', null);


insert into category (name, parent_id)  --
    value
    ('do mac ngoai', 1), -- cac category con cua nu
    ('quan', 1),
    ('chan vay', 1);
insert into category (name, parent_id)
values
    ('em be 0-1 tuoi',2),
    ('em be 6-5 tuoi',2);

-- chi hien thi cac category cha khi vua vao man home
select name from category where parent_id is null;
-- chi lay ra cac category cua nu -> co parent id = nu

select child.name from category child
inner join category parent on child.parent_id = parent.id
where parent.name = 'nu';

-- hi lay ra cac category cua tre so sinh
select child.name from category child
inner join category parent on child.parent_id = parent.id
where parent.name = 'tre so sinh';

-- luu cac du lieu lop con level 2, vay id = 5
select * from category;
insert into category
(name, parent_id) value
    ('chan vay',5),
    ('dam',5),
    ('tat ca chan vay va dam',5);

-- luu cac du lieu lop con level 2, tre so sinh id = 2
select * from category;
insert into category
(name, parent_id) value
    ('do lien manh',2),
    ('ao thun',2),
    ('bodysuit',2);

-- lay ra cac con cua category chan vay
select child.name from category child inner join
category parent on child.parent_id = parent.id
where parent.name = 'chan vay';

/*
full join
    ket hop du lieu ca hai bang voi nhau, trong mysql khong ho tro truc tiep
    can thuc hien thong qua union
union:
    ket hop du lieu cua 2 bang voi nhau, voi dieu kien:
    + tat ca cac cot cua hai bang phai giong nhau ca ten va kieu du lieu
*/

select department_id from employees
union
select department_id from  departments;

select * from employees emp
left join departments dept
on emp.department_id = dept.department_id;

select * from employees emp
                  right join departments dept
                            on emp.department_id = dept.department_id;

/*
cross join:
    tong hop tat ca cac du lieu cua bang a voi bang b theo dang tich decat
*/
select * from employees emp
cross join departments dept on emp.department_id = dept.department_id;


--

/*
sub query:
    trong cau query se thuc hien mot cau query khac truoc, va lay raket qua cua cau query do de thuc hien
dua ra ket qua cuoi cung
*/
-- lay ra cac con cua category chan vay su dung join
select child.name from category child inner join
category parent on child.parent_id = parent.id
where parent.name = 'chan vay';

-- lay ra cac con cua category chan vay su dung sub query
select child.name from category child
where child.parent_id = (select id from category where category.name = 'chan vay');


