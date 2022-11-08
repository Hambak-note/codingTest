package level2;

public class StringCompression {

    public int solution(String s){
        int answer = s.length();
        int maxDivideLength = s.length()/2;

        for(int currentDivideLength = 1; currentDivideLength <= maxDivideLength; currentDivideLength++){
            int compressionDegree = 1;
            String currentStr = s.substring(0, currentDivideLength);
            StringBuilder compressedStr = new StringBuilder();

            for(int j = currentDivideLength; j <= s.length(); j += currentDivideLength){
                String nextStr;
                if(j + currentDivideLength > s.length()){
                    nextStr = s.substring(j, s.length());
                }else{
                    nextStr = s.substring(j, currentDivideLength+j);
                }

                if(currentStr.equals(nextStr)){
                    compressionDegree++;
                }else{
                    compressedStr.append((compressionDegree != 1? compressionDegree : "")+currentStr);
                    currentStr = nextStr;
                    compressionDegree = 1;
                }
            }
            compressedStr.append(currentStr);
            answer = Math.min(answer, compressedStr.length());
        }
        return answer;
    }
}
