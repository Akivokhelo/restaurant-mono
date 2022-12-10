CREATE TABLE tables(
    id bigint not null auto_increment primary key,
    name varchar(255) not null,
    picture varchar(1000),
    winter_ready boolean not null,
    chairs int not null
);

CREATE TABLE reservation(
    id bigint not null auto_increment primary key,
    name varchar(255) not null,
    from_date timestamp not null,
    ends_date timestamp not null,
    table_id bigint not null,
    number_of_people int,
    CONSTRAINT fk_table FOREIGN KEY (table_id) REFERENCES tables(id)
);


INSERT INTO tables (id, name, picture, winter_ready, chairs) VALUES (1,"A1", "url..a1.png", true, 2);
INSERT INTO tables (id, name, picture, winter_ready, chairs) VALUES (2,"A2", "url..a2.png", true, 2);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (3,"A3", "url..a3.png", true, 2);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (4,"A4", "url..a4.png", true, 2);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (5,"A5", "url..a5.png", true, 2);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (6,"B1", "url..b1.png", false, 2);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (7,"B2", "url..b2.png", false, 4);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (8,"B3", "url..b3.png", false, 6);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (9,"C1", "url..c1.png", true, 4);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (10,"C2", "url..c2.png", true, 4);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (11,"C3", "url..c3.png", true, 4);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (12,"C4", "url..c4.png", true, 4);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (13,"C5", "url..c5.png", true, 4);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (14,"C6", "url..c6.png", true, 4);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (15,"D1", "url..d1.png", true, 3);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (16,"D2", "url..d2.png", true, 4);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (17,"D3", "url..d3.png", true, 12);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (18,"D4", "url..d4.png", true, 5);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (19,"D5", "url..d5.png", true, 2);
INSERT INTO tables (id,name, picture, winter_ready, chairs) VALUES (20,"D6", "url..d6.png", true, 1);


INSERT INTO reservation (name, from_date, ends_date, table_id, number_of_people) VALUES ("Peter Griffin", CURRENT_TIMESTAMP, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 1 HOUR), 1, 3);
INSERT INTO reservation (name, from_date, ends_date, table_id, number_of_people) VALUES ("Bruce Wayne", CURRENT_TIMESTAMP, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 1 HOUR), 2, 3);
INSERT INTO reservation (name, from_date, ends_date, table_id, number_of_people) VALUES ("Nick Fury", CURRENT_TIMESTAMP, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 1 HOUR), 3, 1);
