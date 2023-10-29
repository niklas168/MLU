-- Teilaufgabe 2.2 c)

SELECT title, 
(1+(CHAR_LENGTH(title) - CHAR_LENGTH(REPLACE(title, ' ', '')))) AS anzahl_woerter -- gesucht: Titel und Anzahl der Wörter
FROM document


-- Anzahl der Wörter wird bestimmt durch ((Zeichenanzahl - Anzahl der Zeichen bei Eliminierung von Leerzeichen) + 1 