/* Type your code here */
#include<stdio.h>
#include<string.h>
#include "ShoppingCart.h"
#include "ItemToPurchase.h"
//char itemDescription[ ] - set to "none" in MakeItemBlank()

void MakeItemBlank(ItemToPurchase* item){
   strcpy(item->itemName, "none");
   item->itemPrice = 0;
   item->itemQuantity = 0;
   strcpy(item->itemDescription, "none");
}

void PrintItemCost(ItemToPurchase item){
   printf("%s %d @ $%d = $%d\n", item.itemName, item.itemQuantity, item.itemPrice, ((item.itemPrice) * (item.itemQuantity)));
}