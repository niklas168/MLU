SELECT 
    film.film_id, film.title, SUM(payment.amount) AS revenue
FROM 
    film
JOIN inventory ON film.film_id = inventory.film_id
JOIN rental ON inventory.inventory_id = rental.inventory_id
JOIN payment ON rental.rental_id = payment.rental_id
GROUP BY 
    film.film_id, film.title
ORDER BY 
    revenue DESC, film.film_id