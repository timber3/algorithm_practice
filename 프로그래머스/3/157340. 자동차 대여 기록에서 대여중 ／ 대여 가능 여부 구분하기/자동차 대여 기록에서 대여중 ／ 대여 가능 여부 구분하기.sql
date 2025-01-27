select
    CAR_ID,
    case
        when CAR_ID in (
            select
                CAR_ID
            from
                CAR_RENTAL_COMPANY_RENTAL_HISTORY
            where
                start_date <= '2022-10-16' and end_date >= '2022-10-16'
            group by
                CAR_ID
        )
        then '대여중'
        else '대여 가능'
    end AVAILABILITY
from 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
order by CAR_ID desc

