package Interview.General;

import java.io.IOException;
import java.util.*;

public class TopKWords {
    public static void main(String[] args) throws IOException {
        String [] arr = {"i", "love", "leetcode", "i", "love", "coding"};
        topKFrequent(arr, 2).stream().forEach(System.out::println);
    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String > result = new ArrayList<>();
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(new MyComparator());

        for(String s : words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        map.entrySet().stream().forEach(e -> pq.offer(e));
        for(int i = 0; i < k; i++){
            result.add(pq.poll().getKey());
        }
        return result;
    }
}

class MyComparator implements Comparator<Map.Entry<String, Integer>> {

    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
        String word1 = e1.getKey();
        int freq1 = e1.getValue();
        String word2 = e2.getKey();
        int freq2 = e2.getValue();
        if(freq1!=freq2){
            return freq2-freq1;
        }
        else {
            return word1.compareTo(word2);
        }
    }
}