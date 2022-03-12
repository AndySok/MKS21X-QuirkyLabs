//Team Fred - Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish
//APCS pd8
//HW74 -- LLNode
//2022-03-11w
//time spent: 1h

// DISCO

// QCC

//Node - Implemented as foretold in the UML Design Doc
public class LLNode{
    private String cargo;
    private LLNode cdr;
    //----------------Constructors-----------------//
    public LLNode(String cargo, LLNode cdr){
        this.cargo = cargo;
        this.cdr = cdr;
    }

    public LLNode(String cargo){
        this.cargo = cargo;
        this.cdr = null;
    }
    //--------------End Constructors---------------//

    //------------------Mutators-------------------//
    public void setCargo(String newCargo){
        this.cargo = newCargo;
    }

    public void setNode(LLNode cdr){
        this.cdr = cdr;
    } 
    //----------------End Mutators-----------------//

    //------------------Accessors------------------//
    public String getCargo(){
        return this.cargo;
    }
    public LLNode getCdr(){
        return this.cdr;
    }
    public String get(){
        return "{ " + getCargo() + ", " + cdr.toString() + " }";
    }

    public String toString(){
        return "{ " + getCargo() + ", " + getCdr() + " }";
    }
    //----------------End Accessors----------------//
}