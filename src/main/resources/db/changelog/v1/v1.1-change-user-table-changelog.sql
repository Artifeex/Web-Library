--liquibase formatted sql

--changeset sandr:1.1
ALTER TABLE users RENAME COLUMN name TO username;