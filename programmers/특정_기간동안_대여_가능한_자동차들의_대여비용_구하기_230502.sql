--Mysql
SELECT 
    C.CAR_ID, #자동차 ID
    C.CAR_TYPE, #자동차 종류
    ROUND(
        C.DAILY_FEE * 30 * (100-P.DISCOUNT_RATE) / 100 
    ) AS FEE #대여 금액(컬럼명: FEE)
FROM
    CAR_RENTAL_COMPANY_CAR AS C
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
    ON C.CAR_ID=H.CAR_ID
    JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS P 
    ON C.CAR_TYPE=P.CAR_TYPE
WHERE C.CAR_ID NOT IN (
    SELECT 
        CAR_ID
    FROM 
        CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE 
        END_DATE > '2022-11-01' AND START_DATE < '2022-12-01' #2022년 11월 1일부터 2022년 11월 30일까지 대여 가능
) AND P.DURATION_TYPE = '30일 이상' #30일간의 대여 금액
GROUP BY 
    C.CAR_ID
HAVING 
    C.CAR_TYPE 
        IN 
        ('세단', 'SUV') #자동차 종류가 세단 또는 SUV인 자동차
        AND 
        (FEE >= 500000
         AND
         FEE < 2000000) #50만원 이상 200만원 미만인 자동차
ORDER BY 
    FEE DESC, #대여 금액을 기준으로 내림차순 정렬
    CAR_TYPE, #대여 금액이 같은 경우 자동차 종류를 기준으로 오름차순 정렬
    CAR_ID DESC; #자동차 종류까지 같은 경우 자동차 ID를 기준으로 내림차순 정렬




--Oracle
SELECT 
    C.CAR_ID,
    C.CAR_TYPE,
    (C.DAILY_FEE * (1 - (P.DISCOUNT_RATE / 100)) * 30) AS FEE
FROM
    CAR_RENTAL_COMPANY_CAR C            
    INNER JOIN 
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN P
    ON
    C.CAR_TYPE = P.CAR_TYPE
WHERE
    C.CAR_ID 
    NOT IN(
        SELECT
            CAR_ID
        FROM 
            CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE 
            (CAR_ID, END_DATE) IN(
            SELECT 
                CAR_ID, 
                MAX(END_DATE)
            FROM 
                CAR_RENTAL_COMPANY_RENTAL_HISTORY
            GROUP BY
                CAR_ID)
    AND 
        TO_CHAR(START_DATE, 'YYYYMMDD') <= '20221130'
    AND 
        TO_CHAR(END_DATE, 'YYYYMMDD') >= '20221101')
    AND 
        C.CAR_TYPE IN ('세단', 'SUV')
    AND 
        P.DURATION_TYPE = '30일 이상'
    AND 
        (C.DAILY_FEE * (1 - (P.DISCOUNT_RATE / 100)) * 30) 
        BETWEEN
            500000 AND 2000000
ORDER BY 
    FEE DESC, 
    C.CAR_TYPE, 
    C.CAR_ID DESC;