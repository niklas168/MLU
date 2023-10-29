-- Teilaufgabe 2.2 a)

SELECT title -- gesucht: Titel der Märchen
FROM document
WHERE UPPER(title) LIKE UPPER('%könig%') -- Bedingung: muss das Wort König enthalten ( unabhängig von Schreibweise)