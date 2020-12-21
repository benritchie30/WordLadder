import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class WordLadder {
	private static String start;
	private static String end;
	private static StringMap T;			// This map stores the dictionary of words.
	private static StringMap R;			// This map keeps track of all the words that are visited during breadth-first-search.
																	// The key field is the word that is visited, and its value field can hold the predecessor pointer.
	private static Queue Q;					// A queue to perform the breadth-first-search.

	public static void main(String [] args) throws IOException {
		// Loading the dictionary of words into the StringMap T.
		T = new StringMap();
		File file = new File("dictionary4");
		Scanner f = new Scanner(file);
		while (f.hasNext()) {
			String word = f.nextLine();
			T.insert(word, "");
		}
		f.close();

		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the start word: ");
		start = kb.nextLine();
		System.out.print("Enter the end word: ");
		end = kb.nextLine();

		// TODO: Solution to find the shortest set of words that transforms the start word to the end word.
        R = new StringMap();
        Q = new Queue();
        Q.enqueue(new QNode (0 , start));
        R.insert(start, ""); 
        QNode target = null;        
        while (!Q.isEmpty()){
            QNode cur = Q.dequeue();
            String curWord = cur.getWord();
            for (int i = 0; i < curWord.length(); i++) {
                StringBuffer sb = new StringBuffer(curWord);
                for (char j = 'a'; j <= 'z'; j++) {
                    sb.setCharAt(i,j);
                    if (T.find(sb.toString()) != null){
                        //System.out.println(sb.toString()); 
                        if (R.find(sb.toString()) == null){
                            R.insert(sb.toString(), curWord);
                            QNode next = new QNode(cur.getDist() + 1, sb.toString()); 
                            Q.enqueue(next); 
                            //Q.print();                            
                        }
                    
                    
                    
                    }   
            }
        

        }



        }
        
        if (R.find(end) != null){
            System.out.println("Yay! A word ladder is possible.");     
            print(R.find(end));   
        }
        else{
            System.out.println("Duh! Impossible.");   
        }
            
            
       
	}

    public static void print(StringNode cur){
        if (cur.getValue() == ""){
            System.out.println(cur.getKey());
            return;
        }
        print(R.find(cur.getValue()));
        System.out.println(cur.getKey());

    }


}





