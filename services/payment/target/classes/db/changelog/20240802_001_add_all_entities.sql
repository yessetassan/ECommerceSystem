-- 1. Payment
CREATE TABLE t_payment (
                        id SERIAL  PRIMARY KEY,
                        amount NUMERIC(19,2),
                        payment_method VARCHAR(50),
                        orderId INTEGER,
                        created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        last_modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);