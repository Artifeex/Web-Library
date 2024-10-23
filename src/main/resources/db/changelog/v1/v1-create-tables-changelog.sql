--liquibase formatted sql

--changeset sandr:1.0
CREATE TABLE IF NOT EXISTS genre
(
    id   INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS book
(
    id          INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title        VARCHAR(128)              NOT NULL,
    year        INT CHECK ( year >= 100 AND year <= EXTRACT(YEAR FROM CURRENT_DATE) ),
    description TEXT
);

CREATE TABLE IF NOT EXISTS book_genre
(
    book_id  INT REFERENCES book (id),
    genre_id INT REFERENCES genre (id),
    PRIMARY KEY (book_id, genre_id)
);

CREATE TABLE IF NOT EXISTS author
(
    id   INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS book_author
(
    book_id   INT REFERENCES book (id),
    author_id INT REFERENCES author (id),
    PRIMARY KEY (book_id, author_id)
);

CREATE TABLE IF NOT EXISTS users
(
    id       INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name     VARCHAR(128) NOT NULL,
    email    VARCHAR(128) NOT NULL UNIQUE,
    password VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS library
(
    id          INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name        VARCHAR(128) NOT NULL,
    country     VARCHAR(128) NOT NULL,
    city        VARCHAR(128) NOT NULL,
    street      VARCHAR(128) NOT NULL,
    postal_code VARCHAR(20)  NOT NULL
);

CREATE TABLE IF NOT EXISTS library_book
(
    id         INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    book_id    INT REFERENCES book (id)                  NOT NULL,
    library_id INT REFERENCES library (id)               NOT NULL,
    count      INT CHECK ( count >= 0 AND count < 1000 ) NOT NULL,
    UNIQUE (book_id, library_id)
);

CREATE TABLE IF NOT EXISTS borrowed_book
(
    id          INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    user_id     INT REFERENCES users (id)        NOT NULL,
    lib_book_id INT REFERENCES library_book (id) NOT NULL,
    borrow_date TIMESTAMP                        NOT NULL,
    return_date TIMESTAMP                        NOT NULL,
    count       INT CHECK ( count > 0 )          NOT NULL,
    UNIQUE (user_id, lib_book_id)
);
