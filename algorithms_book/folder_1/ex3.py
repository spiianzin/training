from ex1 import Stack

def isoperator(symbol):
    if symbol == '+' or symbol == '-' or symbol == '*' or symbol == '/':
       return True
    return False

def doOperation(op, numb1, numb2):
    print("Will do operation %s%s%s" % (numb1, op, numb2))

    if op == None or numb1 == None or numb2 == None:
        return None

    if (op == '+'):
        return numb1 + numb2
    if (op == '-'):
        return numb1 - numb2
    if (op == '*'):
        return numb1 * numb2
    if (op == '/'):
        return numb1 / numb2

    return None


x = input()

numbers = Stack()
operators = Stack()

res = x.split(' ')
for n in res:
    trimed = n.strip()
    if trimed.isdigit():
        print("digit %s" % trimed)
        numbers.push(float(trimed))

    if isoperator(trimed):
        print("operator %s" % trimed)
        op = trimed
        numb1 = numbers.pop()
        numb2 = numbers.pop()
        numbers.push(doOperation(op, numb1, numb2))

print(numbers.pop())
print(numbers.pop())
print(numbers.pop())
print(numbers.pop())
