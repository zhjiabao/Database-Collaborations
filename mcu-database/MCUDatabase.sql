CREATE DATABASE  IF NOT EXISTS `MCU` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `MCU`;
-- MySQL dump 10.13  Distrib 8.0.13, for macos10.14 (x86_64)
--
-- Host: localhost    Database: MCU
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movies` (
  `moviename` varchar(255) NOT NULL,
  `directedby` varchar(255) NOT NULL,
  `producedby` varchar(255) NOT NULL,
  `screenplayby` text DEFAULT NULL,
  `storyby` varchar(255) DEFAULT NULL,
  `basedon` varchar(255) NOT NULL,
  `starring` text NOT NULL,
  `musicby` varchar(255) NOT NULL,
  `cinematography` varchar(255) NOT NULL,
  `editedby` varchar(255) NOT NULL,
  `productioncompany` varchar(255) NOT NULL,
  `distributedby` varchar(255) NOT NULL,
  `releasedate` date NOT NULL,
  `runningtime` int(11) NOT NULL,
  `country` varchar(255) NOT NULL,
  `clanguage` varchar(255) NOT NULL,
  `budget` double NOT NULL,
  `boxoffice` double NOT NULL,
  PRIMARY KEY (`moviename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES ('Ant-Man','Peyton Reed','Kevin Feige','Edgar Wright, Joe Cornish, Adam McKay, Paul Rudd','Edgar Wright, Joe Cornish','Ant-Man','Paul Rudd, Evangeline Lilly, Corey Stoll, Bobby Cannavale, Michael Peña, Tip \"T.I.\" Harris, Anthony Mackie, Wood Harris, Judy Greer, David Dastmalchian, Michael Douglas','Christophe Beck','Russell Carpenter','Dan Lebental, Colby Parker, Jr.','Marvel Studios','Walt Disney Studios Motion Pictures','2015-06-29',117,'United States','English',169.3,519.3),('Ant-Man and the Wasp','Peyton Reed','Kevin Feige','Chris McKenna, Erik Sommers, Paul Rudd, Andrew Barrer, Gabriel Ferrari',NULL,'Ant-Man','Paul Rudd, Evangeline Lilly, Michael Peña, Walton Goggins, Bobby Cannavale, Judy Greer, Tip \"T.I.\" Harris, David Dastmalchian, Hannah John-Kamen, Abby Ryder Fortson, Randall Park, Michelle Pfeiffer, Laurence Fishburne, Michael Douglas','Christophe Beck','Dante Spinotti','Dan Lebental, Craig Wood','Marvel Studios','Walt Disney Studios Motion Pictures','2018-06-25',118,'United States','English',195,622.7),('Avengers: Age of Ultron','Joss Whedon','Kevin Feige','Joss Whedon',NULL,'The Avengers','Robert Downey Jr., Chris Hemsworth, Mark Ruffalo, Chris Evans, Scarlett Johansson, Jeremy Renner, Don Cheadle, Aaron Taylor-Johnson, Elizabeth Olsen, Paul Bettany, Cobie Smulders, Anthony Mackie, Hayley Atwell, Idris Elba, Stellan Skarsgård, James Spader, Samuel L. Jackson','Brian Tyler, Danny Elfman','Ben Davis','Jeffrey Ford, Lisa Lassek','Marvel Studios','Walt Disney Studios Motion Pictures','2015-04-13',141,'United States','English',495.2,1405),('Avengers: Endgame','Anthony Russo, Joe Russo','Kevin Feige','Christopher Markus, Stephen McFeely',NULL,'The Avengers','Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth, Scarlett Johansson, Jeremy Renner, Don Cheadle, Paul Rudd, Brie Larson, Karen Gillan, Danai Gurira, Bradley Cooper, Josh Brolin','Alan Silvestri','Trent Opaloch','Jeffrey Ford, Matthew Schmidt','Marvel Studios','Walt Disney Studios Motion Pictures','2019-04-22',181,'United States','English',356,2743),('Avengers: Infinity War','Anthony Russo, Joe Russo','Kevin Feige','Christopher Markus, Stephen McFeely',NULL,'The Avengers','Robert Downey Jr., Chris Hemsworth, Mark Ruffalo, Chris Evans, Scarlett Johansson, Benedict Cumberbatch, Don Cheadle, Tom Holland, Chadwick Boseman, Paul Bettany, Elizabeth Olsen, Anthony Mackie, Sebastian Stan, Danai Gurira, Letitia Wright, Dave Bautista, Zoe Saldana, Josh Brolin, Chris Pratt','Alan Silvestri','Trent Opaloch','Jeffrey Ford, Matthew Schmidt','Marvel Studios','Walt Disney Studios Motion Pictures','2018-04-23',149,'United States','English',400,2049),('Black Panther','Ryan Coogler','Kevin Feige','Ryan Coogler, Joe Robert Cole',NULL,'Black Panther','Chadwick Boseman, Michael B. Jordan, Lupita Nyong\'o, Danai Gurira, Martin Freeman, Daniel Kaluuya, Letitia Wright, Winston Duke, Angela Bassett, Forest Whitaker, Andy Serkis','Ludwig Göransson','Rachel Morrison','Michael P. Shawver, Debbie Berman','Marvel Studios','Walt Disney Studios Motion Pictures','2018-01-29',134,'United States','English',210,1347),('Captain America: Civil War','Anthony Russo, Joe Russo','Kevin Feige','Christopher Markus, Stephen McFeely',NULL,'Captain America','Chris Evans, Robert Downey Jr., Scarlett Johansson, Sebastian Stan, Anthony Mackie, Don Cheadle, Jeremy Renner, Chadwick Boseman, Paul Bettany, Elizabeth Olsen, Paul Rudd, Emily Van, Camp, Tom Holland, Frank Grillo, William Hurt, Daniel Brühl','Henry Jackman','Trent Opaloch','Jeffrey Ford, Matthew Schmidt','Marvel Studios','Walt Disney Studios Motion Pictures','2016-04-12',147,'United States','English',250,1153),('Captain America: The First Avenger','Joe Johnston','Kevin Feige','Christopher Markus, Stephen McFeely',NULL,'Captain America','Chris Evans, Tommy Lee Jones, Hugo Weaving, Hayley Atwell, Sebastian Stan, Dominic Cooper, Neal McDonough, Derek Luke, Stanley Tucci','Alan Silvestri','Shelly Johnson','Jeffrey Ford, Robert Dalva','Marvel Studios','Paramount Pictures','2011-07-19',124,'United States','English',216.7,370.6),('Captain America: The Winter Soldier','Anthony Russo, Joe Russo','Kevin Feige','Christopher Markus, Stephen McFeely',NULL,'Captain America','Chris Evans, Scarlett Johansson, Sebastian Stan, Anthony Mackie, Cobie Smulders, Frank Grillo, Emily Van, Camp, Hayley Atwell, Robert Redford, Samuel L. Jackson','Henry Jackman','Trent Opaloch','Jeffrey Ford, Matthew Schmidt','Marvel Studios','Walt Disney Studios Motion Pictures','2014-04-13',136,'United States','English',177,714.3),('Captain Marvel','Anna Boden, Ryan Fleck','Kevin Feige','Anna Boden, Ryan Fleck, Geneva Robertson-Dworet','Nicole Perlman, Meg LeFauve, Anna Boden, Ryan Fleck, Geneva Robertson-Dworet','Captain Marvel','Brie Larson, Samuel L. Jackson, Ben Mendelsohn, Djimon Hounsou, Lee Pace, Lashana Lynch, Gemma Chan, Annette Bening, Clark Gregg, Jude Law','Pinar Toprak','Ben Davis','Elliot Graham, Debbie Berman','Marvel Studios','Walt Disney Studios Motion Pictures','2019-02-27',124,'United States','English',175,1128),('Doctor Strange','Scott Derrickson','Kevin Feige','Jon Spaihts, Scott Derrickson, C. Robert Cargill',NULL,'Doctor Strange','Benedict Cumberbatch, Chiwetel Ejiofor, Rachel McAdams, Benedict Wong, Michael Stuhlbarg, Benjamin Bratt, Scott Adkins, Mads Mikkelsen, Tilda Swinton','Michael Giacchino','Ben Davis','Wyatt Smith, Sabrina Plisco','Marvel Studios','Walt Disney Studios Motion Pictures','2016-10-13',115,'United States','English',236.6,677.7),('Guardians of the Galaxy','James Gunn','Kevin Feige','James Gunn, Nicole Perlman',NULL,'Guardians of the Galaxy','Chris Pratt, Zoe Saldana, Dave Bautista, Vin Diesel, Bradley Cooper, Lee Pace, Michael Rooker, Karen Gillan, Djimon Hounsou, John C. Reilly, Glenn Close, Benicio del Toro','Tyler Bates','Ben Davis','Fred Raskin, Craig Wood, Hughes Winborne','Marvel Studios','Walt Disney Studios Motion Pictures','2014-07-21',122,'United States','English',232.3,773.3),('Guardians of the Galaxy Vol. 2','James Gunn','Kevin Feige','James Gunn',NULL,'Guardians of the Galaxy','Chris Pratt, Zoe Saldana, Dave Bautista, Vin Diesel, Bradley Cooper, Michael Rooker, Karen Gillan, Pom Klementieff, Elizabeth Debicki, Chris Sullivan, Sean Gunn, Sylvester Stallone, Kurt Russell','Tyler Bates','Henry Braham','Fred Raskin, Craig Wood','Marvel Studios','Walt Disney Studios Motion Pictures','2017-04-10',137,'United States','English',200,863.8),('Iron Man','Jon Favreau','Avi Arad, Kevin Feige','Mark Fergus, Hawk Ostby, Art Marcum, Matt Holloway',NULL,'Iron Man','Robert Downey Jr., Terrence Howard, Jeff Bridges, Shaun Toub, Gwyneth Paltrow','Ramin Djawadi','Matthew Libatique','Dan Lebental','Marvel Studios, Fairview Entertainment','Paramount Pictures','2008-04-14',126,'United States','English',140,585.2),('Iron Man 2','Jon Favreau','Kevin Feige','Justin Theroux',NULL,'Iron Man','Robert Downey Jr., Gwyneth Paltrow, Don Cheadle, Scarlett Johansson, Sam Rockwell, Mickey Rourke, Samuel L. Jackson','John Debney','Matthew Libatique','Dan Lebental','Marvel Studios, Fairview Entertainment','Paramount Pictures','2010-04-26',125,'United States','English',200,623.9),('Iron Man 3','Shane Black','Kevin Feige','Drew Pearce, Shane Black',NULL,'Iron Man','Robert Downey Jr., Gwyneth Paltrow, Don Cheadle, Guy Pearce, Rebecca Hall, Stéphanie Szostak, James Badge Dale, Jon Favreau, Ben Kingsley','Brian Tyler','John Toll','Jeffrey Ford, Peter S. Elliot','Marvel Studios','Walt Disney Studios Motion Pictures','2013-04-14',131,'United States','English',200,1215),('Spider-Man: Homecoming','Jon Watts','Kevin Feige','Jonathan Goldstein, John Francis Daley, Jon Watts, Christopher Ford, Chris Mc, Kenna, Erik Sommers','Jonathan Goldstein, John Francis Daley','Spider-Man','Tom Holland, Michael Keaton, Jon Favreau, Zendaya, Donald Glover, Tyne Daly, Marisa Tomei, Robert Downey Jr.','Michael Giacchino','Salvatore Totino','Dan Lebental, Debbie Berman','Columbia Pictures, Marvel Studios, Pascal Pictures','Sony Pictures Releasing','2017-06-28',133,'United States','English',175,880.2),('The Avengers','Joss Whedon','Kevin Feige','Joss Whedon','Zak Penn, Joss Whedon','The Avengers','Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth, Scarlett Johansson, Jeremy Renner, Tom Hiddleston, Clark Gregg, Cobie Smulders, Stellan Skarsgård, Samuel L. Jackson','Alan Silvestri','Seamus McGarvey','Jeffrey Ford, Lisa Lassek','Marvel Studios','Walt Disney Studios Motion Pictures','2012-04-11',143,'United States','English',220,1519),('The Incredible Hulk','Louis Leterrier','Avi Arad, Gale Anne Hurd, Kevin Feige','Zak Penn',NULL,'Hulk','Edward Norton, Liv Tyler, Tim Roth, Tim Blake Nelson, Ty Burrell, William Hurt','Craig Armstrong','Peter Menzies Jr.','John Wright, Rick Shaine, Vincent Tabaillon','Marvel Studios, Fairview Entertainment','Universal Pictures','2008-06-08',112,'United States','English',150,263.4),('Thor','Kenneth Branagh','Kevin Feige','Ashley Edward Miller, Zack Stentz, Don Payne','Ashley Edward Miller, Zack Stentz, Don Payne','Thor','Chris Hemsworth, Natalie Portman, Tom Hiddleston, Stellan Skarsgård, Colm ','Patrick Doyle','Haris Zambarloukos','Paul Rubell','Marvel Studios','Paramount Pictures','2011-04-17',114,'United States','English',150,499.3),('Thor: Ragnarok','Taika Waititi','Kevin Feige','Eric Pearson, Craig Kyle, Christopher L. Yost',NULL,'Thor','Chris Hemsworth, Tom Hiddleston, Cate Blanchett, Idris Elba, Jeff Goldblum, Tessa Thompson, Karl Urban, Mark Ruffalo, Anthony Hopkins','Mark Mothersbaugh','Javier Aguirresarobe','Joel Negron, Zene Baker','Marvel Studios','Walt Disney Studios Motion Pictures','2017-10-10',130,'United States','English',180,854),('Thor: The Dark World','Alan Taylor','Kevin Feige','Christopher Yost, Stephen McFeely, Christopher Markus','Don Payne, Robert Rodat','Thor','Chris Hemsworth, Natalie Portman, Tom Hiddleston, Anthony Hopkins, Stellan Skarsgård, Idris Elba, Christopher Eccleston, Adewale Akinnuoye-Agbaje, Kat Dennings, Ray Stevenson, Zachary Levi, Tadanobu Asano, Jaimie Alexander, Rene Russo','Brian Tyler','Kramer Morgenthaut','Dan Lebental, Wyatt Smith','Marvel Studios','Walt Disney Studios Motion Pictures','2013-10-22',112,'United States','English',272,644.6);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'MCU'
--

--
-- Dumping routines for database 'MCU'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-17 22:12:56
