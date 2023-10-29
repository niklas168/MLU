
-- mehrfach: gibt aus wie oft Kunden Filme ausgeliehen haben(wenn count kleiner eins dann 0 --> nicht mehrfach ausgeliehen
WITH mehrfach as(SELECT c.customer_id as cust_id, c.first_name, c.last_name, 
CASE when count(r.rental_id)<= 1 THEN 0 ELSE count(r.rental_id) END, f.film_id 
FROM customer c left join rental r on c.customer_id=r.customer_id
left join inventory i on i.inventory_id = r.inventory_id
left join film f on f.film_id = i.film_id
GROUP BY f.film_id,c.customer_id, c.first_name, c.last_name), 

-- Hilfstabelle: wenn ei Kunde mehrfach FIlme geschaut hat werden ddiese gezählt , wenn nicht wird es auf 0 gesetzt
-- Problem: zeigt Kunden, welche Filme mehrfach geguckt haben doppelt an (einmal mit korrektemm count und dann mit 0 als count)
Hilfstabelle as (SELECT m.cust_id, m.last_name, m.first_name, CASE WHEN m.count<>0 THEN count(m.film_id) ELSE 0 END as count
FROM mehrfach m 
GROUP BY m.cust_id,  m.last_name, m.first_name, m.count
ORDER BY m.cust_id)

--Lösung: Sum um die Duplikate mit count 0 zu entfernen
SELECT h.cust_id, h.last_name, h.first_name, sum(h.count)
FROM Hilfstabelle h
GROUP BY h.cust_id, h.last_name, h.first_name
ORDER BY h.cust_id, h.last_name, h.first_name