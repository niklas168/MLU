-- Teilaufgabe 2.1 b)

SELECT pres_name, hobby -- gesucht: Präsidentennamen und deren hobbies
FROM pres_hobby
WHERE UPPER(hobby) LIKE UPPER('%ball%') -- Bedingung: das Wort Ball muss im Hobby vorhanden sein (unabhängig von Gro?/Klein-Schreibung)
