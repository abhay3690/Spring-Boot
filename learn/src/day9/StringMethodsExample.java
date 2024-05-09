package day9;


	public class StringMethodsExample {
	    public static void main(String[] args) {
	        String str = "Hello, World!";
	        
	        // length() - returns the length of the string
	        int length = str.length();
	        System.out.println("Length of the string: " + length); // Output: 13
	        
	        // charAt() - returns the character at the specified index
	        char charAtIndex5 = str.charAt(5);
	        System.out.println("Character at index 5: " + charAtIndex5); // Output: ,
	        
	        // substring() - returns a substring from the specified begin index to the end of the string
	        String substringFromIndex7 = str.substring(7);
	        System.out.println("Substring from index 7: " + substringFromIndex7); // Output: World!
	        
	        // substring() - returns a substring from the specified begin index (inclusive) to the specified end index (exclusive)
	        String substringFromIndex2To5 = str.substring(2, 5);
	        System.out.println("Substring from index 2 to 5: " + substringFromIndex2To5); // Output: llo
	        
	        // indexOf() - returns the index of the first occurrence of the specified substring
	        int indexOfComma = str.indexOf(",");
	        System.out.println("Index of comma: " + indexOfComma); // Output: 5
	        
	        // contains() - returns true if the string contains the specified substring
	        boolean containsHello = str.contains("Hello");
	        System.out.println("Contains 'Hello': " + containsHello); // Output: true
	        
	        // replace() - replaces all occurrences of a specified substring with another substring
	        String replacedString = str.replace("World", "Universe");
	        System.out.println("Replaced string: " + replacedString); // Output: Hello, Universe!
	        
	        // toUpperCase() - converts all characters in the string to uppercase
	        String upperCaseString = str.toUpperCase();
	        System.out.println("Uppercase string: " + upperCaseString); // Output: HELLO, WORLD!
	        
	        // toLowerCase() - converts all characters in the string to lowercase
	        String lowerCaseString = str.toLowerCase();
	        System.out.println("Lowercase string: " + lowerCaseString); // Output: hello, world!
	        
	        // trim() - removes leading and trailing whitespace
	        String stringWithWhitespace = "   Trim Me   ";
	        String trimmedString = stringWithWhitespace.trim();
	        System.out.println("Trimmed string: " + trimmedString); // Output: Trim Me
	    }
	}

