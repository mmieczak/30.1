INSERT INTO user(username, password, enabled, firstname, surname) VALUES ('admin', '{noop}admin', true, 'Thed', 'GOD');
INSERT INTO user(username, password, enabled, firstname, surname) VALUES ('user', '{noop}user', true, 'Jan', 'Kowalski');

INSERT INTO user_role(username, role ) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO user_role(username, role) VALUES ( 'user', 'ROLE_USER');

INSERT INTO author(username, firstname, surname) VALUES ('user','Jan', 'Kowalski');
INSERT INTO author(username, firstname, surname) VALUES ('admin','Mac', 'Miecz');

INSERT INTO category(name, category_image) VALUES ('Breakfast',FILE_READ('src/main/resources/static/img/rec1.jpg'));
INSERT INTO category(name, category_image) VALUES ('Soups',FILE_READ('src/main/resources/static/img/rec2.jpg'));
INSERT INTO category(name, category_image) VALUES ('Meat',FILE_READ('src/main/resources/static/img/rec3.jpg'));
INSERT INTO category(name, category_image) VALUES ('Vegetarian',FILE_READ('src/main/resources/static/img/rec4.jpg'));
INSERT INTO category(name, category_image) VALUES ('Low Fat',FILE_READ('src/main/resources/static/img/rec5.jpg'));
INSERT INTO category(name, category_image) VALUES ('Gluten Free',FILE_READ('src/main/resources/static/img/rec6.jpg'));
INSERT INTO category(name, category_image) VALUES ('Deserts',FILE_READ('src/main/resources/static/img/rec7.jpg'));
INSERT INTO category(name, category_image) VALUES ('Junk',FILE_READ('src/main/resources/static/img/rec8.jpg'));


INSERT INTO receipt(name, votes, author_id, receipt_image) VALUES ('Poached Eggs', 80, 1, FILE_READ('src/main/resources/static/img/rec6.jpg'));
INSERT INTO receipt(name, votes, author_id, receipt_image) VALUES ('Pizza Margerita', 177, 2, FILE_READ('src/main/resources/static/img/rec9.jpg'));
INSERT INTO receipt(name, votes, author_id, receipt_image) VALUES ('Green Soup', 98, 1, FILE_READ('src/main/resources/static/img/rec3.jpg'));
INSERT INTO receipt(name, votes, author_id, receipt_image) VALUES ('Sandwitches 1', 10, 2, FILE_READ('src/main/resources/static/img/rec4.jpg'));
INSERT INTO receipt(name, votes, author_id, receipt_image) VALUES ('Scrambled Eggs', 80, 1, FILE_READ('src/main/resources/static/img/rec1.jpg'));
INSERT INTO receipt(name, votes, author_id, receipt_image) VALUES ('Pizza Salame', 177, 2, FILE_READ('src/main/resources/static/img/rec2.jpg'));
INSERT INTO receipt(name, votes, author_id, receipt_image) VALUES ('Fish Soup', 98, 1, FILE_READ('src/main/resources/static/img/rec5.jpg'));
INSERT INTO receipt(name, votes, author_id, receipt_image) VALUES ('Sandwitches 2', 10, 2, FILE_READ('src/main/resources/static/img/rec6.jpg'));
INSERT INTO receipt(name, votes, author_id, receipt_image) VALUES ('Hamburger', 95, 2, FILE_READ('src/main/resources/static/img/rec9.jpg'));

INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 1', 120, 'G',1);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 2', 100, 'G',1);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 3', 550, 'G',1);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 1', 50, 'G',2);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 2', 350, 'ML',2);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 3', 220, 'G',2);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 1', 20, 'G',3);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 2', 15, 'G',3);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 3', 15, 'G',3);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 1', 1500, 'ML',4);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 2', 700, 'G',4);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 3', 2000, 'ML',4);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 1', 400, 'ML',5);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 2', 150, 'G',5);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 3', 500, 'ML',5);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 1', 400, 'ML',6);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 2', 150, 'G',6);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 3', 500, 'ML',6);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 1', 400, 'ML',7);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 2', 150, 'G',7);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 3', 500, 'ML',7);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 1', 400, 'ML',8);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 2', 150, 'G',8);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 3', 500, 'ML',8);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 1', 400, 'ML',9);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 2', 150, 'G',9);
INSERT INTO ingredient(name, quantity, unit, receipt_id) VALUES ('Ingredient 3', 500, 'ML',9);



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

INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (1,4);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (1,5);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (2,8);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (3,2);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (3,3);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (3,4);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (4,7);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (4,1);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (5,7);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (6,6);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (7,7);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (8,2);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (8,5);
INSERT INTO receipt_categories(receipts_id,categories_id) VALUES (8,8);
