package york.eecs.source;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author song and you
 * @description: @BubbleSort uses bubble sorting algorithm to rank a map based on the values.
 */
public class BubbleSort implements MapSort<String, Integer>{
    /**
     * @map to be sort;
     */
	public Map<String, Integer> map;
    
	/**
	 * TODO: There are missing methods, you can find clues from test cases.
	 * Missing methods are setMap and getMap
     */
	

	/**
	 * @description: Sort a map by the values in ascending order with bubble sorting algorithm. 
	 * @return: Return the corresponding key list of the sort map.
	 */
	@Override
	public ArrayList<String> sortbyValue(){
	/**
	 *  TODO: Implement sorting the maps by values with bubble sorting algorithm.
	 *  	  This method returns the corresponding key arrlist.
	 */
		
		
		ArrayList<Integer> arrlist = new ArrayList<Integer>(map.values());
		
		boolean sort = false;
		while (!sort) {
			//set sort to true
			sort = true;
			for (int i = 0; i < arrlist.size()-1; i++) {
				if (arrlist.get(i).compareTo(arrlist.get(1 + i)) > 0) {
					
					//Swap helper method				
					arrlist = swap(i, arrlist);
					
					//set sort to false
					sort = false;
					}
				}
			}
		
		
		 ArrayList<String> final_list = new ArrayList<String>();
		 
		 //Add values to final_list
			for (int i = 0; i < arrlist.size(); i++) {
				final_list.add(getKey(map, arrlist.get(i)));
			}
		
		return final_list;
	}

	
	/**
	 * @description: Swap helper method
	 * @param i
	 * @param arrlist
	 * @return swapped list
	 */
	public ArrayList<Integer> swap(int i, ArrayList<Integer> arrlist){
		
		Integer temp;
		
		temp = arrlist.get(i);
		arrlist.set(i, arrlist.get(1+i));
		arrlist.set(1+i, temp);
		
		return arrlist;
		
	}
	

	/**
	 * @description: Missing method 1
	 * @param map_to_be_sorted
	 * @throws MapContainsNullValueException 
	 */
	
	public void setMap(Map<String, Integer> map_to_be_sorted) throws MapContainsNullValueException {
		//Method should throw MapContainsNullValueException, when the values in the map contain @null.

		ArrayList<String> result = (ArrayList<String>) map_to_be_sorted.keySet().stream().collect(Collectors.toList());
		
		for (int i = 0; i < map_to_be_sorted.size(); i++) {
			if (map_to_be_sorted.get(result.get(i)) == null) {
				throw new MapContainsNullValueException("Map Contains Null Value");
			}
		}
		
		this.map = map_to_be_sorted;
	}
	
	/**
	 * 
	 * @description: Missing method 2
	 * @return Map
	 */

	public Map<String, Integer> getMap() {
		return map;
	}
	
	public <K, V> K getKey(Map<K, V> map, V value) {
	    for (java.util.Map.Entry<K, V> entry : map.entrySet()) {
	        if (entry.getValue().equals(value)) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
}