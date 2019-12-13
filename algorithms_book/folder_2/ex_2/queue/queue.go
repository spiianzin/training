package queue

type Queue struct {
	head     int
	tail     int
	lenght   int
	capacity int
	array    [5]int
}

func (q *Queue) Enqueue(val int) {
	if (q.head + 1) != q.tail {
		q.array[q.head] = val
		q.head++
		if q.head == q.capacity {
			q.head = 0
		}
	}
}

func (q *Queue) Dequeue() int {
	if (q.tail + 1) != q.head {
		ret := q.array[q.tail]
		q.tail++
		if q.tail >= q.capacity {
			q.tail = 0
		}
		return ret
	}
	return -1
}
