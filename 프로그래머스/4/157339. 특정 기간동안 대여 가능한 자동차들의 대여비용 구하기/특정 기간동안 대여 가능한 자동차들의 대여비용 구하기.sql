
# select a.CAR_ID, a.CAR_TYPE, a.DAILY_FEE * 30 * (1 - (c.DISCOUNT_RATE * 0.01 )) as fee
# from CAR_RENTAL_COMPANY_CAR a
# join CAR_RENTAL_COMPANY_RENTAL_HISTORY b on a.CAR_ID = b.CAR_ID
# join CAR_RENTAL_COMPANY_DISCOUNT_PLAN c on a.CAR_TYPE = c.CAR_TYPE
# where a.CAR_ID not in
#     (select CAR_ID
#      from CAR_RENTAL_COMPANY_RENTAL_HISTORY  
#      where START_DATE <= '2022-11-30' and END_DATE > '2022-11-01'
#     ) and c.DURATION_TYPE = '30일 이상' and a.CAR_TYPE in ('세단', 'SUV')
# having fee >= 500000 and fee < 2000000
# order by fee desc, a.CAR_TYPE,  a.CAR_ID desc

select a.CAR_ID, a.CAR_TYPE, round(a.DAILY_FEE * 30 * (1 - (c.DISCOUNT_RATE * 0.01 ))) as fee
from CAR_RENTAL_COMPANY_CAR a
join CAR_RENTAL_COMPANY_RENTAL_HISTORY b on a.CAR_ID = b.CAR_ID
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN c on a.CAR_TYPE = c.CAR_TYPE
where a.CAR_ID not in
    (select CAR_ID
     from CAR_RENTAL_COMPANY_RENTAL_HISTORY  
     where START_DATE <= '2022-11-30' and END_DATE > '2022-11-01'
    ) and c.DURATION_TYPE = '30일 이상'
group by a.CAR_ID
having a.CAR_TYPE in ('세단', 'SUV') and (fee >= 500000 and fee < 2000000)
order by fee desc, a.CAR_TYPE,  a.CAR_ID desc
