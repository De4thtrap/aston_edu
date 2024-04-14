CREATE TABLE IF NOT EXISTS cart
(
    cart_id INT PRIMARY KEY,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    amount INT NOT NULL
);