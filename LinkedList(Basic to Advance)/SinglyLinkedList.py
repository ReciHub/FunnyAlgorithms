class Node:
    def __init__(self,data):
        self.data = data
        self.next = None

class SinglyLinkedList:
    def __init__(self):
        self.head = None

    def insert_begin(self, data):
        cur_head = self.head
        new_head = Node(data)

        new_head.next = cur_head
        self.head = new_head
        print("Element Inserted")

    def insert_end(self, data):
        temp = self.head
        new_node = Node(data)

        while temp.next != None:
            temp = temp.next

        temp.next = new_node
        print("Element inserted")

    def insert_before(self, data, ref):
        temp = self.head
        new_node = Node(data)

        if temp.data == ref:
            self.insert_begin(data)
            return

        flag = 0
        while temp.next != None:
            if temp.next.data == ref:
                flag = 1
                break

            temp = temp.next

        if flag == 0:
            print("Element not found")
            return

        new_node.next = temp.next
        temp.next = new_node
        print("Element inserted")

    def insert_after(self, data, ref):
        temp = self.head
        new_node = Node(data)

        flag = 0
        while temp.next != None:
            if temp.data == ref:
                flag = 1
                break

            temp = temp.next

        if flag == 0 and temp.data != ref:
            print("Element not found")
            return

        new_node.next = temp.next
        temp.next = new_node
        print("Element inserted")

    def delete_head(self):
        self.head = self.head.next
        print("Element deleted")

    def delete_end(self):
        temp = self.head
        while temp.next.next != None:
            temp = temp.next
        temp.next = None
        print("Element deleted")

    def delete_element(self,ele):
        temp = self.head

        if self.head.data == ele:
            self.delete_head()
            return

        flag = 0
        while temp.next != None:
            if temp.next.data == ele:
                flag = 1
                break
            temp = temp.next

        if flag == 0:
            print("Element not found")
            return

        to_be_deleted = temp.next
        temp.next = to_be_deleted.next
        print("Element deleted")

    def search_element(self,ele):
        temp = self.head
        i = 1
        flag = 0

        while temp.next != None:
            if temp.data == ele:
                flag = 1
                break

            temp = temp.next
            i += 1

        if flag == 0 and temp.data != ele:
            return -1

        return i

    def reverse_sll(self):
        cur = self.head
        prev = None

        while cur != None:
            next = cur.next
            cur.next = prev
            prev = cur
            cur = next

        self.head = prev
        print("SLL is revrsed")

    def print_sll(self):
        temp = self.head

        while(temp.next != None):
            print(temp.data,"->",end=" ")
            temp = temp.next

        print(temp.data)

def create_linked_list(data):
    sll = SinglyLinkedList()
    sll.head = Node(data)
    print("Element inserted")
    return sll

sll = None
while True:
    print("****** Singly Linked List ******\n");
    print("1.Create SLL\n2.Insert at Beginning\n3.Insert at end");
    print("4.Insert before given Element\n5.Insert after given element");
    print("6.Delete Head\n7.Delete last element\n8.Delete given element");
    print("9.Search for given element\n10.Reverse SLL\n11.Print SLL");
    print("12.Exit\n");

    ch = int(input("Your choice -> "))

    if ch == 1:
        ele = int(input("Enter element to be inserted -> "))
        sll = create_linked_list(ele)

    elif ch == 12:
        break

    elif sll == None:
        print("SLL does not exist. Create head node first")

    elif ch == 2:
        ele = int(input("Enter element to be inserted -> "))
        sll.insert_begin(ele)

    elif ch == 3:
        ele = int(input("Enter element to be inserted -> "))
        sll.insert_end(ele)

    elif ch == 4:
        ele = int(input("Enter element to be inserted -> "))
        ref = int(input("Enter reference element -> "))
        sll.insert_before(ele,ref)

    elif ch == 5:
        ele = int(input("Enter element to be inserted -> "))
        ref = int(input("Enter reference element -> "))
        sll.insert_after(ele,ref)

    elif ch == 6:
        sll.delete_head()

    elif ch == 7:
        sll.delete_end()

    elif ch == 8:
        ele = int(input("Enter element to be deleted -> "))
        sll.delete_element(ele)

    elif ch == 9:
        ele = int(input("Enter element to be searched -> "))
        pos = sll.search_element(ele)
        if pos == -1:
            print("Element not found")
        else:
            print("Element found at position",pos)

    elif ch == 10:
        sll.reverse_sll()

    elif ch == 11:
        sll.print_sll()

    else:
        print("Invalid Input")

    input("\nPress Enter to continue\n")
