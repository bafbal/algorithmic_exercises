import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.management.InstanceNotFoundException;

public class Main {

  public static void main(String[] args) {

    Map<Integer, List<String>> map = new HashMap<>();
    List<String> list1 = new ArrayList<>();
    list1.add("A");
    list1.add("B");
    list1.add("C");
    map.put(1, list1);
    List<String> list2 = new ArrayList<>();
    list2.add("A");
    list2.add("B");
    list2.add("D");
    list2.add("A");
    map.put(2, list2);
    removeDuplicateIds3(map);

  }

  public static Map<Integer, List<String>> removeDuplicateIds(Map<Integer, List<String>> obj) {
    Map<String, Integer> valuesWithHighestKeys = new HashMap<>();
    for (Integer key : obj.keySet()) {
      List<String> list = obj.get(key);
      for (int i = 0; i < list.size(); i++) {
        if (valuesWithHighestKeys.containsKey(list.get(i))) {
          if (key > valuesWithHighestKeys.get(list.get(i))) {
            valuesWithHighestKeys.replace(list.get(i), key);
          }
        } else {
          valuesWithHighestKeys.put(list.get(i), key);
        }
      }
    }
    for (Integer key : obj.keySet()) {
      List<String> list = obj.get(key);
      for (int i = 0; i < list.size(); i++) {
        if (key != valuesWithHighestKeys.get(list.get(i))) {
          list.remove(i);
          i--;
        }
      }
    }
    for (Integer key : obj.keySet()) {
      List<String> list = obj.get(key);
      for (int i = 0; i < list.size(); i++) {
          if (!valuesWithHighestKeys.containsKey(list.get(i))) {
            list.remove(i);
            i--;
          } else {
            valuesWithHighestKeys.remove(list.get(i));
          }
        }
      }
    return obj;
  }

  public static Map<Integer, List<String>> removeDuplicateIds2(Map<Integer, List<String>> obj) {
    Map<Integer, List<String>> result = new HashMap<>();
    List<SortableDataHolder> list = new ArrayList<>();
    List<String> stringsFound = new ArrayList<>();

    for (Map.Entry<Integer,List<String>> entry : obj.entrySet()) {
      list.add(new SortableDataHolder(entry.getKey(),entry.getValue()));
    }
    Collections.sort(list, Collections.reverseOrder());

    for (SortableDataHolder sdh : list) {
      for (int i = 0; i < sdh.value.size(); i++) {
        if (stringsFound.contains(sdh.value.get(i))) {
          sdh.value.remove(i);
          i--;
        } else {
          stringsFound.add(sdh.value.get(i));
        }
      }
      result.put(sdh.key,sdh.value);
    }
    return result;
  }

  public static class SortableDataHolder implements Comparable<SortableDataHolder> {

    int key;
    List<String> value;

    public SortableDataHolder(int key, List<String> value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public int compareTo(SortableDataHolder o) {
      return this.key - o.key;
    }
  }

  public static Map<Integer, List<String>> removeDuplicateIds3(Map<Integer, List<String>> obj) {
    List<String> stringsFound = new ArrayList<>();
    Map<Integer, List<String>> result = obj.entrySet().stream()
        .sorted(Map.Entry.<Integer, List<String>>comparingByKey().reversed())
        .collect(Collectors.toMap(
        Map.Entry::getKey,
        e -> e.getValue().stream().distinct().collect(Collectors.toList()),
        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    for (:
    ) {
      
    }
    return result;
  }
}