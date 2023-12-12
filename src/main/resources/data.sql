INSERT INTO role (name) VALUES ('Guest');
INSERT INTO role (name) VALUES ('User');
INSERT INTO role (name) VALUES ('Manager');
INSERT INTO role (name) VALUES ('Admin');


INSERT INTO order_status (status) VALUES ('PROCESSING');
INSERT INTO order_status (status) VALUES ('SHIPPED');
INSERT INTO order_status (status) VALUES ('DELIVERED');
INSERT INTO order_status (status) VALUES ('CANCELLED');


INSERT INTO payment_method (method) VALUES ('CREDIT_CARD');
INSERT INTO payment_method (method) VALUES ('DEBIT_CARD');
INSERT INTO payment_method (method) VALUES ('PAYPAL');
INSERT INTO payment_method (method) VALUES ('BY_CASH');


INSERT INTO payment_status (status) VALUES ('PENDING');
INSERT INTO payment_status (status) VALUES ('PAID');
INSERT INTO payment_status (status) VALUES ('FAILED');


INSERT INTO manufacturer (country, name) VALUES ('USA', 'Apple');
INSERT INTO manufacturer (country, name) VALUES ('Germany', 'Bosh');
INSERT INTO manufacturer (country, name) VALUES ('China', 'Huawei');


INSERT INTO category (category_name) VALUES ('Electronics');
INSERT INTO category (category_name) VALUES ('Clothes');
INSERT INTO category (category_name) VALUES ('Sports');


INSERT INTO product (description, name, category_id, manufacturer_id) VALUES ('Iphone 11', 'Iphone', 1, 1);
INSERT INTO product (description, name, category_id, manufacturer_id) VALUES ('Motorola X', 'X', 1, 1);
INSERT INTO product (description, name, category_id, manufacturer_id) VALUES ('Google Pixel', 'Pixel', 1, 1);
INSERT INTO product (description, name, category_id, manufacturer_id) VALUES ('Toshiba AA3A', 'Toshiba', 1, 2);
INSERT INTO product (description, name, category_id, manufacturer_id) VALUES ('Huawei 6pro', 'Huawei', 1, 3);


INSERT INTO product_info (price, quantity, product_id) VALUES ('950', '8', '1');
INSERT INTO product_info (price, quantity, product_id) VALUES ('300', '4', '2');
INSERT INTO product_info (price, quantity, product_id) VALUES ('500', '5', '3');
INSERT INTO product_info (price, quantity, product_id) VALUES ('100', '2', '4');
INSERT INTO product_info (price, quantity, product_id) VALUES ('150', '2', '5');