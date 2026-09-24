package topi127.learn;


import java.time.Year;
import java.util.*;

public class Main {
    //EX1
    public Map<String, List<Integer>> footWorldCup(List<Map.Entry<Integer, String>> lf) {
        Map<String,List<Integer>> m = new HashMap<>();
        for (Map.Entry<Integer,String> entry: lf){
            int year = entry.getKey();
            String country = entry.getValue();
            m.putIfAbsent(country, new ArrayList<>());
            List<Integer> years = m.get(country);
            years.add(year);
        }
        return m;
    }

    //EX2
    public LinkedList<Integer> calcMMS(LinkedList<Integer> serie, Integer period){
        LinkedList<Integer> mms = new LinkedList<>();
        for(int i = 0; i < serie.size() ; i++){
            int sum = 0;
            if(i >= period-1){
                for(int k = i-period+1 ; k <= i ; k++){
                    sum += serie.get(k);
                }
                mms.add(sum/period);
            }
        }
        return mms;
    }

    public static void main(String[] args) {

    }

}