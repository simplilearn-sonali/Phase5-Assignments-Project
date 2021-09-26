// Java implementation to count the
// number of ways to partition the
// String such that each partition
// have same number of distinct
// characters in the String
class GFG{

// Function to count the distinct
// characters in the String
static int distinctChars(String s)
{
	// Frequency of each character
	int freq[] = new int[26];
	int count = 0;
	
	// Loop to count the frequency
	// of each character of the String
	for (int i = 0; i < s.length(); i++)
		freq[s.charAt(i) - 'a']++;

	// If frequency is greater than 0
	// then the character occured
	for (int i = 0; i < 26; i++) {
		if (freq[i] > 0)
			count++;
	}

	return count;
}

// Function to count the number
// of ways to partition the String
// such that each partition have
// same number of distinct character
static int waysToSplit(String s)
{
	int n = s.length();
	int answer = 0;
	
	// Loop to choose the partition
	// index for the String
	for (int i = 1; i < n; i++) {
		
		// Divide in two parts
		String left = s.substring(0, i);
		String right = s.substring(i, n);

		// Check whether number of distinct
		// characters are equal
		if (distinctChars(left) ==
			distinctChars(right))
			answer++;
	}
	return answer;
}

// Driver Code
public static void main(String[] args)
{
	String s = "ababa";

	System.out.print(waysToSplit(s));
}
}