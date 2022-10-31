import Queue from "./queue";

class Graph<T> {
    list: Map<T, Array<T>>;
  
    constructor() {
      this.list = new Map<T, Array<T>>();
    }
  
    addVertice(value: T) {
      this.list.set(value, []);
    }
  
    addEdge(src: T, dest: T) {
      this.list.get(src).push(dest);
      this.list.get(dest).push(src);
    }
  
    bfs(node, callback) {
      let q = new Queue<T>();
  
      let visited = new Set<T>();
  
      q.enqueue(node);
      visited.add(node);
  
      while (!q.isEmpty()) {
        let element = q.dequeue();
  
        callback(element);
  
        let items = this.list.get(element);
        for (let i in items) {
          let neighbor = items[i];
          if (!visited.has(neighbor)) {
            q.enqueue(neighbor);
            visited.add(neighbor);
          }
        }
      }
    }
}