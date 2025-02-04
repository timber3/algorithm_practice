select count(*) FISH_COUNT, fish_name FISH_NAME
from fish_info a join fish_name_info b on (a.fish_type = b.fish_type)
group by FISH_NAME
order by 1 desc