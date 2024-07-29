-- 1. Order
CREATE TABLE t_order (
                        id SERIAL  PRIMARY KEY,
                        reference VARCHAR(255) UNIQUE NOT NULL,
                        total_amount NUMERIC(19,2),
                        payment_method VARCHAR(50),
                        customer_id INTEGER,
                        created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        last_modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- 2. OrderLine
CREATE TABLE t_order_line (
                        id SERIAL  PRIMARY KEY,
                        order_id INTEGER,
                        product_id INTEGER,
                        quantity INTEGER,
                        FOREIGN KEY (order_id) references t_order(id) ON DELETE SET NULL
);