package programmers;

import java.math.BigInteger;

class 두_수의_합_Java_240530 {
    public String solution(String a, String b) {
        BigInteger a_ = new BigInteger(a);
        BigInteger b_ = new BigInteger(b);

        return a_.add(b_).toString();
    }
}
