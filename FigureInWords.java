import java.util.Scanner;

public class FigureInWords{

	static String ones[] = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
	static String tens[] = new String[]{"twenty","thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	static String beyondTens[] = new String[]{"Hundred","Thousand", "Million"};
	static boolean isNegative;

	public static String getOnes(int num){
		return ones[num];

	}
	public static String getTens(int num){
		String inWords ="";
		if(num>=20 && num<30){
			if(num==20)inWords += tens[0];
			else inWords += tens[0] + "-" + ones[num- 20];
		}else if (num>=30 && num<40) {
			if(num==30)inWords += tens[1];
			inWords += tens[1] + "-" + ones[num-30];
		}else if (num>=40 && num<50) {
			if(num==40)inWords += tens[2];
			inWords += tens[2] + "-" + ones[num-40];
		}else if (num>=50 && num<60) {
			if(num==50)inWords += tens[3];
			inWords += tens[3] + "-" + ones[num-50];
		}else if (num>=60 && num<70) {
			if(num==60)inWords += tens[4];
			inWords += tens[4] + "-" + ones[num-60];
		}else if (num>=70 && num<80) {
			if(num==70)inWords += tens[5];
			inWords += tens[5] + "-" + ones[num-70];
		}else if (num>=80 && num<90) {
			if(num==80)inWords += tens[6];
			inWords += tens[6] + "-" + ones[num-80];
		}else if (num>=90 && num<100) {
			if(num==90)inWords += tens[7];
			inWords += tens[7] + "-" + ones[num-90];
		}


		return inWords;


	}
	public static String getBeyondTens(int num){
		String inWords = "";

		if((num % 100)== 0){
			inWords+= ones[num/100] + "";
			inWords+= tens[0];

		}else if((num % 1000)== 0){
			inWords+= ones[num/1000] + "";
			inWords+= tens[1];

		}else if(num>100 && num<1000){
			String value= num + "";
			String partOne= value.substring (0,1);
			String partTwo= value.substring(1);
			inWords+= ones[Integer.parseInt(partOne)];
			inWords+= beyondTens[0]+ " and ";
			inWords+= getTens(Integer.parseInt(partTwo));

		}

		return inWords;

	}



	public static void main(String[] args) {
		while (true){
			String result = "";
			isNegative = false;
			System.out.print("Enter a number (or done to quit): ");
			Scanner in = new Scanner(System.in);
			String userInput = in.nextLine();
			if (userInput.equalsIgnoreCase("done")){
				System.out.println("Thankyou for using the service");
				System.exit(0);

			}
			try{

				int num = Integer.parseInt(userInput);
				
			

			if(num<0){
				isNegative = true;
				num*= -1;
				
			}


			if(num<20){
				result = getOnes(num);
				

			}else if(num<100){
				result = getTens(num);
				

			}else if(num<1000){
				result = getBeyondTens(num);

				
			}else {
				System.out.println("You entered a wrong value ");
			}


			if (isNegative==true){
				result = "negative " + result;  
			}

			System.out.println(result);

			}catch (NumberFormatException ex) {
				System.out.println("You entered a wrong value ");
			}



		}

		
	}

	


	

}