SELECT ar, id, nev
FROM termek
WHERE termek.ar = (SELECT MAX(ar) FROM termek);