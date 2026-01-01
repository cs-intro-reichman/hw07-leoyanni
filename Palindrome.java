/** Checks if a given string is a palindrome. */
public class Palindrome {

	public static void main(String[]args) {
    	System.out.println(isPalindrome(args[0]));
    }
	
	/** Checks if the given string is a palindrome. */
		public static boolean isPalindrome(String s) {
		if (s.length() > 1 && s.charAt(0) == s.charAt(s.length() - 1)){
			s = s.substring(1);
			s = s.substring(0, s.length() - 1);
			return isPalindrome(s);
		}	else if (s.length() > 1) return false;
		return true;
	}
}