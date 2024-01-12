package main

import (
	"encoding/csv"
	"flag"
	"fmt"
	"os"
	"time"
)

func main() {
	fileName := flag.String("f", "quiz.csv", "path of the file")
	timer := flag.Int("t", 30, "timer for the quiz")
	flag.Parse()
	questionAndAnswer,err := pullQuestion(*fileName)
	if err != nil{
		exit(fmt.Sprintf("Something went wrong, try again later: %w, file: %s", err, fileName))
	}
	correctAnswer := 0
	tObj := time.NewTimer(time.Duration(*timer)*time.Second)
	ansC := make(chan string)

	problemLoop:
		// var answer string
		for i,p := range questionAndAnswer{
			var answer string
			fmt.Println("Q: "+ p.question)

			go func() {
				fmt.Scanf("%s", &answer)
				ansC <- answer
			}()
			select{
			case <-tObj.C:
				fmt.Println()
				break problemLoop
			case iAns := <-ansC:
				if iAns == p.answer{
                    correctAnswer++
				}
				if i==len(questionAndAnswer)-1{
					close(ansC)
				}
			}
		}

		fmt.Printf("You scored %d marks out of %d", correctAnswer, len(questionAndAnswer))
		fmt.Println("\nPress Enter to exit")
		<-ansC
}

func pullQuestion(fileName string)([]questionAndAnswer, error){

	if fObj, err := os.Open(fileName); err == nil {
		csvR := csv.NewReader(fObj)
		if cLines, err := csvR.ReadAll(); err == nil{
			return parseQuestion(cLines), nil
		} else {
			return nil, fmt.Errorf("Error reading the file %s: %w", fileName, err)
		}
	} else {
		return nil, fmt.Errorf("Error opening file %s", fileName);
	}


}

type questionAndAnswer struct{
	question string
	answer string
}

func parseQuestion(allQuestions [][]string) []questionAndAnswer{
	
	r := make ([]questionAndAnswer, len(allQuestions))
	for i := 0; i<len(allQuestions); i++{
		r[i] = questionAndAnswer{question: allQuestions[i][0], answer: allQuestions[i][1]}
	}
	return r
}

func exit(msg string){
	fmt.Println(msg)
	os.Exit(1)
}


// what did I learn -
// how to read a csv file using encoding/csv