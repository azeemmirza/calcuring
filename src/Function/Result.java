package Function;

/**
 * @author      Azeem Mirza <contact@azeemirza.com>
 * @version     0.1.1
 * @since       0.1.0
 * @date        31-5-2017
 */
public class Result {
    public int Answer;
    public int Remainder;
    public  int Status;
    public String Message;

     protected void OperandError(){
         this.Status = 200;
         this.Message = "Given Operands are not type of valid Integers";
     }
    protected void OperatorError(){
        this.Status = 300;
        this.Message = "Given Operator is not type of vlaid available arithmetic operators";
    }
    protected void GreaterSecondOperand(){
        this.Status = 400;
        this.Message = "Second Operator is found greater than First Operator, Not valid Subtraction/Division";
    }


    protected void Success(int Answer, int Remainder){
        this.Answer = Answer;
        this.Remainder = Remainder;
        this.Status = 100;
        this.Message = "Operation performed successfully";
    }



}
