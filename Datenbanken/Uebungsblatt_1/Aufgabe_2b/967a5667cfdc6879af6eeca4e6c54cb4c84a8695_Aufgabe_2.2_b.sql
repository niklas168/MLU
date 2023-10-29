-- Teilaufgabe 2.2 b)

SELECT title -- gesucht: Titel der Märchen 
FROM document
WHERE CHAR_LENGTH(title) > 30 -- Bedingung: Titel müssen länger als 30 Zeichen sein