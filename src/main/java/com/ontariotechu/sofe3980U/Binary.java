package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should conatins only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
    public Binary(String number) {
		for (int i = 0; i < number.length(); i++) {
			// check each character if it's not 0 or 1
			char ch=number.charAt(i);
			if(ch!='0' && ch!='1') {
				number="0"; // if not store "0" and end the function
				return;
			}
		}
		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg)!='0')
				break;
		}
		//beg has the index of the first non zero digit in the number
		this.number=number.substring(beg); // exclude the trailing zeros if any
		// uncomment the following code
			if(this.number=="") { // replace empty strings with a single zero
				this.number="0";
			}
    }
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	} 

	/**
	* Function takes two binary numbers, checks if they're the same length, 
	* if not makes the smaller have equal length by adding in zeros 

	* @param  num1 The first binary number 
	* @param num2 The second binary number 
	* @return Returns equal length binary numbers in a string array
	*/

	private static String[] equalLength(Binary num1, Binary num2) {

		// Initialize adding zeros to zero 
		int addZeros = 0; 

		// Get binary value for both binary numbers
		String nStrOne = num1.getValue(); 
		String nStrTwo = num2.getValue(); 
		
		// Check which binary value is longer in length 
		if (nStrOne.length() > nStrTwo.length()) {

			// Get number of zeros to add into smaller binary number
			addZeros = nStrOne.length() - nStrTwo.length();

			// Add in zeros to make smaller binary number same length
			nStrTwo = new String(new char[addZeros]).replace("\0", "0") + nStrTwo; 
		} 
		else {
			// Get number of zeros to add into smaller binary number
			addZeros = nStrTwo.length() - nStrOne.length(); 

			// Add in zeros to make smaller binary number same length
			nStrOne = new String(new char[addZeros]).replace("\0", "0") + nStrOne;
		}

		return new String[] {nStrOne, nStrTwo};
	}
	
	/**
	 *  This function takes in two binary number inputs and performs a bitwise OR operation 
	 * 
	 * @param num1 The first binary number
	 * @param num2 The second binary number
	 * 
	 * @return Returns binary output of operation  
	 */

	public static Binary orOperation(Binary num1, Binary num2) {

		// Call equalLength to manipulate both binary numbers to have equal lengths
		String[] equalBinarySet = equalLength(num1, num2); 
		
		// Set new binary set of numbers 
		String nStrOne = equalBinarySet[0]; 
		String nStrTwo = equalBinarySet[1]; 

		// Set final result
		String result = ""; 

		// Initiate bit
		int bit = nStrOne.length(); 

		// Loop through entire bit of each binary number and compare each 
		while (bit >= 0) {	
			
			// Check if at least one of the bits is 1, if so append to result 1, otherwise 0 
			if (nStrOne.charAt(bit) == '1' || nStrTwo.charAt(bit) == '1') {
				result += "1"; 
			}
			else {
				result += "0"; 
			}

			bit -= 1; 
		}

		// Return the result of the OR operation
		return new Binary(result); 
	 }

	/**
	 *  This function takes in two binary number inputs and performs a bitwise AND operation 
	 * 
	 * @param num1 The first binary number
	 * @param num2 The second binary number
	 * 
	 * @return Returns binary output of operation  
	 */ 

	public static Binary andOperation(Binary num1, Binary num2) {
		// Call equalLength to manipulate both binary numbers to have equal lengths
		String[] equalBinarySet = equalLength(num1, num2); 

		// Set new binary set of numbers 
		String nStrOne = equalBinarySet[0];
		String nStrTwo = equalBinarySet[1];

		// Set final result
		String result = "";
		
		// Initiate bit
		int bit = nStrOne.length(); 
		
		// Loop through entire bit of each binary number and compare each 
		while (bit >= 0) {

			// Check if both bit values of each binary equals 1, if so append 1 to result, otherwise 0
			if (nStrOne.charAt(bit) == '1' && nStrTwo.charAt(bit) == '1') {
				result += "1";
			}
			else {
				result += "0"; 
			}

			bit -= 1; 
		}

		// Return the result of the AND operation
		return new Binary(result);
	}

	/**
	 *  This function takes in two binary number inputs and performs a MULTIPLY operation 
	 * 
	 * @param num1 The first binary number
	 * @param num2 The second binary number
	 * 
	 * @return Returns binary output of operation  
	 */ 

	// public static Binary multOperation(Binary num1, Binary num2) {
	// 	// Call equalLength to manipulate both binary numbers to have equal lengths
	// 	String[] equalBinarySet = equalLength(num1, num2); 

	// 	// Set new binary set of numbers 
	// 	String nStrOne = equalBinarySet[0];
	// 	String nStrTwo = equalBinarySet[1];

	// 	// Set final result
	// 	Binary result = new Binary("0");

	// 	// Initiate bits
	// 	int bitOne = nStrOne.length() -1; 
	// 	int bitTwo = nStrTwo.length() -1; 

	// 	// Loop through first binary number from right side to perform correct Multiply operation
	// 	for (int i = bitOne; i >= 0; i--) {

	// 		// Append zeros to the right end of the result 
	// 		String currentBinNum = new String(new char[nStrOne.length() -1 - i]).replace("\0", "0");

	// 		// Loop through each bit of the second binary number and multiply it with the first binary number
	// 		for (int j = bitTwo; j >= 0; j--) {
	// 			if (nStrOne.charAt(i) == nStrTwo.charAt(j)) {
	// 				currentBinNum = nStrOne.charAt(i) + currentBinNum; 
	// 			}
	// 			else {
	// 				currentBinNum = "0" + currentBinNum; 
	// 			}
	// 		}

	// 		// After result of first iteration, can use AND operation 
	// 		result = Binary.add(new Binary(currentBinNum), result);
	// 	}

	// 	return result; 
	// }

	public static Binary multOperation(Binary num1, Binary num2) {
		// Call equalLength to manipulate both binary numbers to have equal lengths
		String[] equalBinarySet = equalLength(num1, num2); 

		// Set new binary set of numbers 
		String nStrOne = equalBinarySet[0];
		String nStrTwo = equalBinarySet[1];

		// Set final result
		Binary result = new Binary("0");

		// Initiate bits
		int bitOne = nStrOne.length() -1; 
		int bitTwo = nStrTwo.length() -1; 

		// Loop through first binary number from right side to perform correct Multiply operation
		while (bitOne >= 0) {

			
			int i = bitOne; 
			// Append zeros to the right end of the result 
			String currentBinNum = new String(new char[nStrOne.length() -1 - i]).replace("\0", "0");

			// Loop through each bit of the second binary number and multiply it with the first binary number
			for (int j = bitTwo; j >= 0; j--) {
				if (nStrOne.charAt(i) == nStrTwo.charAt(j)) {
					currentBinNum = nStrOne.charAt(i) + currentBinNum; 
				}
				else {
					currentBinNum = "0" + currentBinNum; 
				}
			}

			// After result of first iteration, can use AND operation 
			result = Binary.add(new Binary(currentBinNum), result);

			bitOne -= 1; 
		}

		return result; 
	}
}		