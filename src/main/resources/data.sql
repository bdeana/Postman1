/*INSERT INTO hardware (naziv, cijena, tip, sifra, kolicina)
VALUES ('H1', 100, 'CPU', 1234, 10);

INSERT INTO hardware (naziv, cijena, tip, sifra, kolicina)
VALUES ('H2', 200, 'GPU', 1235, 20);

INSERT INTO hardware (naziv, cijena, tip, sifra, kolicina)
VALUES ('H3', 300, 'MBO', 1235, 30);

INSERT INTO hardware (naziv, cijena, tip, sifra, kolicina)
VALUES ('H4', 400, 'RAM', 1236, 40);
*/


/*
INSERT INTO Type (naziv)
VALUES ('CPU');

INSERT INTO Type (naziv)
VALUES ('GPU');

INSERT INTO Type (naziv)
VALUES ('MBO');

INSERT INTO Type (naziv)
VALUES ('RAM');


INSERT INTO Hardware (naziv, cijena, tip_id, sifra, kolicina)
VALUES ('H1', 100, (SELECT id FROM Type WHERE naziv = 'CPU'), 1234, 10);

INSERT INTO Hardware (naziv, cijena, tip_id, sifra, kolicina)
VALUES ('H2', 200, (SELECT id FROM Type WHERE naziv = 'GPU'), 1235, 20);

INSERT INTO Hardware (naziv, cijena, tip_id, sifra, kolicina)
VALUES ('H3', 300, (SELECT id FROM Type WHERE naziv = 'MBO'), 1235, 30);

INSERT INTO Hardware (naziv, cijena, tip_id, sifra, kolicina)
VALUES ('H4', 400, (SELECT id FROM Type WHERE naziv = 'RAM'), 1236, 40);
*/


IF NOT EXISTS (SELECT 1 FROM Type WHERE naziv = 'CPU')
    INSERT INTO Type (naziv) VALUES ('CPU');

IF NOT EXISTS (SELECT 1 FROM Type WHERE naziv = 'GPU')
    INSERT INTO Type (naziv) VALUES ('GPU');

IF NOT EXISTS (SELECT 1 FROM Type WHERE naziv = 'MBO')
    INSERT INTO Type (naziv) VALUES ('MBO');

IF NOT EXISTS (SELECT 1 FROM Type WHERE naziv = 'RAM')
    INSERT INTO Type (naziv) VALUES ('RAM');


IF NOT EXISTS (SELECT 1 FROM Hardware WHERE sifra = 1234)
    INSERT INTO Hardware (naziv, cijena, tip_id, sifra, kolicina)
    VALUES (
        'H1',
        100,
        (SELECT id FROM Type WHERE naziv = 'CPU'),
        1234,
        10
    );

IF NOT EXISTS (SELECT 1 FROM Hardware WHERE sifra = 1235 AND naziv = 'H2')
    INSERT INTO Hardware (naziv, cijena, tip_id, sifra, kolicina)
    VALUES (
        'H2',
        200,
        (SELECT id FROM Type WHERE naziv = 'GPU'),
        1235,
        20
    );

IF NOT EXISTS (SELECT 1 FROM Hardware WHERE sifra = 1235 AND naziv = 'H3')
    INSERT INTO Hardware (naziv, cijena, tip_id, sifra, kolicina)
    VALUES (
        'H3',
        300,
        (SELECT id FROM Type WHERE naziv = 'MBO'),
        1235,
        30
    );

IF NOT EXISTS (SELECT 1 FROM Hardware WHERE sifra = 1236)
    INSERT INTO Hardware (naziv, cijena, tip_id, sifra, kolicina)
    VALUES (
        'H4',
        400,
        (SELECT id FROM Type WHERE naziv = 'RAM'),
        1236,
        40
    );