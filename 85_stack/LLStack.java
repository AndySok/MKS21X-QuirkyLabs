import java.util.LinkedList;


public class LLStack<PANCAKE> implements Stack<PANCAKE>{
    private LinkedList<PANCAKE> _stack;
    //Return true if this stack is empty, otherwise false.
    public LLStack(){
        _stack = new LinkedList<PANCAKE>();
    }

    //Return true if this stack is empty, otherwise false.
    public boolean isEmpty(){
        return _stack.size() == 0;
    }

    //Return top element of stack without popping it.
    public PANCAKE peekTop(){
        if(!this.isEmpty()) return _stack.getLast();
        else return null;
    }

    //Pop and return top element of stack.
    public PANCAKE pop(){
        if(!this.isEmpty()){
            return _stack.removeLast();
        } else return null;
    }

    //Push an element onto top of this stack.
    public void push( PANCAKE x ){
        _stack.add(x);        
    }
}