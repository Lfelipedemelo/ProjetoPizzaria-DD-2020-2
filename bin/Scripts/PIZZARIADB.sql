create database PIZZARIADB;
use PIZZARIADB;

create table Pizza (
	  IdPizza int not null auto_increment
    , Sabor1 varchar(45)
    , Sabor2 varchar(45)
    , Sabor3 varchar(45)
    , Tamanho varchar(45) not null
    , Valor Double not null
	, primary key (IdPizza)
);



create table Cliente (
	  IdCliente int not null auto_increment
    , Nome varchar(130) not null
    , Telefone varchar(13) not null
    , endereco varchar(150) not null
    , primary key(IdCliente)
);