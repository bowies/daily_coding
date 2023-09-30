package programmers;

class 개미_군단_Java_230930 {
    /*
    개미 군단이 사냥을 나가려고 합니다.
    개미군단은 사냥감의 체력에 딱 맞는 병력을 데리고 나가려고 합니다.
    장군개미는 5의 공격력을, 병정개미는 3의 공격력을 일개미는 1의 공격력을 가지고 있습니다.
    예를 들어 체력 23의 여치를 사냥하려고 할 때, 일
    개미 23마리를 데리고 가도 되지만,
    장군개미 네 마리와 병정개미 한 마리를 데리고 간다면 더 적은 병력으로 사냥할 수 있습니다.
    사냥감의 체력 hp가 매개변수로 주어질 때,
    사냥감의 체력에 딱 맞게 최소한의 병력을 구성하려면 몇 마리의 개미가 필요한지를 return하도록 solution 함수를 완성해주세요.
     */
    public int solution(int hp) {
        int answer = 0;
        int 장군개미 = 5;
        int 병정개미 = 3;
        int 일개미 = 1;

        while(hp > 0) {
            if(hp >= 장군개미) {
                hp -= 장군개미;
                answer++;
            } else if(hp >= 병정개미) {
                hp -= 병정개미;
                answer++;
            } else {
                hp -= 일개미;
                answer++;
            }
        }

        return answer;
    }

    public int solution2(int hp) {
        int 장군개미 = hp / 5;
        hp %= 5; // 장군개미로 처리한 후 남은 체력 계산

        int 병정개미 = hp / 3;
        hp %= 3; // 병정개미로 처리한 후 남은 체력 계산

        return 장군개미 + 병정개미 + hp; // 장군, 병정, 일개미의 수를 합하여 리턴
    }

    public int solution3(int hp) {
        return hp / 5 + (hp % 5 / 3) + hp % 5 % 3;
    }



}