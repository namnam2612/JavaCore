use quanlysinhvienvakhoahoc;
create table student(
                        id integer primary key auto_increment, -- Mã sinh viên, khóa chính, tự động tăng
                        first_name varchar(50), -- tên sinh viên
                        last_name varchar(50), -- họ sinh viên
                        birth_date date, -- ngày tháng năm sinh
                        email varchar(100) -- email
);



create table course (
                        id integer primary key auto_increment, -- Mã khóa học, khóa chính, tự động tăng
                        course_name varchar(50), -- tên khóa học
                        course_description text -- mô tả khóa học
);



create table Enrollments (
                             id integer primary key auto_increment, -- Mã đăng ký, khóa chính, tự động tăng
                             student_id INT, -- mã sinh viên
                             course_id INT, -- mã khóa học
                             enrollment_date date, -- ngày đăng ký khóa học
                             FOREIGN KEY (student_id) REFERENCES student(id), -- Khóa ngoại tham chiếu đến bảng Students
                             FOREIGN KEY (course_id) REFERENCES Course(id) -- Khóa ngoại tham chiếu đến bảng Courses
);

insert into student (id, first_name, last_name, birth_date, email)
    value (1,'Nam', 'Hoang','2003-12-26','danghoangnam@gmail.com');
insert into student (id, first_name, last_name, birth_date, email)
    value (2,'Thao', 'Huyen','2004-07-15','thaohuyen@gmail.com');
insert into student (id, first_name, last_name, birth_date, email)
    value (3,'Phong', 'Le','2004-04-11','phongle@gmail.com');
insert into student (id, first_name, last_name, birth_date, email)
    value (4,'Thang', 'Nguyen','2004-11-15','huythang@gmail.com');
insert into student (id, first_name, last_name, birth_date, email)
    value (5,'Thao', 'Phuong','2005-10-26','thaophuong@gmail.com');

insert into course (course_name, course_description)
    value ('lap trinh C','lap trinh c co ban');
insert into course (course_name, course_description)
    value ('lap trinh java','lap trinh java co ban');
insert into course ( course_name, course_description)
    value ('lap trinh javascript','lap trinh javascript co ban');
insert into course ( course_name, course_description)
    value ( 'lap trinh co ban', 'lap trinh cho nguoi moi bat dau');

insert into Enrollments (student_id, course_id, enrollment_date)
    value (1, 1, '2024-02-12');
insert into Enrollments (student_id, course_id, enrollment_date)
    value (2, 4, '2024-01-12');
insert into Enrollments (student_id, course_id, enrollment_date)
    value (3, 4, '2024-03-12');
insert into Enrollments (student_id, course_id, enrollment_date)
    value (4, 4, '2024-04-12');

-- 1
select student.first_name, student.last_name, student.email from student;
-- 2
select * from student;
select * from  course;
select * from enrollments;
-- 3
select student.first_name as student_first_name,
       student.last_name as student_last_name,
       course.course_name as course_name
from enrollments
         join student on enrollments.student_id = student.id
         join course on enrollments.course_id = course.id;
-- 4
select student.first_name as student_first_name,
       student.last_name as student_last_name,
       student.email
from enrollments
         join student on enrollments.student_id = student.id
         join course on enrollments.course_id = course.id
where course.course_name like 'lap trinh co ban';
-- 5
select student.first_name, student.last_name, student.email
from student
where birth_date > '2000-01-01' and email like 'gmail';

update student
set email = 'nguyenminhkhanhnam@gmail.com'
where id = 1;

update course
set course_description = 'mo ta moi cho khoa hoc lap trinh co ban'
where course_name - 'lap trinh co ban';

DELETE FROM student
WHERE id = 1 AND id NOT IN (SELECT student_id FROM enrollments);

DELETE FROM course
WHERE id = 1 AND id NOT IN (SELECT course_id FROM enrollments);




