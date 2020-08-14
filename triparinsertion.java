
public class Gene {

	public void tri_insertion(int t[])
	{
	    int j;
	    int en_cours;
	 
	    for (int i = 1; i < 20; i++) {
	        en_cours = t[i];
	        for (j = i; j > 0 && t[j - 1] > en_cours; j--) {
	            t[j] = t[j - 1];
	        }
	        t[j] = en_cours;
	    }
	}	
}
