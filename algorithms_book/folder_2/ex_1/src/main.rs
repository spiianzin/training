use std::ptr;
use std::fmt;

struct List<T> {
    head: *const Node<T>,
}

struct Node<T> {
    data: T,
    next: &'static Node<T>,
}

impl<T> List<T> {
    fn new() -> List<T> {
        List {
            head: ptr::null(),
        }
    }
}

impl fmt::Display for Node<i32> {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "({},{:p})", self.data, self.next)
    }
}

fn main() {
    println!("Hello, world!");

    let mut n1 = Node {
        data:1,
        next: Nil,
    };

    let n2 = Node {
        data:1,
        next: &mut n1,
    };

    let list = List::new();

    println!("You guessed: {}", n1);
    println!("You guessed: {}", n2);
}
