// ja que o javascript nao possui uma estrutura de heap, iremos simula-la usando um array
// onde o elemento de maior valor ficará na posiçao "i" (index do parent da heap)

// a funçao heapify verifica se 3 elementos estao na ordem numa max_heap
// caso nao, reordenaremos de acordo com a posiçao ideal
// vale lembrar q largest, left e right sao apenas os indexes dos elementos

function heapify(arr, length, i){
  var largest = i;
  const left = i*2 + 1;
  const right = left + 1;

  if(left < length && arr[left] > arr[largest]){
    largest = left;
  }
  if(right < length && arr[right] > arr[largest]){
    largest = right;
  }
  // agora ja checamos qual elemento é o maior
  // caso o largest tenha mudado de valor, logo largest !== i, arrumamos nosso array
  if(largest !== i){
    [arr[i], arr[largest]] = [arr[largest], arr[i]];
    // checamos, recursivametne, todos os outros valores da heap 
    // apos modificar nosso array
    heapify(arr, length, largest);
  }

  return arr;
}

// bem, vamos dar sort bottom up
// nosso "last parent node" sera nosso "i"
// nosso "last children" sera o nosso "k", o ultimo elemento do array
// vale lembrar q i e k sao apenas os indexes desses elementos
function heapSort(arr){
  const length = arr.length;
  var i = Math.floor((length/2) - 1);
  var k = length -1;

  // começamos no last parent e damos heapify no caminho de volta
  while(i >= 0){
    heapify(arr, length, i);
    i--;
  }

  // nessa etapa ja temos nossa max_heap, porem iremos tirar o parent, o maior valor
  // e coloca-lo no final do nosso array, ao fazermos isso, devemos dar heapify
  // novamente, mas diminuimos o tamanho do array em 1, pois desconsideramos
  // o elemento retirado da heap
  while(k >= 0){
    [arr[0], arr[k]] = [arr[k], arr[0]]
    heapify(arr, k, 0);
    k--;
  }
  return arr;
}

// exemplo de execuçao com um array aleatorio
let arr = [2,4,5,3,1,0,9]
console.log(arr)
heapSort(arr)
console.log(arr)