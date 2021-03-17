package Interview;

import java.util.*;
import java.util.stream.Collectors;
/*
List sorting:

list_name.sort((i1, i2) -> Integer.compare(i1.var, i2.var));
Arrays.sort(arr_name, (i1, i2) -> Integer.compare(i1[0], i2[0]));

*/
class EElement implements Comparable<Interview.Element>{
    String key;
    int value;
    public EElement(String key, int value){
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Interview.Element elem2) {
        return Integer.compare(value, elem2.value);
    }
}


class Element{
    String key;
    int value;
    public Element(String key, int value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString(){
        return key + ", " + value;
    }
}

class Educative{
    public static void main(String[]args){
        Map<String, Integer> map = new TreeMap<>();
        map.put("bir", 1);
        map.put("iki", 2);
        map.put("dort", 4);

        List<Element> list = new ArrayList<>();
        list.add(new Element("bir",1));
        list.add(new Element("dort",4));
        list.add(new Element("iki",2));
        //Collections.sort(list);

        map = sortByValues(map);
        System.out.print("map: ");
        for(Map.Entry e : map.entrySet()){
            System.out.printf("%s: %d, ", e.getKey(), e.getValue());
        }

        System.out.println();
        System.out.print("List: ");
        list.stream().forEach(elem -> System.out.print(elem.key + " "));

        PriorityQueue<Element> pq = new PriorityQueue<>((e1,e2) -> e1.value - e2.value);
        pq.add(new Element("bir",1));
        pq.add(new Element("dort",4));
        pq.add(new Element("iki",2));
        System.out.print("\npq: ");
        while(!pq.isEmpty()){
            System.out.print(pq.poll().toString() +", ");
        }
    }

    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator =
                (k1, k2) -> { return map.get(k1).compareTo(map.get(k2));};

        Map<K, V> sortedByValues =
                new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    public static Map<Integer,String> sortedMap(Map<Integer, String> map){
        LinkedHashMap<Integer, String> sortedMap =
                map.entrySet().stream().
                        sorted(Map.Entry.comparingByValue()).
                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
        return sortedMap;
    }
}