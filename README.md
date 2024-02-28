# Calcuring
Basic calculator implemented on Turing Machine

## Usage
To get started with the Calcuring project, follow these steps:

1. Clone the repository:
    ```
    git clone https://github.com/azeemmirza/calcuring.git
    ```
2. Navigate to the project directory:
    ```
    cd calcuring
    ```
3. Run the script:
    ```
    python .
    ```

## Turing Machines

Turing Machines are abstract mathematical models of computation introduced by the mathematician and logician Alan Turing in 1936. They are named after him and are foundational in the field of theoretical computer science. Turing Machines provide a formal framework for understanding the concept of computation, and they have been instrumental in proving fundamental results about the limits and capabilities of computing devices.

### Components of a Turing Machine:
**Tape:** A Turing Machine has an infinitely long tape divided into cells. Each cell can hold a symbol from a finite set of symbols, typically including the blank symbol and other input symbols. The tape is read and written by the Turing Machine's head.

**Head:** The head of a Turing Machine can read the symbol currently under it on the tape, write a new symbol to that location, and move left or right along the tape. The head determines the current state of the machine and decides what action to take based on the current state and the symbol it reads.

**State Register:** A Turing Machine has a finite set of states, and it can be in only one state at a time. The current state of the machine determines its behavior, including which symbol to write, which direction to move the head, and which state to transition to next.

**Transition Function:** The behavior of a Turing Machine is defined by a transition function, which specifies how the machine should behave when in a certain state and reading a certain symbol. The transition function maps a combination of current state and input symbol to a new state, a symbol to write to the tape, and a direction to move the head.

### Operation of a Turing Machine:
**Initialization:** The Turing Machine starts in a specified initial state with the head positioned on the first cell of the tape, which contains the input provided to the machine.

**Execution:** The Turing Machine repeatedly performs the following steps:
- Reads the symbol currently under the head. 
- Consults the transition function to determine the appropriate action based on the current state and the symbol read. 
- Writes a new symbol to the tape, moves the head left or right, and transitions to a new state according to the transition function.

**Halt Condition:** The Turing Machine continues executing until it reaches a special halting state, at which point it stops, and the computation is considered complete.


### Reference:
Turing, Alan (1950) - _[Computing Machinery and Intelligence](https://academic.oup.com/mind/article/LIX/236/433/986238), Mind, Volume LIX, Issue 236, October 1950_
