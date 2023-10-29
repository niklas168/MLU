SELECT
    customer.first_name,
    customer.last_name,
    category.name,
    COALESCE(rental_counts.count, 0) as count
FROM
    customer
    JOIN address ON customer.address_id = address.address_id
    JOIN city ON address.city_id = city.city_id
    JOIN country ON city.country_id = country.country_id
    JOIN rental ON customer.customer_id = rental.customer_id
    JOIN inventory ON rental.inventory_id = inventory.inventory_id
    JOIN film_category ON inventory.film_id = film_category.film_id
    JOIN category ON film_category.category_id = category.category_id
    LEFT JOIN (
        SELECT
            rental.customer_id,
            category.category_id,
            count(*) as count
        FROM
            rental
            JOIN inventory ON rental.inventory_id = inventory.inventory_id
            JOIN film_category ON inventory.film_id = film_category.film_id
            JOIN category ON film_category.category_id = category.category_id
        GROUP BY
            rental.customer_id,
            category.category_id
    ) as rental_counts ON rental_counts.customer_id = customer.customer_id AND rental_counts.category_id = category.category_id
WHERE
    country.country = 'Germany'
ORDER BY
    customer.first_name,
    customer.last_name,
    count DESC;