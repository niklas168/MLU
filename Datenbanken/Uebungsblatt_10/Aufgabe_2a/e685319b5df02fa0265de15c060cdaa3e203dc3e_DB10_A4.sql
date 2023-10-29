SELECT 
    customer.customer_id, customer.first_name, customer.last_name, 
    COUNT(rental.rental_id) AS number_rentals, 
    category.category_id, category.name
FROM 
    customer
JOIN rental ON customer.customer_id = rental.customer_id
JOIN inventory ON rental.inventory_id = inventory.inventory_id
JOIN film ON inventory.film_id = film.film_id
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
GROUP BY 
    customer.customer_id, customer.first_name, customer.last_name,
    category.category_id, category.name
HAVING 
    COUNT(rental.rental_id) > 5
ORDER BY 
    customer.last_name, customer.first_name, number_rentals DESC