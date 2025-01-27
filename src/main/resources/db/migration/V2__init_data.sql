insert into lab6_maven.school_class (id, name, grade_level, teacher_name, school_year) values (1, 'Math 101', 9, 'John Doe', 2024);
insert into lab6_maven.school_class (id, name, grade_level, teacher_name, school_year) values (2, 'English Literature', 10, 'Jane Smith', 2024);
insert into lab6_maven.school_class (id, name, grade_level, teacher_name, school_year) values (3, 'Physics', 11, 'Alan Turing', 2024);
insert into lab6_maven.school_class (id, name, grade_level, teacher_name, school_year) values (4, 'History', 12, 'Emily Johnson', 2024);
insert into lab6_maven.school_class (id, name, grade_level, teacher_name, school_year) values (5, 'Biology', 11, 'Charles Darwin', 2024);

insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (1, 'Alice', 'Brown', 1);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (2, 'Bob', 'Johnson', 1);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (3, 'Charlie', 'Davis', 1);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (4, 'Diana', 'Wilson', 1);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (5, 'Ethan', 'Clark', 1);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (6, 'Fiona', 'Taylor', 2);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (7, 'George', 'Anderson', 2);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (8, 'Hannah', 'Thomas', 2);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (9, 'Ian', 'White', 2);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (10, 'Jackie', 'Moore', 2);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (11, 'Kevin', 'Harris', 3);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (12, 'Lilly', 'Martin', 3);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (13, 'Mason', 'Garcia', 3);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (14, 'Nina', 'Martinez', 3);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (15, 'Oliver', 'Robinson', 3);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (16, 'Paula', 'Walker', 4);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (17, 'Quinn', 'Young', 4);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (18, 'Rachel', 'Allen', 4);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (19, 'Sophie', 'King', 4);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (20, 'Thomas', 'Lopez', 4);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (21, 'Ursula', 'Hill', 5);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (22, 'Victor', 'Scott', 5);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (23, 'Wendy', 'Green', 5);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (24, 'Xander', 'Adams', 5);
insert into lab6_maven.student (id, first_name, last_name, school_class_id) values (25, 'Yvonne', 'Baker', 5);

insert into lab6_maven.student_grade(id, grade, weight, date, school_class_id, student_id) values
(1, 4, 1, '2024-09-20', 1, 1),  -- Alice Brown (Math 101)
(2, 4, 3, '2024-10-05', 1, 2),  -- Bob Johnson (Math 101)
(3, 5, 1, '2024-11-01', 1, 3),  -- Charlie Davis (Math 101)
(4, 4, 2, '2024-12-12', 1, 4),  -- Diana Wilson (Math 101)
(5, 4, 3, '2024-12-20', 1, 5),  -- Ethan Clark (Math 101)
(6, 5, 2, '2025-01-15', 2, 6),  -- Fiona Taylor (English Literature)
(7, 2, 3, '2025-02-11', 2, 7),  -- George Anderson (English Literature)
(8, 4, 2, '2025-03-03', 2, 8),  -- Hannah Thomas (English Literature)
(9, 5, 1, '2025-04-10', 2, 9),  -- Ian White (English Literature)
(10, 3, 3, '2025-05-05', 2, 10),  -- Jackie Moore (English Literature)
(11, 4, 1, '2024-09-28', 3, 11),  -- Kevin Harris (Physics)
(12, 5, 2, '2024-10-15', 3, 12),  -- Lilly Martin (Physics)
(13, 4, 1, '2024-11-08', 3, 13),  -- Mason Garcia (Physics)
(14, 3, 3, '2025-03-20', 3, 14),  -- Nina Martinez (Physics)
(15, 5, 2, '2025-05-31', 3, 15),  -- Oliver Robinson (Physics)
(16, 4, 2, '2024-09-22', 4, 16),  -- Paula Walker (History)
(17, 5, 2, '2024-10-08', 4, 17),  -- Quinn Young (History)
(18, 4, 3, '2024-11-22', 4, 18),  -- Rachel Allen (History)
(19, 3, 2, '2025-01-25', 4, 19),  -- Sophie King (History)
(20, 5, 1, '2025-02-14', 4, 20),  -- Thomas Lopez (History)
(21, 5, 3, '2024-12-18', 5, 21),  -- Ursula Hill (Biology)
(22, 4, 2, '2025-01-05', 5, 22),  -- Victor Scott (Biology)
(23, 4, 2, '2025-03-19', 5, 23),  -- Wendy Green (Biology)
(24, 5, 2, '2025-05-15', 5, 24),  -- Xander Adams (Biology)
(25, 4, 3, '2025-06-10', 5, 25);  -- Yvonne Baker (Biology)
