import java.lang.*;
import java.util.*;
// ****************************************************
// Interface for the ADT list
// ****************************************************
public interface ListInterface 
{
  // list operations:
  public boolean isEmpty();

  public int size();

  public void add(int index, String item)
    throws ListIndexOutOfBoundsException;

  public void remove(int index)
    throws ListIndexOutOfBoundsException;

  public String get(int index)
    throws ListIndexOutOfBoundsException;

  public void removeAll();

  public boolean isSorted();

  public void reverseList();
} 