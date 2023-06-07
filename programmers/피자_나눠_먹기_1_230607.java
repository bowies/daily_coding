class 피자_나눠_먹기_1_230607 {
    public int solution(int n) {
        double answer = 1;
        double pizzaCounter = 7.0/n;
        
        if(pizzaCounter < 1){

            answer = Math.ceil(1/pizzaCounter);
        }
        
        return (int)answer;
    }

    
    public int solution_nice(int n) {
        return (n + 6) / 7;
    }
}
