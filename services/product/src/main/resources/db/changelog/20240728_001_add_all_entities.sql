-- 1. Category
CREATE TABLE t_category (
                        id SERIAL  PRIMARY KEY,
                        description VARCHAR(255) NOT NULL,
                        name VARCHAR(255) NOT NULL
);

-- 2. Product
CREATE TABLE t_product (
                        id SERIAL  PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        description VARCHAR(255) NOT NULL ,
                        available_quantity INTEGER NOT NULL ,
                        price numeric(38, 2)  NOT NULL,
                        category_id INTEGER NOT NULL,
                        FOREIGN KEY (category_id) references t_category(id) ON DELETE CASCADE
);