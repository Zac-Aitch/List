import java.util.*;


public class ListLauncher
{

	public static void main(String[] args) 
	{
		ListReferenceBased list = new ListReferenceBased();
		Scanner keyboard = new Scanner(System.in);

		while(true)
		{
			//Set/reset parameters to 0 or null each loop to avoid bugs
			int choice = 0;
			int position = 0;
			String item = null;
			
			//Display options
			System.out.println("1) Add item");
			System.out.println("2) Remove item");
			System.out.println("3) Reverse list");
			System.out.println("4) Exit program");
			System.out.print("\nEnter your choice (1-4): ");
			
			//Get users choice
			String input = keyboard.nextLine();
			choice = Integer.parseInt(input);

			//End program immediately
			if (choice == 4) 
			{
				System.out.println("\nGoodbye!");
				break;
			}

			//Position not needed if reversing list
			if (choice != 3) 
			{
				//Get position from user, validate input using NumberFormatException
				while(true)
				{
					try
					{
					System.out.print("Enter position: ");
					input = keyboard.nextLine();
					position = Integer.parseInt(input);
					//user enters position 1, program reads position 0
					position -= 1; 
					break;
					}
					catch(NumberFormatException e)
					{
						System.out.println("Please enter a digit");
					}
				}
			}

			try
			{
				//Test to see if position provided by user is within range
				list.add(position, "Test");

				//Remove test item if add is successful
				list.remove(position);

				//Get new list item from user
				if (choice == 1)
				{
					System.out.print("Enter item to add: ");
					item = keyboard.nextLine();	
				}

				//Perform task based on user's choice
				switch(choice)
				{
					case 1 : list.add(position, item);
								break;

					case 2 : list.remove(position);
								break;

					case 3 : list.reverseList();
								break;
				}
				//Print List, Number of Items, and sorted status
				System.out.print("\nList: ");
				for (int i = 0; i < list.size(); i++) 
				{
					System.out.print(list.get(i) + " ");	
				}

				System.out.println("\nNumber of items: " + list.size());

				if (list.size() == 1) 
				{
					System.out.println("List is in sorted order\n");
				}
				//Only need to check sort status if list is > 1
				else if(list.size() > 1)
				{
					if(list.isSorted()) 
					{
						System.out.println("List is in sorted order\n");	
					}
					else
						System.out.println("List is not in sorted order\n");
				}
			}

			catch(ListIndexOutOfBoundsException e)
			{
				System.out.println("Invalid Position\n");

			}	
		}
	}
}