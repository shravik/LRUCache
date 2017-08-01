import java.util.*;
import java.io.*;

// main class 
public class LRUCache{

 private DoublyLink list = new DoublyLink(); 
  int capacity; 

  
 public LRUCache(int capacity){
   this.capacity = capacity; 
 }// end of constructor

 public void put(int key,int value){
   if(list.search(key)){
    list.removefromlist(key);
    list.insertintolist(key,value);
   }
   else {
      if(list.sizeofcache() >= capacity){
           list.removefromlist(list.head.key);
    }
    list.insertintolist(key,value);
   }
     
 } // end of put

 public void printcache(){
    list.printlist();
  } // end of printcache 

 public static void main(String args[]){

  LRUCache lru = new LRUCache(3);

		lru.put(9, 0);
		lru.put(1, 1);
		lru.put(2, 2);
		lru.put(0, 0);
		lru.put(3, 3);
		lru.put(0, 0);
		lru.put(4, 4);
		lru.put(3, 3);
		lru.put(0, 0);
		lru.put(3, 3);
		lru.put(2, 2);
		lru.put(1, 1);
		lru.put(2, 2);
             lru.printcache();


} // end of main 

} // end of LRUCache class 


// class Doubly Linklist

 class DoublyLink{
    
    Node head = null, tail = null; 

   Map<Integer,Node> map = new HashMap<>();
   int sizecount;
   
  public void printlist(){
    Node temp = tail;
     while(temp !=null){
       System.out.print(temp.key + " ");
         temp = temp.prev; 
     
     }// end of while
   System.out.println();

   }  

  // insertinlist

 public void insertintolist(int key,int value){
  insert(key,value);
  sizecount++;
  map.put(key,tail);
}// end of insert

// remove from list 
 public void removefromlist(int key){
     remove(map.get(key));
     map.remove(key);
     sizecount--; 

  }// end of remove from list

 // search element 

 public boolean search(int data){
   return map.containsKey(data);

  }// end of search 

 // size 

 public int sizeofcache(){
   return sizecount; 
  }// end of size

  //  insert

  private void insert(int key,int value){
     Node new_node = new Node(key,value);
      if(head == null){
        tail = new_node;
        head = new_node;
       }
      else {
        tail.next = new_node; 
        new_node.prev = tail;
        tail = tail.next; 
   
      }

 }// end of insert
  

  // remove
 private void remove(Node n){
      if(head == n){
           head = head.next;
            if(head != null) {
             head.prev = null; }
         }
      else if(tail == n){
        tail = tail.prev; 
          if(tail != null) {
             tail.next = null; }
      }
      else {
        n.prev.next = n.next;
        n.next.prev = n.prev; 
         }

  }// end of remove 


  } // end of doubly link list 

// class Node 

 class Node{

  int key;
  int value;
  Node next;
  Node prev; 

  Node(int key,int value){
   this.key = key;
   this.value = value; 
    next = null;
    prev = null; 
 
 } // end of node constructor 


 }// end of node class 



