select
    ROUTE, 
    concat(round(sum(d_between_dist), 1), "km") TOTAL_DISTANCE, 
    concat(round(avg(d_between_dist), 2), "km") AVERAGE_DISTANCE
from SUBWAY_DISTANCE 
group by ROUTE
order by sum(d_between_dist) desc