package Function;

import java.util.ArrayList;

/**
 * @author      Azeem Mirza <contact@azeemirza.com>
 * @version     0.1.1
 * @since       0.1.0
 * @date        31-5-2017
 */
class Parser {

    //Check if input String is valid Integer - Returns boolean [true/false]
    protected boolean ValidInteger(String input){
        boolean flag = false;
        for(char x: input.toCharArray()){
            if(x == '0' || x == '1' || x == '2' || x == '3' || x == '4' || x == '5' || x == '6' || x == '7' || x == '8' || x == '9'  ){
                flag = true;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    protected boolean ValidOperator(String input){
        boolean flag  = false;
        if(input.length() == 1){
            char opCharacter = input.charAt(0);
            if(opCharacter == '+' || opCharacter == '-' ||opCharacter == '*' ||opCharacter == '/'){
                flag = true;
            }else flag = false;
        }else flag = false;
        return flag;
    }


    protected ArrayList<Character> Taper (String operand1, String operand2, String operator){

        ArrayList Tape = new ArrayList <Character> ();
        Tape.add('#');
        for(int i=0 ; i< Integer.parseInt(operand1); i++)  Tape.add('1');
        char operatorCharacter = operator.charAt(0);
        Tape.add(operatorCharacter);
        for(int i=0 ; i< Integer.parseInt(operand2); i++)  Tape.add('1');
        Tape.add('#');
        return Tape;
    }

    protected int IntegerCount (ArrayList <Character> inputTape){
        int Result = 0;
        for (Character x: inputTape){
            if(x == '1'){
                Result ++;
            }
        }
        return Result;
    }
    protected int RemainderCount (ArrayList <Character> inputTape){
        int Remainders = 0;
        for (Character x: inputTape){
            if(x == '$'){
                Remainders ++;
            }
        }

        return Remainders;
    }


}
