package com.project.todolist.predictive_analysis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class frequent_tasks  {

    /* public static void main(String[] args) throws FileNotFoundException, IOException {
         String inputLine ="string stop words program remove thanks watching tutorial";
         frequent_tasks tm = new frequent_tasks();
         ArrayList<String> result = tm.computing_resultset(inputLine);
         System.out.println(result);
     }*/
    public ArrayList<String> computing_resultset(String inputLine)
    {
        ArrayList<String> result_set = new ArrayList<String>();
        Map<String, Integer> crunchifyMap = new HashMap<>();

        try {

            String[] words = inputLine.split("[ \n\t\r.,;:!?(){}]");

            for (int counter = 0; counter < words.length; counter++) {
                String key = words[counter].toLowerCase(); // remove .toLowerCase for Case Sensitive result.
                if (key.length() > 0) {
                    if (crunchifyMap.get(key) == null) {
                        crunchifyMap.put(key, 1);
                    } else {
                        int value = crunchifyMap.get(key).intValue();
                        value++;
                        crunchifyMap.put(key, value);
                    }
                }

            }
            //System.out.println("final result set:");
            Map<String,Integer> map = new TreeMap<String,Integer>(crunchifyMap);
            Set<Map.Entry<String, Integer>> entrySet = entriesSortedByValues(map);
            result_set.clear();
            int l = 0;
            //System.out.println("Words" + "\t\t" + "# of Occurances");
            for (Map.Entry<String, Integer> entry : entrySet)
            {
                if(l < 10)
                {
                    //System.out.println(entry.getKey() + "\t\t" + entry.getValue());
                    result_set.add(entry.getKey());
                    l++;
                }
                else
                {
                    break;
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        } finally {

        }
        return result_set;
    }

    static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e2.getValue().compareTo(e1.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}

class CrunchifyComparable implements Comparable<CrunchifyComparable> {
    public String wordFromFile;
    public int numberOfOccurrence;

    public CrunchifyComparable(String wordFromFile, int numberOfOccurrence) {
        super();
        this.wordFromFile = wordFromFile;
        this.numberOfOccurrence = numberOfOccurrence;
    }

    @Override
    public int compareTo(CrunchifyComparable arg0) {
        int crunchifyCompare = Integer.compare(arg0.numberOfOccurrence, this.numberOfOccurrence);
        return crunchifyCompare != 0 ? crunchifyCompare : wordFromFile.compareTo(arg0.wordFromFile);
    }

    @Override
    public int hashCode() {
        final int uniqueNumber = 19;
        int crunchifyResult = 9;
        crunchifyResult = uniqueNumber * crunchifyResult + numberOfOccurrence;
        crunchifyResult = uniqueNumber * crunchifyResult + ((wordFromFile == null) ? 0 : wordFromFile.hashCode());
        return crunchifyResult;
    }

    @Override
    public boolean equals(Object crunchifyObj) {
        if (this == crunchifyObj)
            return true;
        if (crunchifyObj == null)
            return false;
        if (getClass() != crunchifyObj.getClass())
            return false;
        CrunchifyComparable other = (CrunchifyComparable) crunchifyObj;
        if (numberOfOccurrence != other.numberOfOccurrence)
            return false;
        if (wordFromFile == null) {
            if (other.wordFromFile != null)
                return false;
        } else if (!wordFromFile.equals(other.wordFromFile))
            return false;
        return true;
    }

}