package QuizesOld;

import java.util.*;
 
public class TreeSetExample {
 
    public static void main(String[] args) {
    
        TreeSet tree = new TreeSet();
        tree.add(12);
        tree.add(63);
        tree.add(34);
        tree.add(45);
 
        // here it test it's sorted, 63 is the last element. see output below
        Iterator iterator = tree.iterator();
        System.out.print("Tree set data: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
 
        //Check empty or not
        if (tree.isEmpty()) {
            System.out.print("Tree Set is empty.");
        } else {
            System.out.println("Tree Set size: " + tree.size());
        }
 
        //Retrieve first data from tree set
        System.out.println("First data: " + tree.first());
 
        //Retrieve last data from tree set
        System.out.println("Last data: " + tree.last());
 
        if (tree.remove(45)) { // remove element by value
            System.out.println("Data is removed from tree set");
        } else {
            System.out.println("Data doesn't exist!");
        }
        
        System.out.print("Now the tree set contain: ");
        iterator = tree.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println("Now the size of tree set: " + tree.size());
 
        //Remove all
        tree.clear();
        if (tree.isEmpty()) {
            System.out.print("Tree Set is empty.");
        } else {
            System.out.println("Tree Set size: " + tree.size());
        }
    }
}