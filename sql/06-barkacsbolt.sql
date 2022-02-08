SELECT *
FROM termek
WHERE termek.ar = (
SELECT MIN(termek.ar)
FROM termek);
