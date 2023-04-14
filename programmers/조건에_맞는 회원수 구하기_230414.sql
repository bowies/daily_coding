--Mysql
SELECT
    COUNT(*) AS USERS
FROM
    USER_INFO
WHERE
            AGE >= 20
        AND
            AGE <= 29
        AND
        YEAR(JOINED) = 2021

--Oracle

SELECT
    COUNT(*) AS USERS
FROM
    USER_INFO
WHERE
        AGE >= 20
  AND
        AGE <= 29
  AND
        TO_CHAR(JOINED, 'YYYY') = '2021'