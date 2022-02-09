SELECT termek.nev, rendeles.ido
FROM termek
INNER JOIN tetel ON termek.id = tetel.rendeles_id
INNER JOIN rendeles ON tetel.rendeles_id = rendeles.id
WHERE rendeles.ido < 12;