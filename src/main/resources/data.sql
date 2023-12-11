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
