package main

type Foo struct {
	first  chan int
	second chan int
}

func NewFoo() *Foo {
	return &Foo{
		first:  make(chan int),
		second: make(chan int),
	}
}

func (f *Foo) First(printFirst func()) {
	// Do not change this line
	printFirst()
	close(f.first)
}

func (f *Foo) Second(printSecond func()) {
	<-f.first
	/// Do not change this line
	printSecond()
	close(f.second)
}

func (f *Foo) Third(printThird func()) {
	<-f.second
	// Do not change this line
	printThird()

}
