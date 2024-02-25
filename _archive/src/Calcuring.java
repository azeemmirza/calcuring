import Function.Controller;
import Function.Result;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author      Azeem Mirza <contact@azeemirza.com>
 * @version     0.1.1
 * @since       0.1.0
 * @date        31-5-2017
 */
public class Calcuring {

    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        String operator1 = scan.nextLine();
        String operator2 = scan.nextLine();
        String operand = scan.nextLine();

        Controller ControllerObject = new Controller(operator1, operator2, operand);
        Result ResultObj;

        ResultObj = ControllerObject.getResult();
        System.out.println("Status: "+ResultObj.Status);
        System.out.println("Message: "+ResultObj.Message);
        System.out.println("Answer: "+ResultObj.Answer);
        System.out.println("Remainder: "+ResultObj.Remainder);
        System.out.println();
        System.out.println("Input Tape: ");
        ArrayPrinter(ControllerObject.getInputTape());
        System.out.println();
        System.out.println("Result Tape: ");
        ArrayPrinter(ControllerObject.getResultTape());

        scan.close();

    }

    private static void ArrayPrinter (ArrayList<Character> Tape){
        Iterator itr = Tape.iterator();
        System.out.print("[ ");
        while(itr.hasNext()){
            System.out.print(itr.next()+ " ");
        }
        System.out.print(" ]");
    }

}
