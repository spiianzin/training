package queue

import (
  "testing"
)

func TestEnqueue(t *testing.T) {
  q := Queue {0, 0, 0, 5, [5]int{}}
  input := 22
  expected := 22

  q.Enqueue(input)
  output := q.array[0]

  if output != expected {
    t.Error("\nTest Failed: {} inserted, {} expected, recieved: {}", input, expected, output)
  }
}

func TestDenqueue(t *testing.T) {
  q := Queue {0, 0, 0, 5, [5]int{}}
  expected := 22

  q.Enqueue(22)
  q.Enqueue(30)
  q.Enqueue(-5)
  output := q.Dequeue()

  if output != expected {
    t.Error("\nTest Failed: {} expected, recieved: {}", expected, output)
  }
}

func TestShouldIncreaseTailIndexWhenAddElement(t *testing.T) {
  q := Queue {0, 0, 0, 5, [5]int{}}
  expected := 1

  q.Enqueue(22)
  output := q.tail

  if output != expected {
    t.Errorf("\nTest Failed: %d expected, recieved: %d", expected, output)
  }
}

func TestShouldRevertTailIndexWhenAddElement(t *testing.T) {
  q := Queue {0, 0, 0, 5, [5]int{}}
  expected := 0

  q.Enqueue(22)
  q.Enqueue(23)
  q.Enqueue(24)
  q.Enqueue(25)
  q.Dequeue()
  q.Enqueue(26)
  output := q.tail

  if output != expected {
    t.Errorf("\nTest Failed: %d expected, recieved: %d", expected, output)
  }
}

// func TestShouldRevertTailIndexWhenAddElement2(t *testing.T) {
//   q := Queue {0, 0, 0, 3, [3]int{}}
//   expected := 0
//
//   q.Enqueue(22)
//   q.Enqueue(23)
//   q.Enqueue(24)
//   output := q.tail
//
//   if output != expected {
//     t.Errorf("\nTest Failed: %d expected, recieved: %d", expected, output)
//   }
// }
