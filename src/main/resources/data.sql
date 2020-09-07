insert into rankings (rankings_id, student_id, rank, date) values (345, 'ST001', '10th Kyu White Belt', sysdate());
insert into rankings (rankings_id, student_id, rank, date) values (545, 'ST002', '09th Kyu Orange Belt', sysdate());
insert into rankings (rankings_id, student_id, rank, date) values (546, 'ST002', '09th Kyu Orange Belt', sysdate());
insert into rankings (rankings_id, student_id, rank, date) values (547, 'ST002', '09th Kyu Orange Belt', sysdate());
insert into rankings (rankings_id, student_id, rank, date) values (234, 'ST003', '08th Kyu Yellow Belt', sysdate());

insert into grading_examinations (exam_code, description, date) values ('BB021', 'Black Brown Grading Examination 2020', sysdate());
insert into grading_examinations (exam_code, description, date) values ('BB003', 'White Grading Examination 2020', sysdate());
insert into grading_examinations (exam_code, description, date) values ('BB004', 'Orange Grading Examination 2020', sysdate());
insert into grading_examinations (exam_code, description, date) values ('BB005', 'Black Brown Grading Examination 2020', sysdate());
insert into grading_examinations (exam_code, description, date) values ('BB006', 'White Grading Examination 2020', sysdate());
insert into grading_examinations (exam_code, description, date) values ('BB007', 'Orange Grading Examination 2020', sysdate());
insert into grading_examinations (exam_code, description, date) values ('BB008', 'Black Brown Grading Examination 2020', sysdate());
insert into grading_examinations (exam_code, description, date) values ('BB009', 'White Grading Examination 2020', sysdate());
insert into grading_examinations (exam_code, description, date) values ('BB010', 'Orange Grading Examination 2020', sysdate());
insert into grading_examinations (exam_code, description, date) values ('BB011', 'Black Brown Grading Examination 2020', sysdate());
insert into grading_examinations (exam_code, description, date) values ('BB012', 'White Grading Examination 2020', sysdate());
insert into grading_examinations (exam_code, description, date) values ('BB013', 'Orange Grading Examination 2020', sysdate());insert into grading_examinations (exam_code, description, date) values ('BB002', 'Black Brown Grading Examination 2020', sysdate());
insert into grading_examinations (exam_code, description, date) values ('BB014', 'White Grading Examination 2020', sysdate());
insert into grading_examinations (exam_code, description, date) values ('BB015', 'Orange Grading Examination 2020', sysdate());

insert into results (results_id, student_id, exam_code, date, kihon, combinations, kata, kumite, general_knowledge, theory) values (123, 'ST001', 'BB002', sysdate(), 18, 19, 18,18, 48, 49);
insert into results (results_id, student_id, exam_code, date, kihon, combinations, kata, kumite, general_knowledge, theory) values (321, 'ST001', 'BB003', sysdate(), 18, 19, 18,18, 48, 49);
insert into results (results_id, student_id, exam_code, date, kihon, combinations, kata, kumite, general_knowledge, theory) values (456, 'ST002', 'BB002', sysdate(), 18, 19, 18,18, 48, 49);

insert into login (user_id, password, role) values ('ST001', 'student1', 'Student');
insert into login (user_id, password, role) values ('ST002', 'student2', 'Student');
insert into login (user_id, password, role) values ('ST003', 'student3', 'Student');
insert into login (user_id, password, role) values ('IN001', 'in1', 'Instructor');
insert into login (user_id, password, role) values ('IN002', 'in2', 'Instructor');
insert into login (user_id, password, role) values ('IN003', 'in3', 'Instructor');
insert into login (user_id, password, role) values ('OP001', 'op1', 'Operator');
insert into login (user_id, password, role) values ('OP002', 'op2', 'Operator');
insert into login (user_id, password, role) values ('OP003', 'op3', 'Operator');



