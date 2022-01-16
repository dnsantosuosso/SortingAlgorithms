package york.eecs.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import york.eecs.source.BubbleSort;
import york.eecs.source.HeapSort;
import york.eecs.source.MapContainsNullValueException;

public class StudentTest {
 /**
  * TODO: Please write at least 5 test cases for testing @BubbleSort.
  * TODO: Please write at least 5 test cases for testing @HeapSort.
  */
	
	BubbleSort bubble;
	
	 @Before
	    public void setUp1() throws Exception {
		 bubble = new BubbleSort();
	    }
	 
	 HeapSort heapsort;
		
	    @Before
	    public void setUp2() throws Exception {
		 heapsort = new HeapSort();
	    }
	
	
	@Test
	// ELEMENTS ARE PUT IN RANDOM ORDER
    public void test_bubble_1() throws MapContainsNullValueException {
	 Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
	 
	 //How many world cups each country has
		map_to_be_sorted.put("Venezuela", 0);
		map_to_be_sorted.put("Brasil", 5);
		map_to_be_sorted.put("Italy", 4); 
		map_to_be_sorted.put("Spain", 1);
		map_to_be_sorted.put("Argentina", 2);
     
      /**
       * Initialize the `map' in @BubbleSort with `map_to_be_sorted'.
       */
      bubble.setMap(map_to_be_sorted);
        
     /**
      * @Expectedresult: the order of keys after ranking `map' by value with bubble algorithm.
      */
     ArrayList<String> expected_result = new ArrayList<String>();
     expected_result.add("Venezuela");
     expected_result.add("Spain");
     expected_result.add("Argentina");
     expected_result.add("Italy");
     expected_result.add("Brasil");
	 

     for(int i =0; i<expected_result.size(); i++) {
    	 Assert.assertEquals(expected_result.get(i), bubble.sortbyValue().get(i));
    	 }
	}
     
     @Test
     // ELEMENTS ARE IN DESCENDING ORDER
     public void test_bubble_2() throws MapContainsNullValueException {
 	 Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
 	 
 	 //Student marks in EECS courses
 		map_to_be_sorted.put("EECS2011", 95);
 		map_to_be_sorted.put("EECS2030", 90);
 		map_to_be_sorted.put("EECS2031", 84); 
 		map_to_be_sorted.put("EECS2001", 70);
      
       /**
        * Initialize the `map' in @BubbleSort with `map_to_be_sorted'.
        */
       bubble.setMap(map_to_be_sorted);
         
      /**
       * @Expectedresult: the order of keys after ranking `map' by value with bubble algorithm.
       */
      ArrayList<String> expected_result = new ArrayList<String>();
      expected_result.add("EECS2001");
      expected_result.add("EECS2031");
      expected_result.add("EECS2030");
      expected_result.add("EECS2011");
 	 

      for(int i =0; i<expected_result.size(); i++) {
     	 Assert.assertEquals(expected_result.get(i), bubble.sortbyValue().get(i));
      }
     }
     
     @Test
     // ELEMENTS ARE ALREADY IN ASCENDING ORDER
     public void test_bubble_3() throws MapContainsNullValueException {
 	 Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
 	 
 	 //Population of countries
 		map_to_be_sorted.put("Venezuela", 30567841);
 		map_to_be_sorted.put("Canada", 37894670);
 		map_to_be_sorted.put("Italy", 60456789); 
 		map_to_be_sorted.put("United States", 328234542);
 		map_to_be_sorted.put("China", 1328467638);
      
       /**
        * Initialize the `map' in @BubbleSort with `map_to_be_sorted'.
        */
       bubble.setMap(map_to_be_sorted);
         
      /**
       * @Expectedresult: the order of keys after ranking `map' by value with bubble algorithm.
       */
      ArrayList<String> expected_result = new ArrayList<String>();
      expected_result.add("Venezuela");
      expected_result.add("Canada");
      expected_result.add("Italy");
      expected_result.add("United States");
      expected_result.add("China");
 	 

      for(int i =0; i<expected_result.size(); i++) {
     	 Assert.assertEquals(expected_result.get(i), bubble.sortbyValue().get(i));
      }
     }
     
     @Test
     // ONLY ONE ELEMENT
     public void test_bubble_4() throws MapContainsNullValueException {
 	 Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
 	 
 	 //Name and student number
 		map_to_be_sorted.put("Diego Santosuosso", 217339987);
      
       /**
        * Initialize the `map' in @BubbleSort with `map_to_be_sorted'.
        */
       bubble.setMap(map_to_be_sorted);
         
      /**
       * @Expectedresult: the order of keys after ranking `map' by value with bubble algorithm.
       */
      ArrayList<String> expected_result = new ArrayList<String>();
      expected_result.add("Diego Santosuosso");
 	 

      for(int i =0; i<expected_result.size(); i++) {
     	 Assert.assertEquals(expected_result.get(i), bubble.sortbyValue().get(i));
      }
     }
     
     @Test(expected = MapContainsNullValueException.class)
     // ONLY NULL ELEMENTS
     public void test_bubble_5() throws MapContainsNullValueException {
 	 Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
 	 
 	 //Presidents of the world
 		map_to_be_sorted.put("Joe Biden", null);
 		map_to_be_sorted.put("Justin Trudeau", null);
 		map_to_be_sorted.put("Fidel Castro", null);
      
       /**
        * Initialize the `map' in @BubbleSort with `map_to_be_sorted'.
        */
       bubble.setMap(map_to_be_sorted);
     }
     
     @Test
     // ELEMENTS ARE PUT IN RANDOM ORDER
	    public void test_heap_1() {
		Map<String, Double> map_to_be_sorted = new HashMap<String, Double>();
		//How many world cups each country has
		map_to_be_sorted.put("Venezuela", 0.0);
		map_to_be_sorted.put("Brasil", 5.0);
		map_to_be_sorted.put("Italy", 4.0);
		map_to_be_sorted.put("Spain", 1.0);
		map_to_be_sorted.put("Argentina", 2.0);
	    /**
	     * Initialize the `map' in bubble with `map_to_be_sorted';
	     */
	    heapsort.setMap(map_to_be_sorted);    
	    
	    /**
	     * Expected results: the order of keys after ranking `map' by value with max heap algorithm;
	     */
		ArrayList<String> results = new ArrayList<String>();
		results.add("Venezuela");
		results.add("Spain");
		results.add("Argentina");
		results.add("Italy");
		results.add("Brasil");
	    
	    /**
	     * Elements in the same position from the expected result and the ranked key list should the same;
	     */
		for(int i =0; i<results.size(); i++) {
			 Assert.assertEquals(results.get(i), heapsort.sortbyValue().get(i));
		}
  }
     
     @Test
     // ELEMENTS ARE IN DESCENDING ORDER
	    public void test_heap_2() {
		Map<String, Double> map_to_be_sorted = new HashMap<String, Double>();
		
		//Student marks in EECS courses
 		map_to_be_sorted.put("EECS2011", 95.2);
 		map_to_be_sorted.put("EECS2030", 90.3);
 		map_to_be_sorted.put("EECS2031", 84.4); 
 		map_to_be_sorted.put("EECS2001", 70.8);
	    /**
	     * Initialize the `map' in bubble with `map_to_be_sorted';
	     */
	    heapsort.setMap(map_to_be_sorted);    
	    
	    /**
	     * Expected results: the order of keys after ranking `map' by value with max heap algorithm;
	     */
		ArrayList<String> results = new ArrayList<String>();
		results.add("EECS2001");
		results.add("EECS2031");
		results.add("EECS2030");
		results.add("EECS2011");
	    
	    /**
	     * Elements in the same position from the expected result and the ranked key list should the same;
	     */
		for(int i =0; i<results.size(); i++) {
			 Assert.assertEquals(results.get(i), heapsort.sortbyValue().get(i));
		}
  }
     
     @Test
     // ELEMENTS ARE ALREADY IN ASCENDING ORDER
	    public void test_heap_3() {
		Map<String, Double> map_to_be_sorted = new HashMap<String, Double>();
		
		//Population of countries
 		map_to_be_sorted.put("Venezuela", 30567841.0);
 		map_to_be_sorted.put("Canada", 37894670.0);
 		map_to_be_sorted.put("Italy", 60456789.0); 
 		map_to_be_sorted.put("United States", 328234542.0);
 		map_to_be_sorted.put("China", 1328467638.0);
 		
	    /**
	     * Initialize the `map' in bubble with `map_to_be_sorted';
	     */
	    heapsort.setMap(map_to_be_sorted);    
	    
	    /**
	     * Expected results: the order of keys after ranking `map' by value with max heap algorithm;
	     */
	    ArrayList<String> results = new ArrayList<String>();
	    results.add("Venezuela");
	    results.add("Canada");
	    results.add("Italy");
	    results.add("United States");
	    results.add("China");
	    
	    /**
	     * Elements in the same position from the expected result and the ranked key list should the same;
	     */
		for(int i =0; i<results.size(); i++) {
			 Assert.assertEquals(results.get(i), heapsort.sortbyValue().get(i));
		}
  }
     
     @Test
     // ONLY ONE ELEMENT
	    public void test_heap_4() {
		Map<String, Double> map_to_be_sorted = new HashMap<String, Double>();
		
		//My weight
 		map_to_be_sorted.put("Diego Santosuosso", 87.3);
 		
	    /**
	     * Initialize the `map' in bubble with `map_to_be_sorted';
	     */
	    heapsort.setMap(map_to_be_sorted);    
	    
	    /**
	     * Expected results: the order of keys after ranking `map' by value with max heap algorithm;
	     */
	    ArrayList<String> results = new ArrayList<String>();
	    results.add("Diego Santosuosso");
	    /**
	     * Elements in the same position from the expected result and the ranked key list should the same;
	     */
		for(int i =0; i<results.size(); i++) {
			 Assert.assertEquals(results.get(i), heapsort.sortbyValue().get(i));
		}
  }
     
     @Test(expected = MapContainsNullValueException.class)
     // ONLY NULL ELEMENTS
     public void test_heap_5() throws MapContainsNullValueException {
 	 Map<String, Double> map_to_be_sorted = new HashMap<String, Double>();
 	 
 	 //Presidents of the world
 		map_to_be_sorted.put("Joe Biden", null);
 		map_to_be_sorted.put("Justin Trudeau", null);
 		map_to_be_sorted.put("Fidel Castro", null);
      
       /**
        * Initialize the `map' in @BubbleSort with `map_to_be_sorted'.
        */
       heapsort.setMap(map_to_be_sorted);
     }
}
