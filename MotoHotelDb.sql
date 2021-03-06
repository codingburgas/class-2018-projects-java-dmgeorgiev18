USE [master]
GO
/****** Object:  Database [MotoHotel]    Script Date: 6/13/2022 2:30:06 PM ******/
CREATE DATABASE [MotoHotel]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MotoHotel', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\MotoHotel.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'MotoHotel_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\MotoHotel_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [MotoHotel] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MotoHotel].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MotoHotel] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MotoHotel] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MotoHotel] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MotoHotel] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MotoHotel] SET ARITHABORT OFF 
GO
ALTER DATABASE [MotoHotel] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [MotoHotel] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MotoHotel] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MotoHotel] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MotoHotel] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MotoHotel] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MotoHotel] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MotoHotel] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MotoHotel] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MotoHotel] SET  DISABLE_BROKER 
GO
ALTER DATABASE [MotoHotel] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MotoHotel] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MotoHotel] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MotoHotel] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MotoHotel] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MotoHotel] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MotoHotel] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MotoHotel] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [MotoHotel] SET  MULTI_USER 
GO
ALTER DATABASE [MotoHotel] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MotoHotel] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MotoHotel] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MotoHotel] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [MotoHotel] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [MotoHotel] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [MotoHotel] SET QUERY_STORE = OFF
GO
USE [MotoHotel]
GO
/****** Object:  Table [dbo].[Motor]    Script Date: 6/13/2022 2:30:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Motor](
	[MotorId] [int] IDENTITY(1,1) NOT NULL,
	[Plate] [nvarchar](20) NOT NULL,
	[Brand] [nvarchar](50) NOT NULL,
	[Model] [nvarchar](50) NOT NULL,
	[ParkingId] [int] NOT NULL,
	[date] [datetime] NOT NULL,
	[SubscriptionId] [int] NULL,
 CONSTRAINT [PK_Motor] PRIMARY KEY CLUSTERED 
(
	[MotorId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MotorRegistration]    Script Date: 6/13/2022 2:30:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MotorRegistration](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[MotorId] [int] NOT NULL,
	[DateTime] [datetime2](7) NOT NULL,
 CONSTRAINT [PK_MotorRegistration] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MotorSubscription]    Script Date: 6/13/2022 2:30:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MotorSubscription](
	[MotorId] [int] IDENTITY(1,1) NOT NULL,
	[SubscriptionId] [int] NOT NULL,
 CONSTRAINT [PK_MotorSubscription] PRIMARY KEY CLUSTERED 
(
	[MotorId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Parking]    Script Date: 6/13/2022 2:30:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Parking](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[MotoNumber] [nvarchar](50) NOT NULL,
	[AvailableSpace] [int] NOT NULL,
 CONSTRAINT [PK_Parking_1] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Subscription]    Script Date: 6/13/2022 2:30:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subscription](
	[SubscriptionsId] [int] IDENTITY(1,1) NOT NULL,
	[Duration] [nvarchar](50) NOT NULL,
	[Price] [int] NOT NULL,
 CONSTRAINT [PK_Subscription] PRIMARY KEY CLUSTERED 
(
	[SubscriptionsId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 6/13/2022 2:30:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[UserId] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [nvarchar](50) NOT NULL,
	[LastName] [nvarchar](50) NOT NULL,
	[Email] [varchar](100) NOT NULL,
	[Username] [nvarchar](50) NOT NULL,
	[Password] [varbinary](max) NOT NULL,
	[ParkingId] [int] NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Motor]  WITH CHECK ADD  CONSTRAINT [FK_Motor_Parking] FOREIGN KEY([ParkingId])
REFERENCES [dbo].[Parking] ([Id])
GO
ALTER TABLE [dbo].[Motor] CHECK CONSTRAINT [FK_Motor_Parking]
GO
ALTER TABLE [dbo].[MotorRegistration]  WITH CHECK ADD  CONSTRAINT [FK_MotorRegistration_Motor] FOREIGN KEY([MotorId])
REFERENCES [dbo].[Motor] ([MotorId])
GO
ALTER TABLE [dbo].[MotorRegistration] CHECK CONSTRAINT [FK_MotorRegistration_Motor]
GO
ALTER TABLE [dbo].[MotorSubscription]  WITH CHECK ADD  CONSTRAINT [FK_MotorSubscription_Motor] FOREIGN KEY([MotorId])
REFERENCES [dbo].[Motor] ([MotorId])
GO
ALTER TABLE [dbo].[MotorSubscription] CHECK CONSTRAINT [FK_MotorSubscription_Motor]
GO
ALTER TABLE [dbo].[MotorSubscription]  WITH CHECK ADD  CONSTRAINT [FK_MotorSubscription_Subscription1] FOREIGN KEY([SubscriptionId])
REFERENCES [dbo].[Subscription] ([SubscriptionsId])
GO
ALTER TABLE [dbo].[MotorSubscription] CHECK CONSTRAINT [FK_MotorSubscription_Subscription1]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_User_Parking1] FOREIGN KEY([ParkingId])
REFERENCES [dbo].[Parking] ([Id])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_User_Parking1]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [CK_Email] CHECK  (([Email] like '%_@__%.__%'))
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [CK_Email]
GO
/****** Object:  StoredProcedure [dbo].[Procedura]    Script Date: 6/13/2022 2:30:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Dimitar Georgiev>
-- Create date: <13/6/2022>
-- Description:	<Description>
-- =============================================
CREATE PROCEDURE [dbo].[Procedura] 
	-- Add the parameters for the stored procedure here
	@FirstName nvarchar(50),
	@LastName nvarchar(50),
	@Email varchar(100),
	@Username nvarchar(50),
	@Password nvarchar(50),
	@ParkingId int

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

  INSERT INTO [User](FirstName,LastName,
						Email,Username,[Password],ParkingId)
   VALUES (
	@FirstName,
	@LastName,
	@Email ,
	@Username,
	CONVERT(varbinary(MAX),EncryptByPassPhrase('motorcbr', @Password), 2),
	@ParkingId )
END
GO
USE [master]
GO
ALTER DATABASE [MotoHotel] SET  READ_WRITE 
GO
