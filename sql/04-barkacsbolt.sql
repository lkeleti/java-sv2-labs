SELECT termek.nev, SUM(tetel.db) AS db, SUM(termek.ar * tetel.db) AS ar
FROM termek
INNER JOIN tetel ON termek.id = tetel.termek_id
GROUP BY termek.nev;
