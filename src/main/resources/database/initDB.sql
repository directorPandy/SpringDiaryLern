CREATE TABLE IF NOT EXISTS students(

    student_id BIGINT not null PRIMARY KEY,
    name varchar(50),
    age integer ,
    email varchar(50),
    grade_id integer
);

CREATE TABLE IF NOT EXISTS teachers(
    teacher_id BIGINT not null PRIMARY KEY,
    name varchar(50) ,
    age integer ,
    email varchar(50),
    grade_id integer

);

CREATE TABLE IF NOT EXISTS grade(
    grade_id BIGINT not null PRIMARY KEY,
    number varchar(50)
);