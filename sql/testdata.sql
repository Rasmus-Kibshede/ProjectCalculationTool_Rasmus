use projectcalculationtool;

INSERT INTO employees(employee_email, employee_password) VALUES ("test@yes.com", "123");

INSERT INTO projects(project_name, fk_employee_id) VALUES ("Hus", 1);

INSERT INTO subprojects(subproject_name, fk_project_id) VALUES ("Design", 1);
INSERT INTO tasks(task_name, task_hours, fk_subproject_id) VALUES ("Tilladelser", 65, 1);
INSERT INTO tasks(task_name, task_hours, fk_subproject_id) VALUES ("Tegninger", 45, 1);

INSERT INTO subprojects(subproject_name, fk_project_id) VALUES ("Indkøb", 1);
INSERT INTO tasks(task_name, task_hours, fk_subproject_id) VALUES ("Elektricitet", 205, 2);
INSERT INTO tasks(task_name, task_hours, fk_subproject_id) VALUES ("VVS", 85, 2);
INSERT INTO tasks(task_name, task_hours, fk_subproject_id) VALUES ("HVAC", 55, 2);

INSERT INTO subprojects(subproject_name, fk_project_id) VALUES ("Konstruktion", 1);
INSERT INTO tasks(task_name, task_hours, fk_subproject_id) VALUES ("Interiør", 525, 3);
INSERT INTO tasks(task_name, task_hours, fk_subproject_id) VALUES ("Eksteriør", 198, 3);

INSERT INTO subprojects(subproject_name, fk_project_id) VALUES ("Inspektion", 1);
INSERT INTO tasks(task_name, task_hours, fk_subproject_id) VALUES ("Murerarbejde", 68, 4);
INSERT INTO tasks(task_name, task_hours, fk_subproject_id) VALUES ("Bygningsfærdiggørelse", 45, 4);

INSERT INTO subprojects(subproject_name, fk_project_id) VALUES ("Omsætning", 1);
INSERT INTO tasks(task_name, task_hours, fk_subproject_id) VALUES ("Gennemgang", 10, 5);
INSERT INTO tasks(task_name, task_hours, fk_subproject_id) VALUES ("Afslutning", 12, 5);