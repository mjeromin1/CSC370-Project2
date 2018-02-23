////// file:  ConcordList.java

public class ProcessList {

    protected ProcessLink first;
    protected int size;
    protected ProcessLink last;

    public ProcessList() {
        size = 0;
        first = null;
        last = null;
    } // end of constructor

    public ProcessLink getFirst() {
        return first;
    } // end of getFirst()

    public int getSize() {
        return size;
    } // end of getSize()
   

   
    public void insertLast(String input, int num){
        ProcessLink newLink = new ProcessLink(input, num);
        if(this.getSize() <= 0){
            first = newLink;
        }else{
            last.next = newLink;
        }
        last = newLink;
        size++;
    }
    public void terminateLink(){
        first = first.next;
    }

}  // end class ConcordList

