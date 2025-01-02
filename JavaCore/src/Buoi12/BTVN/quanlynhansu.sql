-- 11 tìm phòng ban có nhiều nhân viên nhất và tổng lương của phòng ban đó
/*
+ max
+ sum
*/
use quanlynhansu;
-- tim ra phong ban co nhieu nhan vien nhat
select department_id,count(*) from employees group by  department_id order by count(*) desc limit 1;
-- tim phong ban co nhieu nhan vien nhat va tong luong phong ban do
select dept.department_id, sum(emp.salary) from employees emp inner join
    departments dept on emp.department_id = dept.department_id
inner join (select department_id,count(*) from employees group by  department_id order by count(*) desc limit 1) term
on term.department_id = dept.department_id group by dept.department_id;

-- 12 tim nhan vien co muc luong cao nhat trong moi phong ban
select  emp.name, emp.salary, dept.department_name from  employees emp
inner join departments dept on emp.department_id = dept.department_id
where emp.salary = (select max(salary) from employees where employees.department_id = dept.department_id);

-- 13 tinh muc luong trung binh cua tung vi tri cong viec, chi hien thi cac vi tri co luong trung binh lon hon 1500
select distinct e.position, avg(e.salary) avg_salary_position from employees e
group by e.position having avg_salary_position > 1500;

-- 14 lay danh sach nhan vien va dong nghiep cung phong ban (khong bao gom chinh ho)
select distinct emp.name, dept.department_name from departments dept
inner join employees emp on dept.department_id = emp.department_id
group by emp.name, dept.department_name;

-- 15 tinh tong so nam kinh nghiem cua moi phong ban
select emp.department_id, dept.department_name,
       sum(datediff(curdate(), emp.hire_date)/ 365) as total
from employees emp inner join departments dept
on emp.department_id = dept.department_id group by emp.department_id, dept.department_name;

select dept.department_name, max(year(curdate()) - year(emp.hire_date)) from employees emp
inner join departments dept on emp.department_id = dept.department_id
group by dept.department_name;

-- 16 tim nhân viên được tuyển dụng sớm nhất trong mỗi phòng ban, bao gồm cả tên và ngày tuyển dụng
-- tim ra phong ban va ngay tuyen dung som nhat cua phong ban do
select dept.department_name, min(emp.hire_date) from employees emp
join departments dept on emp.department_id = dept.department_id group by dept.department_name;

select emp.name, dept.department_name, emp.hire_date from employees emp
inner join departments dept on emp.department_id = dept.department_id
inner join (select dept.department_name, min(emp.hire_date) as min_hire_date from employees emp
    inner join departments dept on emp.department_id = dept.department_id group by dept.department_name) dept_min_hire_date
    on dept.department_name = dept_min_hire_date.department_name
where dept_min_hire_date.min_hire_date = emp.hire_date;

-- 17 tim phong ban co tong luong lon nhat va hien thi ten nhan vien, luong va phong ban do
-- tim phong ban co tong luong lon nhat
select dept.department_name, max(emp.salary) max_salary from employees emp
join departments dept on emp.department_id = dept.department_id group by dept.department_name
order by max_salary desc limit 1;

select emp.name, dept.department_name, emp.salary from employees emp
inner join departments dept on emp.department_id = dept.department_id
inner join (select dept.department_name, max(emp.salary) max_salary from employees emp
    join departments dept on emp.department_id = dept.department_id group by dept.department_name
order by max_salary desc limit 1)
dept_max_salary on dept.department_name = dept_max_salary.department_name
where emp.salary = dept_max_salary.max_salary;

-- 18 phan nhom nhan vien theo cap bac luong (vd: < 1500, 1500-2000, > 2000) va tinh tong so nhan vien trong tung
/*
case
    when condition1 then a
    when condition2 then b
    eles c
end
chu thich:
+ condition1: dieu kien kiem tra voi if 1
    a: duoc thuc thi khi condition1 = true
+ condition2: dieu kien kiem tra voi if 2
    b: duoc thuc thi khi condition2 = true
    c: duoc thuc thi khi tat ca condition1 va condition2 = false
*/
select
    case
        when emp.salary > 2000 then 'level > 2000'
        when emp.salary between 1500 and 2000 then 'level between 1500 and 2000'
        else 'level < 1500'
    end as level,
    count(*) total_emp
from employees emp group by level;

-- 19 tim nhan vien co tong so luong cao nhat trong tat ca cac phong ban (bao gom ca ten phong ban)
select max(salary) max_salary from employees;

select emp.name, emp.salary, dept.department_name from employees emp
inner join departments dept on emp.department_id = dept.department_id
where emp.salary = (select max(salary) max_salary from employees);

-- 20 tim nhan vien co luong cao hon muc luong trung binh cua phong ban ma ho lam viec

-- muc luong trung binh cua cac phong ban
select dept.department_name, avg(emp.salary) from employees emp
inner join departments dept on emp.department_id = dept.department_id group by  dept.department_name;

select emp.name, dept.department_name, emp.salary, dept_avg_salary.avg_salary from employees emp
inner join departments dept on emp.department_id = dept.department_id
inner join (select dept.department_name, avg(emp.salary) avg_salary from employees emp
inner join departments dept on emp.department_id = dept.department_id group by  dept.department_name)
dept_avg_salary on dept.department_name = dept_avg_salary.department_name
where emp.salary > dept_avg_salary.avg_salary;