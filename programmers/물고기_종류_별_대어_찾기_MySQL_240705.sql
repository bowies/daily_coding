SELECT 
    FI.ID AS ID, 
    FNI.FISH_NAME AS FISH_NAME, 
    FI.LENGTH AS LENGTH
FROM (
    SELECT 
        FISH_TYPE, 
        MAX(LENGTH) AS MAX_LENGTH
    FROM 
        FISH_INFO
    WHERE 
        LENGTH IS NOT NULL
    GROUP BY 
        FISH_TYPE
) AS FS
JOIN 
    FISH_INFO AS FI 
    ON 
        FS.FISH_TYPE = FI.FISH_TYPE 
        AND 
        FS.MAX_LENGTH = FI.LENGTH
JOIN 
    FISH_NAME_INFO AS FNI 
    ON 
        FI.FISH_TYPE = FNI.FISH_TYPE
ORDER BY 
    ID;







WITH FS AS (
    SELECT 
        FI.FISH_TYPE, 
        FNI.FISH_NAME, 
        MAX(FI.LENGTH) AS MAX_LENGTH
    FROM 
        FISH_INFO FI
        JOIN FISH_NAME_INFO FNI ON FI.FISH_TYPE = FNI.FISH_TYPE
    GROUP BY 
        FI.FISH_TYPE, FNI.FISH_NAME
)
SELECT
    FI.ID,
    FS.FISH_NAME,
    FS.MAX_LENGTH AS LENGTH
FROM
    FISH_INFO FI
    JOIN FS ON FI.FISH_TYPE = FS.FISH_TYPE AND FI.LENGTH = FS.MAX_LENGTH
ORDER BY
    FI.ID;
