///////   file:  ConcordLink.java

public class ProcessLink {

    
    public ProcessLink   next;
    public String bound;
    public int num;

    public ProcessLink(String s, int i) {
        bound = s;
        num = i;
        next = null;
    } // end of specific constructor


}  // end class ConcordLink
