--CAST를 쓰면 Oracle, Mysql에서 둘 다 쓸 수 있긴 한데, FORMAT 때문에 2018-01-22 00:00:00 와 같은 식으로 출력된다.
--이 경우에는 지난 번처럼 CAST를 안 쓰고 하는 것이 옳은 답변...
--금일 것은 CAST를 써보려고 굳이 한번 더 싸매 본 형식이다. (불필요)
SELECT
    ANIMAL_ID,
    NAME,
    CAST(DATETIME AS DATE) AS "날짜"
FROM
    ANIMAL_INS
ORDER BY
    ANIMAL_ID;


--MySQL
SELECT
    ANIMAL_ID,
    NAME,
    DATE_FORMAT(CAST(DATETIME AS DATE), '%Y-%m-%d') AS "날짜"
FROM
    ANIMAL_INS;


--Oracle
SELECT
    ANIMAL_ID,
    NAME,
    TO_CHAR(CAST(DATETIME AS DATE), 'YYYY-MM-DD') AS "날짜"
FROM
    ANIMAL_INS
ORDER BY
    ANIMAL_ID;
