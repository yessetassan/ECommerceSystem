/*
 Добавление админа
 */
INSERT INTO t_address (street, house_number, zip_code)
VALUES ('123 Main Street', '10A', '12345')
    RETURNING id;

INSERT INTO t_user (username, password, first_name, last_name, email, role_id, address_id)
VALUES (
           'admin',
           '$2a$10$dGV7hCuRLHyR46FdC0cmleT2uEv78Uyl8QSDY53jMgLnaV/7cBSqe',
           'Assan',
           'Yesset',
           'yesset.assan@gmail.com',
           (SELECT id FROM t_role WHERE name = 'ADMIN'),
           (SELECT id FROM t_address WHERE street = '123 Main Street' AND house_number = '10A' AND zip_code = '12345')
       );