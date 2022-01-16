package york.eecs.source;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author song and you
 * @description: @HeapSort uses max heap algorithm to rank a map based on the values.
 */
public class HeapSort implements MapSort<String, Double>{
	/**
     * @map to be sorted;
     */	
	public Map<String, Double> map;
    
	/**
	 * TODO: There are missing methods, you can find clues of these methods from test cases.
	 * Missing methods are setMap and getMap
     */
	
	
	/**
	 * @description: Sort a map by the values in ascending order max heap sorting algorithm.
	 * @return: Return the corresponding key list of the sorted map.
	 */
	@Override
	public ArrayList<String> sortbyValue() {
		/**
		 *  TODO: Implement sorting the maps by values with max heap sorting algorithm.
		 *  	  This method returns the corresponding key list.
		 *  	  You need to use the auxiliary method, i.e., @heapify.
		 */
		
		Double[] var_arr = map.values().toArray(new Double[0]);
		int len = var_arr.length;
		
        for (int i = len / 2 - 1; i >= 0; i--) {
        	//Heapify
        	heapify(var_arr, i, len);
        }
 
        for (int i = len - 1; i > 0; i--) {
        	//Swap
            var_arr = swapping(var_arr, i);
            //Heapify
            heapify(var_arr, 0, i);
        }
		
		ArrayList<String> final_list = new ArrayList<String>();
		 
		 //Add values to list
			for (int i = 0; i < var_arr.length; i++) {
				final_list.add(getKey(map, (Double.valueOf(var_arr[i]))));
			}
		
		return final_list;
	}
	
	@SuppressWarnings("hiding")
	public <String, Double> String getKey(Map<String, Double> map, Double value) {
	    for (java.util.Map.Entry<String, Double> entry : map.entrySet()) {
	        if (entry.getValue().equals(value)) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
	
	
	/**
	 * To heapify a subtree rooted with node `i' which is an index in both @keys and @values. 
	 * `n' is size of heap.
	 */
	public void heapify(Double[] var_arr, int i,  int n) {
		
		int root = i; // Root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child
        
        // 3 CASES: If left child > root; if right child > root; if root is not i
 
        // Case 1: left > root (new root is left child)
        if (left < n && var_arr[left] > var_arr[root]) {
        	// root is left child
            root = left;
        }
 
        // Case 2: right > root (new root is right child)
        if (right < n && var_arr[right] > var_arr[root]) {
        	// root is right child
            root = right;
        }
 
        // Case 3: root != i (swap and recurse)
        if (root != i) {
        	
        	//swap
            var_arr = rootswap(var_arr, i, root);
            // Recursion
            heapify(var_arr, root, n);
        }
    }
	
	/**
	 * @description: Swap helper method 1 (for heapify function). Swaps int i with root
	 * @param var_arr
	 * @param i
	 * @return swapped list
	 */
	public Double[] rootswap(Double[] var_arr, int i, int root){
		
		Double temp;
		
		temp = var_arr[i];
		var_arr[i] = var_arr[root];
		var_arr[root] = temp;
		
		return var_arr;
		
	}
	
	/**
	 * @description: Swap helper method 2 (for sortbyValue function)
	 * @param var_arr
	 * @param i
	 * @return swapped list
	 */
	
	public Double[] swapping(Double[] var_arr, int i){
	
		Double temp;
		
		temp = var_arr[0];
        var_arr[0] = var_arr[i];
        var_arr[i] = temp;
        
		return var_arr;
		
	}
	
	/**
	 * @description: Missing method 1
	 * @param map_to_be_sorted
	 * @throws MapContainsNullValueException 
	 */

	public void setMap(Map<String, Double> map_to_be_sorted) {
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

	public Map<String, Double> getMap() {
		return map;
	}
}