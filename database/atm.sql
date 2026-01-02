CREATE DATABASE atm_db;
USE atm_db;

CREATE TABLE users (
    card_number VARCHAR(20) PRIMARY KEY,
    pin INT,
    balance DOUBLE
);

INSERT INTO users VALUES ('123456', 1234, 5000);
