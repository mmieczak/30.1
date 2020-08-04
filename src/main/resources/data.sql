INSERT INTO user(username, password, enabled, firstname, surname) VALUES ('admin', '{noop}admin', true, 'Thed', 'GOD');
INSERT INTO user(username, password, enabled, firstname, surname) VALUES ('user', '{noop}user', true, 'Jan', 'Kowalski');

INSERT INTO user_role(username, role ) VALUES ('admin', 'ADMIN');
INSERT INTO user_role(username, role) VALUES ( 'user', 'USER' );

INSERT INTO author(username, firstname, surname) VALUES ('user','Jan', 'Kowalski');
INSERT INTO author(username, firstname, surname) VALUES ('admin','Mac', 'Miecz');

INSERT INTO category(name, category_image) VALUES ('Breakfast',FILE_READ('src/main/resources/static/img/sr1.jpg'));
INSERT INTO category(name, category_image) VALUES ('Soups',FILE_READ('src/main/resources/static/img/sr2.jpg'));
INSERT INTO category(name, category_image) VALUES ('Meat',FILE_READ('src/main/resources/static/img/sr3.jpg'));
INSERT INTO category(name, category_image) VALUES ('Vegetarian',FILE_READ('src/main/resources/static/img/sr4.jpg'));
INSERT INTO category(name, category_image) VALUES ('Low Fat',FILE_READ('src/main/resources/static/img/sr5.jpg'));
INSERT INTO category(name, category_image) VALUES ('Gluten Free',FILE_READ('src/main/resources/static/img/sr6.jpg'));
INSERT INTO category(name, category_image) VALUES ('Deserts',FILE_READ('src/main/resources/static/img/sr7.jpg'));
INSERT INTO category(name, category_image) VALUES ('Junk',FILE_READ('src/main/resources/static/img/sr8.jpg'));


INSERT INTO receipt(name, votes, author_id, receipt_image) VALUES ('Scrambled Eggs', 80, 1, FILE_READ('src/main/resources/static/img/rec6.jpg'));
INSERT INTO receipt(name, votes, author_id, receipt_image) VALUES ('Pizza', 177, 2, FILE_READ('src/main/resources/static/img/rec9.jpg'));
INSERT INTO receipt(name, votes, author_id, receipt_image) VALUES ('Green Soup', 98, 1, FILE_READ('src/main/resources/static/img/rec3.jpg'));
INSERT INTO receipt(name, votes, author_id, receipt_image) VALUES ('Sandwitches', 10, 2, FILE_READ('src/main/resources/static/img/rec4.jpg'));

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