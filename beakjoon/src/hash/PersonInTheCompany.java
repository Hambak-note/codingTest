package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PersonInTheCompany {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfAccessRecords = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Set<String> personStatusSet = new HashSet<>();
        for(int i = 0; i < numberOfAccessRecords; i++){
            st = new StringTokenizer(br.readLine());
            String name, log;
            name = st.nextToken();
            log = st.nextToken();
            if(log.equals("enter")) personStatusSet.add(name);
            else personStatusSet.remove(name);
        }

        List<String> personStatusList = new ArrayList<>(personStatusSet);
        Collections.sort(personStatusList, Collections.reverseOrder());
        for (String person : personStatusList) {
            System.out.println(person);
        }
    }
}
