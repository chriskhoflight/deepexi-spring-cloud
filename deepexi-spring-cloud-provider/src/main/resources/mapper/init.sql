-- 权限表 --
CREATE TABLE permission (
    id int(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL DEFAULT '',
    url VARCHAR(255) DEFAULT '',
    PRIMARY KEY (id)
)   ENGINE = InnoDB default CHARSET = utf8;