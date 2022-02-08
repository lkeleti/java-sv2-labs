SELECT vasarlo.nev AS ugyfel 
FROM vasarlo
INNER JOIN rendeles ON vasarlo.id = rendeles.vasarlo_id
INNER JOIN tetel ON rendeles.id = tetel.rendeles_id
WHERE tetel.rendeles_id = 1
GROUP BY vasarlo.nev;
