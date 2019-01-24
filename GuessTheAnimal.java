import java.util.*;
import java.io.*;

public class GuessTheAnimal {
	public static void main (String [] args) throws IOException {
	    //
	    BufferedReader f = new BufferedReader(new FileReader("guess.in"));
	                                                  
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));
	  
	    StringTokenizer token1 = new StringTokenizer(f.readLine()); 
	    int n = Integer.parseInt(token1.nextToken());
	    
	 // Read array and convert string properties to numeric codes
	    
	    ArrayList <String> chars_list = new ArrayList<String>();
	    
	    Integer [] numProp = new Integer[n];
	    int max = 0;
	    
	    for (int i = 0; i < numProp.length; i++) {
	    	numProp[i] = 0;
	    }
	    
	    Integer [][] properties = new Integer [n][100];
	    
	    for(int i = 0; i < n; i++)
	    {
	            StringTokenizer token2 = new StringTokenizer(f.readLine()); 
	            String animalToken = token2.nextToken();
	            int numprop = Integer.parseInt(token2.nextToken());
	            for (int j = 0; j < numprop ; j++)
	            {
	                String charac = token2.nextToken();
	                boolean found = false;
	                int propnum = 0;
	                for(int k=0 ; k < chars_list.size(); k++)
	                {
	                    if(charac.equals(chars_list.get(k)))
	                    {
	                           found = true;
	                           propnum = k;
	                           break;
	                    }
	                }
	                if(found == false)
	                {
	                    chars_list.add(charac);
	                    properties[i][numProp[i]] = chars_list.size() - 1;
	                    numProp[i]++;
	                }
	                else
	                {
	                    properties[i][numProp[i]] = propnum;
	                    numProp[i]++;
	                }
	            }
	    }	    
	    
	    // Main loop to exhaustively search through all the properties
	    
	    for(int i = 0; i < n; i++)
	    {
	           if(numProp[i] <= max)
	               continue;
	           for(int j = i+1 ; j < n; j++)
	           {
	               int localmax = 0;
	               if(numProp[j] <= max)
	                   continue;
	               
	               for(int k = 0; k < numProp[i]; k++)
	               {
	                   for(int l = 0; l < numProp[j] ; l++)
	                   {
	                       if(properties[i][k] == properties[j][l])
	                       {
	                           localmax++;
	                           break;
	                       }
	                   }
	               }
	               if( localmax > max) 
	                   max = localmax;	               
	           }
	    }
	    
	    f.close();
        //System.out.println(max+1);
	    out.println(max+1);
	    out.close(); 
	}
}

