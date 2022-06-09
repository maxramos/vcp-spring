CREATE TABLE person (
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(30) NOT NULL, 
	last_name VARCHAR(30) NOT NULL, 
	age INT NOT NULL, 
	birth_date DATE NOT NULL, 
	weight DECIMAL(5,2) NOT NULL, 
	height DECIMAL(5,2) NOT NULL
);