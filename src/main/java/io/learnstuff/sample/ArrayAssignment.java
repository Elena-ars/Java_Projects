package io.learnstuff.sample;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class ArrayAssignment {
	static final Scanner scan = new Scanner(System.in);
	
	static int[] reverseIntArray(int arrayToReverse[], int noItems){//swapping items till half of the array
		for (int i = 0;i < noItems / 2; i++) {
			int temporaryItem = arrayToReverse[i];//first item and so on
			arrayToReverse[i] = arrayToReverse[noItems - i - 1];//put last item as first item and so on
			arrayToReverse[noItems - i - 1] = temporaryItem;//put first item as last item and so on
		}
		return arrayToReverse;
	}
	static String intArrayToString(int arrayInput[], int noItems) {
		String allItems = "";
		for (int k = 0; k < noItems; k++) {
			allItems = allItems + " " + arrayInput[k];
		}
		return allItems;
	}
	//	static char[] reverseCharArray(char arrayToReverse[], int noItems){//brute force reversing 
	//		char[] reversedArray = new char[noItems];
	//		int noReversedItems = noItems;
	//		for (int i = 0; i < noItems; i++) {
	//			reversedArray[noReversedItems - 1] = arrayToReverse[i];
	//			noReversedItems = noReversedItems - 1;
	//		}
	//		return reversedArray;
	//	}
	//	static String charArrayToString(char arrayInput[], int noItems) {
	//		String allItems = "";
	//		for (int k = 0; k < noItems; k++) {
	//			//allItems = allItems + " " + Character.toString(arrayToReverse[k]);
	//			allItems = allItems.concat(Character.toString(arrayInput[k]));
	//		}
	//		return allItems;
	//	}
	static void bubbleSort(int arrayToSort[])
    {
        int arrayLength = arrayToSort.length;
        for (int i = 0; i < arrayLength-1; i++)
            for (int j = 0; j < arrayLength-i-1; j++)
            	if (arrayToSort[j] > arrayToSort[j+1])
                {
                    //make the switch: lowest before higher value
                    int tempItem = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j+1];
                    arrayToSort[j+1] = tempItem;
                }
    }
	@SuppressWarnings("unused")
	public static void main(String[] args) {			
		//For an array of elements count the number of occurrences of a given element. 
		////(experiment with arrays of numbers and strings)
		////Read an array from the keyboard (requires the use of the Scanner class)
		////Use the Random class to generate elements for an array.
		////Generate a random array of numbers and search for a specific one. 
		////	If you find it then use a named break to exit the loop.
		////For a given array, reverse the order of the elements.
		////Implement the bubble sort algorithm.

		//create an array with integers generated randomly
		Random randomize = new Random();
		Integer[] randomizedArray = new Integer[30];
		for (int i = 0; i < randomizedArray.length; i++) {
			randomizedArray[i] = randomize.nextInt(5000); // storing random integers in an array
			System.out.println(randomizedArray[i]); // printing each array element
		}
		//search a specific number in a random populated array
		System.out.println("Enter the number you want to search for: \n"); 
		Integer numberToBeSearched = 0;
		while(numberToBeSearched == 0){  
			if(scan.hasNextInt()){  
				numberToBeSearched = scan.nextInt(); 
			}  
			else{  
				scan.next();  
			} 
		}
		//when it finds the first occurrence of the searched number it stops the loop
		loopNoOfOccurrences:
			for(int i = 0;i<randomizedArray.length;i++) {
				if(-1 != Arrays.asList(randomizedArray).indexOf(numberToBeSearched)) {
					System.out.println("The index of the first occurrence of the searched number is: " 
							+ Integer.valueOf(Arrays.asList(randomizedArray).indexOf(numberToBeSearched)).toString());
					break loopNoOfOccurrences;
				}				
			}
		//count the number of occurrences of a given element
		Integer noOccurrences = 0;
		for (int i=0; i<randomizedArray.length; i++){
		    if (randomizedArray[i].equals(numberToBeSearched)){
		    	++noOccurrences;
		    }
		}
		System.out.println("The searched number: " + numberToBeSearched.toString() + " appears: " + noOccurrences.toString() + " times.");
				
		//read from keyboard type of items of an array, its total number of items and each item of the array
				char itemsType;
				int noItems = 0;
		
				System.out.print("Select an option: \n  [i] --> integers \n  [c] --> chars \n  [s] --> strings \n");  
				itemsType = scan.next().charAt(0);
		
				System.out.print("Enter the number of items you want to store: \n"); 
				while(noItems == 0){  
					if(scan.hasNextInt()){  
						noItems = scan.nextInt(); 
					}  
					else{  
						scan.next();  
					} 
				}
		
				System.out.println("Enter the items of the array: \n");  		
				switch(itemsType) {
				case 'i':
					int[] intsArray = new int[noItems];  
					int totalSum = 0;
					for(int i=0;i<noItems;i++) {
						//reading the items from the user
						intsArray[i] = scan.nextInt();
						//Total SUM of all the integers
						totalSum = totalSum + intsArray[i];
					}
					System.out.println("The Total SUM of your integer items is: " + totalSum); 
					System.out.println("Your all initial inserted integer items are: ");  
					for (int i=0; i < noItems; i++)   
					{  
						System.out.println(intsArray[i]);  
					}  
					ArrayAssignment.reverseIntArray(intsArray,noItems);//reverse the items of the array
					System.out.println("Your inverted integer items are: " + ArrayAssignment.intArrayToString(intsArray, noItems));
					//Apply BUBBLE SORT
					ArrayAssignment.bubbleSort(intsArray);
					System.out.println("Your BUBBLE sorted integer items are: " + ArrayAssignment.intArrayToString(intsArray, noItems));
				case 'c':
					char[] charsArray = new char[noItems];  
					String finalWord = "";
					for(int i=0;i<noItems;i++) {
						//reading the items from the user (if there is more than 1 char, we get just 1)
						charsArray[i] = scan.next().charAt(0);
						//forming a word with all the chars
						finalWord = finalWord.concat(Character.toString(charsArray[i]));
					}
					System.out.println("The word formed with your char items is: " + finalWord);  
					System.out.println("Your all initial inserted char items are: ");  
					for (int i=0; i<noItems; i++)   
					{  
						System.out.println(charsArray[i]);  
					} 
		//			ArrayAssignment.reverseCharArray(charsArray,noItems);//reverse the items of the array
		//			System.out.println("Your inverted char items are: " + ArrayAssignment.charArrayToString(charsArray, noItems));  
				case 's':
					String[] stringsArray = new String[noItems];  
					String finalPhrase = "";
					for(int i=0;i<noItems;i++) {
						//reading the items from the user
						stringsArray[i] = scan.next();
						//forming a phrase with all the chars
						finalPhrase = finalPhrase + " " + stringsArray[i];
					}
					System.out.println("The phrase formed with your string items is: " + finalPhrase);  
					System.out.println("Your all inserted string items are: ");  
					for (int i=0; i<noItems; i++)   
					{  
						System.out.println(stringsArray[i]);  
					} 
				default:
					break;
		
				}
				scan.close(); 		
	}
}