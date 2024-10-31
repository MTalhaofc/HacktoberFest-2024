#include<iostream>
using namespace std;

class Node{
    public:
        int data;
        Node * Next;

        Node(int data){
            this->data=data;
            this->Next=NULL;
        }
};

void InsertNode(Node*&head,int data){
    Node *p = head;
    Node * newnode = new Node(data);
    while (p->Next)
    {
        p=p->Next;
    }
    p->Next = newnode;
    
}
void print(Node*&head){
    Node *p = head;
    while (p){
        cout<<p->data<<" ";
        p=p->Next;
    }
   
   
    
}
//method 1 to reverse list
void reverseLL(Node *&head){
    Node *prev=NULL,*current=head,*forward;
    while (current)
    {
        forward = current->Next;
        current->Next = prev;
        prev = current;
        current = forward;
        
    }
    head = prev;
    
}


//method 2 to reverse list
Node* reverseList(Node* head) {
    Node *cur = head, *prev = nullptr;
    while (cur) {
        swap(cur->Next, prev);
        swap(prev, cur);
    }
    return prev;
}


int main(){

    Node * Head = new Node(23);
    InsertNode(Head,32);
    InsertNode(Head,56);
    InsertNode(Head,16);
    InsertNode(Head,78);
    print(Head);
    Head =reverseList(Head);
    cout<<endl;
    print(Head);
    
    return 0;
}
