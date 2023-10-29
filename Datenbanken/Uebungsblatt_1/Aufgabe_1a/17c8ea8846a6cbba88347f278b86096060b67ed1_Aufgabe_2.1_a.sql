-- Teilaufgabe 2.1 a)

SELECT state_name -- gesuchter output: alle Staaten Namen
FROM state
WHERE state_name Like 'C%' -- Bedingung: Name soll mit C beginnen
