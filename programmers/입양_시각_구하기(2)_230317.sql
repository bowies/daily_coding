SELECT L.LVL AS HOUR , NVL(H.CNT, 0) AS COUNT
FROM
    (SELECT
    TO_CHAR(DATETIME,'HH24') AS HOUR, COUNT(*) AS CNT
    FROM
    ANIMAL_OUTS
    GROUP BY
    TO_CHAR(DATETIME,'HH24')
    ORDER BY
    HOUR
    ) H,
    (SELECT
    (LEVEL-1) LVL
    FROM
    DUAL
    CONNECT BY
    LEVEL <=24
    ) L
WHERE L.LVL = H.HOUR(+) ORDER BY L.LVL