CREATE DATABASE travel_app;

USE travel_app;

CREATE TABLE `cities`(
    `city_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `city_name` VARCHAR(255) NOT NULL
);

CREATE TABLE `distance_matrix`(
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `source_city_id` INT NOT NULL,
    `destination_city_id` INT NOT NULL,
    `distance` INT NOT NULL,
    FOREIGN KEY (`source_city_id`) REFERENCES `cities`(`city_id`),
    FOREIGN KEY (`destination_city_id`) REFERENCES `cities`(`city_id`)
);

INSERT INTO `cities` (`city_name`) VALUES
('Bangalore'),
('Mysore'),
('Hubli'),
('Mangalore'),
('Gulbarga'),
('Belgaum'),
('Bellary'),
('Shimoga'),
('Tumkur'),
('Bijapur'),
('Hospet'),
('Chitradurga'),
('Udupi');

INSERT INTO `distance_matrix` (`source_city_id`, `destination_city_id`, `distance`) VALUES
(1, 2, 150),
(1, 3, 410),
(1, 4, 372),
(1, 5, 573),
(1, 6, 504),
(1, 7, 312),
(1, 8, 299),
(1, 9, 71),
(1, 10, 526),
(1, 11, 328),
(1, 12, 204),
(1, 13, 396),
(2, 1, 150),
(2, 3, 467),
(2, 4, 254),
(2, 6, 565),
(2, 7, 370),
(2, 8, 254),
(2, 9, 153),
(2, 10, 589),
(2, 11, 393),
(2, 12, 257),
(2, 13, 309),
(3, 1, 410),
(3, 2, 467),
(3, 4, 381),
(3, 5, 377),
(3, 6, 100),
(3, 7, 209),
(3, 8, 200),
(3, 9, 346),
(3, 10, 214),
(3, 11, 148),
(3, 12, 211),
(3, 13, 323),
(4, 1, 372),
(4, 2, 254),
(4, 3, 381),
(4, 5, 737),
(4, 6, 444),
(4, 7, 433),
(4, 8, 200),
(4, 9, 296),
(4, 10, 595),
(4, 11, 383),
(4, 12, 304),
(4, 13, 64),
(5, 1, 573),
(5, 3, 377),
(5, 4, 737),
(5, 6, 373),
(5, 7, 298),
(5, 8, 486),
(6, 1, 504),
(6, 2, 565),
(6, 3, 100),
(6, 4, 444),
(6, 5, 373),
(6, 7, 311),
(6, 8, 295),
(7, 1, 312),
(7, 2, 370),
(7, 3, 209),
(7, 4, 433),
(7, 5, 298),
(7, 6, 311),
(7, 8, 251),
(8, 1, 299),
(8, 2, 254),
(8, 3, 200),
(8, 4, 200),
(8, 5, 486),
(8, 6, 295),
(8, 7, 251),
(9, 1, 71),
(9, 2, 153),
(9, 3, 346),
(9, 4, 296),
(9, 5, 547),
(9, 6, 468),
(9, 7, 238),
(9, 8, 206),
(10, 1, 526),
(10, 2, 589),
(10, 3, 214),
(10, 4, 595),
(10, 5, 153),
(10, 6, 198),
(10, 7, 270),
(11, 1, 328),
(11, 2, 393),
(11, 3, 148),
(11, 4, 383),
(11, 5, 298),
(11, 6, 248),
(11, 7, 63),
(11, 8, 200),
(12, 1, 204),
(12, 2, 257),
(12, 3, 211),
(12, 4, 304),
(12, 6, 306),
(12, 7, 137),
(12, 8, 106),
(13, 1, 396),
(13, 2, 309),
(13, 3, 323),
(13, 4, 64),
(13, 5, 620),
(13, 6, 385),
(13, 7, 383),
(13, 8, 150);

CREATE TABLE `car`(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `model` VARCHAR(255) NOT NULL,
    `number` VARCHAR(255) NOT NULL,
    `seat` INT NOT NULL,
    `driver_id` INT NOT NULL,
    `status` CHAR(1) NOT NULL,
    `charge` INT NOT NULL
);

CREATE TABLE `driver`(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `age` INT NOT NULL,
    `phone` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL
);

ALTER TABLE
    `car` ADD CONSTRAINT `car_driver_id_foreign` FOREIGN KEY(`driver_id`) REFERENCES `driver`(`id`);
	
-- Inserting data into the `driver` table
INSERT INTO `driver` (`name`, `age`, `phone`, `email`) VALUES
('John Doe', 35, '1234567890', 'john.doe@example.com'),
('Jane Smith', 30, '0987654321', 'jane.smith@example.com'),
('Bob Johnson', 40, '1122334455', 'bob.johnson@example.com');

-- Inserting data into the `car` table
INSERT INTO `car` (`name`, `model`, `number`, `seat`, `driver_id`, `status`, `charge`) VALUES
('Car A', 'Model X', 'KA-01-1234', 4, 1, 'A', 100),
('Car B', 'Model Y', 'KA-02-5678', 6, 2, 'B', 150),
('Car C', 'Model Z', 'KA-03-9012', 4, 3, 'A', 200);

CREATE TABLE `user`(
    `username` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `phone` VARCHAR(255) NOT NULL,
	`gender` CHAR(1),
    `password` CHAR(68) NOT NULL,
    `enabled` TINYINT NOT NULL,
    PRIMARY KEY(`username`)
);

INSERT INTO `user` (`username`, `email`, `phone`, `gender`, `password`, `enabled`) VALUES
('user1', 'user1@example.com', '1234567890', 'M', '{bcrypt}$2a$12$43f56UG6ykqKp4rOFOLgKOXiNOk17.ZZabujIaJ8W/y6XOqwpFYje', 1),
('user2', 'user2@example.com', '0987654321', 'F', '{bcrypt}$2a$12$43f56UG6ykqKp4rOFOLgKOXiNOk17.ZZabujIaJ8W/y6XOqwpFYje', 1),
('user3', 'user3@example.com', '1122334455', 'M', '{bcrypt}$2a$12$43f56UG6ykqKp4rOFOLgKOXiNOk17.ZZabujIaJ8W/y6XOqwpFYje', 1);

INSERT INTO `user` (`username`, `email`, `phone`, `gender`, `password`, `enabled`) VALUES
('admin', 'admin@example.com', '1234567890', 'M', '{bcrypt}$2a$12$43f56UG6ykqKp4rOFOLgKOXiNOk17.ZZabujIaJ8W/y6XOqwpFYje', 1);

INSERT INTO `user` (`username`, `email`, `phone`, `gender`, `password`, `enabled`) VALUES
('employee', 'employee@example.com', '0987654321', 'M', '{bcrypt}$2a$12$43f56UG6ykqKp4rOFOLgKOXiNOk17.ZZabujIaJ8W/y6XOqwpFYje', 1);

CREATE TABLE `authorities`(
    `username` VARCHAR(255) NOT NULL,
    `authority` VARCHAR(255) NOT NULL
);

ALTER TABLE
    `authorities` ADD CONSTRAINT `authorities_username_foreign` FOREIGN KEY(`username`) REFERENCES `user`(`username`);

INSERT INTO authorities VALUES('user1', 'ROLE_USER'),
	('user2', 'ROLE_USER'),
	('user3', 'ROLE_USER'),
	('employee', 'ROLE_USER'),
	('employee', 'ROLE_MANAGER'),
	('admin', 'ROLE_USER'),
	('admin', 'ROLE_MANAGER'),
	('admin', 'ROLE_ADMIN');

CREATE TABLE orders(
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` VARCHAR(255) NOT NULL,
	`car_id` INT NOT NULL,
    `driver_id` INT NOT NULL,
    `fare` INT NOT NULL,
    `distance_id` INT NOT NULL
);

ALTER TABLE
    `orders` ADD CONSTRAINT `order_distance_id_foreign` FOREIGN KEY(`distance_id`) REFERENCES `distance_matrix`(`id`);
ALTER TABLE
    `orders` ADD CONSTRAINT `order_car_id_foreign` FOREIGN KEY(`car_id`) REFERENCES `car`(`id`);
ALTER TABLE
    `orders` ADD CONSTRAINT `order_driver_id_foreign` FOREIGN KEY(`driver_id`) REFERENCES `driver`(`id`);
ALTER TABLE
    `orders` ADD CONSTRAINT `order_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `user`(`username`);
ALTER TABLE orders
ADD completed CHAR(1) NOT NULL;

CREATE USER 'travelAppDev'@'%' IDENTIFIED BY 'travelAppDev';
GRANT ALL PRIVILEGES ON travel_app.* TO 'travelAppDev'@'%';
FLUSH PRIVILEGES;



