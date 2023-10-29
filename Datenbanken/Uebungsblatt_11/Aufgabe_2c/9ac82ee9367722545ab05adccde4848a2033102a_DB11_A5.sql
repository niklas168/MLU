

WITH Hilfstabelle as(SELECT * 
FROM customer c join address a on c.address_id=a.address_id 
join city ci on a.city_id=ci.city_id 
join country co on co.country_id=ci.country_id
WHERE co.country='Brazil' or co.country= 'Austria' or ci.city = 'Bern' or ci.city = 'Lausanne' or ci.city='Siegen')

SELECT CASE WHEN h.city='Bern' or h.city='Lausanne' or h.city='Siegen' THEN 'city'
			ELSE 'country' END as Typ,
       CASE WHEN h.city='Bern' THEN h.city 
			WHEN h.city='Lausanne' THEN h.city
			WHEN h.city='Siegen' THEN h.city 
			WHEN h.country = 'Brazil' THEN h.country
			WHEN h.country ='Austria' THEN h.country END as "Stadt/Land",
       COUNT(h.customer_id) AS Anzahl_Kunden
FROM Hilfstabelle h
GROUP BY "Stadt/Land", Typ
