--Mysql
SELECT
    MCDP_CD AS '진료과코드',
        COUNT(*) AS '5월예약건수'
FROM
    APPOINTMENT
WHERE
        APNT_YMD LIKE '2022-05%'
GROUP BY
    MCDP_CD
ORDER BY
    COUNT(MCDP_CD) ASC,
    MCDP_CD ASC;

--Oracle
SELECT
    MCDP_CD AS "진료과코드",
    COUNT(*) AS "5월예약건수"
FROM
    APPOINTMENT
GROUP BY
    MCDP_CD,
    TO_CHAR(APNT_YMD , 'MM')
HAVING
        TO_CHAR(APNT_YMD , 'MM')
        IN
        ('05')
ORDER BY
    "5월예약건수"  ASC ,
    "진료과코드" ASC