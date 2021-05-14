#ifndef ITEM_TO_PURCHASE_H
#define ITEM_TO_PURCHASE_H
/* Type your code here */
typedef struct ItemToPurchase_Struct{
   char itemName[50];
   int itemPrice;
   int itemQuantity;
   struct ItemToPurchase* nextNode;
}ItemToPurchase;
void MakeItemBlank(ItemToPurchase* item);
void PrintItemCost(ItemToPurchase* item);
char getChar(ItemToPurchase* item);
ItemToPurchase CreatItemNode(ItemToPurchase* thisItem, char name[], int price, int quantity, ItemToPurchase* adrrese);
void InsertItemAfter(ItemToPurchase* thisItem, ItemToPurchase* nextItem);
#endif