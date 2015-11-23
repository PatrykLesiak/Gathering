DROP TABLE Event;
DROP TABLE Participant;
DROP TABLE Member;
DROP TABLE Organizer;

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
	MaximalAge int
);

CREATE TABLE Participant
(
	ParticipantId int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	Name varchar(255) NOT NULL,
	Surname varchar(255) NOT NULL,
	Age int NOT NULL,
	Email varchar(255) NOT NULL,
	Sex varchar(255) NOT NULL
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

CREATE TABLE Organizer
(
	OrganizerId int PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	CompanyName varchar(255) NOT NULL,
	CompanyIdentificationNumber int NOT NULL,
	RepresentativeName varchar(255) NOT NULL,
	RepresentativeSurname varchar(255) NOT NULL,
	Email varchar(255) NOT NULL,
	PhoneNumber int NOT NULL,
	AccountNumber int NOT NULL
);


/* Some values for demo */

INSERT INTO Event(Title, Description, EventDate, EventTime, Place, PictureLink , MaxAmountOfParticipants, Price, Currency, Cathegory, MinimalAge, MaximalAge) 
    VALUES ('New year cruise party', 
			'Whole night cruise party to step into new year',
			DATE('2015-12-31'), 
			TIME('18:00'),
			'ul. Zamknięta 18, 80-955 Gdańsk',
			'http://www.destination360.com/travel/new-years/images/cruises-new-years-eve.jpg',
			400,
			500.00,
			'PLN',
			'Bal',
			18,
			0						  
			);	
	