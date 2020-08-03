INSERT INTO user(username, password, enabled) VALUES ('admin', '{noop}admin', true);
INSERT INTO user(username, password, enabled) VALUES ('user', '{noop}user', true);

INSERT INTO user_role(username, role) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO user_role(username, role) VALUES ('user', 'ROLE_USER');

INSERT INTO author(name, surname) VALUES ('Magda','Gessler');
INSERT INTO author(name, surname) VALUES ('Andrzej','Sapkowski');
INSERT INTO author(name, surname) VALUES ('Kuchcik','Beztalencie');
INSERT INTO author(name, surname) VALUES ('Joe','Doe');
INSERT INTO author(name, surname) VALUES ('El','Testosteron');

INSERT INTO category(name) VALUES ('Breakfast');
INSERT INTO category(name) VALUES ('Soups');
INSERT INTO category(name) VALUES ('Meat');
INSERT INTO category(name) VALUES ('Vegetarian');
INSERT INTO category(name) VALUES ('Low FAT');
INSERT INTO category(name) VALUES ('Gluten Free');
INSERT INTO category(name) VALUES ('Desserts');
INSERT INTO category(name) VALUES ('Pasta');
INSERT INTO category(name) VALUES ('Italian');

/*INSERT INTO receipt(name, votes, author_id) VALUES ('Scrambled Eggs', 80, 1);
INSERT INTO receipt(name, votes, author_id) VALUES ('Pizza', 2, 1);
INSERT INTO receipt(name, votes, author_id) VALUES ('Tomato Soup', 0, 3);
INSERT INTO receipt(name, votes, author_id) VALUES ('Pancakes', 10, 4);*/

/*INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 1', 120, 'g',1);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 2', 100, 'g',1);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 3', 550, 'g',1);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 4', 50, 'g',2);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 5', 350, 'ml',2);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 6', 220, 'g',3);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 7', 20, 'g',3);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 8', 15, 'g',3);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 9', 1500, 'ml',3);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 10', 700, 'g',4);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 11', 2000, 'ml',4);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 12', 400, 'ml',4);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 13', 150, 'g',4);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 14', 500, 'ml',4);*/



/*INSERT INTO receipt_ingredients(receipt_id,ingredients_id) VALUES (1,1);
INSERT INTO receipt_ingredients(receipt_id,ingredients_id) VALUES (1,3);
INSERT INTO receipt_ingredients(receipt_id,ingredients_id) VALUES (1,5);
INSERT INTO receipt_ingredients(receipt_id,ingredients_id) VALUES (1,7);
INSERT INTO receipt_ingredients(receipt_id,ingredients_id) VALUES (2,2);
INSERT INTO receipt_ingredients(receipt_id,ingredients_id) VALUES (2,4);
INSERT INTO receipt_ingredients(receipt_id,ingredients_id) VALUES (2,6);
INSERT INTO receipt_ingredients(receipt_id,ingredients_id) VALUES (2,8);
INSERT INTO receipt_ingredients(receipt_id,ingredients_id) VALUES (2,10);
INSERT INTO receipt_ingredients(receipt_id,ingredients_id) VALUES (3,11);
INSERT INTO receipt_ingredients(receipt_id,ingredients_id) VALUES (3,12);
INSERT INTO receipt_ingredients(receipt_id,ingredients_id) VALUES (3,13);
INSERT INTO receipt_ingredients(receipt_id,ingredients_id) VALUES (4,14);*/

/*INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (1,4);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (1,5);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (2,9);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (3,2);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (3,3);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (3,4);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (4,7);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (4,1);*/