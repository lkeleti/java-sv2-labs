SELECT count(vasarlo.nev) AS countOfMorgoBuying
FROM vasarlo
INNER JOIN rendeles ON vasarlo.id = rendeles.vasarlo_id
WHERE vasarlo.nev = "Morgó"
GROUP BY vasarlo.nev;
