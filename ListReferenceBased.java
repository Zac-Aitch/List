import java.util.*;

// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************
public class ListReferenceBased implements ListInterface 
{
  //Reference to linked list of items
  private Node head;

  //Definitions of constructors and methods
  public ListReferenceBased() 
  {
    head = null;
  }  

  public boolean isEmpty() 
  {
  // --------------------------------------------------
  // Checks if list is empty
  // Precondition: None
  // Postcondition: Returns true if list is empty, 
  // false is list is not.
  // --------------------------------------------------
    if (head == null) 
    {
      return true;
    }
    return false;
  }  

  public int size() 
  {
  // --------------------------------------------------
  // Returns size of list
  // Precondition: None
  // Postcondition: Returns size of list
  // --------------------------------------------------
    int num = 0;
    Node curr = head;
    while (curr != null) 
    {
      curr = curr.next;
      num++; 
    }
    return num;
  }  

  private Node find(int index) 
  {
  // --------------------------------------------------
  // Locates a specified node in a linked list.
  // Precondition: index is the number of the desired
  // node. Assumes that 0 <= index <= size()
  // Postcondition: Returns a reference to the desired
  // node.
  // --------------------------------------------------
    Node curr = head;
    for (int skip = 0; skip < index; skip++) 
    {
      curr = curr.next;
    } 
    return curr;
  } 

  public String get(int index)
                throws ListIndexOutOfBoundsException{
  // --------------------------------------------------
  // Returns the string contained in node specified by
  // index
  // Precondition: index is the number of the desired
  // node. Assumes that 0 <= index <= size()
  // Postcondition: Returns string from the desired
  // index.
  // --------------------------------------------------
    if (index >= 0 && index < size()) 
    {
      // get reference to node, then data in node
      Node curr = find(index);
      String dataItem = curr.item;
      return dataItem;
    }
    else 
    {
      throw new ListIndexOutOfBoundsException();
    } 
  } 

  public void add(int index, String item)
                    throws ListIndexOutOfBoundsException{
  // --------------------------------------------------
  // Add a new item to list
  // Precondition: Index is the number of the desired
  // position for new node. Item is the data to be placed
  // in new node. Assumes that 0 <= index <= size()
  // Postcondition: Node added to list
  // 
  // --------------------------------------------------

    if (index >= 0 && index <= size()) 
    {
      if (index == 0) 
      {
        // insert the new node containing item at
        // beginning of list
        Node newNode = new Node(item, head);
        head = newNode;
      }
      else 
      {
        Node prev = find(index-1);

        // insert the new node containing item after
        // the node that prev references
        Node newNode = new Node(item, prev.next);
        prev.next = newNode;
      }
    }
    
    else 
    {
      throw new ListIndexOutOfBoundsException();
    } 
  }  

  public void remove(int index)
                   throws ListIndexOutOfBoundsException{
  // --------------------------------------------------
  // Removed node from list
  // Precondition: Index is the position of the node to
  // be deleted. Assumes that 0 <= index <= size()
  // Postcondition: Node removed from list
  // --------------------------------------------------
    if (index >= 0 && index < size()) 
    {
      if (index == 0) 
      {
        // delete the first node from the list
        head = head.next;
      }
      else 
      {
        Node prev = find(index-1);
        // delete the node after the node that prev
        // references, save reference to node
        Node curr = prev.next;
        prev.next = curr.next;
      } 
    } 
    else 
    {
      throw new ListIndexOutOfBoundsException();
    } 
  }  

  public void removeAll() 
  {
  // --------------------------------------------------
  // Removes all nodes from list
  // Precondition: None
  // Postcondition: List is empty
  // --------------------------------------------------
    head = null;
  } 

  public boolean isSorted()
  {
  // --------------------------------------------------
  // Checks whether list is sorted or not
  // Precondition: None
  // Postcondition: Returns true if list is sorted and 
  // false if not.
  // --------------------------------------------------
    boolean sorted = false;

    for (Node curr = head; curr.next != null; curr = curr.next) 
    {
      //System.out.println("curr item loop" + curr.item.toString());
      //Create new node object for comparison
      Node next = curr.next;

      
      if(curr.item.compareTo(next.item) < 0)
      {
        //System.out.println("Comparing: " + curr.item.toString() + " to " + next.item.toString());
        sorted = true;
      }
      else
      {
        return sorted = false;
      }
    }
    return sorted;
  }

  public void reverseList()
  {
  // --------------------------------------------------
  // Reverses the order of the list
  // Precondition: None
  // Postcondition: List is reversed
  // --------------------------------------------------
    Node reverse = null;
    Node curr = head;
    while(curr != null)
    {
      Node next = curr.next;
      curr.next = reverse;
      reverse = curr;
      curr = next;
    }
    head = reverse;
  }
}
