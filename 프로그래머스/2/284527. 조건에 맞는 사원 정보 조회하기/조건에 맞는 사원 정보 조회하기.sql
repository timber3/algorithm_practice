# select
#     score, a.emp_no, emp_name, position, email
# from HR_GRADE a join HR_EMPLOYEES b on (a.EMP_NO = b.EMP_NO)
# where a.EMP_NO in (

# )

select SCORE, a.emp_no, emp_name, position, email
from HR_EMPLOYEES a join (
    select EMP_NO, sum(score) SCORE
    from HR_GRADE
    group by EMP_NO
    order by score desc
    limit 1
) b
where a.EMP_NO = b.EMP_NO

