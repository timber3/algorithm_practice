with sedan as (
    select a.car_id, car_type, daily_fee, start_date, end_date, options
    from CAR_RENTAL_COMPANY_CAR a join CAR_RENTAL_COMPANY_RENTAL_HISTORY b on (a.car_id = b.car_id)
    where car_type = '세단' and start_date like "%-10-%"
)


select distinct car_id
from sedan
order by 1 desc