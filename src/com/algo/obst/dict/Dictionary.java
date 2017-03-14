package com.algo.obst.dict;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/*************************************************************************

*  Description:
*  Use your program as a rudimentary dictionary on real text 
*  of similar length (n words). Cite the source of your text. 
*  Determine the probability of searching each word by counting
*  how many times each word occurs in your text. Determine 
*  experimentally the expected search in the OBST obtained. 
*  You can omit the definition of each word since you are just 
*  testing the expected search time of your OBST.
*   
*  Visible data fields:
*  COPY DECLARATION OF VISIBLE DATA FIELDS HERE
*
*  Input: word entered by user
*  Output: Probability of finding that word and search cost
*  
* Text cited from :
* http://www.cs.princeton.edu/~chazelle/pubs/algorithm.html
* http://culturedigitally.org/2012/11/the-relevance-of-algorithms/
*
*  Visible methods:
*  main(String[] args)
*
*   Remarks
*   -------
*  Please change the file location and name accordingly

********************************************************************************************************************************/

public class Dictionary 
{
	public static void main(String[] args) throws IOException 
	{
		long startTime = 0;
		long endTime = 0;
		long runningTime = 0;
		double  p = 0;
		double count =0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try 
		{
			System.out.println(" Enter a word to search ");
			String wordToSearch = br.readLine();
			//set content file path
			String content = new String(Files.readAllBytes(Paths.get("Algorithms.txt")));
			StringTokenizer st = new StringTokenizer(content);
			//count number of words in the text
			double totalWords = st.countTokens();
			//System.out.println("Total number of words in the cited text "+totalWords);
			//check if word exist in the text
			int prob = content.indexOf(wordToSearch);
			//content.
			if(prob == -1)
			{
				System.out.println("Word not found!");
			}
			else
			{
				//count occurrences of word to calculate probability
				int wordToSearchLength = wordToSearch.length();
		        startTime = System.currentTimeMillis();
		        for(int i=0;i<content.length();i++)
		        {
		            if(wordToSearch.startsWith(Character.toString(content.charAt(i))))
		            {
		                if(content.substring(i).length() >= wordToSearchLength)
		                {
		                    if(content.substring(i, i+wordToSearchLength).equals(wordToSearch))
		                    {
		                        count++;
		                    }
		                }
		            }
		        }
		        // find probability of success
		        p = count/totalWords;
		        //round off the value
		        double temp = Math.round(p *1000);
		        p = temp/1000;
		        System.out.println("Probability of "+wordToSearch+" is: "+p);
		        endTime = System.currentTimeMillis();
			   // calculate total time taken
			   runningTime = endTime-startTime;
			   System.out.println("Running Time: "+runningTime+" ms");
			}
		} 
		catch (Exception e) 
		{
			System.out.println(" Exception occurred, while searching for a word "+e.getMessage());
		}
	}
}
