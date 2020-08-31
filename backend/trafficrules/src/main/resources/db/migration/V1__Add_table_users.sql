CREATE TABLE users
(
    uuid             BINARY(16) NOT NULL,
    levels_completed INT        NOT NULL DEFAULT '0',
    name             VARCHAR(255),
    PRIMARY KEY (uuid)
)