select REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, round(avg(REVIEW_SCORE), 2) SCORE
from REST_INFO a join REST_REVIEW b using (REST_ID)
where ADDRESS like '서울%'
group by REST_ID
order by SCORE desc, FAVORITES desc;

    # select REST_ID, round(avg(REVIEW_SCORE), 2) SCORE
    # from REST_REVIEW
    # group by REVIEW_SCORE

# select * from REST_REVIEW
# where REST_ID in (
# select REST_ID
# from REST_INFO
# where ADDRESS like '서울%');