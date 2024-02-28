from calcuring import Calcuring

operand_one = input('Enter number: ')
operator = input('Enter Op (+ - * /): ')
operand_two = input('Enter number: ')

# input string formation
input_str = operand_one + operator + operand_two

res = Calcuring().calculate(input_str)

print('Result: ' + str(res))
