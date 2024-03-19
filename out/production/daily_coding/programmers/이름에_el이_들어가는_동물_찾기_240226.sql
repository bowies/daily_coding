SELECT
    ANIMAL_ID, NAME
FROM
    ANIMAL_INS
WHERE
    UPPER(NAME) LIKE '%EL%' AND ANIMAL_TYPE = 'Dog'
ORDER BY
    NAME ASC;

-- 이전 것이 Oracle에서는 동작하지 않아서, 표준 ANSI SQL로 변환하면 사실
-- where 절에 NAME LIKE '%EL%' AND ANIMAL_TYPE = 'Dog' 이 맞긴 한데,
-- 대소문자 상관 없이 비교하기 위해 UPPER를 써서 Oracle - Mysql에서 동시 사용할 수 있게 되었습니다.