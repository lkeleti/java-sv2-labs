SELECT COUNT(vasarlo.nev) AS Szende_vasarlasai
FROM vasarlo
INNER JOIN rendeles ON rendeles.vasarlo_id = vasarlo.id
WHERE vasarlo.nev = "Szende"
GROUP BY vasarlo.nev;