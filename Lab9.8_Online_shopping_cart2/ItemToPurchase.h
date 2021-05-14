/* Type your code here */
#ifndef ITEM_TO_PURCHASE_H
#define ITEM_TO_PURCHASE_H
typedef struct ItemToPurchase_struct{
   char itemName[50];
   int itemPrice;
   int itemQuantity;
   char itemDescription[100];
}ItemToPurchase;

void MakeItemBlank(ItemToPurchase* item);
void PrintItemCost(ItemToPurchase item);

#endif