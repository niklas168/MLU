WITH number_of_rentals AS (SELECT c.customer_id, c.first_name, c.last_name, f.film_id, count(rental_id) as anzahl_ausleihen
FROM customer c, film f, inventory i, rental r
WHERE f.film_id = i.film_id AND i.inventory_id = r.inventory_id AND r.customer_id=c.customer_id
GROUP BY f.film_id, c.customer_id),

actor_count AS(SELECT nr.customer_id, nr.last_name, nr.first_name, a.actor_id, count(a.actor_id) as number_rentals, a.last_name as a_last_name, a.first_name as a_first_name
FROM number_of_rentals nr, film_actor fa, actor a 
WHERE nr.film_id = fa.film_id AND fa.actor_id = a.actor_id
GROUP BY a.actor_id, nr.customer_id, nr.last_name, nr.first_name)

SELECT DISTINCT ac.customer_id, ac.first_name, ac.last_name, ac.actor_id, ac.a_first_name, ac.a_last_name, MAX(ac.number_rentals) as number_rentals
FROM actor_count ac
GROUP BY ac.number_rentals, ac.customer_id, ac.first_name, ac.last_name, ac.actor_id,ac.a_first_name, ac.a_last_name