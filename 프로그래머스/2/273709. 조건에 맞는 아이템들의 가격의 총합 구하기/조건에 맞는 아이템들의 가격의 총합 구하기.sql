select sum(price) as TOTAL_PRICE
from item_info
where rarity regexp ('LEGEND');