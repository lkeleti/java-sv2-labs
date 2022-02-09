-- SELECT orszag
-- FROM orszagok
-- WHERE orszag LIKE 'M%';

-- SELECT count(orszag) AS orszagok_szama
-- FROM orszagok
-- WHERE orszag LIKE 'M%';

-- SELECT orszag
-- FROM orszagok
-- WHERE orszag LIKE 'M%'
-- ORDER BY orszag DESC;

-- átlag terület, lakosság
-- Államformák száma
-- legsűrűbben lakott
-- legnagyobb főre, területre
-- Melyik az a 4 mely teröletében legközelebb van Mo területéhez
-- M betűvel kezdödő országok fővárosai fordított sorrenben
-- M betűvel kezdödő országok lakosság sorrendben, terület sorrendben


-- SELECT AVG(terulet)
-- FROM orszagok;

-- SELECT AVG(nepesseg)
-- FROM orszagok;

-- SELECT *
-- FROM orszagok
-- WHERE nepesseg = (SELECT MAX(nepesseg) FROM orszagok);

-- SELECT *
-- FROM orszagok
-- WHERE nepesseg = (SELECT MIN(nepesseg) FROM orszagok);

-- SELECT *
-- FROM orszagok
-- WHERE terulet = (SELECT MAX(terulet) FROM orszagok);

-- SELECT *
-- FROM orszagok
-- WHERE terulet = (SELECT MIN(terulet) FROM orszagok);

-- SELECT fovaros
-- FROM orszagok
-- WHERE orszag LIKE 'M%'
-- ORDER BY fovaros DESC;

-- SELECT orszag, nepesseg
-- FROM orszagok
-- WHERE orszag LIKE 'M%'
-- ORDER BY nepesseg;

-- SELECT orszag, terulet
-- FROM orszagok
-- WHERE orszag LIKE 'M%'
-- ORDER BY terulet DESC;

-- SELECT orszag, ABS(terulet -(SELECT terulet FROM orszagok WHERE orszag LIKE 'MAGYAR%')) AS kulonbseg
-- FROM orszagok
-- WHERE ABS(terulet - (SELECT terulet FROM orszagok WHERE orszag LIKE 'MAGYAR%')) >= 0
-- ORDER BY kulonbseg
-- LIMIT 4;

-- SELECT orszag, ABS(nepesseg -(SELECT nepesseg FROM orszagok WHERE orszag LIKE 'MAGYAR%')) AS kulonbseg
-- FROM orszagok
-- WHERE ABS(nepesseg - (SELECT nepesseg FROM orszagok WHERE orszag LIKE 'MAGYAR%')) >= 0
-- ORDER BY kulonbseg
-- LIMIT 4;
