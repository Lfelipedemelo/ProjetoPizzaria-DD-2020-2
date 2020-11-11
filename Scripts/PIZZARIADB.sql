create database PIZZARIADB;
use PIZZARIADB;

create table Pizza (
	  IdPizza int not null auto_increment
    , Sabor1 varchar(45)
    , Sabor2 varchar(45)
    , Sabor3 varchar(45)
    , Tamanho varchar(45) not null
    , Valor Double not null
    , Observacoes varchar(250)
    , TelefoneCliente varchar()14 not null
	, primary key (IdPizza)
);



create table Cliente (
	  IdCliente int not null auto_increment
    , Nome varchar(130) not null
    , Telefone varchar(13) not null
    , Endereco varchar(150) not null
    , PesquisarNome varchar(130)
    , primary key(IdCliente)
);