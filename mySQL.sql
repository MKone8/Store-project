CREATE DATABASE gamesStore

CREATE TABLE User (
	id INT AUTO_INCREMENT,
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    admin BOOL DEFAULT 0,
    PRIMARY KEY (id)
    
);

INSERT INTO User (email, password, admin)
VALUES ('jankowalski@gmail.com','Polska123','1'),
	   ('mariuszp@gmail.com','Hejka','0');

CREATE TABLE category (
	id INT AUTO_INCREMENT,
    category VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO category (category)
VALUES ('Horror'),
       ('Adventure'),
       ('Action'),
       ('Casual'),
       ('Indie'),
       ('RPG'),
       ('Sports'),
       ('Strategy'),
       ('Tower Defense'),


CREATE TABLE Games (
	id INT AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    categoryID INT NOT NULL,
    price DOUBLE NOT NULL,
    dscd_price DOUBLE,
    PRIMARY KEY (id),
    FOREIGN KEY (categoryID) REFERENCES category(id)    
);

INSERT INTO games (title, category,price) 
VALUES ('Portal2','2','12.99'),
	   ('PeoplePlayground','3','10.95'),
	   ('Hades','5','12.09'),
       ('VampireSurviviors','5','7.65'),
       ('StardewValley','6','4.44'),
       ('Terraria','2','8.29'),
       ('Portal','4','7.21'),
       ('RimWorld','3','9.12'),
       ('Half-Life:Alyx','2','10.99'),
       ('ULTRAKILL','1','2.99'),
       ('Left4Dead2','5','0.99'),
       ('TheHenryStickminCollection','7','2.12'),
       ('KatanaZero','6','105.99'),
       ('TheBindingofIsaac:Rebirth','4','22.93'),
       ('Helltaker','6','24.99'),
	   ('SlaytheSpire','5','18.99'),
       ('EuroTruckSimulator2','2','10.99'),
       ('KatanaZero','3','91.92'),       
       ('SlimeRancher','1','10.29'),
       ('AShortHike','2','2.99'),
       ('Counter-Strike','5','3.84'),
       ('BloonsTD6','4','7.82');