/*
	Name Surname: Halit Burak Yeşildal
	Student Num: 18050111043

	Please only submit this file without zipping.
*/


import java.util.Scanner;

class Link
   {
   public char dData;             // data item
   public Link next;              // next link in list
// -------------------------------------------------------------
   public Link(char dd)           // constructor
      { dData = dd; }
// -------------------------------------------------------------
   public void displayLink()      // display ourself
      { System.out.print(dData + " "); }
   }  // end class Link
////////////////////////////////////////////////////////////////

class LinkList
   {
   private Link first;            // ref to first item on list
// -------------------------------------------------------------
   public LinkList()              // constructor
      { first = null; }           // no items on list yet
// -------------------------------------------------------------
   public boolean isEmpty()       // true if list is empty
      { return (first==null); }
// -------------------------------------------------------------
   public void insertFirst(char dd) // insert at start of list
      {                           // make new link
      Link newLink = new Link(dd);
      newLink.next = first;       // newLink --> old first
      first = newLink;            // first --> newLink
      }
// -------------------------------------------------------------
   public long deleteFirst()      // delete first item
      {                           // (assumes list not empty)
      Link temp = first;          // save reference to link
      first = first.next;         // delete it: first-->old next
      return temp.dData;          // return deleted link
      }
// -------------------------------------------------------------
   public void displayList()
      {
      Link current = first;       // start at beginning of list
      while(current != null)      // until end of list,
         {
         current.displayLink();   // print data
         current = current.next;  // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   }  // end class LinkList
////////////////////////////////////////////////////////////////
class LinkStack
   {
   private LinkList theList;
//--------------------------------------------------------------
   public LinkStack()             // constructor
      {
      theList = new LinkList();
      }
//--------------------------------------------------------------
   public void push(char j)     // put item on top of stack
      {
      theList.insertFirst(j);
      }
//--------------------------------------------------------------
   public long pop()            // take item from top of stack
      {
      return theList.deleteFirst();
      }
//--------------------------------------------------------------
   public boolean isEmpty()       // true if stack is empty
      {
      return ( theList.isEmpty() );
      }
//--------------------------------------------------------------
   public void displayStack()
      {
      System.out.print("Stack (top-->bottom): ");
      theList.displayList();
      }
//--------------------------------------------------------------
   }  // end class LinkStack
////////////////////////////////////////////////////////////////
public class LinkStackApp
   {
   public static void main(String[] args) {
	   // Delete the codes inside the main. This is just an example to see how this stack works.
      LinkStack theStack = new LinkStack(); // make stack
      Scanner scanner = new Scanner(System.in);
      String input= scanner.nextLine();
      isAccepted(input,theStack);                //put your inputs and stack into isAccepted method

         /*

           theStack.push(20);                    // push items
           theStack.push(40);

           theStack.displayStack();              // display stack

           theStack.push(60);                    // push items
           theStack.push(80);

           theStack.displayStack();              // display stack

           theStack.pop();                       // pop items
           theStack.pop();

           theStack.displayStack();              // display stack
         */


	   // Delete the codes inside the main. This is just an example to see how this stack works.
   	   

   }  // end main()

      //push "("into stack and if there is ")" pops. if stack is empty and check is false opening bracket is missing
      // if check is true and stack is not empty we need ")"
      static void isAccepted(String input, LinkStack stack){
         boolean check=true;
         for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='(')
               stack.push(input.charAt(i));
            else if(input.charAt(i)==')'){
               if(stack.isEmpty())
                  check=false;
               else
                  stack.pop();
            }

         }

         if((check== false && !stack.isEmpty()) || check==false)                    //first character might be closed bracket and upcoming brackets might be opening )(())
            System.out.println("Opening bracket is missing");
         else if(!stack.isEmpty())                                //if stack is not empty at the end of all pop operations, we need closing brackets (()
            System.out.println("Closing bracket is missing");

         else
            System.out.println("Accepted");                       // stack is empty and check is true (), (())()
      }

   }  // end class LinkStackApp

////////////////////////////////////////////////////////////////
