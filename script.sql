USE [master]
GO
/****** Object:  Database [BookManagement]    Script Date: 11/15/2021 1:17:30 AM ******/
CREATE DATABASE [BookManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BookManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\BookManagement.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BookManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\BookManagement_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [BookManagement] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BookManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BookManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BookManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BookManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BookManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BookManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [BookManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BookManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BookManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BookManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BookManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BookManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BookManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BookManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BookManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BookManagement] SET  ENABLE_BROKER 
GO
ALTER DATABASE [BookManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BookManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BookManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BookManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BookManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BookManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BookManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BookManagement] SET RECOVERY FULL 
GO
ALTER DATABASE [BookManagement] SET  MULTI_USER 
GO
ALTER DATABASE [BookManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BookManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BookManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BookManagement] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BookManagement] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'BookManagement', N'ON'
GO
ALTER DATABASE [BookManagement] SET QUERY_STORE = OFF
GO
USE [BookManagement]
GO
/****** Object:  Table [dbo].[Book]    Script Date: 11/15/2021 1:17:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Book](
	[ISBN] [varchar](20) NOT NULL,
	[Title] [nvarchar](100) NOT NULL,
	[Author] [nvarchar](50) NULL,
	[Price] [decimal](2, 0) NOT NULL,
	[Brief] [nvarchar](max) NULL,
	[Status] [bit] NOT NULL,
	[Description] [nvarchar](max) NULL,
	[Image] [varchar](max) NULL,
	[CategoryID] [varchar](10) NULL,
	[PublisherID] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[ISBN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 11/15/2021 1:17:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CategoryID] [varchar](10) NOT NULL,
	[CategoryName] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 11/15/2021 1:17:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[OrderID] [varchar](10) NOT NULL,
	[CreateDate] [date] NOT NULL,
	[UserID] [varchar](10) NULL,
	[NameUser] [varchar](200) NULL,
	[Total] [decimal](2, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 11/15/2021 1:17:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[OrderDetailID] [int] IDENTITY(1,1) NOT NULL,
	[NameBook] [varchar](200) NOT NULL,
	[Quantity] [int] NOT NULL,
	[Price] [decimal](2, 0) NOT NULL,
	[OrderID] [varchar](10) NULL,
	[BookID] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderDetailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Publisher]    Script Date: 11/15/2021 1:17:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Publisher](
	[PublisherID] [varchar](10) NOT NULL,
	[PublisherName] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NULL,
	[Address] [nvarchar](100) NULL,
	[Phone] [varchar](20) NULL,
	[Image] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[PublisherID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 11/15/2021 1:17:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[RoleID] [varchar](10) NOT NULL,
	[RoleName] [nvarchar](20) NULL,
	[Description] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 11/15/2021 1:17:30 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[UserID] [varchar](10) NOT NULL,
	[FullName] [nvarchar](50) NOT NULL,
	[Phone] [varchar](20) NULL,
	[Address] [nvarchar](50) NULL,
	[Username] [varchar](20) NOT NULL,
	[Password] [varchar](20) NOT NULL,
	[Status] [bit] NOT NULL,
	[Image] [varchar](max) NULL,
	[RoleID] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Book] ([ISBN], [Title], [Author], [Price], [Brief], [Status], [Description], [Image], [CategoryID], [PublisherID]) VALUES (N'9780060888695', N'To Kill a Mockingbird', N'Harper Lee', CAST(15 AS Decimal(2, 0)), NULL, 1, N'One of the most cherished stories of all time, To Kill a Mockingbird has been translated into more than forty languages, sold more than forty million copies worldwide, served as the basis for an enormously popular motion picture, and was voted one of the best novels of the twentieth century by librarians across the country. A gripping, heart-wrenching, and wholly remarkable tale of coming-of-age in a South poisoned by virulent prejudice, it views a world of great beauty and savage inequities through the eyes of a young girl, as her father—a crusading local lawyer—risks everything to defend a black man unjustly accused of a terrible crime.', N'to_kill_mockingbird.jpg', N'Cat003', N'Pub003')
INSERT [dbo].[Book] ([ISBN], [Title], [Author], [Price], [Brief], [Status], [Description], [Image], [CategoryID], [PublisherID]) VALUES (N'9780330305372', N'Beloved', N'Toni Morrison', CAST(10 AS Decimal(2, 0)), NULL, 1, N'Sethe, its protagonist, was born a slave and escaped to Ohio, but eighteen years later she is still not free. She has too many memories of Sweet Home, the beautiful farm where so many hideous things happened. And Sethe’s new home is haunted by the ghost of her baby, who died nameless and whose tombstone is engraved with a single word: Beloved. Filled with bitter poetry and suspense as taut as a rope, Beloved is a towering achievement.', N'beloved.jpg', N'Cat003', N'Pub003')
INSERT [dbo].[Book] ([ISBN], [Title], [Author], [Price], [Brief], [Status], [Description], [Image], [CategoryID], [PublisherID]) VALUES (N'9780930289232', N'Watchmen', N' Alan Moore', CAST(8 AS Decimal(2, 0)), NULL, 1, N'A hit HBO original series, Watchmen, the groundbreaking series from award-winning author Alan Moore, presents a world where the mere presence of American superheroes changed history--the U.S. won the Vietnam War, Nixon is still president, and the Cold War is in full effect.', N'watchmen.jpg', N'Cat004', N'Pub002')
INSERT [dbo].[Book] ([ISBN], [Title], [Author], [Price], [Brief], [Status], [Description], [Image], [CategoryID], [PublisherID]) VALUES (N'9781565117808', N'Life of Pi', N'Yann Martel', CAST(9 AS Decimal(2, 0)), N'', 1, N'The son of a zookeeper, Pi Patel has an encyclopedic knowledge of animal behavior and a fervent love of stories. When Pi is sixteen, his family emigrates from India to North America aboard a Japanese cargo ship, along with their zoo animals bound for new homes.', N'life_of_pi.jpg', N'Cat002', N'Pub001')
INSERT [dbo].[Book] ([ISBN], [Title], [Author], [Price], [Brief], [Status], [Description], [Image], [CategoryID], [PublisherID]) VALUES (N'9781607060765', N'The Walking Dead: Compendium One', N'Robert Kirkman', CAST(32 AS Decimal(2, 0)), NULL, 0, N'Introducing the first eight volumes of the fan-favorite, New York Times Best Seller series collected into one massive paperback collection! Collects The Walking Dead #1-48. This is the perfect collection for any fan of the Emmy Award-winning television series on AMC: over one thousand pages chronicling the beginning of Robert Kirkman''s Eisner Award-winning continuing story of survival horror- from Rick Grimes'' waking up alone in a hospital, to him and his family seeking solace on Hershel''s farm, and the controversial introduction of Woodbury despot: The Governor. In a world ruled by the dead, we are finally forced to finally start living.
', N'the_walking_dead.jpg', N'Cat004', N'Pub002')
INSERT [dbo].[Book] ([ISBN], [Title], [Author], [Price], [Brief], [Status], [Description], [Image], [CategoryID], [PublisherID]) VALUES (N'9783401716947', N'The Three Musketeers', N'Alexandre Dumas', CAST(15 AS Decimal(2, 0)), NULL, 1, N'NULLThe Three Musketeers is a novel by Alexandre Dumas. Set in the 17th century, it recounts the adventures of a young man named d''Artagnan after he leaves home to travel to Paris, to join the Musketeers of the Guard. D''Artagnan is not one of the musketeers of the title; those being his friends Athos, Porthos and Aramis, inseparable friends who live by the motto "all for one, one for all", a motto which is first put forth by d''Artagnan. In genre, The Three Musketeers is primarily a historical novel and adventure. However Dumas also frequently works into the plot various injustices, abuses and absurdities of the ancien regime, giving the novel an additional political aspect at a time when the debate in France between republicans and monarchists was still fierce. The story was first serialized from March to July 1844, during the July monarchy, four years before the French Revolution of 1848 violently established the second Republic. The author''s father, Thomas-Alexandre Dumas had been a well-known general in France''s Republican army during the French revolutionary wars. Although adaptations tend to portray d''Artagnan and the three musketeers as heroes, the novel portrays less appealing characters, who are willing to commit violence over slight insults and through unquestioning loyalty to the king and queen, and treat their servants and supposed social inferiors with contempt and violence.', N'the_three_musketeer.jpg', N'Cat002', N'Pub002')
INSERT [dbo].[Book] ([ISBN], [Title], [Author], [Price], [Brief], [Status], [Description], [Image], [CategoryID], [PublisherID]) VALUES (N'9783471360217', N'The Boy, the Mole, the Fox and the Horse', N'Charlie Mackesy', CAST(14 AS Decimal(2, 0)), NULL, 0, N'“The Boy, the Mole, the Fox and the Horse is not only a thought-provoking, discussion-worthy story, the book itself is an object of art.”- Elizabeth Egan, The New York Times', N'the_boy_mole_Fox.jpg', N'Cat004', N'Pub001')
INSERT [dbo].[Book] ([ISBN], [Title], [Author], [Price], [Brief], [Status], [Description], [Image], [CategoryID], [PublisherID]) VALUES (N'9788809810570', N'Little Women ', N'Louisa May Alcott', CAST(12 AS Decimal(2, 0)), NULL, 1, N'For generations, children around the world have come of age with Louisa May Alcott''s March girls: hardworking eldest sister Meg, headstrong, impulsive Jo, timid Beth, and precocious Amy. With their father away at war, and their loving mother Marmee working to support the family, the four sisters have to rely on one another for support as they endure the hardships of wartime and poverty. We witness the sisters growing up and figuring out what role each wants to play in the world, and, along the way, join them on countless unforgettable adventures.', N'little_women.jpg', N'Cat003', N'Pub004')
INSERT [dbo].[Book] ([ISBN], [Title], [Author], [Price], [Brief], [Status], [Description], [Image], [CategoryID], [PublisherID]) VALUES (N'9788838439018', N'The Call of the Wild', N'Jack London', CAST(6 AS Decimal(2, 0)), NULL, 1, N'The Call of the Wild is a novel by Jack London published in 1903. The story is set in the Yukon during the 1890s Klondike Gold Rush—a period in which strong sled dogs were in high demand. The novel''s central character is a dog named Buck, a domesticated dog living at a ranch in the Santa Clara Valley of California as the story opens. Stolen from his home and sold into service as sled dog in Alaska, he reverts to a wild state. Buck is forced to fight in order to dominate other dogs in a harsh climate. Eventually he sheds the veneer of civilization, relying on primordial instincts and learned experience to emerge as a leader in the wild.London lived for most of a year in the Yukon collecting material for the book. The story was serialized in the Saturday Evening Post in the summer of 1903; a month later it was released in book form. The novel’s great popularity and success made a reputation for London. Much of its appeal derives from the simplicity of this tale of survival. As early as 1908 the story was adapted to film and it has since seen several more cinematic adaptations.', N'the_call_of_the_wild.jpg', N'Cat002', N'Pub001')
GO
INSERT [dbo].[Category] ([CategoryID], [CategoryName]) VALUES (N'Cat001', N'World Politics')
INSERT [dbo].[Category] ([CategoryID], [CategoryName]) VALUES (N'Cat002', N'Action and Adventure')
INSERT [dbo].[Category] ([CategoryID], [CategoryName]) VALUES (N'Cat003', N'Classics')
INSERT [dbo].[Category] ([CategoryID], [CategoryName]) VALUES (N'Cat004', N'Comic Book')
INSERT [dbo].[Category] ([CategoryID], [CategoryName]) VALUES (N'Cat005', N'Detective ')
INSERT [dbo].[Category] ([CategoryID], [CategoryName]) VALUES (N'Cat006', N'Fantasy')
GO
INSERT [dbo].[Order] ([OrderID], [CreateDate], [UserID], [NameUser], [Total]) VALUES (N'IV001', CAST(N'2021-11-01' AS Date), N'Emp001', NULL, CAST(23 AS Decimal(2, 0)))
INSERT [dbo].[Order] ([OrderID], [CreateDate], [UserID], [NameUser], [Total]) VALUES (N'IV002', CAST(N'2021-11-01' AS Date), N'Emp002', NULL, CAST(38 AS Decimal(2, 0)))
INSERT [dbo].[Order] ([OrderID], [CreateDate], [UserID], [NameUser], [Total]) VALUES (N'IV003', CAST(N'2021-11-10' AS Date), N'Emp001', NULL, CAST(66 AS Decimal(2, 0)))
INSERT [dbo].[Order] ([OrderID], [CreateDate], [UserID], [NameUser], [Total]) VALUES (N'IV004', CAST(N'2021-11-12' AS Date), N'Emp001', NULL, CAST(38 AS Decimal(2, 0)))
INSERT [dbo].[Order] ([OrderID], [CreateDate], [UserID], [NameUser], [Total]) VALUES (N'IV005', CAST(N'2021-11-14' AS Date), N'Emp002', NULL, CAST(59 AS Decimal(2, 0)))
GO
SET IDENTITY_INSERT [dbo].[OrderDetail] ON 

INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (1, N'To Kill a Mockingbird', 2, CAST(15 AS Decimal(2, 0)), N'IV001', N'9780060888695')
INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (2, N'Watchmen', 1, CAST(8 AS Decimal(2, 0)), N'IV001', N'9780930289232')
INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (3, N'To Kill a Mockingbird', 2, CAST(15 AS Decimal(2, 0)), N'IV002', N'9780060888695')
INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (4, N'Watchmen', 1, CAST(8 AS Decimal(2, 0)), N'IV002', N'9780930289232')
INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (5, N'The Three Musketeers', 1, CAST(15 AS Decimal(2, 0)), N'IV002', N'9783401716947')
INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (6, N'The Walking Dead: Compendium One', 1, CAST(32 AS Decimal(2, 0)), N'IV003', N'9781607060765')
INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (7, N'The Boy, the Mole, the Fox and the Horse', 2, CAST(14 AS Decimal(2, 0)), N'IV003', N'9783471360217')
INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (8, N'The Boy, the Mole, the Fox and the Horse', 1, CAST(14 AS Decimal(2, 0)), N'IV003', N'9783471360217')
INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (9, N'The Call of the Wild', 1, CAST(6 AS Decimal(2, 0)), N'IV003', N'9788838439018')
INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (10, N'Watchmen', 1, CAST(8 AS Decimal(2, 0)), N'IV004', N'9780930289232')
INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (11, N'The Three Musketeers', 2, CAST(15 AS Decimal(2, 0)), N'IV004', N'9783401716947')
INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (12, N'The Three Musketeers', 1, CAST(15 AS Decimal(2, 0)), N'IV004', N'9783401716947')
INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (13, N'Watchmen', 1, CAST(8 AS Decimal(2, 0)), N'IV005', N'9780930289232')
INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (14, N'The Three Musketeers', 2, CAST(15 AS Decimal(2, 0)), N'IV005', N'9783401716947')
INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (15, N'The Three Musketeers', 1, CAST(15 AS Decimal(2, 0)), N'IV005', N'9783401716947')
INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (16, N'Life of Pi', 1, CAST(9 AS Decimal(2, 0)), N'IV005', N'9781565117808')
INSERT [dbo].[OrderDetail] ([OrderDetailID], [NameBook], [Quantity], [Price], [OrderID], [BookID]) VALUES (17, N'Little Women ', 1, CAST(12 AS Decimal(2, 0)), N'IV005', N'9788809810570')
SET IDENTITY_INSERT [dbo].[OrderDetail] OFF
GO
INSERT [dbo].[Publisher] ([PublisherID], [PublisherName], [Email], [Address], [Phone], [Image]) VALUES (N'Pub001', N'Seven Stories Press', N'anne@sevenstories.com', N'New York City, US', N'202-555-0193', N'Pub001.png')
INSERT [dbo].[Publisher] ([PublisherID], [PublisherName], [Email], [Address], [Phone], [Image]) VALUES (N'Pub002', N'Candlewick Press', N'anne@sevenstories.com', N'Boston, US', N'202-555-0128', N'Pub002.jpg')
INSERT [dbo].[Publisher] ([PublisherID], [PublisherName], [Email], [Address], [Phone], [Image]) VALUES (N'Pub003', N'New Directions', N'anne@sevenstories.com', N'New York City, US', N'202-555-0195', N'Pub003.jpg')
INSERT [dbo].[Publisher] ([PublisherID], [PublisherName], [Email], [Address], [Phone], [Image]) VALUES (N'Pub004', N'Akashic Books', N'anne@sevenstories.com', N'New York City, US', N'202-555-0120', N'Pub004.jpg')
GO
INSERT [dbo].[Role] ([RoleID], [RoleName], [Description]) VALUES (N'1', N'Admin', N'Quan tri vien')
INSERT [dbo].[Role] ([RoleID], [RoleName], [Description]) VALUES (N'2', N'User', N'Nhan vien')
GO
INSERT [dbo].[User] ([UserID], [FullName], [Phone], [Address], [Username], [Password], [Status], [Image], [RoleID]) VALUES (N'Emp001', N'Nguyen Thi Thao Nguyen', N'0908123456', N'Da Nang', N'thaonguyen', N'123', 1, N'Emp001.png', N'1')
INSERT [dbo].[User] ([UserID], [FullName], [Phone], [Address], [Username], [Password], [Status], [Image], [RoleID]) VALUES (N'Emp002', N'Huynh Huu Hieu', N'0903654321', N'Gia Lai', N'huuhieu', N'123', 1, N'Emp002.png', N'2')
GO
ALTER TABLE [dbo].[Book] ADD  DEFAULT ((0)) FOR [Price]
GO
ALTER TABLE [dbo].[Book] ADD  DEFAULT ((0)) FOR [Status]
GO
ALTER TABLE [dbo].[User] ADD  DEFAULT ((0)) FOR [Status]
GO
ALTER TABLE [dbo].[Book]  WITH CHECK ADD FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Category] ([CategoryID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Book]  WITH CHECK ADD FOREIGN KEY([PublisherID])
REFERENCES [dbo].[Publisher] ([PublisherID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[User] ([UserID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([BookID])
REFERENCES [dbo].[Book] ([ISBN])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([OrderID])
REFERENCES [dbo].[Order] ([OrderID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD FOREIGN KEY([RoleID])
REFERENCES [dbo].[Role] ([RoleID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
USE [master]
GO
ALTER DATABASE [BookManagement] SET  READ_WRITE 
GO
