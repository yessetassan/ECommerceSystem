-- 1. User
CREATE TABLE t_role (
                        id SERIAL  PRIMARY KEY,
                        name VARCHAR(50) NOT NULL
);

-- 3. Address
CREATE TABLE t_address (
                           id SERIAL  PRIMARY KEY,
                           street VARCHAR(255) NOT NULL,
                           house_number VARCHAR(255) NOT NULL,
                           zip_code VARCHAR(255) NOT NULL
);

-- 2. Role
CREATE TABLE t_user (
                        id SERIAL  PRIMARY KEY,
                        username VARCHAR(255) UNIQUE NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        first_name VARCHAR(255) NOT NULL,
                        last_name VARCHAR(255) NOT NULL,
                        email VARCHAR(255) UNIQUE NOT NULL,
                        role_id INTEGER,
                        address_id INTEGER,
                        FOREIGN KEY (role_id) REFERENCES t_role(id),
                        FOREIGN KEY (address_id) REFERENCES t_address(id)
);
