create table MEMBER
(
    ID       INTEGER auto_increment
        primary key,
    USERNAME CHARACTER VARYING(255),
    NICKNAME CHARACTER VARYING(255),
    PASSWORD CHARACTER VARYING(255)
);

create table BOARD
(
    ID       INTEGER auto_increment
        primary key,
    TITLE      CHARACTER VARYING(255),
    CONTENT    CHARACTER VARYING(255),
    CREATED_AT TIMESTAMP
);