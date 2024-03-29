--Mysql
SELECT
    HOUR(DATETIME) AS HOUR,
    COUNT(DATETIME) AS COUNT
FROM
    ANIMAL_OUTS
GROUP BY
    HOUR(DATETIME)
HAVING
    HOUR >= 9
   AND
    HOUR <= 19
ORDER BY
    HOUR(DATETIME) ASC;

--Oracle
SELECT
    TO_NUMBER(TO_CHAR(DATETIME,'HH24')) AS HOUR,
    COUNT(*) AS COUNT
FROM
    ANIMAL_OUTS
WHERE
    TO_CHAR(DATETIME,'HH24') >= '09'
  AND
    TO_CHAR(DATETIME,'HH24') <= '19'
GROUP BY
    TO_CHAR(DATETIME, 'HH24')
ORDER BY
    HOUR ASC;