select a.id ID, b.fish_name FISH_NAME, a.length LENGTH
from fish_info a join fish_name_info b using (fish_type)
where (a.fish_type, a.length) in
    (select fish_type, max(length)
    from fish_info
    group by fish_type
    )
