SELECT
    G.SCORE,
    E.EMP_NO,
    E.EMP_NAME,
    E.POSITION,
    E.EMAIL
FROM (
         SELECT
             EMP_NO,
             SUM(SCORE) AS SCORE
         FROM
             HR_GRADE
         WHERE
             YEAR = 2022
         GROUP BY
             EMP_NO
     ) G
         JOIN HR_EMPLOYEES E ON G.EMP_NO = E.EMP_NO
ORDER BY
    G.SCORE DESC
    LIMIT 1;
