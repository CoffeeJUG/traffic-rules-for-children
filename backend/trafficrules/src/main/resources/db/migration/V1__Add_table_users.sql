create table users
(
    uuid             BINARY(16) not null,
    levels_completed INT        NOT NULL DEFAULT '0',
    name             varchar(255),
    primary key (uuid)
)