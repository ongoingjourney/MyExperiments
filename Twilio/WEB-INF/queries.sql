USE orm;
DROP table dictionary;

CREATE TABLE dictionary(
	id INT(5) NOT NULL AUTO_INCREMENT,
	created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	word VARCHAR(200),
	meaning VARCHAR(1000), 
	PRIMARY KEY(id)
);

INSERT INTO dictionary(word, meaning) 
VALUES("hello", "greeting");

SELECT * FROM dictionary;