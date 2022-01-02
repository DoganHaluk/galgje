set names utf8mb4;
set charset utf8mb4;

drop database if exists galgje;
create database galgje charset utf8mb4;
use galgje;

CREATE TABLE categorieen (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    naam VARCHAR(50) NOT NULL
);

insert into categorieen(naam) values
('Landen'),
('Voedsel'),
('Dieren');

CREATE TABLE woorden (
    categorieId INT UNSIGNED NOT NULL,
    woord VARCHAR(50) NOT NULL,
    CONSTRAINT woordenCategorieen FOREIGN KEY (categorieId)
        REFERENCES categorieen (id)
);

insert into woorden(categorieId, woord) values
(1,'Belgie'),
(1,'Duitsland'),
(1,'Frankrijk'),
(1,'Nederland'),
(1,'Italie'),
(1,'Spanje'),
(1,'Engeland'),
(1,'Denemarken'),
(1,'Zwitserland'),
(1,'Turkije'),
(2,'aardappel'),
(2,'taart'),
(2,'mandarijn'),
(2,'broccoli'),
(2,'brood'),
(2,'fijnhakken'),
(2,'tomaten'),
(2,'knoflook'),
(2,'paddestoel'),
(2,'komkommer'),
(3,'leeuw'),
(3,'olifant'),
(3,'vlinder'),
(3,'valk'),
(3,'kakkerlak'),
(3,'tonijn'),
(3,'kameleon'),
(3,'kikker'),
(3,'inktvis'),
(3,'kwallen');

create user if not exists cursist identified by 'cursist';
grant select,insert,delete on categorieen to cursist;
grant select,insert,delete on woorden to cursist;