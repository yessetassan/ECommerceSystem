-- Insert data into t_role table for Online Shop
INSERT INTO t_role (name) VALUES
('ADMIN'),      -- Has full access to manage the shop
('CUSTOMER'),   -- Regular users who can browse and purchase products
('VENDOR'),     -- Users who can manage their own products
('SUPPORT');    -- Users who provide customer support