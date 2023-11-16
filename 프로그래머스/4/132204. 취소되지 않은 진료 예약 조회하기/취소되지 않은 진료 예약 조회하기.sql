select APNT_NO, PT_NAME, a.PT_NO, a.MCDP_CD, DR_NAME, APNT_YMD
from APPOINTMENT a
join DOCTOR d on a.MDDR_ID = d.DR_ID
join PATIENT p on a.PT_NO = p.PT_NO
where APNT_YMD like '2022-04-13%' and a.MCDP_CD = 'CS' and a.APNT_CNCL_YMD IS NULL
order by APNT_YMD