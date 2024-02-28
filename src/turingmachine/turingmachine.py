from .exceptions import UnknownState, UnknownSymbol, BadSymbol
from .tape import Tape


class TuringMachine:
    def __init__(self, tape='', blank_symbol=' '):
        self.__tape = Tape(tape, blank_symbol)

    def __call__(self, machine=None, *args, **kwargs):
        if machine is None:
            machine = {}

        running = True
        head_position = 0
        current_state = 0

        print(str(self.__tape))

        while running:
            if current_state not in machine:
                running = False
                raise UnknownState()

            char = self.__tape.get_item(head_position)
            state = machine[current_state]

            print('char: ' + char + '; state: ' + str(current_state) + '; head: ' + str(head_position))
            print(state)

            if char not in state:
                running = False
                raise UnknownSymbol()

            transition = state[char]

            if char != transition[0]:
                running = False
                raise BadSymbol()

            self.__tape.set_item(head_position, transition[1])
            head_position += transition[3]
            current_state = transition[2]

            if current_state == 'H':
                running = False

            print('--- \n')

        print('call ended - ' + str(running))

    # returns tape in string format
    def get_tape(self):
        return str(self.__tape)
