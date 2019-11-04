package list

import (
  "fmt"
  )

type Node struct {
  val int
  next *Node
}

func (n *Node) GetVal() int {
  return n.val
}

func (n *Node) Print() {
    fmt.Print(n.val)
    if (n.next != nil) {
        fmt.Print(" -> ")
        n.next.Print()
    }
}

func (list *List) InsertAfter(node *Node, insertingNode *Node) {
  currentNode := list.head
  for i := 0; i < list.len; i++ {
    if (currentNode == node) {
      insertingNode.next = currentNode.next
      currentNode.next = insertingNode
       list.len = list.len + 1
       return
    }
    currentNode = currentNode.next
  }
}

type List struct {
  head *Node
  len int
}

func (l *List) GetLen() int {
  return l.len
}

func (l *List) RemoveNode(node *Node) {
  currentNode := l.head
  previousNode := l.head
  for i := 0; i < l.len; i++ {
    if (currentNode == node) {
       previousNode.next = currentNode.next
       l.len = l.len - 1
       return
    }
    previousNode = currentNode
    currentNode = currentNode.next
  }
}

func (list *List) FindByPos(val int) *Node {
  if (val > list.len || val < 0) {
    return nil
  }

  currentNode := list.head
  for i:=0; i < val ; i++ {
    currentNode = currentNode.next
  }

  return currentNode
}

func (list *List) Find(val int) *Node {
  currentNode := list.head
  for i:=0; i < list.len; i++ {
    if (currentNode.GetVal() == val) {
       return currentNode
    }
    currentNode = currentNode.next
  }

  return nil
}

func (list *List) find(counter int, val int, node *Node) *Node {
  if (counter == list.len) {
    return nil
  }

  if (node.val == val) {
    return node
  }

  counter = counter + 1
  return list.find(counter, val, node.next)
}

func (list *List) Insert(val int) {
  newNode := Node{val: val}
  if (list.head != nil) {
    newNode.next = list.head
  }
  list.head = &newNode
  list.len = list.len + 1
}

func (l *List) Print() {
  l.head.Print()
  fmt.Println()
}

func (l *List) PrintAll() {
  printed := l.head
  for i:=0; i < l.len; i++ {
    fmt.Print(printed, " -> ")
    printed = printed.next
  }

  fmt.Println()
}

func (l *List) Head() *Node {
  return l.head
}
