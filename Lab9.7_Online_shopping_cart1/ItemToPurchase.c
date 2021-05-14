#include<stdio.h>
#include<string.h>

#include "ItemToPurchase.h"

void MakeItemBlank(ItemToPurchase* item){
   strcpy(item->itemName, "none");
   item->itemPrice = 0; 
   item->itemQuantity = 0;
}
void PrintItemCost(ItemToPurchase* item){
   printf("%s %d @ $%d = $%d\n",item->itemName, item->itemQuantity, item->itemPrice, item->itemPrice * item->itemQuantity);
}
ItemToPurchase CreatItemNode(ItemToPurchase* thisItem, char name[], int price, int quantity, ItemToPurchase* address){
   strcpy(thisItem->itemName, name);
   thisItem->itemPrice = price;
   thisItem->itemQuantity = quantity;
   thisItem->nextNode = address;
   return *thisItem;
   }
void InsertItemAfter(ItemToPurchase* thisItem, ItemToPurchase* nextItem){
   ItemToPurchase* tmpNext = NULL;
   tmpNext = thisItem->nextNode;
   thisItem->nextNode = nextItem;
   nextItem->nextNode = tmpNext;
return;
   }
/* Type your code here */