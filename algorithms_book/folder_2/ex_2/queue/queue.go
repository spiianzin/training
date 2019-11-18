package queue

type Queue struct {
  head int
  tail int
  lenght int
  capacity int
  array [5]int
}

func (q *Queue) Enqueue(val int) {

  if ((q.tail + 1 == q.head) || (q.head == 0 && q.tail + 1 >=q.capacity)) {
    return
  }

  q.array[q.tail] = val
  q.tail++
  if (q.tail >= q.capacity) {
    q.tail = 0
  }

  // if (q.head + 1 <= q.capacity) {
  //     q.array[q.head] = val
  //     q.lenght++
  //     q.head++
  // }
}

func (q *Queue) Dequeue() int {
  ret := q.array[q.head]
  q.head++
  return ret
}
