SELECT termek.nev, SUM(tetel.db)
FROM termek
LEFT OUTER JOIN tetel ON termek.id = tetel.termek_id
GROUP BY termek.nev;
