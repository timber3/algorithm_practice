# select
#     MCDP_CD '진료과 코드', count(*) '5월예약건수'
# from
#     APPOINTMENT
# where
#     YEAR(apnt_ymd) = '2022' and MONTH(apnt_ymd) = '5'
# group by
#     MCDP_CD
# order by
#     2 , 1 desc;
    
    
select 
    MCDP_CD '진료과코드', count(*) '5월예약건수'
from
    appointment
where
    APNT_YMD like '2022-05%'
group by
    MCDP_CD
order by
    2 , 1;