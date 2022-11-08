package level2;

public class NextBigNumber {
    public static void main(String[] args) {

        System.out.println(solution(78));
        System.out.println(solution(15));

    }

    static public int solution(int n){
        int answer = 0;

        int oneNumberOfn = Integer.bitCount(n);

        int nextBigNumber = n;
        int oneNumberOfNext = -1;

        while(oneNumberOfn != oneNumberOfNext){
            nextBigNumber++;
            oneNumberOfNext = Integer.bitCount(nextBigNumber);
        }

        answer = nextBigNumber;

        return answer;
    }
}
