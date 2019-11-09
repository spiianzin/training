package queue

type Queue struct {
  head int
  tail int
  lenght int
  capacity int
  array [10]int
}

func (q *Queue) Enqueue(val int) {
  if (q.head + 1 <= q.capacity) {
      q.array[q.head] = val
      q.lenght++
      q.head++
  }
}

func (q *Queue) Dequeue() int {
  if (q.lenght > 0) {
      result := q.array[q.tail]
      q.tail++
      q.lenght--
      return result
  }
  return -1
}
