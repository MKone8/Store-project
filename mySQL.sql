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



CREATE TABLE Games (
	id INT AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    category VARCHAR(255),
    price DOUBLE NOT NULL,
    dscd_price DOUBLE,
    PRIMARY KEY (id)    
);

INSERT INTO games (title, category,price) 
VALUES ('Portal2','Platformer','12.99'),
	   ('PeoplePlayground','Sandbox','10.95'),
	   ('Hades','Action','12.09'),
       ('VampireSurviviors','Action','7.65'),
       ('StardewValley','Simulator','4.44'),
       ('Terraria','Sandbox','8.29'),
       ('Portal','Platformer','7.21'),
       ('RimWorld','Survival','9.12'),
       ('Half-Life:Alyx','FPS','10.99'),
       ('ULTRAKILL','FPS','2.99'),
       ('Left4Dead2','FPS','0.99'),
       ('TheHenryStickminCollection','Action','2.12'),
       ('KatanaZero','Action','105.99'),
       ('TheBindingofIsaac:Rebirth','Action','22.93'),
       ('Helltaker','Platformer','24.99'),
	   ('SlaytheSpire','CardGame','18.99'),
       ('EuroTruckSimulator2','Forautists','10.99'),
       ('KatanaZero','Action','91.92'),       
       ('SlimeRancher','Sandbox','10.29'),
       ('AShortHike','Action','2.99'),
       ('Counter-Strike','FPS','3.84'),
       ('BloonsTD6','Strategy','7.82');