select a.dept_id, DEPT_NAME_EN, round(avg(SAL)) AVG_SAL
from HR_EMPLOYEES a join HR_DEPARTMENT b on (a.dept_id = b.dept_id)
group by DEPT_ID
order by AVG_SAL desc