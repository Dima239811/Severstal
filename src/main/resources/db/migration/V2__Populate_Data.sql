INSERT INTO products (type, kind) VALUES
('APPLE', 'GOLDEN'),
('APPLE', 'RED'),
('PEAR', 'CONFERENCE'),
('PEAR', 'WILLIAMS');


INSERT INTO suppliers (name, phone) VALUES
('Фруктовый Мир', '+79001112233'),
('Сады Придонья', '+78005553535');

INSERT INTO supplier_prices (supplier_id, product_id, price_per_kg, date_from) VALUES
(1, 1, 120.00, '2024-01-01'),
(1, 3, 210.50, '2024-01-01');

INSERT INTO deliveries (supplier_id, delivery_date) VALUES (1, CURRENT_DATE);

INSERT INTO delivery_items (delivery_id, product_id, weight_kg, price_per_kg) VALUES
(1, 1, 500.0, 120.00),
(1, 3, 200.0, 210.50);