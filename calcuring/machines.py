from turingmachine.constants import BLANK, HALT, R, L, S

# Addition State Machine
ADDITION_MACHINE = {
    0: {
        BLANK: (BLANK, BLANK, 1, R),
    },
    1: {
        '1': ('1', '1', 1, R),
        '+': ('+', '1', 2, R),
    },
    2: {
        '1': ('1', '1', 2, R),
        BLANK: (BLANK, BLANK, 3, L),
    },
    3: {
        '1': ('1', BLANK, HALT, S),
    },
}

# Subtraction State Machine
SUBTRACTION_MACHINE = {
    0: {
        BLANK: (BLANK, BLANK, 1, R),
    },
    1: {
        '1': ('1', BLANK, 2, R),
    },
    2: {
        '1': ('1', '1', 2, R),
        '-': ('-', '-', 3, R),
    },
    3: {
        '1': ('1', '1', 3, R),
        BLANK: (BLANK, BLANK, 4, L),
    },
    4: {
        '1': ('1', BLANK, 5, L),
    },
    5: {
        '-': ('-', BLANK, HALT, S),
        '1': ('1', '1', 6, L),
    },
    6: {
        '1': ('1', '1', 6, L),
        '-': ('-', '-', 7, L),
    },
    7: {
        '1': ('1', '1', 8, L),
        BLANK: (BLANK, BLANK, HALT, S),
    },
    8: {
        '1': ('1', '1', 8, L),
        BLANK: (BLANK, BLANK, 1, R),
    },
}

# Multiplication State Machine
MULTIPLICATION_MACHINE = {
    0: {
        BLANK: (BLANK, BLANK, 1, R),
    },
    1: {
        '1': ('1', BLANK, 2, R),
    },
    2: {
        '*': ('*', '1', 3, R),
        '1': ('1', '1', 5, R),
    },
    3: {
        '1': ('1', '1', 3, R),
        'Z': ('Z', '1', 3, R),
        BLANK: (BLANK, BLANK, 4, L),
    },
    4: {
        '1': ('1', BLANK, HALT, S),
    },
    5: {
        '1': ('1', '1', 5, R),
        '*': ('*', '*', 6, R),
    },
    6: {
        '1': ('1', 'E', 7, R),
        'Z': ('Z', 'Z', 9, L),
    },
    7: {
        '1': ('1', '1', 7, R),
        'Z': ('Z', 'Z', 7, R),
        BLANK: (BLANK, 'Z', 8, L),
    },
    8: {
        '1': ('1', '1', 8, L),
        'Z': ('Z', 'Z', 8, L),
        'E': ('E', 'E', 6, R),
    },
    9: {
        'E': ('E', '1', 9, L),
        '*': ('*', '*', L),
    },
    10: {
        '1': ('1', '1', L),
        BLANK: (BLANK, BLANK, 1, R),
    },
}

# Division State Machine
DIVISION_MACHINE = {
    0: {
        BLANK: (BLANK, BLANK, 1, R),
    },
    1: {
        '1': ('1', BLANK, 2, R),
        '/': ('/', BLANK, 9, R),
    },
    2: {
        '1': ('1', '1', 2, R),
        '/': ('/', '/', 3, R),
    },
    3: {
        '1': ('1', '1', 3, R),
        'E': ('E', 'E', 3, R),
        'Z': ('Z', 'Z', 4, L),
        BLANK: (BLANK, BLANK, 4, L),
    },
    4: {
        'E': ('E', BLANK, 4, L),
        '1': ('1', 'E', 5, L),
    },
    5: {
        '/': ('/', '/', 6, R),
        '1': ('1', '1', 7, L),
    },
    6: {
        'E': ('E', '1', 6, R),
        'Z': ('Z', 'Z', 6, R),
        BLANK: (BLANK, 'Z', 7, L),
    },
    7: {
        '1': ('1', '1', 7, L),
        'Z': ('Z', 'Z', 7, L),
        '/': ('/', '/', 8, L),
    },
    8: {
        '1': ('1', '1', 8, L),
        BLANK: (BLANK, BLANK, 1, R),
    },
    9: {
        'Z': ('Z', '1', 9, R),
        '1': ('1', BLANK, 9, R),
        BLANK: (BLANK, BLANK, HALT, S),
    },
}
