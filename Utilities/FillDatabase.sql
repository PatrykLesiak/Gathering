DROP VIEW v_user_role;
DROP TABLE Event;
DROP TABLE Member;
DROP TABLE Organizer;
DROP TABLE USERS_GROUPS;
DROP TABLE Groups;
DROP TABLE Participant;

CREATE TABLE Organizer
(
	OrganizerId int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	CompanyName varchar(255) NOT NULL,
	CompanyIdentificationNumber int NOT NULL,
	RepresentativeName varchar(255) NOT NULL,
	RepresentativeSurname varchar(255) NOT NULL,
	Email varchar(255) NOT NULL,
	PhoneNumber int NOT NULL,
	AccountNumber varchar(26) NOT NULL
);

CREATE TABLE Event
(
	EventId int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	Title varchar(255),
	Description varchar(1024),
	EventDate Date,
	EventTime Time,
	Place varchar(255),
	PictureLink varchar(255),
	MaxAmountOfParticipants int,
	Price double,
	Currency varchar(3),
	Cathegory varchar(255),
	MinimalAge int,
	MaximalAge int,
	Organizer int NOT NULL,
	FOREIGN KEY (Organizer) REFERENCES Organizer(OrganizerId)
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

CREATE TABLE Groups
(
group_id int PRIMARY KEY NOT NULL,
group_name varchar(20) NOT NULL
);

CREATE TABLE USERS_GROUPS
(
Id int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
participant_id int NOT NULL,
group_id int NOT NULL, 
FOREIGN KEY (group_id) REFERENCES Groups (group_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
FOREIGN KEY (participant_id) REFERENCES Participant (ParticipantId) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE VIEW v_user_role AS
SELECT  u.Email, u.Password, g.group_name
 FROM USERS_GROUPS ug
 INNER JOIN Participant u ON u.ParticipantId = ug.participant_id
 INNER JOIN Groups g ON g.group_id =  ug.group_id; 


/* Some values for demo */

INSERT INTO Organizer(CompanyName, CompanyIdentificationNumber, RepresentativeName, RepresentativeSurname, Email, PhoneNumber, AccountNumber)
	VALUES ('Hotel Wybrzeże',
			123456,
			'Patryk',
			'Lesiak',
			'recepcja@wybrzeze.pl',
			667362918,
			'26987800012321361628'
			);

INSERT INTO Participant(Name, Surname, Age, Email, Sex, Password) 
	VALUES ('Patryk',
			'Lesiak',
			23,
			'pat@les.pl',
			'M',
			'd74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1'
			);

INSERT INTO Event(Title, Description, EventDate, EventTime, Place, PictureLink , MaxAmountOfParticipants, Price, Currency, Cathegory, MinimalAge, MaximalAge, Organizer) 
    VALUES ('Noworoczny rejs statkiem', 
			'Całonocny rejst statkiem, aby przywitać nowy rok !',
			DATE('2015-12-31'), 
			TIME('18:00'),
			'ul. Zamknięta 18, 80-955 Gdańsk',
			'http://www.destination360.com/travel/new-years/images/cruises-new-years-eve.jpg',
			400,
			500.00,
			'PLN',
			'Bal',
			18,
			0,
			1
			);	
			
INSERT INTO Event(Title, Description, EventDate, EventTime, Place, PictureLink , MaxAmountOfParticipants, Price, Currency, Cathegory, MinimalAge, MaximalAge, Organizer) 
    VALUES ('Opłatek', 
			'Uroczysta wigilijna wieczerza',
			DATE('2015-12-24'), 
			TIME('20:00'),
			'ul. Zamknięta 18, 80-955 Gdańsk',
			'http://www.phrz.pl/upload/Gallery/restauracja-folwark-af5c9.jpg',
			400,
			500.00,
			'PLN',
			'Bal',
			18,
			0,
			1
			);
			
INSERT INTO Groups(group_id,group_name) VALUES (1,'loggedParticipant');
INSERT INTO USERS_GROUPS(participant_id, group_id) VALUES (1, 1);
	