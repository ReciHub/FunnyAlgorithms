	public static boolean isAnagram(String s1, String s2)
	{
		if(s1.length()!=s2.length())return false;
		char [] c1 = s1.toCharArray();
		char [] c2 = s2.toCharArray();
		Arrays.sort(c1);
		arrays.sort(c2);
		String a1 = "", a2 = "";
		for(int i=0;i<c1.length; i++){
			a1+=c1[i];
			a2+=c2[i];
		}
		if(a1.equals(a2))return true;
		return false;
	}
