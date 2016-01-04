DROP VIEW v_user_role;
DROP TABLE ORGANIZERS_GROUPS;
DROP TABLE PARTICIPANTS_GROUPS;
DROP TABLE Participant_to_Event;
DROP TABLE Member;
DROP TABLE Groups;
DROP TABLE Participant;
DROP TABLE Event;
DROP TABLE Organizer;
DROP TABLE Cathegory;

CREATE TABLE Cathegory
(
	CathegoryId int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	Name varchar(255) NOT NULL
);

CREATE TABLE Organizer
(
	OrganizerId int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	CompanyName varchar(255) NOT NULL,
	CompanyIdentificationNumber int NOT NULL,
	RepresentativeName varchar(255) NOT NULL,
	RepresentativeSurname varchar(255) NOT NULL,
	Email varchar(255) NOT NULL,
	PhoneNumber int NOT NULL,
	AccountNumber varchar(26) NOT NULL,
	Password varchar(256) NOT NULL
);

CREATE TABLE Event
(
	EventId int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	Title varchar(255),
	Description varchar(1024),
	EventDate Date,
	Place varchar(255),
	PictureLink varchar(255),
	MaxAmountOfParticipants int,
	Price double,
	Currency varchar(3),
	MinimalAge int,
	MaximalAge int,
	Organizer int NOT NULL,
	Cathegory int NOT NULL,
	FOREIGN KEY (Organizer) REFERENCES Organizer(OrganizerId),
	FOREIGN KEY (Cathegory) REFERENCES Cathegory(CathegoryId)
);

CREATE TABLE Participant
(
	ParticipantId int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	Name varchar(255) NOT NULL,
	Surname varchar(255) NOT NULL,
	Age int NOT NULL,
	Email varchar(255) NOT NULL,
	Sex varchar(255) NOT NULL,
	Password varchar(256) NOT NULL
);

CREATE TABLE Member
(
	MemberId int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	Name varchar(255) NOT NULL,
	Surname varchar(255) NOT NULL,
	Age int NOT NULL,
	Email varchar(255) NOT NULL,
	Sex varchar(255) NOT NULL,
	AccountNumber int,
	Address varchar(255) NOT NULL,
	PhoneNumber int NOT NULL
);

CREATE TABLE Participant_to_Event
(
Id int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
Participant int NOT NULL,
Event int NOT NULL,
FOREIGN KEY (Participant) REFERENCES Participant(ParticipantId),
FOREIGN KEY (Event) REFERENCES Event(EventId)
);

CREATE TABLE Groups
(
group_id int PRIMARY KEY NOT NULL,
group_name varchar(20) NOT NULL
);

CREATE TABLE PARTICIPANTS_GROUPS
(
Id int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
participant_id int NOT NULL,
group_id int NOT NULL, 
FOREIGN KEY (group_id) REFERENCES Groups (group_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
FOREIGN KEY (participant_id) REFERENCES Participant (ParticipantId) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE ORGANIZERS_GROUPS
(
Id int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
organizer_id int NOT NULL,
group_id int NOT NULL, 
FOREIGN KEY (group_id) REFERENCES Groups (group_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
FOREIGN KEY (organizer_id) REFERENCES Organizer (OrganizerId) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE VIEW v_user_role AS
SELECT  p.Email, p.Password, g.group_name
 FROM PARTICIPANTS_GROUPS pg
 INNER JOIN Participant p ON p.ParticipantId = pg.participant_id
 INNER JOIN Groups g ON g.group_id =  pg.group_id
UNION
SELECT  o.Email, o.Password, g.group_name
 FROM ORGANIZERS_GROUPS og
 INNER JOIN Organizer o ON o.OrganizerId = og.organizer_id
 INNER JOIN Groups g ON g.group_id =  og.group_id;



/* Some values for demo */
INSERT INTO Cathegory(Name) VALUES('Bal');
INSERT INTO Cathegory(Name) VALUES('Koncert');
INSERT INTO Cathegory(Name) VALUES('Aukcja');
INSERT INTO Cathegory(Name) VALUES('Bankiet');
INSERT INTO Cathegory(Name) VALUES('Pokaz');

INSERT INTO Organizer(CompanyName, CompanyIdentificationNumber, RepresentativeName, RepresentativeSurname, Email, PhoneNumber, AccountNumber, Password)
	VALUES ('Hotel Wybrzeże',
			123456,
			'Patryk',
			'Lesiak',
			'recepcja@wybrzeze.pl',
			667362918,
			'26987800012321361628',
            'd74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1'
			);

INSERT INTO Participant(Name, Surname, Age, Email, Sex, Password) 
	VALUES ('Patryk',
			'Lesiak',
			23,
			'pat@les.pl',
			'M',
			'd74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1'
			);

INSERT INTO Event(Title, Description, EventDate, Place, PictureLink , MaxAmountOfParticipants, Price, Currency, MinimalAge, MaximalAge, Organizer, Cathegory) 
    VALUES ('Noworoczny rejs statkiem', 
			'Całonocny rejst statkiem, aby przywitać nowy rok !',
			DATE('2015-12-31 18:00:00'), 
			'ul. Zamknięta 18, 80-955 Gdańsk',
			'http://www.destination360.com/travel/new-years/images/cruises-new-years-eve.jpg',
			400,
			500.00,
			'PLN',
			18,
			0,
			1, 
			1
			);	
			
INSERT INTO Event(Title, Description, EventDate, Place, PictureLink , MaxAmountOfParticipants, Price, Currency, MinimalAge, MaximalAge, Organizer, Cathegory) 
    VALUES ('Opłatek', 
			'Uroczysta wigilijna wieczerza',
			DATE('2015-12-24 20:00:00'),
			'ul. Zamknięta 18, 80-955 Gdańsk',
			'http://www.phrz.pl/upload/Gallery/restauracja-folwark-af5c9.jpg',
			400,
			500.00,
			'PLN',
			18,
			0,
			1, 
			2
			);
			
INSERT INTO Event(Title, Description, EventDate, Place, PictureLink , MaxAmountOfParticipants, Price, Currency, MinimalAge, MaximalAge, Organizer, Cathegory) 
    VALUES ('Rejs statkiem', 
			'Rejs luksusowym statkiem po Bałtyku wraz z poczęstunkiem na pokładzie.',
			DATE('2016-02-10 16:00:00'),
			'ul. Zamknięta 18, 80-955 Gdańsk',
			'http://www.sunreef-charter.com/img/special_offers/99-1.jpg',
			400,
			500.00,
			'PLN',
			18,
			0,
			1, 
			2
			);
			
INSERT INTO Groups(group_id,group_name) VALUES (1,'loggedParticipant');
INSERT INTO Groups(group_id,group_name) VALUES (2,'loggedOrganizer');

INSERT INTO PARTICIPANTS_GROUPS(participant_id, group_id) VALUES (1, 1);
INSERT INTO ORGANIZERS_GROUPS(organizer_id, group_id) VALUES (1, 2);

INSERT INTO Participant_to_Event(Participant, Event) VALUES(1, 1);
	