-- Mysql
SELECT
    BOOK_ID,
    DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM
    BOOK
WHERE
            CATEGORY = '인문'
        AND YEAR(PUBLISHED_DATE) = 2021
ORDER BY
    PUBLISHED_DATE;

--Oracle
SELECT
    BOOK_ID,
    TO_CHAR(PUBLISHED_DATE, 'YYYY-MM-DD') PUBLISHED_DATE
FROM
    BOOK
WHERE
        CATEGORY = '인문'
  AND TO_CHAR(PUBLISHED_DATE, 'YYYY') = '2021'
ORDER BY
    PUBLISHED_DATE ASC;