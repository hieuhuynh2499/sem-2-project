USE BookManagement

ALTER TABLE OrderDetail
ADD [Description] NVARCHAR(MAX)


 ALTER TABLE OrderDetail
 ADD Total NVARCHAR(50)

 ALTER TABLE OrderDetail
 ADD Amount Decimal(2,0)

  ALTER TABLE [Order]
  DROP COLUMN Total;
    ALTER TABLE [Order]
  DROP COLUMN Amount;

   ALTER TABLE [Order]
  DROP COLUMN [Description]