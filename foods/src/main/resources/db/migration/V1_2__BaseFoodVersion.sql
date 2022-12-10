CREATE TABLE foods (
    id bigint not null primary key,
    name varchar(255) not null,
    price bigint not null,
    description varchar(255)
);

CREATE TABLE table_food(
    id bigint not null primary key,
    table_id bigint not null,
    food_id bigint not null,
    CONSTRAINT fk_table_food_table_id FOREIGN KEY (table_id) REFERENCES tables (id)
);

INSERT INTO foods (id, name, price, description) VALUES (1, 'Burger', 10000, 'Burger with beef');
INSERT INTO foods (id, name, price, description) VALUES (2, 'Pizza', 15000, 'Pizza with cheese');
INSERT INTO foods (id, name, price, description) VALUES (3, 'Fried chicken', 20000, 'Fried chicken with sauce');
INSERT INTO foods (id, name, price, description) VALUES (4, 'Fried rice', 25000, 'Fried rice with chicken');
INSERT INTO foods (id, name, price, description) VALUES (5, 'Noodle', 30000, 'Noodle with beef');
INSERT INTO foods (id, name, price, description) VALUES (6, 'Salad', 35000, 'Salad with chicken');
INSERT INTO foods (id, name, price, description) VALUES (7, 'Sushi', 40000, 'Sushi with fish');
INSERT INTO foods (id, name, price, description) VALUES (8, 'Hotdog', 45000, 'Hotdog with beef');
INSERT INTO foods (id, name, price, description) VALUES (9, 'Sandwich', 50000, 'Sandwich with beef');
INSERT INTO foods (id, name, price, description) VALUES (10, 'Coca', 10000, 'Coca with ice');
INSERT INTO foods (id, name, price, description) VALUES (11, 'Pepsi', 10000, 'Pepsi with ice');
INSERT INTO foods (id, name, price, description) VALUES (12, '7up', 10000, '7up with ice');
INSERT INTO foods (id, name, price, description) VALUES (13, 'Sting', 10000, 'Sting with ice');
INSERT INTO foods (id, name, price, description) VALUES (14, 'Beer', 10000, 'Beer with ice');
INSERT INTO foods (id, name, price, description) VALUES (15, 'Tea', 10000, 'Tea with ice');
INSERT INTO foods (id, name, price, description) VALUES (16, 'Coffee', 10000, 'Coffee with ice');
INSERT INTO foods (id, name, price, description) VALUES (17, 'Milk', 10000, 'Milk with ice');
INSERT INTO foods (id, name, price, description) VALUES (18, 'Juice', 10000, 'Juice with ice');
INSERT INTO foods (id, name, price, description) VALUES (19, 'Water', 10000, 'Water with ice');
INSERT INTO foods (id, name, price, description) VALUES (20, 'Ice cream', 10000, 'Ice cream with ice');
INSERT INTO foods (id, name, price, description) VALUES (21, 'Fruit', 10000, 'Fruit with ice');
INSERT INTO foods (id, name, price, description) VALUES (22, 'Cake', 10000, 'Cake with ice');
INSERT INTO foods (id, name, price, description) VALUES (23, 'Bread', 10000, 'Bread with ice');


INSERT INTO table_food (id, table_id, food_id) VALUES (1, 1, 1);
INSERT INTO table_food (id, table_id, food_id) VALUES (2, 1, 2);
INSERT INTO table_food (id, table_id, food_id) VALUES (3, 1, 3);
INSERT INTO table_food (id, table_id, food_id) VALUES (4, 1, 4);
INSERT INTO table_food (id, table_id, food_id) VALUES (5, 1, 5);
INSERT INTO table_food (id, table_id, food_id) VALUES (6, 1, 22);
INSERT INTO table_food (id, table_id, food_id) VALUES (7, 2, 3);
INSERT INTO table_food (id, table_id, food_id) VALUES (8, 2, 4);
INSERT INTO table_food (id, table_id, food_id) VALUES (9, 2, 5);
INSERT INTO table_food (id, table_id, food_id) VALUES (10, 2, 6);

