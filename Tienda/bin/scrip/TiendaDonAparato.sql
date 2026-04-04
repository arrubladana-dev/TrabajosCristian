create database DonAparatoTienda;

use DonAparatoTienda;

create table Usuario(
idDocumento varchar(10) primary key,
nombreUsuario varchar(30),
ApellidoUsuario varchar(30),
edad int,
telefono varchar(10),
tipo varchar(1)
);
-- Tabla producto
create table Producto(
idCodigoProducto varchar(20) primary key,
nombreProducto varchar(20),
precio int,
cantidad int
);
drop table Producto;
drop table FacturaCompra;
-- Tabla Factura. compra
 create table FacturaCompra(
 idFacturaCodigo int auto_increment primary key,
 descuento double, 
 compraRealizada double,
  total double,
  documento varchar(20),
  codigoProducto varchar(20),
  foreign key (documento) references Usuario(idDocumento),
  foreign key (codigoProducto) references Producto(idCodigoProducto)
 );
 
 select*from Usuario;
  select*from Producto;
 
 DELETE FROM usuario WHERE idDocumento = "1";
 
 
