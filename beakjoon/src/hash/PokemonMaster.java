package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PokemonMaster {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberOfPokemon = Integer.parseInt(st.nextToken());
        int numberOfProblems = Integer.parseInt(st.nextToken());

        String[] intToStr = new String[100005];
        Map<String, Integer> strToInt = new HashMap<>();

        for (int i = 1; i <= numberOfPokemon; i++) {
            intToStr[i] = br.readLine();
            strToInt.put(intToStr[i], i);
        }

        for(int i = 0; i < numberOfProblems; i++){
            String question = br.readLine();
            if(Character.isDigit(question.charAt(0))){
                System.out.println(intToStr[Integer.parseInt(question)]);
            }
            else{
                System.out.println(strToInt.get(question));
            }
        }
    }
}
