select a.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS,
round(avg(b.REVIEW_SCORE),2) as SCORE

from REST_INFO a join REST_REVIEW b on a.REST_ID = b.REST_ID

where a.ADDRESS like '서울%'

group by a.REST_ID

order by SCORE desc, FAVORITES desc