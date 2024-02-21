--MySQL & Oracle
SELECT
    ANIMAL_TYPE,
    COALESCE(NAME, 'No name') AS NAME,
    SEX_UPON_INTAKE
FROM
    ANIMAL_INS
ORDER BY
    ANIMAL_ID;

--IFNULL이나 NVL이나 DECODE 대신 COALESCE 함수로 표준 SQL을 사용해 봅시다.
--SQL을 생짜로 잘 안 써서 복기 목적