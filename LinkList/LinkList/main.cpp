#include <iostream>

using namespace std;

class Node {
    public:
        int data = 0;
        Node * next = nullptr;

        Node(int x){
            data = x;
            next = nullptr;
        }

};

Node *nthToLast(Node *head, int k, int &i){
    if(head == nullptr){
        return nullptr;
    }
    Node *nd = nthToLast(head->next,k,i);
    i++;
    if(i==k) return head;
    return nd;
}

Node *nthToLast(Node* head, int k){
    int i = 0;
    Node *p = nthToLast(head,k,i);
    return p;
}

Node *addList(Node *l1, Node *l2, int carry){
    Node *ans = new Node(0);
    if(l1 == nullptr && l2 == nullptr && carry == 0) return nullptr;
    int total = carry;
    if(l1 != nullptr) total += l1->data;
    if(l1 != nullptr) total += l2->data;
    int d = total  % 10;
    carry = total / 10;
    ans->data = d;
    if(l1 != nullptr || l2 != nullptr)
    ans->next = addList(l1 == nullptr ? nullptr : l1->next,
                        l2 == nullptr ? nullptr : l2 ->next,
                        carry);
    return ans;
}

void reverseList(Node *head){
    Node *ptr_1 = head;
    Node *last = nullptr;
    Node *ptr_2;
    while(ptr_1 != last && ptr_1->next != last){
        ptr_2 = ptr_1;
        while(ptr_2->next != last){
            ptr_2 = ptr_2->next;
        }
        cout << ptr_1->data << ' ' << ptr_2->data << endl;
        int temp = ptr_2->data;
        ptr_2->data = ptr_1->data;
        ptr_1->data = temp;
        last = ptr_2;
        ptr_1 = ptr_1->next;
    }
}

Node *insertNode(Node *head, int k){
    Node *n = new Node(k);
    if(head == nullptr) return n;
    Node *p = head;
    while(p->next != nullptr){
        p = p->next;
    }
    p->next = n;
    return head;
}

void printList(Node *h){
    auto p = h;
    while(p != nullptr){
        cout << p->data << ' ';
        p = p->next;
    }
    cout << endl;
}

bool has_cycle(Node* head) {
  Node *p1 = head;
  if(head->next == nullptr) return 0;
  Node *p2 = head->next->next;
  while(p1 != p2){
    p1 = p1->next;
    if(p2->next == nullptr) return 0;
    p2 = p2->next->next;
    if(p2 == nullptr) return 0;
  }
  return 1;
}

int main()
{
    Node *h = new Node(1);
    for(int k = 2; k < 10; k++){
        h = insertNode(h,k);
    }
    Node *a = new Node(1);
    a = insertNode(a,2);
    a = insertNode(a,3);
    Node *p = a;
    while(p->next != nullptr){
        p = p->next;
    }
    p->next = a;
    /*
    Node *b = new Node(4);
    b = insertNode(b,5);

    printList(a);
    printList(b);
    */
    cout << has_cycle(a) << endl;

    return 0;
}
