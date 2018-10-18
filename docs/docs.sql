create database springBootBbs DEFAULT CHARACTER SET euckr COLLATE euckr_korean_ci;

-- mysql 6 --
grant all privileges on springBootBbs.* to bbsAdmin@localhost identified by 'bbsAdmin123' with grant option;

-- mysql 8 --
CREATE USER 'bbsAdmin'@'localhost' IDENTIFIED BY 'bbsAdmin123';
GRANT ALL ON springBootBbs.* TO 'bbsAdmin'@'localhost';

CREATE TABLE springBootBbs.accounts (
    id int not null auto_increment unique,
    username varchar(50) not null primary key,
    password varchar(50) not null,
    email varchar(50) not null unique,
    createdAt datetime default current_timestamp
);

CREATE TABLE springBootBbs.posts (
    id int not null auto_increment primary key,
    username varchar(50) not null,
    title varchar(100) not null,
    content varchar(1000) not null,
    createdAt datetime default current_timestamp,
    updatedAt datetime default null
);