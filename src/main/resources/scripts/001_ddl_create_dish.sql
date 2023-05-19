CREATE TABLE dish
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR NOT NULL UNIQUE,
    description VARCHAR NOT NULL
);
