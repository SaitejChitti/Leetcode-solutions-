class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        HashMap<Character, String> digitToChar = new HashMap<>();
        digitToChar.put('2', "abc");
        digitToChar.put('3', "def");
        digitToChar.put('4', "ghi");
        digitToChar.put('5', "jkl");
        digitToChar.put('6', "mno");
        digitToChar.put('7', "pqrs");
        digitToChar.put('8', "tuv");
        digitToChar.put('9', "wxyz");
        
        backtrack(digits, 0, "", result, digitToChar);
        return result;
    }
    
    private void backtrack(String digits, int index, String current, 
                          List<String> result, HashMap<Character, String> digitToChar) {
        // Base case: found a complete combination
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        
        // Get current digit's letters
        char digit = digits.charAt(index);
        String letters = digitToChar.get(digit);
        
        // Try each letter for current digit
        for (char letter : letters.toCharArray()) {
            backtrack(digits, index + 1, current + letter, result, digitToChar);
        }
    }
}
