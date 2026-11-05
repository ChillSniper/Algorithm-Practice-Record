package main

import (
	"fmt"
	"sync"
)

func main() {
	oddTurn := make(chan struct{}, 1)
	evenTrun := make(chan struct{})

	var wg sync.WaitGroup
	wg.Add(2)

	go func() {
		defer wg.Done()

		for i := 1;i < 100;i += 2 {
			<- oddTurn

			fmt.Printf("线程1 打印 %d\n", i)

			evenTrun <- struct{}{}

		}

		fmt.Print("线程1 退出\n")
	}()

	go func() {
		defer wg.Done()

		for i := 2;i <= 100;i += 2 {
			<- evenTrun

			fmt.Printf("线程2 打印 %d\n", i)

			oddTurn <- struct{}{}
		}

		fmt.Print("线程2 退出\n")
	}()

	oddTurn <- struct{}{}

	wg.Wait()
}