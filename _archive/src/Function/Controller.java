package Function;

import java.util.ArrayList;

/**
 * @author      Azeem Mirza <contact@azeemirza.com>
 * @version     0.1.1
 * @since       0.1.0
 * @date        31-5-2017
 */
public class Controller {
    String Operand1;
    String Operand2;
    String Operator;
    Result ResultObj;
    ArrayList InputTape;
    ArrayList InputTapeStore;
    ArrayList ResultTape;

    public Controller(String Operand1, String Operand2, String Operator){
        this.Operand1 = Operand1;
        this.Operand2 = Operand2;
        this.Operator = Operator;
        this.ResultObj = new Result();
        this.InputTape = new ArrayList<Character>();
        this.InputTapeStore = new ArrayList<Character>();
        this.ResultTape = new ArrayList<Character>();
        this.init();
    }
    public Result getResult(){
        return ResultObj;
    }
    public ArrayList<Character> getInputTape(){return InputTapeStore;}
    public ArrayList<Character> getResultTape(){return ResultTape;}

    private void init(){
       /* System.out.println(this.Operand1+" "+this.Operand2+" "+this.Operator);*/
        Parser ParserObject = new Parser();
        if(ParserObject.ValidInteger(this.Operand1) && ParserObject.ValidInteger(this.Operand2)){
            if(ParserObject.ValidOperator(this.Operator)){
                char OperatorChar = this.Operator.charAt(0);
                if(OperatorChar == '-' || OperatorChar == '/'){
                   if(Integer.parseInt(this.Operand2) > Integer.parseInt(this.Operand1)){
                       this.ResultObj.GreaterSecondOperand();
                   }else {
                       //TODO Operation
                       this.InputTape = ParserObject.Taper(this.Operand1, this.Operand2, this.Operator);
                       this.InputTapeStore = InputTape;
                       this.start();
                   }
                }else {
                    //TODO Operation
                    this.InputTape = ParserObject.Taper(this.Operand1, this.Operand2, this.Operator);
                    this.InputTapeStore = InputTape;
                    this.start();
                     }
            }else this.ResultObj.OperatorError();
        }else this.ResultObj.OperandError();

    }

    private void start(){
        ArrayList<Character> InTape= this.InputTape;

        Operate Operations = new Operate();
        this.ResultTape = Operations.init(InTape);
        Parser ParserObject = new Parser();
        int Answer = ParserObject.IntegerCount(this.ResultTape);
        int Remainder = ParserObject.RemainderCount(this.ResultTape);
        this.ResultObj.Success(Answer, Remainder);
    }

}
