insert into categorieen(naam)
values ('test');
insert into woorden(categorieId, woord)
values ((select id from categorieen where naam = 'test'), 'testwoord');