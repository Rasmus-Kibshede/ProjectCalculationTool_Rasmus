CREATE SCHEMA if NOT EXISTS projectcalculationtool;
use projectcalculationtool;

DROP TABLE if EXISTS employees;
DROP TABLE if EXISTS projects;
DROP TABLE if EXISTS subprojects;
DROP TABLE if EXISTS tasks;

CREATE TABLE employees(
    employee_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    employee_email varchar(128) NOT NULL UNIQUE,
    employee_password varchar(128) NOT NULL
);

CREATE TABLE projects(
    project_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    project_name varchar(45) NOT NULL,
    fk_employee_id int NOT NULL
);

CREATE TABLE subprojects(
    subproject_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    subproject_name varchar(45) NOT NULL,
    fk_project_id int NOT NULL
);

CREATE TABLE tasks(
    task_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    task_name varchar(45) NOT NULL,
    task_hours int NOT NULL,
    fk_subproject_id int NOT NULL
);