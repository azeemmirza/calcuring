package Function;

import java.util.ArrayList;

/**
 * Created by Azeem on 02-May-17.
 */
class Operate {
    private ArrayList Tape = new ArrayList <Character>();

    protected ArrayList<Character> init(ArrayList <Character> InputTape){
        char Head;
        this.Tape = InputTape;
        Loop1: for(int i = 0; i<Tape.size(); i++){
            Head = (char)Tape.get(i);
            if(Head == '1'){
                continue Loop1;
            }else{
                switch (Head){
                    case '+': {this.Tape = this.Add(Tape); break;}
                    case '-': {this.Tape = this.Subtract(Tape); break;}
                    case '*': {this.Tape = this.Multiply(Tape); break;}
                    case '/': {this.Tape = this.Divide(Tape);}
                }
            }
        }
        return this.Tape;
    }

    private ArrayList<Character> Add(ArrayList<Character> inputTape){
        char Head;
        int countHash = 0;
        System.out.println("Call Function: Add()");
        for(int i = 0; i<inputTape.size(); i++){
            Head = (char) inputTape.get(i);
            //Replacing operator with 1
            if(Head == '+'){
                inputTape.set(i,'1');
            }else if( Head == '#'){
                countHash ++;
                if(countHash ==2){
                    inputTape.set((i-1), '#');
                }
            }else if(Head == '1'){
                continue;
            }
        }
        return inputTape;
    }
    private ArrayList <Character> Subtract(ArrayList <Character> inputTape){
        System.out.println("Funcition Call: Subtract()");
        int TapeSize = inputTape.size();
        char Head;
        int BackLoopIndex;
        char BackLoopIndexChar;

        for (int i = 0; i<TapeSize; i++) {
            Head = (char) inputTape.get(i);
            if(Head == '1' ){
                /*System.out.println(i);*/
                BackLoopIndex = (TapeSize-1)-i;
                BackLoopIndexChar = (char) inputTape.get(BackLoopIndex);
                /*System.out.println("BLIC: "+BackLoopIndex+" : "+BackLoopIndexChar);*/
                if(BackLoopIndexChar == '1'){
                    inputTape.set(i, '#');
                    inputTape.set(BackLoopIndex, '#');
                }else if(BackLoopIndexChar == '-'){
                    this.Tape.set(BackLoopIndex, '#');
                    break;
                }
            }
        }
        return inputTape;
    }
    private ArrayList <Character> Multiply(ArrayList <Character> inputTape){
        char Head;
        System.out.println("Funcition Call: Multiply()");
        int HeadCount = 0;
        int ElementCount = 0;
        boolean operatorParsed = false;

      for(int i = 0; i<this.Tape.size(); i++){
          Head = (char) this.Tape.get(i);
          if(Head == '1') {
              HeadCount ++;
              if(HeadCount == 1){
                  this.Tape.set(i, '#');
                  /*System.out.println(HeadCount);*/
              }else if (HeadCount > 1){
                  /*System.out.println("hc1++");*/
                  this.Tape.set(i, '#');
                    for(int j = 0; j<inputTape.size(); j++){
                            Head = (char) this.Tape.get(j);
                            if(Head == '*'){
                          operatorParsed = true;
                        }else if(Head == '1' && operatorParsed){
                          ElementCount ++;
                      }else if(Head == '#' && operatorParsed){
                          break;
                      }
                  }
                  inputTape = this.Multiplyrecur(inputTape, ElementCount);

              }
          }else if(Head == '*'){
              this.Tape.set(i, '#');
              break;
          }
      }
        return inputTape;
    }

    private ArrayList <Character>  Multiplyrecur (ArrayList <Character> inputTape, int loopCount){
        for(int i = 0; i<loopCount; i++){
            inputTape.add('1');
        }
        inputTape.add('#');
        return inputTape;
    }

    private ArrayList<Character> Divide( ArrayList<Character> inputTape){
        System.out.println("Funcition Call: Divide()");
        char Head;
        int ElementCount = 0;
        int InstanceCount = 0;
        /*int Ans = 0;*/
        boolean OpParsed = false;
        // Loop for ElementCount
        for(int i = 0; i< inputTape.size(); i++){
            Head = (char) inputTape.get(i);
            if(Head == '/'){
                OpParsed = true;
            }else if(Head == '1' && OpParsed){
                ElementCount ++;
            }
        }

        for (int j = 0; j<inputTape.size(); j++){
            Head = (char) inputTape.get(j);
            if(Head == '1'){
                InstanceCount ++;
                if( InstanceCount == ElementCount){
                    /*Ans++;*/
                    for(int k = 0; k<(ElementCount-1); k++){
                        inputTape.set((j-k), '#');
                    }
                    InstanceCount = 0;
                }
            }else if(Head == '/'){
                /*System.out.println("j= "+j);*/
                OpParsed = false;
                for(int k = (j-(ElementCount-1)); k<inputTape.size(); k++){
                    /*System.out.println(k);*/
                    if(inputTape.get(k) == '1'){
                        if(OpParsed){
                            inputTape.set(k, '#');
                        }else inputTape.set(k,'$');
                    }else if(inputTape.get(k) == '/') {inputTape.set(k,'#'); OpParsed = true;}
                }
                break;
            }
        }
       /* System.out.println(Ans);*/
        return inputTape;
    }

}
