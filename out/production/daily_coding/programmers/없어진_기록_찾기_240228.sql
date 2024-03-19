SELECT
    O.ANIMAL_ID,
    O.NAME
FROM
    ANIMAL_OUTS O
    LEFT JOIN
    ANIMAL_INS I
    ON O.ANIMAL_ID = I.ANIMAL_ID
WHERE
    I.ANIMAL_ID IS NULL
ORDER BY
    O.ANIMAL_ID;


-- 사실 left join이 맞는 것 ㅋㅋㅋㅋㅋㅋ...
-- 두 쿼리가 left-right 조인 을 했을때도 같았던 이유는
-- 1) left를 하면 outs 테이블 기준 ins 테이블 조인을 하고
-- 2) right를 하면 ins 테이블 기준으로 outs 테이블 조인을 해서
-- 일치하는 행이 없는 경우를 선택한 거라 두 쿼리가 내용이 같음...
-- 글서 일반적으로 left join을 쓰니까 left join이 정답이라고 볼 수 있다!
-- 짤 때 아마 이것도 되나? ㅋㅋㅋ 같은 마음으로 짰던 것 같다. (자아 비평)