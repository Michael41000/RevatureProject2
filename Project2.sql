ALTER TABLE store DROP CONSTRAINT fk_store_location;
ALTER TABLE inventory_item DROP CONSTRAINT fk_ii_topping;
ALTER TABLE inventory_item DROP CONSTRAINT fk_ii_location; 
ALTER TABLE pizza DROP CONSTRAINT fk_pizza_psize;
ALTER TABLE pizza_inventory_item DROP CONSTRAINT fk_pii_pizza;
ALTER TABLE pizza_inventory_item DROP CONSTRAINT fk_pii_ii;
ALTER TABLE person DROP CONSTRAINT fk_person_location;
ALTER TABLE person DROP CONSTRAINT fk_person_role; 
ALTER TABLE person_pizza DROP CONSTRAINT fk_pp_person;
ALTER TABLE person_pizza DROP CONSTRAINT fk_pp_pizza;
ALTER TABLE porder DROP CONSTRAINT fk_porder_person;
ALTER TABLE porder DROP CONSTRAINT fk_porder_store;
ALTER TABLE porder_pizza DROP CONSTRAINT fk_op_porder;
ALTER TABLE porder_pizza DROP CONSTRAINT fk_op_pizza;
ALTER TABLE porder DROP CONSTRAINT fk_porder_coupon;



DROP TABLE store;
DROP TABLE location; 
DROP TABLE inventory_item;
DROP TABLE topping;
DROP TABLE pizza;
DROP TABLE psize;
DROP TABLE pizza_inventory_item;
DROP TABLE person;
DROP TABLE role;
DROP TABLE person_pizza;
DROP TABLE porder;
DROP TABLE porder_pizza;
DROP TABLE coupon;


CREATE TABLE store(
    s_id NUMBER (10) PRIMARY KEY,
    location_id NUMBER (10),
    inventory_id NUMBER (10),
    s_pizza_id NUMBER (10)
);

CREATE TABLE location(
    l_id NUMBER (10) PRIMARY KEY,
    latitude NUMBER (10),
    longtitude NUMBER (10),
    name VARCHAR2 (200)    
);

CREATE TABLE inventory_item(
    i_id NUMBER (10) PRIMARY KEY,
    topping_id NUMBER (10), 
    amount_left NUMBER (10),
    price NUMBER (10),
    location_id NUMBER (10)
);

CREATE TABLE topping(
    t_id NUMBER (10) PRIMARY KEY,
    name VARCHAR2 (500),
    calories NUMBER (10)
);


CREATE TABLE pizza(
    p_id NUMBER (10) PRIMARY KEY,
    psize_id NUMBER (10)
);

CREATE TABLE psize(
    ps_id NUMBER (10) PRIMARY KEY,
    psize_name VARCHAR2 (100),
    multipler NUMBER (10)
);

CREATE TABLE pizza_inventory_item(
    pizza_id NUMBER (10),                       -- JOIN TABLE does not have primary key, Many to Many Relationship
    ii_id NUMBER (10)
);

CREATE TABLE person(
    person_id NUMBER (10) PRIMARY KEY,
    first_name VARCHAR2(100),
    last_name VARCHAR2 (100),
    username VARCHAR2 (100),
    password VARCHAR2 (100),
    location_id NUMBER (10),
    role_id NUMBER (10)
);

CREATE TABLE role(
    r_id NUMBER (10) PRIMARY KEY,
    role_name VARCHAR2 (100)
);

CREATE TABLE person_pizza(
    person_id NUMBER (10),
    pizza_id NUMBER (10)
);

CREATE TABLE porder(
    o_id NUMBER (10) PRIMARY KEY,
    person_id NUMBER (10),
    store_id NUMBER (10),
    minutes_to_make NUMBER (10),
    time DATE,
    coupon_id NUMBER (10)
);

CREATE TABLE porder_pizza(
    porder_id NUMBER (10),
    pizza_id NUMBER (10)
);

CREATE TABLE coupon(
    c_id NUMBER (10) PRIMARY KEY,
    discount_percent NUMBER (10),
    code NUMBER (10),
    description VARCHAR2 (500)
);


ALTER TABLE store ADD CONSTRAINT fk_store_location FOREIGN KEY (location_id) REFERENCES location(l_id) ON DELETE CASCADE;
ALTER TABLE inventory_item ADD CONSTRAINT fk_ii_topping FOREIGN KEY (topping_id) REFERENCES topping(t_id) ON DELETE CASCADE;
ALTER TABLE inventory_item ADD CONSTRAINT fk_ii_location FOREIGN KEY (location_id) REFERENCES location(l_id) ON DELETE CASCADE; 
ALTER TABLE pizza ADD CONSTRAINT fk_pizza_psize FOREIGN KEY (psize_id) REFERENCES psize(ps_id) ON DELETE CASCADE;
ALTER TABLE pizza_inventory_item ADD CONSTRAINT fk_pii_pizza FOREIGN KEY (pizza_id) REFERENCES pizza(p_id) ON DELETE CASCADE;
ALTER TABLE pizza_inventory_item ADD CONSTRAINT fk_pii_ii FOREIGN KEY (ii_id) REFERENCES inventory_item(i_id) ON DELETE CASCADE;
ALTER TABLE person ADD CONSTRAINT fk_person_location FOREIGN KEY (location_id) REFERENCES location (l_id) ON DELETE CASCADE;
ALTER TABLE person ADD CONSTRAINT fk_person_role FOREIGN KEY (role_id) REFERENCES role (r_id) ON DELETE CASCADE; 
ALTER TABLE person_pizza ADD CONSTRAINT fk_pp_person FOREIGN KEY (person_id) REFERENCES person(person_id) ON DELETE CASCADE;
ALTER TABLE person_pizza ADD CONSTRAINT fk_pp_pizza FOREIGN KEY (pizza_id) REFERENCES pizza(p_id) ON DELETE CASCADE;
ALTER TABLE porder ADD CONSTRAINT fk_porder_person FOREIGN KEY (person_id) REFERENCES person(person_id) ON DELETE CASCADE;
ALTER TABLE porder ADD CONSTRAINT fk_porder_store FOREIGN KEY (store_id) REFERENCES store(s_id) ON DELETE CASCADE;
ALTER TABLE porder_pizza ADD CONSTRAINT fk_op_porder FOREIGN KEY (porder_id) REFERENCES porder(o_id) ON DELETE CASCADE;
ALTER TABLE porder_pizza ADD CONSTRAINT fk_op_pizza FOREIGN KEY (pizza_id) REFERENCES pizza(p_id) ON DELETE CASCADE;
ALTER TABLE porder ADD CONSTRAINT fk_porder_coupon FOREIGN KEY (coupon_id) REFERENCES coupon(c_id) ON DELETE CASCADE;


DROP SEQUENCE store_id_maker;
/
DROP SEQUENCE location_id_maker;
/
DROP SEQUENCE ii_id_maker;
/
DROP SEQUENCE topping_id_maker;
/
DROP SEQUENCE pizza_id_maker;
/
DROP SEQUENCE psize_id_maker;
/
DROP SEQUENCE person_id_maker;
/
DROP SEQUENCE role_id_maker;
/
DROP SEQUENCE porder_id_maker;
/
DROP SEQUENCE coupon_id_maker;
/

CREATE SEQUENCE store_id_maker
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;
    /

CREATE SEQUENCE location_id_maker
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;
    /
    
CREATE SEQUENCE ii_id_maker
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;
    /

CREATE SEQUENCE topping_id_maker
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;
    /

CREATE SEQUENCE pizza_id_maker
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;
    /

CREATE SEQUENCE psize_id_maker
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;
    /

CREATE SEQUENCE person_id_maker
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;
    /

CREATE SEQUENCE role_id_maker
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;
    /

CREATE SEQUENCE porder_id_maker
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;
    /

CREATE SEQUENCE coupon_id_maker
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;
    /



commit;



