package classes;

public class SymmetricStringAnalyzer {
	private String s; 
	public SymmetricStringAnalyzer(String s) {
		this.s = s; 
	}
	
	/**
	 * Determines if the string s is symmetric
	 * @return true if it is; false, otherwise. 
	 */
	public boolean isValidContent() { 
		SLLStack<Character> stack = new SLLStack<Character>(); 
		for(int i=0; i < s.length(); i++) { 
			char c = s.charAt(i); 
			if (Character.isLetter(c))
			   if (Character.isUpperCase(c))
				  stack.push(c); 
			   else if (stack.isEmpty())
					 return false; 
			   else {
				   char t = stack.top(); 
				   if (t == Character.toUpperCase(c))
					   stack.pop();  
				   else 
					   return false; 
			   }
			else 
				return false; 
		} 
		if(stack.isEmpty())
			return true;
		return false;
	}
	
	public String toString() { 
		return s; 
	}

	public String parenthesizedExpression() throws StringIsNotSymmetricException {
		if(!(isValidContent()))
			throw new StringIsNotSymmetricException("parenthesizedExpression: string is not symmetric");
		String str = "";
		for(int i=0; i < s.length(); i++) { 
			char c = s.charAt(i); 
			if(Character.isUpperCase(c))
				str += ("<" + c + " ");
			else
				str += (c + "> ");			
		}
		return str;  
	}

}
