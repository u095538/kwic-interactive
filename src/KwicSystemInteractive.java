import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KwicSystemInteractive
{

   public static void main(String[] args)
   {
	  ArrayList<String> masterList = new ArrayList<>();
	  Scanner keyboard = new Scanner(System.in);
	  String input;

	  // MAIN MENU
	  while (true)
	  {
		 System.out.println("Enter command: [a]dd, [d]elete, [p]rint, [q]uit");
		 input = keyboard.nextLine();
		 switch (input)
		 {
			case "a":
			   System.out.print(">");
			   add(masterList, keyboard.nextLine());
			   break;

			case "d":
			   System.out.println(">");
			   delete(masterList, keyboard.nextLine());
			   break;

			case "p":
			   print(masterList);
			   break;

			case "q":
			   keyboard.close();
			   quit();
			   break;

			default:
			   break;
		 }
	  }
   }

   private static void quit()
   {
	  System.out.println("> exiting");
	  System.exit(0);

   }

   private static void print(ArrayList<String> list)
   {
	  for (String sentence : list)
	  {
		 System.out.println(sentence);
	  }
   }

   private static void delete(ArrayList<String> list, String input)
   {
	  ArrayList<String> toBeDeleted = new ArrayList<>();
	  add(toBeDeleted, input);
	  list.removeAll(toBeDeleted);
   }

   private static void add(ArrayList<String> list, String input)
   {
	  circularShift(list, input);
	  alphabetise(list);
   }

   private static void circularShift(ArrayList<String> list, String sentence)
   {
	  // split the sentence into an array of words
	  String words[] = sentence.split("\\s+"); // split on space, "\\s" is
	  // a space, + means 'one
	  // or more spaces'

	  // Now shift and record each shift in output
	  for (int i = 0; i < words.length; i++)
	  {
		 String shiftedSentence = "";
		 int wordsToTheRight = words.length - i; // words to the right of
		 // words[i]
		 int wordsToTheLeft = i; // words to the left of words[i]

		 for (int j = 0; j < wordsToTheRight; j++)
		 {
			shiftedSentence += words[i + j] + " ";
		 }

		 for (int j = 0; j < wordsToTheLeft; j++)
		 {
			shiftedSentence += words[j] + " ";
		 }

		 // commit the new sentence to output
		 list.add(shiftedSentence);
	  }
   }

   private static void alphabetise(ArrayList<String> list)
   {
	  Collections.sort(list);
   }

}
