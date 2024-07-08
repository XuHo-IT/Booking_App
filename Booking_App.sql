create database Booking
CREATE TABLE [Booking].[dbo].[User] (
    id INT IDENTITY(1,1) PRIMARY KEY,
    email NVARCHAR(MAX),
    name NVARCHAR(MAX),
    password NVARCHAR(MAX), 
);


DBCC CHECKIDENT ('User', RESEED, 0);


select * from [Booking].[dbo].[User]

CREATE TABLE [Booking].[dbo].[Room] (
    roomid INT IDENTITY(1,1) PRIMARY KEY,
    roomtype NVARCHAR(MAX),
	capacity int,
	price float,
    status NVARCHAR(MAX),
    message NVARCHAR(MAX),
	photo nvarchar(max),
    userid int,
);
select * from Room

CREATE TABLE [Booking].[dbo].[Bill] (
    billNo INT IDENTITY(1,1) PRIMARY KEY,
	dateIn datetime,
	dateOut datetime,
	price float,
    userid int,
	number int,
    roomtype nvarchar(max),
	request nvarchar(max),
	userName nvarchar(max),
    userEmail nvarchar(max)
);


	
DBCC CHECKIDENT ('Bill', RESEED, 0);



delete from [Booking].[dbo].[Bill] 

select * from [Booking].[dbo].[Bill]
insert into [Booking].[dbo].[User] values ('user@gmail.com','user','user')


AlTER TABLE [Booking].[dbo].[Admin] (
    id INT IDENTITY(1,1) PRIMARY KEY,
    email NVARCHAR(MAX),
    name NVARCHAR(MAX),
    password NVARCHAR(MAX), 
);