select substring(product_code, 1, 2) as category, count(substring(product_code, 0, 2)) as Products

from product

group by category

order by category