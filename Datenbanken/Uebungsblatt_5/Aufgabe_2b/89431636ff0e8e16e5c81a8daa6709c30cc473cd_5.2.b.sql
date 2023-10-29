-- Teilaufgabe 2.b)

SELECT A1.pres_name, p.birth_year
FROM pres_hobby A1, pres_hobby A2, president p
WHERE A1.pres_name = A2.pres_name
AND p.pres_name = A1.pres_name
AND (A1.hobby = 'Riding' AND A2.hobby = 'Golf')

