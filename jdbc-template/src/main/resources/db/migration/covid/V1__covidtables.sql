CREATE TABLE person (taj VARCHAR(9) PRIMARY KEY, full_name VARCHAR(100), zip VARCHAR(4), age BIGINT, email VARCHAR(100));
CREATE TABLE citizen (id BIGINT PRIMARY KEY AUTO_INCREMENT, person_taj VARCHAR(9), number_of_vaccination INT DEFAULT 0, last_vaccination_date TIMESTAMP NULL DEFAULT NULL ON UPDATE current_timestamp(),
	    CONSTRAINT `fk_person_taj`
        FOREIGN KEY (person_taj) REFERENCES person (taj) );