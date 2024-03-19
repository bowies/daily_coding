--ANSI SQL
SELECT
    R.REST_ID,
    I.REST_NAME,
    I.FOOD_TYPE,
    I.FAVORITES,
    I.ADDRESS,
    ROUND(AVG(R.REVIEW_SCORE), 2) AS SCORE
FROM
    REST_REVIEW R
JOIN
    REST_INFO I
ON
    R.REST_ID = I.REST_ID
WHERE
    I.ADDRESS LIKE '서울%'
GROUP BY
    R.REST_ID,
    I.REST_NAME,
    I.FOOD_TYPE,
    I.FAVORITES,
    I.ADDRESS
ORDER BY
    SCORE DESC,
    I.FAVORITES DESC;

--Mysql처럼 select 절을 바꾸고, 서브쿼리를 제낀 담에 where 절로 address 필터링 하는 방식으로 oracle 것을 차용했다.
--그리고 모든 선택한 열을 group by에 사용하도록 추가하고
--평균 review score 로 desc 하도록 수정했다.
--그래서 Mysql 이랑 유사하게 생겼지만, oracle에서 효율적인 부분을 가져다가 개선해봤다.


--Mysql
SELECT
    R.REST_ID,
    I.REST_NAME,
    I.FOOD_TYPE,
    I.FAVORITES,
    I.ADDRESS,
    ROUND(AVG(R.REVIEW_SCORE),2) AS SCORE
FROM
    REST_REVIEW R
        JOIN
    REST_INFO I
    ON
            R.REST_ID = I.REST_ID
GROUP BY
    R.REST_ID
HAVING
        I.ADDRESS
        LIKE '서울%'
ORDER BY
    SCORE DESC,
    I.FAVORITES DESC

--Oracle
SELECT
    I.REST_ID,
    I.REST_NAME,
    I.FOOD_TYPE,
    I.FAVORITES,
    I.ADDRESS,
    R.SCORE
FROM
    REST_INFO I
        INNER JOIN (
        SELECT REST_ID, ROUND(AVG(REVIEW_SCORE), 2) SCORE
        FROM REST_REVIEW
        GROUP BY REST_ID
    ) R
                   ON
                           I.REST_ID = R.REST_ID
WHERE
        I.ADDRESS LIKE '서울%'
ORDER BY
    R.SCORE DESC,
    I.FAVORITES DESC