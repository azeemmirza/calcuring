from calcuring import Calcuring

# to take user input
operand_one = input('Enter number: ')
operator = input('Enter Op (+ - * /): ')
operand_two = input('Enter number: ')

# concatenated operands on the sides fo the operator, to form input string
input_str = operand_one + operator + operand_two

res = Calcuring().calculate(input_str)

print('Result: ' + str(res))
