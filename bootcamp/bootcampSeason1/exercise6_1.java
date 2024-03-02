class exercise6_1 {
	public static void main (String[] args) {
		int[] myArray = {0,5,1209,6,2,111,112,33};
		int myArrayCount = myArray.length; // extrating array number
		System.out.println("Your Array have " + myArrayCount + " numbers."); 
	        int i = 0; //counter
			    //
			while (i < myArrayCount) { //Enquanto countador é menor que o lenght do array
				int newArray[] = new int [myArrayCount];
				newArray[i]=myArray[i]-myArray[i+1];
				System.out.println(newArray[i]);
				i= i + 1;
			};
	}
}
