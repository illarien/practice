package QuizesOld;

// String to Integer

public class WordsStringToInteger {

	public static int atoi(String str) {
		char [] arc = str.toCharArray();
		int num = 0;
		int sing = 1;
		System.out.println(arc);
		int i = 0;
		
		if (arc.length > 11) {System.out.println("Too long"); return num;}
		if (arc.length < 1) {System.out.println("Empty string"); return num;}
		if (hasLet(arc)) {System.out.println("Has wrong simb"); return num;}
	
		if (arc[0] == '0') {return 0;}
		
		if (arc[0] == '-') {sing = -1; i++;
		
//		switch (month) {
 //       case 1:  monthString = "January";
  //               break;
 //       case 2:  monthString = "February";
  //               break;
 //      
  //      default: monthString = "Invalid month";
   //              break;
//		}
		
		
		while (i < arc.length) {
			num *= 10;
			num = (arc[i] == '1') ? num += 1: num;
			num = (arc[i] == '2') ? num += 2: num;
			num = (arc[i] == '3') ? num += 3: num;
			num = (arc[i] == '4') ? num += 4: num;
			num = (arc[i] == '5') ? num += 5: num;
			num = (arc[i] == '6') ? num += 6: num;
			num = (arc[i] == '7') ? num += 7: num;
			num = (arc[i] == '8') ? num += 8: num;
			num = (arc[i] == '9') ? num += 9: num;
			num = (arc[i] == '0') ? num += 0: num;
			i++;
		}
		
		}
		else {
			while (i < arc.length) {
				num *= 10;
				num = (arc[i] == '1') ? num += 1: num;
				num = (arc[i] == '2') ? num += 2: num;
				num = (arc[i] == '3') ? num += 3: num;
				num = (arc[i] == '4') ? num += 4: num;
				num = (arc[i] == '5') ? num += 5: num;
				num = (arc[i] == '6') ? num += 6: num;
				num = (arc[i] == '7') ? num += 7: num;
				num = (arc[i] == '8') ? num += 8: num;
				num = (arc[i] == '9') ? num += 9: num;
				num = (arc[i] == '0') ? num += 0: num;
				i++;
			}
		}
		return num*sing;
	}
	
	public static boolean hasLet(char[] array) {
		boolean flag = false;
		for (int i = 0; i < array.length; i++) {
			flag = (array[i] == '-') ? false : (array[i] == '0') ? false : (array[i] == '1') ? false :
				(array[i] == '2') ? false : (array[i] == '3') ? false : (array[i] == '4') ? false : (array[i] == '5') ? false :
					(array[i] == '6') ? false : (array[i] == '7') ? false : (array[i] == '8') ? false : (array[i] == '9') ? false : true;
		}
		return flag;
	}
	
	public static void main(String[] args) {
		
		String str = "4567";
		System.out.println(atoi(str));
		
		str = "-7834";
		System.out.println(atoi(str));
		
		str = "0";
		System.out.println(atoi(str));
		
		str = "";
		System.out.println(atoi(str));
		
		str = "78d34";
		System.out.println(atoi(str));

		str = "783412341234555";
		System.out.println(atoi(str));
	}

}
