package list

import (
	"fmt"
	"testing"
)


func initList() *List {
	var l List
	l.Insert(1)
	l.Insert(2)
	l.Insert(3)
	return &l
}

func TestFindOne(t *testing.T) {
	l := initList()
	input := 2
	expected := 2

	output := l.Find(input)
	if output.GetVal() != expected {
		t.Error("\nTest Failed: {} inserted, {} expected, recieved: {}", input, expected, output)
	}
}

func TestNoFindAndGetNil(t *testing.T) {
	l := initList()
	input := 4
	var expected *Node = nil

	output := l.Find(input)
	if output != expected {
		t.Error("\nTest Failed: {} inserted, {} expected, recieved: {}", input, expected, output)
	}
}

func TestRemoveOne(t *testing.T) {
	l := initList()
	expected := l.GetLen() - 1

	node := l.Find(1)
	l.RemoveNode(node)

	if l.GetLen() != expected {
		t.Errorf("\nTest Failed: expected size is %d", expected)
	}
}

func TestFindByPos(t *testing.T) {
	l := initList()
	input := 2
	expected := 1

	output := l.FindByPos(input)
	fmt.Println(output)
	if output.GetVal() != expected {
		t.Error("\nTest Failed: {} inserted, {} expected, recieved: {}", input, expected, output)
	}
}

func TestInsertAfter2(t *testing.T) {
	l := initList()
	inputNode := Node{42, nil}
	expectedLen := 4

	n := l.Find(2)

	l.InsertAfter(n, &inputNode)

	output := l.Find(42)
	fmt.Println(output)
	if inputNode != *output {
		t.Errorf("Failed: expected node is %d", inputNode.GetVal())
	}
	if l.len != expectedLen {
		t.Errorf("Failed: expected length of list is %d", expectedLen)
	}
}
