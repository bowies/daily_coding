/*

 다음과 같은 구조를 가진 두 개의 테이블( teams 및 matches ) 이 제공됩니다 .

  테이블 팀 생성(
      null이 아닌 team_id 정수,
      team_name varchar(30) null이 아님,
      고유(team_id)
  );

  테이블 일치 생성(
      null이 아닌 match_id 정수,
      null이 아닌 host_team 정수,
      guest_team 정수가 null이 아님,
      null이 아닌 host_goals 정수,
      guest_goals null이 아닌 정수,
      고유(match_id)
  );
팀 테이블의 각 레코드는 단일 축구팀을 나타냅니다. 테이블 경기 의 각 기록은 두 팀 간의 완료된 경기를 나타냅니다. 팀( host_team , guest_team )은 팀 테이블( team_id ) 에서 해당 ID로 표시됩니다 . 어떤 팀도 자신과 경기를 하지 않습니다. 각 경기의 결과(즉, 각 팀이 득점한 골 수)를 알고 있습니다.

테이블에 설명된 모든 경기 후 각 팀이 득점한 총 점수를 계산하려고 합니다. 채점 규칙은 다음과 같습니다.

한 팀이 경기에서 이기면(상대 팀보다 훨씬 더 많은 골을 넣음) 3점을 받습니다.
한 팀이 경기에서 무승부를 기록하면(상대 팀과 정확히 같은 수의 골을 넣은 경우) 1점을 받습니다.
팀이 경기에서 패배하면(상대 팀보다 득점이 적음) 점수를 받지 못합니다.
팀 테이블 에 설명된 모든 팀( team_id ) 의 순위를 반환하는 SQL 쿼리를 작성합니다 . 각 팀에 대해 설명된 모든 경기 후 받은 점수( num_points ) 와 이름을 제공해야 합니다 . 테이블은 num_points 기준으로 정렬되어야 합니다 (내림차순). 동률인 경우 team_id 별로 행을 정렬합니다 (오름차순).

예를 들어:

  팀:

   team_id | 팀 이름
  ---------+---------------
   10 | 주다
   20 | 절대
   30 | 너
   40 | 위로
   50 | 갈거야


  성냥:

   match_id | host_team | guest_team | host_goals | guest_goals
  ----------+-----------+------------+------------+- ------------
   1 | 30 | 20 | 1 | 0
   2 | 10 | 20 | 1 | 2
   3 | 20 | 50 | 2 | 2
   4 | 10 | 30 | 1 | 0
   5 | 30 | 50 | 0 | 1
쿼리는 다음을 반환해야 합니다.

   team_id | team_name | num_points
  ---------+-----------+------------
   20 | 절대로 | 4
   50 | 갈거야 | 4
   10 | 줘 | 삼
   30 | 당신 | 삼
   40 | 위로 | 0
Codility Limited의 저작권 2009–2023. 판권 소유. 무단 복사, 출판 또는 공개를 금지합니다.

 */

SELECT
    t.team_id as team_id,
    t.team_name as team_name,
    COALESCE(sum(
        CASE
            WHEN
                t.team_id = m.host_team THEN m.home_score
            WHEN
                t.team_id = m.guest_team THEN m.away_score
            END
    ), 0) AS num_points -- null 대신 0 쓰기
FROM teams AS t
LEFT JOIN (
    SELECT
        host_team,
        (CASE
            WHEN
                host_goals > guest_goals THEN 3 -- 한 팀이 경기에서 이기면(상대 팀보다 훨씬 더 많은 골을 넣음) 3점을 받습니다.
            WHEN
                host_goals = guest_goals THEN 1 -- 한 팀이 경기에서 무승부를 기록하면(상대 팀과 정확히 같은 수의 골을 넣은 경우) 1점을 받습니다.
            ELSE 0 -- 팀이 경기에서 패배하면(상대 팀보다 득점이 적음) 점수를 받지 못합니다.
        END) AS home_score,
        guest_team,
        (CASE
            WHEN
                host_goals > guest_goals THEN 0
            WHEN
                host_goals = guest_goals THEN 1
            ELSE 3
        END) AS away_score
    FROM matches
) m
ON
        t.team_id = m.host_team
    OR
        t.team_id = m.guest_team
GROUP BY
    t.team_id, t.team_name
ORDER BY
    num_points DESC, t.team_id