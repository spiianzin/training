
class Stack:

    def __init__(self):
        self.arr = []

    def pop(self):
        if self.empty():
            return
        length = len(self.arr)
        head = self.arr[length-1]
        self.arr.remove(head)
        return head

    def push(self, elem):
        self.arr.append(elem)

    def top(self):
        if self.empty():
            return
        length = len(self.arr)
        return self.arr[length-1]

    def empty(self):
        return len(self.arr) == 0

# 
#
# s = Stack()
#
# s.push(1)
# s.push(1)
# s.push(2)
# s.push(3)
# s.push(5)
#
# print(s.pop())
# print(s.pop())
# print(s.pop())
# print(s.pop())
# print(s.pop())
# print(s.pop())
# print(s.pop())
