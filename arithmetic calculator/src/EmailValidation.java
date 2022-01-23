

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation { //will ignore quoted email

	private final String [] VALIDEMAILS = {
			"manager@mphasis.com",
			"learner@mphasis.com",
			"trainer@mphasis.com",
			"ceo@mphasis.com"
	};

	public boolean validateEmail(String emailtovalidate) {
		String regexdoublepoint = ".*[.]{2}.*";
		String emailpattern ="[a-zA-Z0-9!#$&'*+-/=?^_`{|}~]*@[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9][.][a-zA-Z]*"; // email construction rulles from wikipedia

		Pattern pattern = Pattern.compile(regexdoublepoint);
		Matcher matcher = pattern.matcher(emailtovalidate);
		if(matcher.matches()) {
			System.out.println("Invalid email format , email with consecutive '.'");
			return false;
		}
		else {
			pattern = Pattern.compile(emailpattern);
			matcher = pattern.matcher(emailtovalidate);
			if(matcher.matches()) {
				for (int i=0;i<VALIDEMAILS.length;i++) {
					if (VALIDEMAILS[i].toLowerCase().equals(emailtovalidate.toLowerCase())) { // email servers are not case sensitive
						System.out.println("Email recognized... welcome");
						return true;
					}
				}

				{System.out.println("Email not recognized");
				return false;}
			}
			else
			{   System.out.println("Invalid email format");
				return false;}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EmailValidation email = new EmailValidation();
		Scanner sc = new Scanner(System.in);
		String userinput;
		do {
			System.out.println("Enter your email:");
		userinput = sc.next();
		}
		while(!email.validateEmail(userinput));
		System.out.println("Terminating after email validation... bye");
		sc.close();
	}

}