SELECT  rendeles.id, rendeles.datum, rendeles.ido, termek.nev
FROM rendeles
INNER JOIN tetel ON tetel.rendeles_id = rendeles.id
INNER JOIN termek ON tetel.termek_id = termek.id
WHERE rendeles.ido > 12.0;
