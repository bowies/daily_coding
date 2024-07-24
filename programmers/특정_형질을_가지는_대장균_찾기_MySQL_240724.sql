SELECT COUNT(ID) AS COUNT
FROM ECOLI_DATA
WHERE
    GENOTYPE & 5         -- (0101 in binary): 1번 또는 3번 형질 보유 여부 확인
    AND NOT GENOTYPE & 2 -- (0010 in binary): 2번 형질이 없음을 확인
-- best answer