import java.util.Scanner;

class Node{
    private int data;
    private Node next;

    // blank as well as parameter constructor in Node class
    public Node() {
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    //then use getter and setter for the parameters in constructor
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class LinkedList{
    private Node start;
    private int size;

    //only blank contructor in linkedlist class
    public LinkedList() {
        size=0;
        start=null;
    }

    public void insertAtStart(int val){
        Node n;
        n=new Node();
        n.setData(val);
        n.setNext(start);
        start=n;
        size++;
    }

    public void insertAtEnd(int val){
        Node n,t;
        n=new Node();
        n.setData(val);
        t=start;
        if(t==null){
            start=n;
        }
        else{
            while(t.getNext()!=null) {
                t=t.getNext();          //t will traverse through all nod till it has refrence vairable of null that is the end.
                                         // when it is null it will add a node before that
                t.setNext(n);
            }
        size++;
        }
/*
    //TO insert at particular position
    1)To insert at 1st position (insertAtStart(val))
    2)To insert at last Position  (insertAtEnd(val))
    3)To insert at center any position ( pos>0 && pos<=size)

*/
    }

    public void insertAtPos(int val,int pos){
        if(pos==1){
            insertAtStart(val);
        }
        else if(pos==size+1){
            insertAtEnd(val);
        }
        else if(pos>1 && pos <=size ){
            Node n,t;
            n = new Node(val,null);
            t = start;

            for(int i=1;i<pos-1;i++){
                t=t.getNext();
                n.setNext(t.getNext());         //new node value is given by the previous node ater which we are adding this node as this new node will have refrence of next node
                t.setNext(n);
                size++;
            }
        }
        else{
            System.out.println("Insertion no possible at position : "+pos);
        }
    }


    // Create isEmpty fucntion to check if list is empty of not
    public boolean isEmpty(){
        if(start==null){
            return true;
        }
        else{
            return false;
        }
    }

    public int getListSize(){
        System.out.println("size ="+size);
        return size;

    }

    public void viewList(){
        Node t;
       if(isEmpty()){
           System.out.println("List is empty");
       }
       else{
           t=start;
           for(int i=1;i<=size;i++){
               System.out.println(""+t.getData());  //now t will get data from next node
               t = t.getNext();         //now in t giving refernce varibale of next node to continue this cycle;
           }
       }
    }

    public void deleteFirst(){
        if(start==null){
            System.out.println("List is already empty!!!");
        }
        else {
            start = start.getNext();         // start will get data of next that is first node
            size--;                               // and will get the refrence of seconnd node that refrence will be given to start so athat 1 st node refrence will be deleted
        }
    }

    public void deleteLast(){
        if(start==null){
            System.out.println("List is already empty!!!");
        }
        else if(size==1){
            start=null;
            size--;
        }
        else {
            Node t;
            t=start;
            for(int i=1; i<size-1  ;i++){
                t=t.getNext();          //this will take to second last node
                t.setNext(null);        //here when we are at second last node we are seetiing value of next node at nulll so it will be free and garbage collction will hapen
                size--;
            }
        }
    }

    public void deletePos(int pos){
        if(start==null){
            System.out.println("List is empty!!!");
        }
        else if(pos<1 || pos >size){
            System.out.println("Invalid Postion");
        }
        else if(pos==1){
            deleteFirst();
        }
        else if(pos==size){
            deleteLast();
        }
        else{
            Node t,t1;
            t=start;
            for(int i=1;i<pos-1;i++){
                t=t.getNext();              //looping till pos-1.
                t1=t.getNext();             //taking the next reference will needs to be deleted in t1
                t.setNext(t1.getNext());        //taking the reference of next node from t1 ie the node present after the node that needs to be deleted
                                                //and setting the nodes reference in t so that middle node will be deleted
                                                // eg==  a->b->c   here a it t, giving reference of b, now this reference is stored in t1 and t1 wil now get reference of c which will be given to t to set that value.
                                                // and b will be deleted
                size--;
            }

        }
    }
}



public class Test {
    public static void main(String[] args){
        System.out.println("Welcome to Linked list!");
        Scanner scan =new Scanner(System.in);
        LinkedList list =new LinkedList();
        boolean flag=true;
        while(flag) {

            System.out.println("1)Add item to the Start!");
            System.out.println("2)Add item at the End!");
            System.out.println("3)Add item at a Position!");
            System.out.println("4)Delete item at the Start!");
            System.out.println("5)Delete item to the End!");
            System.out.println("6)Delete item at a Position!");
            System.out.println("7)View The Size of the List!!!");
            System.out.println("8)View The List!!!");
            System.out.println("9)Exit");
            System.out.println("Enter your choice!");

            int position;

            int value;
            int choice = scan.nextInt();
            switch (choice){
                case 1 : System.out.println("ENter the value!!");
                        int a = scan.nextInt();
                        list.insertAtStart(a);
                        break;

                case 2 :
                        System.out.println("ENter the value!!");
                        int b = scan.nextInt();
                        list.insertAtEnd(b);
                        break;

                case 3 :
                        System.out.println("Enter the position");
                        position=scan.nextInt();
                        System.out.println("ENter the value!!");
                        int c = scan.nextInt();
                        list.insertAtPos(c,position);
                        break;

                case 4 :list.deleteFirst();
                         break;

                case 5 :list.deleteLast();
                         break;

                case 6 :System.out.println("Enter the position");
                        position=scan.nextInt();
                        list.deletePos(position);
                        break;

                case 7 :list.getListSize();
                        break;

                case 8 :list.viewList();
                        break;

                case 9 :flag=false;
                        break;

                default:System.out.println("Wrong Choice!!!");

            }

        }
    }
}
