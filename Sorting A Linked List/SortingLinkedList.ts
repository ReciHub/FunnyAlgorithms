interface INode {
    data: number;
    next: INode | null;
}

class LLNode implements INode {
    public data: number;
    public next: INode | null;

    constructor(data: number) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private _head = null;
    private _tail = null;
    private _size = 0;

    public get size(): number {
        return this._size;
    }


    public isEmpty(): boolean {
        return this.size === 0;
    }


    public get head(): INode | null {
        return this._head;
    }


    public get tail(): INode | null {
        return this._tail;
    }

    public get mid(): INode | never {
        if (this.isEmpty()) {
            throw new Error("Linked List is empty");
        }

        if (this.size === 1) {
            return this.head;
        }

        let first = this.head;
        let second = this.head;

        while (second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
        }

        return first;
    }

    public set head(data: INode) {
        this._head = data;
    }

    public set tail(data: INode) {
        this._tail = data;
    }

    public set size(data: number) {
        this._size = data;
    }

    public getAtIndex(index: number): INode | never {
        if (this.isEmpty()) {
            throw new Error("Linked List is Empty");
        }

        if (index < 0 || index >= this.size) {
            throw new Error("Index is out of bounds");
        }

        let curr = this.head;

        for (let i = 1; i <= index; i++) {
            curr = curr.next as INode;
        }

        return curr;
    }
    
    
    public display(): void {
        console.log("These are the items in the Linked List");
        let curr = this.head;
        for (let i = 0; i < this.size; i++) {
            if (i === 0) {
                console.log(`Head: ${curr.data}`)
                curr = curr.next as INode;
                continue;
            }

            if (i === this.size - 1) {
                console.log(`Tail: ${curr.data}`);
                curr = curr.next;
                break;
            }

            console.log(`Index ${i}: ${curr.data}`);
            curr = curr.next as INode;
        }
    }


    public push(data: number): void {
        let newNode = new LLNode(data);

        if (!this.isEmpty()) {
            this.tail.next = newNode;
        }

        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.size++;
        } else {
            this.tail = newNode;
            this.size++;
        }
    }


    public unshift(data: number): void {
        let newNode = new LLNode(data);
        newNode.next = this.head;

        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.size++;
        } else {
            this.head = newNode;
            this.size++;
        } 
    }


    public insert(index: number, data: number) : void | never {
        if (index < 0 || index > this.size) {
            throw new Error("Index is out of bounds.");
        }

        if (index === 0) {
            this.unshift(data);
        } else if (index === this.size) {
            this.push(data);
        } else {
            let newNode = new LLNode(data);
            let prevNode = this.getAtIndex(index - 1);
            let nextNode = prevNode.next;
            prevNode.next = newNode;
            newNode.next = nextNode;
            this.size++;
        } 
    }


    public shift(): INode | never {
        if (this.isEmpty()) {
            throw new Error("Linked List is Empty");
        }

        let item = this.head as INode;

        if (this.size === 1) {
            this.head = null;
            this.tail = null;
            this.size = 0;
        } else {
            this.head = this.head.next;
            this.size--;
        }

        return item;
    }


    public pop(): INode | never {
        if (this.isEmpty()) {
            throw new Error("Linked List is Empty");
        }

        let item = this.tail as INode;

        if (this.size === 1) {
            this.head = null;
            this.tail = null;
            this.size = 0;
        } else {
            let secondToLast = this.getAtIndex(this.size - 2);
            this.tail = secondToLast;
            secondToLast.next = null;
            this.size--;
        }

        return item
    }


    public remove(index: number): INode | never {
        if (this.isEmpty()) {
            throw new Error("Linked List is Empty");
        }

        if (index < 0 || index >= this.size) {
            throw new Error ("Index is out of bounds");
        }

        if (index === 0) {
            return this.shift();
        } else if (index === this.size - 1) {
            return this.pop();
        } else {
            let prevNode = this.getAtIndex(index - 1);
            let nodeToRemove = prevNode.next;
            let nextNode = nodeToRemove.next;
            prevNode.next = nextNode;
            this.size--;
            return nodeToRemove;
        }
    }


    public mergeSortedLinkedLists(second: LinkedList): LinkedList {
        let merged = new LinkedList();

        let temp1 = this.head;
        let temp2 = second.head as INode;

        while (temp1 !== null && temp2 !== null) {
            if (temp1.data < temp2.data) {
                merged.push(temp1.data);
                temp1 = temp1.next;
            } else {
                merged.push(temp2.data);
                temp2 = temp2.next;
            }
        }

        if (temp1 === null) {
            while (temp2 !== null) {
                merged.push(temp2.data);
                temp2 = temp2.next;
            }
        }

        if (temp2 === null) {
            while (temp1 !== null) {
                merged.push(temp1.data);
                temp1 = temp1.next;
            }
        }

        return merged;
    }


    public mergeSort(): void {
        if (this.size == 1) {
            return;
        }

        let mid = this.mid;
        let midNext = mid.next;

        let left = new LinkedList();

        left.head = this.head;
        left.tail = this.mid;
        left.tail.next = null;
        left.size = Math.ceil((this.size) / 2);

        let right = new LinkedList();
        right.head = midNext;
        right.tail = this.tail;
        right.tail.next = null;
        right.size = Math.floor(this.size / 2);

        left.mergeSort();
        right.mergeSort();

        let sorted = left.mergeSortedLinkedLists(right);

        this.head = sorted.head;
        this.tail = sorted.tail;
    }
}