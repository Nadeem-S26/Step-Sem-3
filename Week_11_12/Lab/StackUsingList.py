class Stack:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)
        print(f"Pushed: {item}")

    def pop(self):
        if not self.is_empty():
            popped = self.items.pop()
            print(f"Popped: {popped}")
            return popped
        else:
            print("Stack is empty. Cannot pop.")
            return None

    def peek(self):
        if not self.is_empty():
            print(f"Top element: {self.items[-1]}")
            return self.items[-1]
        else:
            print("Stack is empty. No top element.")
            return None

    def is_empty(self):
        return len(self.items) == 0

    def display(self):
        print("Stack contents:", self.items)

if __name__ == "__main__":
    stack = Stack()
    stack.push(10)
    stack.push(20)
    stack.peek()
    stack.pop()
    stack.display()
    print("Is stack empty?", stack.is_empty())
