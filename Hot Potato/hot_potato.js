// Since js's array doesn't have the insert method, we'll create it
function insert(arr, index, item){
    return arr.splice(index, 0, item);
  }
  
  // In this game, the first person to pass the potato is in the last
  // position of the array
  // The main idea is, we dequeued and enqueued simulating the pass of the 'hot potato'
  // The last one to be dequeued, is the loser
  function hotPotato(nameList, repetitions){
    // this function should use a Queue, but, since the array in JS have the
    // pop, and we created the insert, method it'll be fine
    let person;
    for(let i=0; i<repetitions; i++){
      person = nameList.pop();
      insert(nameList, 0, person)
    }
    return nameList.pop()
  }
  
  // Testing the code
  loser = hotPotato(["Ada","Alan","Linus","Paul","Bjarne"],7)
  console.log(loser)