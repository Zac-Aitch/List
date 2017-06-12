class Node 
{
  String item; 
  Node next;
  //Definitions of constructors
  Node(String newItem) 
  {
    item = newItem;
    next = null;
  } 
  Node (String newItem, Node nextNode) 
  {
    item = newItem;
    next = nextNode;
  } 

} 
