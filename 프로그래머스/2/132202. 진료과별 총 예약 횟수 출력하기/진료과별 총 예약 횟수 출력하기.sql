# SELECT MCDP_CD as '진료과코드', COUNT(APNT_NO) AS '5월예약건수'
# from APPOINTMENT
# WHERE APNT_YMD like '2022-05%' and APNT_CNCL_YN = 'N'
# group by MCDP_CD
# ORDER BY '5월예약건수' , '진료과코드'

SELECT MCDP_CD as '진료과 코드', count(APNT_NO) as '5월예약건수'
from APPOINTMENT 
where APNT_YMD like '2022-05%'
group by MCDP_CD
order by count(APNT_NO), MCDP_CD