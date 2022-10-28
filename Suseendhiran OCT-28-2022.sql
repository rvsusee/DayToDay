CREATE TABLE SUSEENDHIRAN_EMPLOYEES(
    id int Primary key,
    first_name varchar(50),
    last_name varchar(50),
    salary decimal(8,2),
    department_id int,
    year_of_joining DATETIME,
    year_of_relieving DATETIME
);

CREATE TABLE SUSEENDHIRAN_DEPARTMENTS(
    department_id int primary key,
    manager_id int,
    department_name varchar(50)
);

insert into SUSEENDHIRAN_EMPLOYEES(id,first_name,last_name,salary,department_id,year_of_joining,year_of_relieving) VALUES
    (1001,'Aimee','Zank',23000,22,'07-11-2018' ,'07-10-2022'),
    (1002,'Salena','Olmos',17000,30,'06-17-2019' ,'10-22-2023'),
    (1003,'Sanda','Ryban',18000,90,'12-21-2018' ,'06-03-2022'),
    (1004,'Gisela','Levin',15000,50,'08-06-2020' ,'09-15-2024'),
    (1005,'Tandra','Meadows',25000,10,'03-30-2017' ,'10-18-2021'),
    (1006,'Kafa','Ryban',18000,90,'12-17-2018' ,'06-03-2022'),
    (1007,'Selva','Ryban',18000,90,'12-01-2018' ,'06-03-2022'),
    (1008,'Kumar','Riyaz',18000,90,'12-01-2022' ,'06-03-2022'),
    (1009,'ARUN','KUMAR',2000,10,'2016-03-03','2019-04-04'),
    (1010,'VARUN','KUMAR',2500,12,'2016-06-05','2019-02-04'),
    (1011,'SARAN','KUMAR',5000,32,'2015-06-05','2019-08-04'),
    (1012,'SARATH','KUMAR',6000,90,'2015-06-05','2019-08-04'),
    (1013,'SARAN','KUMAR',6000,30,'2017-03-11','2019-08-04')
;

select * from  SUSEENDHIRAN_EMPLOYEES;
select * from SUSEENDHIRAN_DEPARTMENTS;
delete from SUSEENDHIRAN_EMPLOYEES;

insert into SUSEENDHIRAN_DEPARTMENTS(department_id,manager_id,department_name) values
    (10,101,'department 10'),
    (20,102,'department 20'),
    (22,NULL,'department 22'),
    (50,NULL,'department 50'),
    (90,109,'department 90')
;
select * from SUSEENDHIRAN_DEPARTMENTS;
delete from SUSEENDHIRAN_DEPARTMENTS;




-- 1.Write a query to display all the name which starts with S
    select * from SUSEENDHIRAN_EMPLOYEES where first_name like 'S%';

-- 2.Write a query to display all the name starts with S and ends with character n.
    select * from SUSEENDHIRAN_EMPLOYEES where first_name like 'S%' and last_name like '%n';

-- 3.Write a query to display all the employees who are all working for department 90 and their name must starts with ‘S’.
    select * from SUSEENDHIRAN_EMPLOYEES where department_id = 90 and first_name like 'S%';

-- 4. Display all the department id which contain 2 as 2nd character.
    select * from SUSEENDHIRAN_DEPARTMENTS where department_id like '%_2';

-- 5. Write a query to display all the employees who are all working in department 10,20,50 and 90.
    select * from SUSEENDHIRAN_EMPLOYEES where department_id = 10 or department_id = 20 or department_id = 30 or department_id = 90;

-- 6. Write a query to display who are all getting salary between 5000 and 7000
    select * from SUSEENDHIRAN_EMPLOYEES where salary between 5000 and 7000;
    
-- 7. Display First_name, salary, department_id and manager_id of the employee who don't have manager
    select SUSEENDHIRAN_EMPLOYEES.first_name,SUSEENDHIRAN_EMPLOYEES.salary,SUSEENDHIRAN_EMPLOYEES.department_id,
    SUSEENDHIRAN_DEPARTMENTS.manager_id from SUSEENDHIRAN_EMPLOYEES JOIN SUSEENDHIRAN_DEPARTMENTS ON SUSEENDHIRAN_EMPLOYEES.department_id = SUSEENDHIRAN_DEPARTMENTS.department_id where SUSEENDHIRAN_DEPARTMENTS.manager_id IS NULL;

-- 8. Display all the records in employees table and sort the first name in ascending order
    select * from SUSEENDHIRAN_EMPLOYEES ORDER BY first_name ASC;

-- 9. Display first name, department id and salary from employees table and sort the records ( sort department id in ascending order and salary in descending order)
    select first_name, department_id,salary from SUSEENDHIRAN_EMPLOYEES ORDER BY department_id,salary DESC;

-- 10. Display first three characters from first name
    select substring(first_name,1,3) as first_name from SUSEENDHIRAN_EMPLOYEES;

-- 11. Display last two character from last name
    select RIGHT(last_name,2) as last_name from SUSEENDHIRAN_EMPLOYEES;

-- 12. Display all the first name and position of a in that name (first occurrence of a). 
    select first_name,CHARINDEX('a',first_name) from SUSEENDHIRAN_EMPLOYEES;

-- 13. Write a query to select maximum salary from employees table
    select Max(salary) as max_salary from SUSEENDHIRAN_EMPLOYEES;
    
-- 14. Write a query to select second maximum salary from employees table
    select Max(salary) as second_maximum_salary from SUSEENDHIRAN_EMPLOYEES where salary NOT IN (SELECT MAX(salary) from SUSEENDHIRAN_EMPLOYEES);

-- 15. Display average salary in the department 90
    select avg(salary) as avg_salary_dept_90 from SUSEENDHIRAN_EMPLOYEES where department_id = 90;
    
-- 16. Display number of employees joined in each year into department 30
    SELECT COUNT(first_name) AS counts,year_of_joining FROM SUSEENDHIRAN_EMPLOYEES WHERE department_id=30 GROUP BY year_of_joining;
    
-- 17. Display average salary for employees who did a job in the past.
    select avg(salary) as past_emp_avg_salary from SUSEENDHIRAN_EMPLOYEES where year_of_relieving <= getdate();
    
-- 18. Display the month in which more than 5 employees joined in any department
    SELECT MONTH(year_of_joining) AS MONTHS  FROM SUSEENDHIRAN_EMPLOYEES GROUP BY MONTH(year_of_joining) HAVING COUNT(MONTH(year_of_joining))>5;

-- 19. Display employee last name, starting date for all jobs from 2000 to 2005
    select last_name,DAY(year_of_joining) from SUSEENDHIRAN_EMPLOYEES where YEAR(year_of_joining) BETWEEN 2018 and 2020;
    
-- 20. Display years in which more than 10 employees joined.
    SELECT YEAR(year_of_joining),COUNT(year_of_joining) FROM SUSEENDHIRAN_EMPLOYEES GROUP BY YEAR(year_of_joining) having COUNT(MONTH(year_of_joining)) > 10;

-- 21.  Display employee ID for jobs with average salary more than 10000. 
    SELECT AVG(salary) AS salary,id FROM SUSEENDHIRAN_EMPLOYEES GROUP BY id HAVING AVG(salary)>=10000

-- 22. Display the number of days between working for all employees.
    select id,first_name,last_name,DATEDIFF(day,year_of_joining,year_of_relieving) as date_diff from SUSEENDHIRAN_EMPLOYEES;

-- 23. Display employees who joined in the current year.  select * from SUSEENDHIRAN
   select * from SUSEENDHIRAN_EMPLOYEES where YEAR(year_of_joining) = YEAR(getDate());

-- 24. Display first name in upper case and last name in lower case
    select UPPER(first_name),LOWER(last_name) from SUSEENDHIRAN_EMPLOYEES;

-- 25. Display the length of first name for employees where last name contain character ‘b’ after 3rd position.
    select first_name,LEN(first_name) as first_name_length,CHARINDEX('b',last_name) as indexes from SUSEENDHIRAN_EMPLOYEES where CHARINDEX(last_name,'b') > 3;

-- 26. Display first name and experience of the employees 
    select first_name,DATEDIFF(YEAR,year_of_joining,year_of_relieving) AS experience from SUSEENDHIRAN_EMPLOYEES;
    
-- 27. Display employees who joined in the month of May
    select * from SUSEENDHIRAN_EMPLOYEES where MONTH(year_of_joining) = '5';

-- 28. write a SQL query to find those employees who earn more than the average salary. Return employee ID, first name, last name
    select id,first_name,last_name from SUSEENDHIRAN_EMPLOYEES where salary > (select AVG(salary) from SUSEENDHIRAN_EMPLOYEES);    

-- 29. Difference between primary key and Foreign key with exmple. 
    SELECT * FROM SUSEENDHIRAN_EMPLOYEES LEFT OUTER JOIN SUSEENDHIRAN_DEPARTMENTS ON SUSEENDHIRAN_EMPLOYEES.department_id=SUSEENDHIRAN_DEPARTMENTS.department_id;
    
-- 30. Repalce ‘null’ value to ‘AAA’ 
    SELECT id,ISNULL(first_name,'AAA') as first_name,ISNULL(last_name,'AAA') as last_name from SUSEENDHIRAN_EMPLOYEES;
    
-- 31. Create View table for ID,FIRST_NAME,LAST_NAME, DEPARTMENT_ID,DEPARTMENT_NAME
    CREATE VIEW SUSEENDHIRAN_EMPLOYEES_VIEW AS SELECT SUSEENDHIRAN_EMPLOYEES.id,SUSEENDHIRAN_EMPLOYEES.first_name,SUSEENDHIRAN_EMPLOYEES.last_name,SUSEENDHIRAN_EMPLOYEES.department_id,SUSEENDHIRAN_DEPARTMENTS.department_name from SUSEENDHIRAN_EMPLOYEES JOIN SUSEENDHIRAN_DEPARTMENTS ON SUSEENDHIRAN_EMPLOYEES.department_id = SUSEENDHIRAN_DEPARTMENTS.department_id;
    
    SELECT * FROM SUSEENDHIRAN_EMPLOYEES_VIEW;
    
    
-- 32. Create SYNONYMS for EMPLOYEE table.
    CREATE SYNONYM SUSEENDHIRAN_SYNONYM FOR SUSEENDHIRAN_EMPLOYEES; 
    SELECT * FROM SUSEENDHIRAN_SYNONYM;


-- 33. Create a procedure for who are joined between 2 dates.

    CREATE PROCEDURE SUSEENDHIRAN_PROCEDURE
    AS
    SELECT * FROM SUSEENDHIRAN_EMPLOYEES
    GO;

    EXEC SUSEENDHIRAN_PROCEDURE;

    CREATE PROCEDURE SUSEENDHIRAN_PROCEDURE_2 AS SELECT first_name FROM SUSEENDHIRAN_EMPLOYEES WHERE year_of_joining BETWEEN '2017-03-11' AND '2019-03-11';

    EXEC SUSEENDHIRAN_PROCEDURE;

-- 34. Create a procedure for insert a rows in Department table.

    -- incomplete


-- 35. write a query for convert ‘2006-12-30 00:38:54.840’ to 20061230003854 
    select replace(convert(varchar, '2006-12-30',101),'-','')+ replace(convert(varchar, '00:38:54',108),':','')

    
    
    
    
    
    