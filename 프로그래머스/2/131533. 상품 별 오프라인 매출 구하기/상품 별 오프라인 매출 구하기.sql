select PRODUCT_CODE, sum(PRICE * SALES_AMOUNT) SALES

from PRODUCT a join OFFLINE_SALE b on (a.product_id = b.product_id)

group by PRODUCT_CODE

order by SALES desc, PRODUCT_CODE