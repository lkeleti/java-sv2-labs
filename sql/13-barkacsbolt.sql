SELECT *
FROM termek
LEFT outer JOIN tetel ON termek.id = tetel.termek_id
WHERE tetel.termek_id IS NULL;