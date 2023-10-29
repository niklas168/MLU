-- Teilaufgabe 2.1 c)

SELECT state_name -- gesucht: Namen der Staaten
FROM state
WHERE CHAR_LENGTH(state_name) = 4 -- Bedingung: Zeichenlänge genau 4
