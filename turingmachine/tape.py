class Tape:
    # private fields
    __blank_symbol = ' '
    __tape = list()

    def __init__(self, tape_string='', blank_symbol=' '):
        self.__tape = list(tape_string)
        self.__blank_symbol = blank_symbol

        print(self.__tape)
        print(self.__blank_symbol)

    # returns tape in string format
    def __str__(self):
        return ''.join(self.__tape)

    # returns item of desired index
    def __getitem__(self, index):
        if index < len(self.__tape):
            return self.__tape[index]
        else:
            return self.__blank_symbol

    # sets item on the provided index
    def __setitem__(self, index, char):
        self.__tape[index] = char

    def get_item(self, index):
        if index < len(self.__tape):
            return self.__tape[index]
        else:
            return self.__blank_symbol

    def set_item(self, index, char):
        if index < len(self.__tape):
            self.__tape[index] = char
        else:
            self.__tape.append(char)