# select
#     food_type, rest_id, rest_name, favorites
# from
#     rest_info
# where
#     (rest_id) in (
#         select
#             rest_id
#         from
#             rest_info
#         group by
#             food_type
#         having
#             max(favorites)
#     )
# order by
#     food_type desc


# SELECT
#     food_type, rest_id, rest_name, favorites
# FROM
#     rest_info
# WHERE
#     (food_type, favorites) IN (
#         SELECT food_type, MAX(favorites)
#         FROM rest_info
#         GROUP BY food_type
# )
# ORDER BY
#     food_type DESC;


SELECT
    food_type, rest_id, rest_name, favorites
FROM
    rest_info
WHERE
    (favorites, food_type) IN (
        SELECT 
            MAX(favorites), food_type
        FROM
            rest_info
        GROUP BY
            food_type
    )
ORDER BY
    food_type DESC;