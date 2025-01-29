insert into lab6_maven.school_class (id, name, grade_level, teacher_name, school_year) values
(1, 'Math 101', 9, 'John Doe', 2024),
(2, 'English Literature', 10, 'Jane Smith', 2024),
(3, 'Physics', 11, 'Alan Turing', 2024),
(4, 'History', 12, 'Emily Johnson', 2024),
(5, 'Biology', 11, 'Charles Darwin', 2024);

alter sequence lab6_maven.school_class_id_seq restart with 6;

insert into lab6_maven.student (id, first_name, last_name, school_class_id) values
(1, 'Alice', 'Brown', 1),
(2, 'Bob', 'Johnson', 1),
(3, 'Charlie', 'Davis', 1),
(4, 'Diana', 'Wilson', 1),
(5, 'Ethan', 'Clark', 1),
(6, 'Fiona', 'Taylor', 2),
(7, 'George', 'Anderson', 2),
(8, 'Hannah', 'Thomas', 2),
(9, 'Ian', 'White', 2),
(10, 'Jackie', 'Moore', 2),
(11, 'Kevin', 'Harris', 3),
(12, 'Lilly', 'Martin', 3),
(13, 'Mason', 'Garcia', 3),
(14, 'Nina', 'Martinez', 3),
(15, 'Oliver', 'Robinson', 3),
(16, 'Paula', 'Walker', 4),
(17, 'Quinn', 'Young', 4),
(18, 'Rachel', 'Allen', 4),
(19, 'Sophie', 'King', 4),
(20, 'Thomas', 'Lopez', 4),
(21, 'Ursula', 'Hill', 5),
(22, 'Victor', 'Scott', 5),
(23, 'Wendy', 'Green', 5),
(24, 'Xander', 'Adams', 5),
(25, 'Yvonne', 'Baker', 5);

alter sequence lab6_maven.student_id_seq restart with 26;

insert into lab6_maven.student_grade (id, grade, weight, date, school_class_id, student_id) values
(1, 4, 1, '2024-09-20', 1, 1),
(2, 4, 3, '2024-10-05', 1, 2),
(3, 5, 1, '2024-11-01', 1, 3),
(4, 4, 2, '2024-12-12', 1, 4),
(5, 4, 3, '2024-12-20', 1, 5),
(6, 5, 2, '2025-01-15', 2, 6),
(7, 2, 3, '2025-02-11', 2, 7),
(8, 4, 2, '2025-03-03', 2, 8),
(9, 5, 1, '2025-04-10', 2, 9),
(10, 3, 3, '2025-05-05', 2, 10),
(11, 4, 1, '2024-09-28', 3, 11),
(12, 5, 2, '2024-10-15', 3, 12),
(13, 4, 1, '2024-11-08', 3, 13),
(14, 3, 3, '2025-03-20', 3, 14),
(15, 5, 2, '2025-05-31', 3, 15),
(16, 4, 2, '2024-09-22', 4, 16),
(17, 5, 2, '2024-10-08', 4, 17),
(18, 4, 3, '2024-11-22', 4, 18),
(19, 3, 2, '2025-01-25', 4, 19),
(20, 5, 1, '2025-02-14', 4, 20),
(21, 5, 3, '2024-12-18', 5, 21),
(22, 4, 2, '2025-01-05', 5, 22),
(23, 4, 2, '2025-03-19', 5, 23),
(24, 5, 2, '2025-05-15', 5, 24),
(25, 4, 3, '2025-06-10', 5, 25);

alter sequence lab6_maven.student_grade_id_seq restart with 26;
