SELECT rendeles.id, rendeles.datum, rendeles.ido, elado.nev AS elado
FROM rendeles
INNER JOIN elado ON rendeles.elado_id = elado.id;