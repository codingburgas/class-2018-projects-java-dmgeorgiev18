-- ================================================
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Dimitar Georgiev>
-- Create date: <13/6/2022>
-- Description:	<HashThePass>
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

  INSERT INTO [Users](FirstName,LastName,
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
ALTER DATABASE [Parking_Lot] SET  READ_WRITE
GO
