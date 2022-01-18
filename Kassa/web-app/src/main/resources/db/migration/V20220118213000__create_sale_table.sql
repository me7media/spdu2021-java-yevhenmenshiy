CREATE TABLE sale
(
    id                  serial      NOT NULL,
    event_id            VARCHAR(255) DEFAULT NULL,
    places              Integer     NOT NULL,
    total_price         Integer     NOT NULL,
    sale_date           timestamp   NOT NULL,
    customer_first_name VARCHAR(25) NOT NULL,
    customer_last_name  VARCHAR(25) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT sales_event_id_fkey FOREIGN KEY (event_id) REFERENCES event (id)
);