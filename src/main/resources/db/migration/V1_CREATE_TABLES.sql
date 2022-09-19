CREATE TABLE hibernate_sequence (
    next_val BIGINT
) engine=MyISAM;

INSERT INTO hibernate_sequence VALUES ('1');
INSERT INTO hibernate_sequence VALUES ('1');

CREATE TABLE user (
    id BIGINT NOT NULL, AUTO_INCREMENT,
    userName VARCHAR(64) NOT NULL UNIQUE,
    userPass VARCHAR(64) NOT NULL,
    PRIMARY KEY(id)
) engine=MyISAM;

CREATE TABLE todo (
    id BIGINT NOT NULL, AUTO_INCREMENT,
    title VARCHAR(64) NOT NULL,
    completed BOOLEAN NOT NULL,
    PRIMARY KEY(id)
) engine=MyISAM;