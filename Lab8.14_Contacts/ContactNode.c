#include <stdio.h>
#include "ContactNode.h"
#include <string.h>
void CreateContactNode(ContactNode* thisNode, char nameInit[], char phoneNumInit[], ContactNode* nextLoc) {
   strcpy(thisNode->contactName, nameInit);
   strcpy(thisNode->contactPhoneNum, phoneNumInit);
   thisNode->nextNodePtr = nextLoc;
   
}
void InsertContactAfter(ContactNode* thisNode, ContactNode* newNode) {
   ContactNode* tmpNext = NULL;
   
   tmpNext = thisNode->nextNodePtr; // Remember next
   thisNode->nextNodePtr = newNode; // this -- new -- ?
   newNode->nextNodePtr = tmpNext;
}
//Insert a new node after node
ContactNode* GetNextContact(ContactNode* thisNode) {
   return thisNode->nextNodePtr;
}
//Return location pointed by nextNodePtr
void PrintContactNode(const ContactNode* thisNode){
   printf("Name: %s\n", thisNode->contactName);
   printf("Phone number: %s\n", thisNode->contactPhoneNum);
}
