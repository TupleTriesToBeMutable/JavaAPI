--Админ1
insert into admins
values (1, 'admin1', 'password');

--Админ2
insert into admins
values (2, 'admin2', 'password');

---------------------------------------------------------------

insert into users
values (1, 'user1', 'password', 'Иван Иванов Иванович', '@some',
        DATE '2000-10-05', 'some@gmail.com', 'Воронеж', 'VSU', 'PMM',
        '20.02.03', '3', 'учусь', 'Что-то интересно и важное');

insert into users
values (2, 'user2', 'password', 'Александр Александрович', '@some',
        DATE '2004-10-05', 'duck@gmail.com', 'Москва', 'VSU', 'PMM',
        '20.04.03', '4', 'учусь', 'Что-то интересно');

---------------------------------------------------------------

insert into internships
values (1, 'Java', DATE '2024-10-1', DATE '2024-12-15', DATE '2024-09-30',true);

insert into internships
values (2, 'C++', DATE '2024-10-1', DATE '2024-12-15', DATE '2024-09-30',true);

---------------------------------------------------------------

insert into lessons
values (1, 'Вводный C++', true);

insert into lessons
values (2, 'Жесткий C++', false);

insert into lessons
values (3, 'Вводный Java', true);

insert into lessons
values (4, '2 Java', true);

insert into lessons
values (5, '3 Java', true);

---------------------------------------------------------------
insert into tasks
values (1, 'Hello word Java', 'Написать надо вот', 'url', true);

insert into tasks
values (2, 'Hello word C++', 'Написать надо вот', 'url', true);

insert into tasks
values (3, 'Память программы', 'Написать надо вот', 'url', true);

insert into tasks
values (4, 'Асинхронное программирование', 'Написать надо вот', 'url', false);

---------------------------------------------------------------

insert into internships_users
values (1, 1);

insert into internships_users
values (1, 2);

insert into internships_users
values (2, 1);

---------------------------------------------------------------

insert into internships_lessons
values (1, 3);

insert into internships_lessons
values (1, 4);

insert into internships_lessons
values (1, 5);

insert into internships_lessons
values (2, 1);

insert into internships_lessons
values (2, 2);

---------------------------------------------------------------
insert into lessons_tasks
values (3, 1);

insert into lessons_tasks
values (1, 2);

insert into lessons_tasks
values (2, 3);

insert into lessons_tasks
values (4, 3);

insert into lessons_tasks
values (2, 4);

insert into lessons_tasks
values (3, 4);

------------------------------------------------------------------------

insert into user_progress
values (1, 1, 1, true, 'Четко');

insert into user_progress
values (2, 2, 1, true, 'Четко');

insert into user_progress
values (3, 3, 2, true, 'Четко');

insert into user_progress
values (4, 3, 1, false, 'Переделать');

insert into user_progress
values (5, 1, 2, true, 'Четко');