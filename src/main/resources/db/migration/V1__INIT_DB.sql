create sequence hibernate_sequence start 1 increment 1;

create table admins
(
    id       bigserial not null,
    login    varchar(255) not null,
    password varchar(255) not null,
    primary key (id)
);

create table internships
(
    id               bigserial not null,
    name             varchar(255) not null,
    start_date       date not null,
    end_date         date,
    registration_end date not null,
    status           boolean not null,
    primary key (id)
);

create table internships_lessons
(
    internship_id bigint not null,
    lesson_id     bigint not null,
    primary key (internship_id, lesson_id)
);

create table internships_users
(
    internship_id bigint not null,
    user_id       bigint not null,
    primary key (internship_id, user_id)
);

create table lessons
(
    id         bigserial not null,
    name       varchar(255) not null,
    visibility boolean not null,
    primary key (id)
);

create table lessons_tasks
(
    lesson_id bigint not null,
    task_id   bigint not null,
    primary key (lesson_id, task_id)
);

create table tasks
(
    id          bigserial not null,
    name        varchar(255) not null,
    description varchar(255) not null,
    url         varchar(255),
    visibility  boolean not null,
    primary key (id)
);

create table user_progress
(
    id      bigserial not null,
    task_id bigint    not null,
    user_id bigint    not null,
    status  boolean,
    comment varchar(255),
    primary key (id)
);

create table users
(
    id             bigserial not null,
    username       varchar(255) not null,
    password       varchar(255) not null,
    fullname       varchar(255) not null,
    telegram_id    varchar(255) not null,
    birthdate      date not null,
    e_mail         varchar(255) not null,
    city           varchar(255) not null,
    place_of_study varchar(255),
    faculty        varchar(255),
    specialty      varchar(255),
    course         varchar(255),
    study_status   varchar(255) not null,
    info           varchar(255),
    primary key (id)
);


alter table if exists internships_lessons
    add constraint internships_lessons_lesson_fk
    foreign key (lesson_id) references lessons;

alter table if exists internships_lessons
    add constraint internships_lessons_internship_fk
    foreign key (internship_id) references internships;

alter table if exists internships_users
    add constraint internships_users_user_fk
    foreign key (user_id) references users;

alter table if exists internships_users
    add constraint internships_users_internship_fk
    foreign key (internship_id) references internships;

alter table if exists lessons_tasks
    add constraint lessons_tasks_task_fk
    foreign key (task_id) references tasks;

alter table if exists lessons_tasks
    add constraint lessons_tasks_lesson_fk
    foreign key (lesson_id) references lessons;

alter table if exists user_progress
    add constraint user_progress_task_fk
    foreign key (task_id) references tasks;

alter table if exists user_progress
    add constraint user_progress_user_fk
    foreign key (user_id) references users;