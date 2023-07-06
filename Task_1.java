import java.util.*;

public class Task_1 {
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>();
		map.put("Иванов Иван" , "89282213344");
		map.put("Петров Петр" , "89292113456");
		map.put("Иванов Александр" , "89282213478");
		map.put("Сидоров Андрей" , "89124123456");
		map.put("Иванов Петр" , "89282264634");
		
		
		Map<String, String> sorted = new TreeMap<>(map);
		
		
		Map<String, Integer> phoneBook = new HashMap<String, Integer>();
		
		
		for (String key : sorted.keySet()) {
			String name = key.substring(0, key.indexOf(" "));
			
			if (phoneBook.containsKey(name)) {
				phoneBook.put(name, phoneBook.get(name) + 1);
			} else {
				phoneBook.put(name, 1);
			}
		}
		
		
		Map<String, Integer> sortedPhoneBook = sortByValues(phoneBook);
		
		
		System.out.println(sortedPhoneBook);
		
	}
	
	
	private static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k2).compareTo(map.get(k1));
				if (compare == 0) 
					return 1;
				else 
					return compare;
			}
		};
 
		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}
}