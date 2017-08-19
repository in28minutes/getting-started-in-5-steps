insert into passport(id, number)
values(40001, 'L123456');

insert into passport(id, number)
values(40002, 'M123456');

insert into passport(id, number)
values(40003, 'N123456');

insert into passport(id, number)
values(40004, 'O123456');


insert into course(id, name)
values(10001,'Spring in 100 Steps');

insert into course(id, name)
values(10002,'Spring Boot in 100 Steps');

insert into course(id, name)
values(10003,'JPA in 50 Steps');

insert into student(id, name,passport_id)
values(20001, 'Adam',40001);

insert into student(id, name,passport_id)
values(20002, 'Buck',40002);

insert into student(id, name,passport_id)
values(20003, 'Chris',40003);

insert into student(id, name,passport_id)
values(20004, 'Dennis',40004);


insert into course_students(courses_id,students_id)
values(10001,20001);

insert into course_students(courses_id,students_id)
values(10001,20002);

insert into course_students(courses_id,students_id)
values(10001,20003);

insert into course_students(courses_id,students_id)
values(10002,20001);

insert into course_students(courses_id,students_id)
values(10002,20002);
