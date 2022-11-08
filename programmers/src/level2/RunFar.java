package level2;

public class RunFar {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    static public long solution(int n) {
        long answer = 0;
        long[] numberOfCasesArr = new long[n+2];
        numberOfCasesArr[1] = 1;
        numberOfCasesArr[2] = 2;

        for(int i = 3; i <= n; i++){
            numberOfCasesArr[i] = (numberOfCasesArr[i-1] + numberOfCasesArr[i -2]) % 1234567;
        }

        answer = numberOfCasesArr[n];

        return answer;
    }
}
