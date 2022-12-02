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
    ID       INTEGER auto_increment primary key,
    TITLE      CHARACTER VARYING(255),
    CONTENT    CHARACTER VARYING(255),
    CREATED_AT TIMESTAMP
);

create table HTTP_LOG
(
    ID       INTEGER auto_increment primary key,
    TRACE_ID      CHARACTER VARYING(255),
    HTTP_TYPE    CHARACTER VARYING(8),
    URI         CHARACTER VARYING(255),
    HEADER         CHARACTER VARYING(2000),
    BODY         CHARACTER VARYING(10000),
    CREATED_AT TIMESTAMP
);
