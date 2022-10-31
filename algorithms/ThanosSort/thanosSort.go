package main

import (
  "math/rand"
  "fmt"
  "time"
)

func main() {
  // Populate a slice with random values
  fmt.Println("Composition of universe : ")
  universe := generateRandomUniverse()
  DisplayUniverse(universe)
  // Run Thanos Fate
  ThanosFate(universe)
}

func generateRandomUniverse () (universe []string) {
    universe = []string {"Pierre","Jack","Georges","David","Julien","Jerome","Leo","Alfred","Quentin","Michel"}
    return universe
}

func ThanosFate(universe []string) (){
  fmt.Println("Thanos Fate !!! :D :D :D")
  fmt.Println()
  for i := 0; i < len(universe)-1 / 2 ; i++ {
      min := 0
      max := len(universe)
      rand.Seed(time.Now().UnixNano())
      randomIndex := rand.Intn(max - min) + min
      universe = append(universe[:randomIndex], universe[randomIndex+1:]...)
  }
  fmt.Println("The survivors are : ")
  DisplayUniverse(universe)
}

func DisplayUniverse(universe []string){
  for i := 0; i < len(universe); i++ {
    fmt.Println(universe[i] + " ");
  }
  fmt.Println()
}
