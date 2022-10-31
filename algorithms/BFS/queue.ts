export default class Queue<T> {
    nodes: Array<T>;
    constructor() {
      this.nodes = [];
    }
  
    enqueue(value: T) {
      this.nodes.push(value);
    }
  
    dequeue() {
      return this.nodes.shift();
    }
  
    isEmpty() {
      return this.nodes.length <= 0;
    }
  }