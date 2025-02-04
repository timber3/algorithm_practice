select count(*) fish_count, MONTH(time) month
from fish_info
group by MONTH(time)
order by 2