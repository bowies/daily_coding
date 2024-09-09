package programmers;
import java.util.Scanner;

public class PCCE_기출문제_4번_병과분류_Java_240909{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = sc.next();
        String lastFourWords = code.substring(code.length()-4, code.length());

        if(lastFourWords.equals(
"_eye"
)){
            System.out.println("Ophthalmologyc");
        }
        else if(
lastFourWords.equals("head")
){
            System.out.println("Neurosurgery");
        }
        else if(
lastFourWords.equals("infl")
){
            System.out.println("Orthopedics");
        }
        
else if(lastFourWords.equals("skin"))
{
            System.out.println("Dermatology");
        }
        
else
{
            System.out.println("direct recommendation");
        }
    }
}
