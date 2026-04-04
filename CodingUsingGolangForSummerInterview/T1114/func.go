// package main

// type Foo struct {
// 	firstDown  chan struct{}
// 	secondDown chan struct{}
// }

// func NewFoo() *Foo {
// 	return &Foo{
// 		firstDown:  make(chan struct{}),
// 		secondDown: make(chan struct{}),
// 	}
// }

// func (f *Foo) First(printFirst func()) {
// 	// Do not change this line
// 	printFirst()
// 	close(f.firstDown)
// }

// func (f *Foo) Second(printSecond func()) {
// 	/// Do not change this line
// 	<-f.firstDown
// 	printSecond()

// 	close(f.secondDown)
// }

//	func (f *Foo) Third(printThird func()) {
//		// Do not change this line
//		<-f.secondDown
//		printThird()
//		// close(f.secondDown)
//	}
package main
