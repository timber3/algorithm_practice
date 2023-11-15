select MONTH(start_date) MONTH, CAR_ID, count(*) RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where CAR_ID in (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where START_DATE between '2022-08-01' AND '2022-10-31'
    group by CAR_ID
    having count(*) >= 5
)
and START_DATE between '2022-08-01' AND '2022-10-31'
group by MONTH, car_id
order by MONTH, car_id desc