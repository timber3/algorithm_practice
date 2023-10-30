select fp.CATEGORY, t.mp, fp.PRODUCT_NAME from
(select Max(PRICE) as mp from FOOD_PRODUCT
where CATEGORY in ('과자', '국', '김치', '식용유')
GROUP BY CATEGORY) t, FOOD_PRODUCT fp
where fp.PRICE = t.mp and CATEGORY in ('과자', '국', '김치', '식용유')
order by fp.PRICE desc

