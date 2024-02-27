--MYSQL
SELECT
    APP.APNT_NO,
    P.PT_NAME,
    P.PT_NO,
    D.MCDP_CD,
    D.DR_NAME,
    APP.APNT_YMD
FROM
    APPOINTMENT APP
    JOIN PATIENT P
        ON APP.PT_NO = P.PT_NO
    JOIN DOCTOR D
        ON APP.MDDR_ID = D.DR_ID
WHERE
    CAST(APP.APNT_YMD AS DATE) = DATE '2022-04-13'
    AND
    APP.APNT_CNCL_YN = 'N'
    AND
    APP.APNT_CNCL_YMD IS NULL
ORDER BY
    APP.APNT_YMD;

--ORACLE
SELECT
    APP.APNT_NO,
    P.PT_NAME,
    P.PT_NO,
    D.MCDP_CD,
    D.DR_NAME,
    APP.APNT_YMD
FROM
    APPOINTMENT APP
    JOIN PATIENT P
        ON APP.PT_NO = P.PT_NO
    JOIN DOCTOR D
        ON APP.MDDR_ID = D.DR_ID
WHERE
    TRUNC(APP.APNT_YMD) = DATE '2022-04-13'
    AND
    APP.APNT_CNCL_YN = 'N'
    AND
    APP.APNT_CNCL_YMD IS NULL
ORDER BY
    APP.APNT_YMD;


--     CAST(APP.APNT_YMD AS DATE) = DATE '2022-04-13'랑
--     TRUNC(APP.APNT_YMD) = DATE '2022-04-13'은 극복하기 어렵다.
--     ansi sql 형태로 맞출 때도 to_char 같은걸 추천해서 Timestamp 형태일 때는 어떻게 할 지 고민해 봄.
--     convert /cast 로 timestamp 값 가져오는 방식을 추천하긴 하는데 출력값이 DB를 타기 때문에 표준화하기 어려운 소스임.
--     그러므로 2쌍을 짜거나 jpa를...★
