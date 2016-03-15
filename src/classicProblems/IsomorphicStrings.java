package classicProblems;

import java.util.HashMap;

public class IsomorphicStrings {
	private String s;
	private String t;
	private HashMap<Character, Character> map;
	
	public IsomorphicStrings() {
		// TODO Auto-generated constructor stub
		s = "egg";
		t = "add";
		map = new HashMap<Character, Character>();
	}
	
	public boolean isIsomorphicString(){
		if(s == null || t == null)
			return false;
		if(s.length() != t.length())
			return false;
		if(s.length() == 0 && t.length() == 0)
			return true;
		for(int i = 0; i < s.length(); i++){
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if(!map.containsKey(c1) && !map.containsValue(c2))
				map.put(c1, c2);
			if(map.get(c1) == null)
				return false;
			if(map.get(c1) != c2)
				return false;
		}
		return true;
	}
	
	public static void main(String[] argc) {
		IsomorphicStrings is = new IsomorphicStrings();
		if(is.isIsomorphicString())
			System.out.println("True");
		else
			System.out.println("False");
	}

}
