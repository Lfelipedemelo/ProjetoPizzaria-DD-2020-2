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
    , TelefoneCliente varchar(14) not null
    , primary key (IdPizza)
);



create table Cliente (
	  IdCliente int not null auto_increment
    , Nome varchar(130) not null
    , Telefone varchar(14) not null
    , endereco varchar(150) not null
    , primary key(IdCliente)
);


SELECT * FROM CLIENTE;
insert into CLIENTE VALUES (1, 'Bryan Richard Lohn', 48984797911, 'servidão são lázaro');
insert into CLIENTE VALUES (2, 'Luis Felipe', 4896321580, 'servidão seu zico');
insert into CLIENTE VALUES (3, 'Antonio Ademir', 48984583128, 'servidão Afonso');
insert into CLIENTE VALUES (4, 'Ademar Felix', 49998801520, 'servidão Izabel Mendes');
insert into CLIENTE VALUES (5, 'Lucas Orildo', 41988583290, 'Rua do Baby');
insert into CLIENTE VALUES (6, 'Rolland Escad Abaixo', 81972803020, 'Rua Daqueles Canto');
insert into CLIENTE VALUES (7, 'Goiab Assadan Amanteiga', 48984554422, 'Rua das Ruas');
insert into CLIENTE VALUES (8, 'Pimpolho Tade Olho', 48996315820, 'Rua do Pimpo');
insert into CLIENTE VALUES (9, 'Henrique Ixtopo', 47985283020, 'Rua do Canalha');
