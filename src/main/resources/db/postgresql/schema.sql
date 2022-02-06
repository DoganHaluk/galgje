begin; 
set transaction read write;

DROP TABLE IF EXISTS "public"."categorieen" CASCADE;
CREATE TABLE "public"."categorieen" ("id" BIGSERIAL NOT NULL, "naam" VARCHAR(50)  NOT NULL);
ALTER SEQUENCE "public"."categorieen_id_seq" RESTART WITH 4 INCREMENT BY 1;
DROP INDEX IF EXISTS "PRIMARY";
ALTER TABLE "public"."categorieen" ADD CONSTRAINT "PRIMARY" PRIMARY KEY ("id");

INSERT INTO "public"."categorieen"("id", "naam") VALUES (1, 'Landen');
INSERT INTO "public"."categorieen"("id", "naam") VALUES (2, 'Voedsel');
INSERT INTO "public"."categorieen"("id", "naam") VALUES (3, 'Dieren');

DROP TABLE IF EXISTS "public"."woorden" CASCADE;
CREATE TABLE "public"."woorden" ("categorieid" BIGINT NOT NULL, "woord" VARCHAR(50)  NOT NULL);
DROP INDEX IF EXISTS "woordenCategorieen";
CREATE INDEX "woordenCategorieen" ON "public"."woorden" ("categorieid");


INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (1, 'Belgie');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (1, 'Duitsland');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (1, 'Frankrijk');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (1, 'Nederland');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (1, 'Italie');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (1, 'Spanje');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (1, 'Engeland');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (1, 'Denemarken');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (1, 'Zwitserland');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (1, 'Turkije');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (2, 'aardappel');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (2, 'taart');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (2, 'mandarijn');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (2, 'broccoli');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (2, 'brood');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (2, 'fijnhakken');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (2, 'tomaten');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (2, 'knoflook');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (2, 'paddestoel');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (2, 'komkommer');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (3, 'leeuw');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (3, 'olifant');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (3, 'vlinder');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (3, 'valk');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (3, 'kakkerlak');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (3, 'tonijn');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (3, 'kameleon');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (3, 'kikker');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (3, 'inktvis');
INSERT INTO "public"."woorden"("categorieid", "woord") VALUES (3, 'kwallen');

commit;
