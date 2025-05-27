create database java_ss12;
use java_ss12;
# drop database java_ss12;
CREATE TABLE student (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         email VARCHAR(100) NOT NULL,
                         dob DATE NOT NULL
);
delimiter //
create procedure find_all()
begin
    select * from student;
end;
create procedure find_ById(c_id int)
begin
    select * from student
        where id = c_id;
end;
create procedure save(c_name varchar(100),c_email varchar(100), c_dob date)
begin
    insert into student( name, email, dob)
        values(c_name,c_email,c_dob);
end;
create procedure update_stu(c_id int,c_name varchar(100),c_email varchar(100), c_dob date)
begin
    update student set name = c_name , email = c_email , dob = c_dob where id = c_id;
end;
create procedure delete_stu(c_id int)
begin
    delete from student where id = c_id;
end;
delimiter //
-- ===========
CREATE TABLE product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         price DECIMAL(10, 2) NOT NULL CHECK (price > 0),
                         quantity INT NOT NULL,
                         image VARCHAR(255)
);
DELIMITER //
CREATE PROCEDURE sp_get_all_products()
BEGIN
    SELECT * FROM product;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_find_product_by_id(IN p_id INT)
BEGIN
    SELECT * FROM product WHERE id = p_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_insert_product(
    IN p_name VARCHAR(255),
    IN p_price DECIMAL(10,2),
    IN p_quantity INT,
    IN p_image VARCHAR(255)
)
BEGIN
    INSERT INTO product(name, price, quantity, image)
    VALUES(p_name, p_price, p_quantity, p_image);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_update_product(
    IN p_id INT,
    IN p_name VARCHAR(255),
    IN p_price DECIMAL(10,2),
    IN p_quantity INT,
    IN p_image VARCHAR(255)
)
BEGIN
    UPDATE product
    SET name = p_name,
        price = p_price,
        quantity = p_quantity,
        image = p_image
    WHERE id = p_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_delete_product(IN p_id INT)
BEGIN
    DELETE FROM product WHERE id = p_id;
END //
DELIMITER ;
CREATE TABLE bus (
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     license_plate VARCHAR(20) NOT NULL,
                     bus_type ENUM('NORMAL', 'VIP', 'LUXURY') NOT NULL,
                     row_seat INT NOT NULL,
                     col_seat INT NOT NULL,
                     total_seat INT NOT NULL,
                     image VARCHAR(255)
);

CREATE TABLE seat (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name_seat VARCHAR(10),
                      price DECIMAL(10,2),
                      bus_id INT,
                      status ENUM('Trống', 'Đã đặt') DEFAULT 'Trống',
                      FOREIGN KEY (bus_id) REFERENCES bus(id) ON DELETE CASCADE
);
DELIMITER $$

CREATE PROCEDURE find_all_bus()
BEGIN
    SELECT * FROM bus;
END$$

CREATE PROCEDURE find_bus_by_id(IN b_id INT)
BEGIN
    SELECT * FROM bus WHERE id = b_id;
END$$

CREATE PROCEDURE save_bus(
    IN b_licensePlate VARCHAR(50),
    IN b_busType VARCHAR(100),
    IN b_rowSeat INT,
    IN b_colSeat INT,
    IN b_totalSeat INT,
    IN b_image TEXT
)
BEGIN
    INSERT INTO bus(license_plate, bus_type, row_seat, col_seat, total_seat, image)
    VALUES (b_licensePlate, b_busType, b_rowSeat, b_colSeat, b_totalSeat, b_image);
END$$

CREATE PROCEDURE update_bus(
    IN b_id INT,
    IN b_licensePlate VARCHAR(50),
    IN b_busType VARCHAR(100),
    IN b_rowSeat INT,
    IN b_colSeat INT,
    IN b_totalSeat INT,
    IN b_image TEXT
)
BEGIN
    UPDATE bus
    SET license_plate = b_licensePlate,
        bus_type = b_busType,
        row_seat = b_rowSeat,
        col_seat = b_colSeat,
        total_seat = b_totalSeat,
        image = b_image
    WHERE id = b_id;
END$$

CREATE PROCEDURE delete_bus(IN b_id INT)
BEGIN
    DELETE FROM bus WHERE id = b_id;
END$$

DELIMITER ;
DELIMITER $$

CREATE PROCEDURE find_seat_by_bus_id(IN s_bus_id INT)
BEGIN
    SELECT * FROM seat WHERE bus_id = s_bus_id;
END$$

CREATE PROCEDURE save_seat(
    IN s_name VARCHAR(20),
    IN s_price DECIMAL(10,2),
    IN s_bus_id INT,
    IN s_status VARCHAR(20)
)
BEGIN
    INSERT INTO seat(name_seat, price, bus_id, status)
    VALUES (s_name, s_price, s_bus_id, s_status);
END$$

CREATE PROCEDURE update_seat(
    IN s_id INT,
    IN s_name VARCHAR(20),
    IN s_price DECIMAL(10,2),
    IN s_bus_id INT,
    IN s_status VARCHAR(20)
)
BEGIN
    UPDATE seat
    SET name_seat = s_name,
        price = s_price,
        bus_id = s_bus_id,
        status = s_status
    WHERE id = s_id;
END$$

CREATE PROCEDURE delete_seat_by_bus_id(IN s_bus_id INT)
BEGIN
    DELETE FROM seat WHERE bus_id = s_bus_id;
END$$

DELIMITER ;
