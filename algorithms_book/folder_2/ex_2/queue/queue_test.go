package queue

import (
  "testing"
)

func TestEnqueue(t *testing.T) {
  q := Queue {0, 0, 0, 10, [10]int{}}
  input := 22
  expected := 22

  q.Enqueue(input)
  output := q.array[0]

  if output != expected {
    t.Error("\nTest Failed: {} inserted, {} expected, recieved: {}", input, expected, output)
  }
}

func TestDenqueue(t *testing.T) {
  q := Queue {0, 0, 0, 10, [10]int{}}
  expected := 22

  q.Enqueue(22)
  q.Enqueue(30)
  q.Enqueue(-5)
  output := q.Dequeue()

  if output != expected {
    t.Error("\nTest Failed: {} expected, recieved: {}", expected, output)
  }
}
