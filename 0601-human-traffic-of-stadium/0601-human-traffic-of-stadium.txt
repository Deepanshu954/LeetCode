WITH ConsecutiveGroups AS (
    SELECT 
        id, 
        visit_date, 
        people,
        id - ROW_NUMBER() OVER (ORDER BY id) AS grp
    FROM Stadium
    WHERE people >= 100
),
GroupCounts AS (
    SELECT 
        *,
        COUNT(*) OVER (PARTITION BY grp) AS cnt
    FROM ConsecutiveGroups
)
SELECT 
    id, 
    visit_date, 
    people
FROM GroupCounts
WHERE cnt >= 3
ORDER BY visit_date;