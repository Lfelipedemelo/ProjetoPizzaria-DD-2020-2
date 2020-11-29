drop database if exists pizzariadb;
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

insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('ALHO E ÓLEO', 'BACON', 'BOLONHESA', 'GIGANTE', 56.90, '', '48999216672');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('BRÓCOLIS', 'CALABRESA', 'FRANGO', 'GRANDE', 52.90, '', '48999970889');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('LOMBINHO', 'MARGUERITA', 'MUSSARELA', 'MEDIA', 46.90, '', '48984583128');
insert into PIZZA (sabor1, sabor2, tamanho, valor, observacoes, telefonecliente) values ('PORTUGUESA', 'QUATRO QUEIJOS', 'MEDIA', 46.90, '', '49998801520');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('ALHO E ÓLEO', 'BACON', 'BOLONHESA', 'GIGANTE', 56.90, '', '48999216672');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('BRÓCOLIS', 'CALABRESA', 'FRANGO', 'GRANDE', 52.90, '', '48996543211');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('LOMBINHO', 'MARGUERITA', 'MUSSARELA', 'MEDIA', 46.90, '', '48938797001');
insert into PIZZA (sabor1, tamanho, valor, observacoes, telefonecliente) values ('PORTUGUESA', 'BROTO', 32.90, '', '49998801520');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('ALHO E ÓLEO', 'BACON', 'BOLONHESA', 'GIGANTE', 56.90, '', '48999216672');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('BRÓCOLIS', 'CALABRESA', 'FRANGO', 'GRANDE', 52.90, '', '47985283020');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('LOMBINHO', 'MARGUERITA', 'MUSSARELA', 'MEDIA', 46.90, '', '48984554422');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('ALHO E ÓLEO', 'BACON', 'BOLONHESA', 'GIGANTE', 56.90, '', '48999216672');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('BRÓCOLIS', 'CALABRESA', 'FRANGO', 'GRANDE', 52.90, '', '48999999999');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('LOMBINHO', 'MARGUERITA', 'MUSSARELA', 'MEDIA', 46.90, '', '48984583128');
insert into PIZZA (sabor1, sabor2, tamanho, valor, observacoes, telefonecliente) values ('PORTUGUESA', 'QUATRO QUEIJOS', 'MEDIA', 46.90, '', '49998801520');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('ALHO E ÓLEO', 'BACON', 'BOLONHESA', 'GIGANTE', 56.90, '', '48998805020');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('BRÓCOLIS', 'CALABRESA', 'FRANGO', 'GRANDE', 52.90, '', '48996609787');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('LOMBINHO', 'MARGUERITA', 'MUSSARELA', 'MEDIA', 46.90, '', '48938797001');
insert into PIZZA (sabor1, tamanho, valor, observacoes, telefonecliente) values ('PORTUGUESA', 'BROTO', 32.90, '', '48991162738');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('ALHO E ÓLEO', 'BACON', 'BOLONHESA', 'GIGANTE', 56.90, '', '48991415161');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('BRÓCOLIS', 'CALABRESA', 'FRANGO', 'GRANDE', 52.90, '', '48933044144');
insert into PIZZA (sabor1, sabor2, sabor3, tamanho, valor, observacoes, telefonecliente) values ('LOMBINHO', 'MARGUERITA', 'MUSSARELA', 'MEDIA', 46.90, '', '48984554422');



SELECT * FROM CLIENTE;
insert into CLIENTE VALUES (1, 'Bryan Richard Lohn', 48999216672, 'servidão são Lázaro');
insert into CLIENTE VALUES (2, 'Luis Felipe', 48999970889, 'servidão seu zico');
insert into CLIENTE VALUES (3, 'Antonio Ademir', 48984583128, 'servidão Afonso');
insert into CLIENTE VALUES (4, 'Ademar Felix', 49998801520, 'servidão Izabel Mendes');
insert into CLIENTE VALUES (5, 'Lucas Orildo', 41988583290, 'Rua do Baby');
insert into CLIENTE VALUES (6, 'Rolland Escad Abaixo', 81972803020, 'Rua Daqueles Canto');
insert into CLIENTE VALUES (7, 'Goiab Assadan Amanteiga', 48984554422, 'Rua das Ruas');
insert into CLIENTE VALUES (8, 'Pimpolho Tade Olho', 48996315820, 'Rua do Pimpo');
insert into CLIENTE VALUES (9, 'Henrique Ricardo', 48985283020, 'Rua do Bagre');
insert into CLIENTE VALUES (10, 'Bruno Augusto', 48998389109, 'servidão são Lázaro');
insert into CLIENTE VALUES (11, 'Luiz Fernando', 48996183556, 'servidão seu zico');
insert into CLIENTE VALUES (12, 'Mario Gonzaga', 48933716117, 'servidão Afonso');
insert into CLIENTE VALUES (13, 'Arlindo Cruz', 48938797001, 'servidão Izabel Mendes');
insert into CLIENTE VALUES (14, 'Lucas da silva', 48933690208, 'Rua do Baby');
insert into CLIENTE VALUES (15, 'Arthur Aguilar', 48932118219, 'Rua Daqueles Canto');
insert into CLIENTE VALUES (16, 'Geisael machado', 48999999999, 'Rua das Ruas');
insert into CLIENTE VALUES (17, 'Bruna santos', 48111111111, 'Rua do Pimpo');
insert into CLIENTE VALUES (18, 'Maria Eduarda', 48222222222, 'Rua do Bagre');
insert into CLIENTE VALUES (19, 'Nelcivan Zen', 48988582832, 'servidão são Lázaro');
insert into CLIENTE VALUES (20, 'Valney Santos', 48921381540, 'servidão seu zico');
insert into CLIENTE VALUES (21, 'Alexandre Lohan', 48997182130, 'servidão Afonso');
insert into CLIENTE VALUES (22, 'Lindsey Maria', 48996102030, 'servidão Izabel Mendes');
insert into CLIENTE VALUES (23, 'Mariana da silva', 48996543211, 'Rua do Baby');
insert into CLIENTE VALUES (24, 'Ricardo Sales', 48933044144, 'Rua Daqueles Canto');
insert into CLIENTE VALUES (25, 'Altair Jr', 48996183556, 'Rua das Ruas');
insert into CLIENTE VALUES (26, 'Alexandre Lopes', 48933652022, 'Rua do Pimpo');
insert into CLIENTE VALUES (27, 'Sidnei Souza', 48933696722, 'Rua do Bagre');
insert into CLIENTE VALUES (28, 'Thiago Ademar', 48984057705, 'servidão são Lázaro');
insert into CLIENTE VALUES (29, 'Thiago Cruz', 48998805020, 'servidão seu zico');
insert into CLIENTE VALUES (30, 'Alexander Gomes', 48998899889, 'servidão Afonso');
insert into CLIENTE VALUES (31, 'Adriana Sinder', 48987788877, 'servidão Izabel Mendes');
insert into CLIENTE VALUES (32, 'José Adão', 48994455664, 'Rua do Baby');
insert into CLIENTE VALUES (33, 'Adauto Inácio da silva', 48995283020, 'Rua Daqueles Canto');
insert into CLIENTE VALUES (34, 'Adriano da silva viana', 48917375720, 'Rua das Ruas');
insert into CLIENTE VALUES (35, 'Ana Lúcia Caldas', 48991161516, 'Rua do Pimpo');
insert into CLIENTE VALUES (36, 'Antonio José Fagundes', 48991929394, 'Rua do Bagre');
insert into CLIENTE VALUES (37, 'Elisabete Maria da Silva', 48984858689, 'Rua do Pimpo');
insert into CLIENTE VALUES (38, 'José Henrique da silva', 48997766564, 'Rua do Bagre');
insert into CLIENTE VALUES (39, 'Aylter Maguila', 48991415161, 'servidão são Lázaro');
insert into CLIENTE VALUES (40, 'Ana Catia', 48933656530, 'servidão seu zico');
insert into CLIENTE VALUES (41, 'Afonso Jaccoud', 48995587423, 'servidão Afonso');
insert into CLIENTE VALUES (42, 'Andy Nery', 48996609999, 'servidão Izabel Mendes');
insert into CLIENTE VALUES (43, 'Ana Júlia Blaudt', 48996609787, 'Rua do Baby');
insert into CLIENTE VALUES (44, 'Mariana dos Reis', 48984797979, 'Rua Daqueles Canto');
insert into CLIENTE VALUES (45, 'Arão ivo Machado', 48984797920, 'Rua das Ruas');
insert into CLIENTE VALUES (46, 'Wanderson Vasconcellos', 48984797925, 'Rua do Pimpo');
insert into CLIENTE VALUES (47, 'Ademberg Taborda', 48984656565, 'Rua do Bagre');
insert into CLIENTE VALUES (48, 'Frajola Lun', 48984651747, 'Rua do Pimpo');
insert into CLIENTE VALUES (49, 'Harry Potter', 48985311758, 'Rua do Bagre');
insert into CLIENTE VALUES (50, 'Ronie Colleman', 48991162738, 'servidão são Lázaro');
insert into CLIENTE VALUES (51, 'Hermione Granger', 48991021414, 'servidão seu zico');
insert into CLIENTE VALUES (52, 'Ronie Wisley', 48991021418, 'servidão Afonso');
insert into CLIENTE VALUES (53, 'Draco Malfoy', 48991033525, 'servidão Izabel Mendes');
insert into CLIENTE VALUES (54, 'Severo Snap', 48997273840, 'Rua do Baby');
insert into CLIENTE VALUES (55, 'Albus Wolfric Bryan Dumbledore', 48994342528, 'Rua Daqueles Canto');
insert into CLIENTE VALUES (56, 'Mafalda Hopkirk', 48991473969, 'Rua das Ruas');
insert into CLIENTE VALUES (57, 'Neville Longbottom', 48998765432, 'Rua do Pimpo');
insert into CLIENTE VALUES (58, 'Rúbeo Hagrid', 48991234568, 'Rua do Bagre');

SELECT * FROM PIZZA;


