DROP TABLE store CASCADE CONSTRAINTS;
DROP TABLE location CASCADE CONSTRAINTS; 
DROP TABLE inventory_item CASCADE CONSTRAINTS;
DROP TABLE topping CASCADE CONSTRAINTS;
DROP TABLE pizza CASCADE CONSTRAINTS;
DROP TABLE psize CASCADE CONSTRAINTS;
DROP TABLE pizza_inventory_item CASCADE CONSTRAINTS;
DROP TABLE person CASCADE CONSTRAINTS;
DROP TABLE role CASCADE CONSTRAINTS;
DROP TABLE person_pizza CASCADE CONSTRAINTS;
DROP TABLE porder CASCADE CONSTRAINTS;
DROP TABLE porder_pizza CASCADE CONSTRAINTS;
DROP TABLE coupon CASCADE CONSTRAINTS;
DROP TABLE topping_type CASCADE CONSTRAINTS;


CREATE TABLE store(
    s_id NUMBER (10) PRIMARY KEY,
    location_id NUMBER (10) UNIQUE
);

CREATE TABLE location(
    l_id NUMBER (10) PRIMARY KEY,
    latitude NUMBER (10, 6),
    longitude NUMBER (10, 6),
    name VARCHAR2 (200)    
);

CREATE TABLE inventory_item(
    i_id NUMBER (10) PRIMARY KEY,
    topping_id NUMBER (10), 
    amount_left NUMBER (10),
    price NUMBER (10, 2),
    location_id NUMBER (10),
    store_id NUMBER(10)
);

CREATE TABLE topping(
    t_id NUMBER (10) PRIMARY KEY,
    name VARCHAR2 (500),
    calories NUMBER (10),
    type_id NUMBER(10)
);

CREATE TABLE topping_type(
    tt_id NUMBER(10) PRIMARY KEY,
    type VARCHAR2(100)
);

CREATE TABLE pizza(
    p_id NUMBER (10) PRIMARY KEY,
    psize_id NUMBER (10),
    is_specialty VARCHAR2(1)
);

CREATE TABLE psize(
    ps_id NUMBER (10) PRIMARY KEY,
    psize_name VARCHAR2 (100),
    multipler NUMBER (10, 2)
);

CREATE TABLE pizza_inventory_item(
    pizza_id NUMBER (10),                       -- JOIN TABLE does not have primary key, Many to Many Relationship
    ii_id NUMBER (10),
    amount NUMBER(10)
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
    discount_percent NUMBER (10, 2),
    code NUMBER (10),
    description VARCHAR2 (500)
);

ALTER TABLE store ADD CONSTRAINT fk_store_location FOREIGN KEY (location_id) REFERENCES location(l_id) ON DELETE CASCADE;
ALTER TABLE inventory_item ADD CONSTRAINT fk_ii_topping FOREIGN KEY (topping_id) REFERENCES topping(t_id) ON DELETE CASCADE;
ALTER TABLE inventory_item ADD CONSTRAINT fk_ii_location FOREIGN KEY (location_id) REFERENCES location(l_id) ON DELETE CASCADE; 
ALTER TABLE inventory_item ADD CONSTRAINT fk_ii_store FOREIGN KEY (store_id) REFERENCES store(s_id) ON DELETE CASCADE; 
ALTER TABLE pizza ADD CONSTRAINT fk_pizza_psize FOREIGN KEY (psize_id) REFERENCES psize(ps_id) ON DELETE CASCADE;
ALTER TABLE pizza_inventory_item ADD CONSTRAINT fk_pii_pizza FOREIGN KEY (pizza_id) REFERENCES pizza(p_id) ON DELETE CASCADE;
ALTER TABLE pizza_inventory_item ADD CONSTRAINT fk_pii_ii FOREIGN KEY (ii_id) REFERENCES inventory_item(i_id) ON DELETE CASCADE;
ALTER TABLE pizza_inventory_item ADD CONSTRAINT fk_pii_psize FOREIGN KEY (amount) REFERENCES psize(ps_id) ON DELETE CASCADE;
ALTER TABLE person ADD CONSTRAINT fk_person_location FOREIGN KEY (location_id) REFERENCES location (l_id) ON DELETE CASCADE;
ALTER TABLE person ADD CONSTRAINT fk_person_role FOREIGN KEY (role_id) REFERENCES role (r_id) ON DELETE CASCADE; 
ALTER TABLE person_pizza ADD CONSTRAINT fk_pp_person FOREIGN KEY (person_id) REFERENCES person(person_id) ON DELETE CASCADE;
ALTER TABLE person_pizza ADD CONSTRAINT fk_pp_pizza FOREIGN KEY (pizza_id) REFERENCES pizza(p_id) ON DELETE CASCADE;
ALTER TABLE porder ADD CONSTRAINT fk_porder_person FOREIGN KEY (person_id) REFERENCES person(person_id) ON DELETE CASCADE;
ALTER TABLE porder ADD CONSTRAINT fk_porder_store FOREIGN KEY (store_id) REFERENCES store(s_id) ON DELETE CASCADE;
ALTER TABLE porder_pizza ADD CONSTRAINT fk_op_porder FOREIGN KEY (porder_id) REFERENCES porder(o_id) ON DELETE CASCADE;
ALTER TABLE porder_pizza ADD CONSTRAINT fk_op_pizza FOREIGN KEY (pizza_id) REFERENCES pizza(p_id) ON DELETE CASCADE;
ALTER TABLE porder ADD CONSTRAINT fk_porder_coupon FOREIGN KEY (coupon_id) REFERENCES coupon(c_id) ON DELETE CASCADE;
ALTER TABLE topping ADD CONSTRAINT fk_topping_tt FOREIGN KEY (type_id) REFERENCES topping_type ON DELETE CASCADE;


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
DROP SEQUENCE tt_id_maker;
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
    
CREATE SEQUENCE tt_id_maker
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;
    /

INSERT INTO role VALUES(role_id_maker.nextval, 'Customer');
INSERT INTO role VALUES(role_id_maker.nextval, 'Employee');

INSERT INTO location VALUES(location_id_maker.nextval, 39.656755, -79.9283087, 'West Run Apartments');
INSERT INTO location VALUES(location_id_maker.nextval, 39.6318875, -79.9559044, 'Pizza Store #1');
INSERT INTO location VALUES(location_id_maker.nextval, 39.6266512, -79.9600794, 'Pizza Store #2');
INSERT INTO location VALUES(location_id_maker.nextval, 39.650808, -79.943543, 'Kroger');
INSERT INTO location VALUES(location_id_maker.nextval, 39.6608103, -79.9309657, 'Animal Farm');
INSERT INTO location VALUES(location_id_maker.nextval, 39.6465469, -79.9385532, 'Organic Farm');

INSERT INTO psize VALUES(psize_id_maker.nextval, 'Small', 1);
INSERT INTO psize VALUES(psize_id_maker.nextval, 'Medium', 2);
INSERT INTO psize VALUES(psize_id_maker.nextval, 'Large', 3);

INSERT INTO store VALUES(store_id_maker.nextval, 2);
INSERT INTO store VALUES(store_id_maker.nextval, 3);

INSERT INTO person VALUES(person_id_maker.nextval, 'Head', 'Employee', 'he', 'pass', 1, 2);

INSERT INTO topping_type VALUES(tt_id_maker.nextval, 'Sauce');
INSERT INTO topping_type VALUES(tt_id_maker.nextval, 'Cheese');
INSERT INTO topping_type VALUES(tt_id_maker.nextval, 'Meat');
INSERT INTO topping_type VALUES(tt_id_maker.nextval, 'Vegetable');
INSERT INTO topping_type VALUES(tt_id_maker.nextval, 'Herb');

INSERT INTO topping VALUES(topping_id_maker.nextval, 'Alfredo sauce', 535, 1);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Tomato sauce', 70, 1);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Basil sauce', 86, 1);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Barbecue sauce', 172, 1);

INSERT INTO topping VALUES(topping_id_maker.nextval, 'Mozzarella', 78, 2);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Buffalo mozzarella', 85, 2);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Parmesan', 122, 2);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Parmigiano-Reggiano', 122, 2);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Provolone', 98, 2);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Cheddar', 113, 2);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Feta', 75, 2);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Asiago', 111, 2);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Goat cheese', 103, 2);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Ricotta', 44, 2);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Gorgonzola', 100, 2);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Emmental cheese', 97, 2);

INSERT INTO topping VALUES(topping_id_maker.nextval, 'Pepperoni', 138, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Chicken', 60, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Sausage', 77, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Bacon', 43, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Beef', 213, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Canadian Bacon', 89, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Duck', 337, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Meatballs', 197, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Salami', 41, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Buffalo Chicken Strips', 262, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Anchovy', 95, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Prosciutto', 203, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Lamb', 250, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Shrimp', 99, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Tuna', 45, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Shellfish', 99, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Egg', 78, 3);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Chorizo', 129, 3);

INSERT INTO topping VALUES(topping_id_maker.nextval, 'Spinach', 23, 4);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Olive', 115, 4);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Artichoke', 60, 4);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Tomato', 18, 4);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Broccoli', 50, 4);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Green Pepper', 30, 4);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Jalapeno', 26, 4);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Eggplant', 20, 4);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Onion', 44, 4);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Pineapple', 42, 4);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Red Onion', 40, 4);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Sun Dried Tomato', 30, 4);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Sweetcorn', 77, 4);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Zucchini', 33, 4);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Sauerkraut', 27, 4);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Bell Pepper', 30, 4);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Sweet Potato', 114, 4);

INSERT INTO topping VALUES(topping_id_maker.nextval, 'Garlic', 1, 5);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Basil', 1, 5);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Sesame Seeds', 52, 5);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Oregano', 3, 5);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Chives', 1, 5);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Arugula', 10, 5);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Thyme', 1, 5);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Rosemary', 1, 5);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Parsely', 1, 5);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Coriander', 23, 5);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Paprika', 19, 5);
INSERT INTO topping VALUES(topping_id_maker.nextval, 'Black Pepper', 17, 5);

insert into coupon values (coupon_id_maker.nextval, 10, 55, '???');
INSERT INTO person values(person_id_maker.nextval, 'kush', 'patel', 'kush9001', 'password', 1, 1);  -- test


insert into porder values (porder_id_maker.nextval, 1, 1, 15, null, 1);
insert into porder values (porder_id_maker.nextval, 2, 1, 15, null, 1);
--select * from person;
--select * from porder;
commit;
--select * from porder;
--insert into role values(role_id_maker.nextval, 'Customer');

--insert into location values(location_id_maker.nextval, 50, 50, 'somewhere');
--
--INSERT INTO person values(person_id_maker.nextval, 'kush', 'patel', 'kush9001', 'password', 1, 1);  -- test

INSERT INTO pizza VALUES(pizza_id_maker.nextval, 2, 'T');

--select * from role;
--select * from location;
--select * from person;
select * from pizza;

CREATE OR REPLACE PROCEDURE add_inventory_to_store(store_id IN NUMBER) 
IS
BEGIN

    FOR record IN (SELECT t_id, tt_id FROM topping t JOIN topping_type tt ON t.type_id = tt.tt_id)
    LOOP
        IF record.tt_id = 1 THEN -- First topping type is Sauce
            -- Create Sauce ingredient item. Give it the topping, 100 amountLeft, 2.50 price, Kroger location, and store
            INSERT INTO inventory_item VALUES (ii_id_maker.nextval, record.t_id, 100, 2.50, 4, store_id);
        ELSIF record.tt_id = 2 THEN -- Second topping type is Cheese
            -- Create Cheese ingredient item. Give it the topping, 100 amountLeft, 2.50 price, Animal Farm location, and store
            INSERT INTO inventory_item VALUES (ii_id_maker.nextval, record.t_id, 100, 2.50, 5, store_id);
        ELSIF record.tt_id = 3 THEN -- Third topping type is Meat
            -- Create Meat ingredient item. Give it the topping, 100 amountLeft, 2.50 price, Animal Farm location, and store
            INSERT INTO inventory_item VALUES (ii_id_maker.nextval, record.t_id, 100, 2.50, 5, store_id);
        ELSIF record.tt_id = 4 THEN -- Fourth topping type is Vegetable
            -- Create Vegetable ingredient item. Give it the topping, 100 amountLeft, 2.50 price, Organic Farm location, and store
            INSERT INTO inventory_item VALUES (ii_id_maker.nextval, record.t_id, 100, 2.50, 6, store_id);
        ELSIF record.tt_id = 5 THEN -- Fifth topping type is Herb
            -- Create Herb ingredient item. Give it the topping, 100 amountLeft, 2.50 price, Organic Farm location, and store
            INSERT INTO inventory_item VALUES (ii_id_maker.nextval, record.t_id, 100, 2.50, 6, store_id);
        END IF;
    END LOOP;

END;
/

-- Fill inventory of Store 1
CALL add_inventory_to_store(1);
-- Fill inventory of Store 2
CALL add_inventory_to_store(2);

commit;

-- Prints out inventory items
--SELECT ii.i_id, 
--t.name AS topping_name, t.calories, tt.type, 
--ii.amount_left, ii.price, 
--l.name AS supplier_name, l.latitude, l.longitude, 
--l2.name AS store_name, l2.latitude, l2.longitude
--FROM inventory_item ii JOIN topping t ON ii.topping_id = t.t_id 
--JOIN topping_type tt ON t.type_id = tt.tt_id 
--JOIN location l ON ii.location_id = l.l_id
--JOIN store s ON ii.store_id = s.s_id
--JOIN location l2 ON s.location_id = l2.l_id
--ORDEr BY ii.i_id;

SELECT * FROM person;

