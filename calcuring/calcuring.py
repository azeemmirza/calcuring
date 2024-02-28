import re
from . import machines
from turingmachine.turingmachine import TuringMachine
from turingmachine.constants import BLANK

class Calcuring:
    def __parse_input(self, input_str: str, operator: str) -> str:
        operand_one, operand_two = input_str.split(operator)
        parsed_str = BLANK

        for x in range(int(operand_one)):
            parsed_str += '1'

        parsed_str += operator

        for x in range(int(operand_two)):
            parsed_str += '1'

        parsed_str += BLANK

        return parsed_str

    def __parse_output(self, output_str: str) -> int:
        parsed_result = 0

        for c in output_str:
            if c == '1':
                parsed_result += 1

        if '-' in output_str:
            parsed_result = -abs(parsed_result)

        return parsed_result

    def calculate(self, input_str: str) -> int:
        # compiling the pattern for alphanumeric string
        pat = re.compile(r"[0-9]+[+\-*/][0-9]+")

        if not re.fullmatch(pat, input_str):
            raise Exception('Invalid input string')

        operator = re.search(r"[0-9]+([+\-*/])[0-9]+", input_str)[1]

        print(operator)

        parsed_str = self.__parse_input(input_str, operator)
        tm = TuringMachine(parsed_str, BLANK)

        if operator == '+':
            tm(machines.ADDITION_MACHINE)
        elif operator == '-':
            tm(machines.SUBTRACTION_MACHINE)
        elif operator == '*':
            tm(machines.MULTIPLICATION_MACHINE)
        elif operator == '/':
            tm(machines.DIVISION_MACHINE)

        output_tape = tm.get_tape()

        print(output_tape)

        output_str = self.__parse_output(output_tape)

        return output_str
