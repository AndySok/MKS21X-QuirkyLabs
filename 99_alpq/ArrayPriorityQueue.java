import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {
    private ArrayList<Priority> Q;

    public ArrayPriorityQueue(){
        Q = new ArrayList<Priority>();
    }

    public void add( String cargo, int priority ) {
        for(int i = Q.size() - 1; i >= 0; i--){
            if(Q.get(i).priority() == priority){
                add(cargo, i+1);
            } else if () //finish
        }
    } //O(n)

    public boolean isEmpty() {
        return Q.isEmpty();
    } //O(1)

    public String peekMin() {
        return Q.get( Q.size() - 1 ).cargo();
    } //O(1)
    
    public String removeMin() {
        return Q.remove( Q.size() - 1 ).cargo();
    } //O(1)
}

public class Priority {
    private String cargo;
    private int priority;

    public Priority(String cargo, int priority){
        this.cargo = cargo;
        this.priority = priority;
    }

    public String cargo(){
        return cargo;
    }

    public int priority(){
        return priority;
    }

}