class UnknownSymbol(Exception):
    """
    This exception is raised when the Turing machine encounters a symbol
    that does not appear in the transition dictionary.
    """
    pass


class UnknownState(Exception):
    """
    This exception is raised when the Turing machine enters a state that
    does not appear in the transition dictionary.
    """
    pass


class BadSymbol(Exception):
    """
    This exception is raised when the user attempts to specify a tape
    alphabet that includes strings of length not equal to one.
    """
    pass
