CREATE TABLE event
(
    id     serial      NOT NULL,
    name   VARCHAR(25) NOT NULL,
    places Integer     NOT NULL,
    price  Integer     NOT NULL,
    date   timestamp   NOT NULL,
    PRIMARY KEY (id)
);