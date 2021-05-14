#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define NUM 3
#include "ContactNode.h"

int main(void) {
   /* Type code here */
   ContactNode* Person[NUM];
   for(int i = 0; i < NUM; i++){
      ContactNode temp;
      printf("Person %d\n", i + 1);
      fgets(temp.contactName, 50, stdin);
      printf("Enter name:\n");
      temp.contactName[strlen(temp.contactName) - 1] = '\0';
      fgets(temp.contactPhoneNum, 50, stdin);
      printf("Enter phone number:\n");
      temp.contactPhoneNum[strlen(temp.contactPhoneNum)] = '\0';
      printf("You entered: %s, %s\n", temp.contactName, temp.contactPhoneNum);
      Person[i] = (ContactNode*)malloc(sizeof(ContactNode));
      strcpy(Person[i]->contactName, temp.contactName);
      strcpy(Person[i]->contactPhoneNum, temp.contactPhoneNum);
      Person[i]->nextNodePtr = NULL;
   }
   InsertContactAfter(Person[0], Person[1]);
   InsertContactAfter(Person[1], Person[2]);
   printf("\n");
   printf("CONTACT LIST\n");
   PrintContactNode(Person[0]);
   PrintContactNode(Person[1]);
   PrintContactNode(Person[2]);
   printf("\n");
   
   return 0;
}