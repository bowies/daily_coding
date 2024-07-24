with recursive FINDWITH as (
    select
        id,
        parent_id,
        1 as generation
    from
        ecoli_data
    where
        parent_id is null
        union all
            select
                ED.id,
                ED.parent_id,
                FINDWITH.generation + 1
            from
                FINDWITH
                join
                    ecoli_data ED
            on FINDWITH.id = ED.parent_id
)

select
    count(*) as count,
    generation
from
    FINDWITH
where
    id
        not in (
            select
                distinct parent_id
            from
                FINDWITH
            where
                parent_id is not null
        )
group by
    generation
order by 2;















