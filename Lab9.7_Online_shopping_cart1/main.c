#include<stdio.h>
#include<string.h>
#include <stdlib.h>

#include "ItemToPurchase.h"
int main(void) {
   /* Type your code here */  
   ItemToPurchase* item[2];
   for(int i = 0; i < 2 ; i++){
      ItemToPurchase temp;
      printf("Item %d\n", i + 1);
      printf("Enter the item name:\n");
      fgets(temp.itemName, 50, stdin);
      temp.itemName[strlen(temp.itemName) - 1] = '\0';
      printf("Enter the item price:\n");
      scanf("%d", &temp.itemPrice);
      printf("Enter the item quantity:\n\n");
      scanf("%d", &temp.itemQuantity);
      item[i] = (ItemToPurchase*)malloc(sizeof(ItemToPurchase));
      *item[i] = CreatItemNode(item[i], temp.itemName, temp.itemPrice, temp.itemQuantity,NULL);
      char c = getchar();
         while(c != '\n' && c != EOF) {
            c = getchar();
         }
   }
   InsertItemAfter(item[0],item[1]);
   printf("TOTAL COST\n");
   PrintItemCost(item[0]);
   PrintItemCost(item[1]);
   int cost = item[0]->itemQuantity*item[0]->itemPrice+item[1]->itemQuantity*item[1]->itemPrice;
   printf("\nTotal: $%d\n", cost);
   return 0;
}