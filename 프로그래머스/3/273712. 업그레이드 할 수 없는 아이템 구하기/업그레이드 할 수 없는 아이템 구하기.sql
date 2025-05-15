# select

# from ITEM_INFO a join ITEM_TREE b on a.ITEM_ID = b.ITEM_ID

# where 


select a.item_id, b.ITEM_NAME, b.RARITY
from ITEM_TREE a join ITEM_INFO b on (a.ITEM_ID = b.ITEM_ID)
where a.item_id not in 
    (select DISTINCT parent_item_id
    from ITEM_TREE
    where PARENT_ITEM_ID is not null)
order by item_id desc