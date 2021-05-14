/* Type your code here */
#include<stdio.h>
#include <stdlib.h>
#include<string.h>
#include "ShoppingCart.h"
void printOptions(){
      printf("MENU\n");
      printf("a - Add item to cart\n");
      printf("r - Remove item from cart\n");
      printf("c - Change item quantity\n");
      printf("i - Output items' descriptions\n");
      printf("o - Output shopping cart\n");
      printf("q - Quit\n\n");
   }
int main(void){
   ShoppingCart cart;
   char name[50];
   char option = ' ';
   char temp;
   printf("Enter Customer's Name:\n");
   fgets(cart.customerName, 100, stdin);
   cart.customerName[strlen(cart.customerName) - 1] = '\0';
   printf("Enter Today's Date:\n");
   fgets(cart.currentDate, 100, stdin);
   cart.currentDate[strlen(cart.currentDate) - 1] = '\0';
   cart.cartSize = 0;
   printf("\n");
   printf("Customer Name: %s\n", cart.customerName);
   printf("Today's Date: %s\n", cart.currentDate);
   printf("\n");
   printOptions();
   char item_name[50];
   char item_desc[100];
   int item_price;
   int item_qty;
   ItemToPurchase item;
   scanf(" %c%c", &option, &temp);
   while (option != 'q'){
      switch(option){
         case 'f':
            printf("Choose an option:\n");
            scanf(" %c%c", &option, &temp);
            break;
         case 's':
         printf("Choose an option:\n");
         printf("Choose an option:\n");
         scanf(" %c%c", &option, &temp);
            break;
         case 'q':
            //printOptions();
            //printf("Choose an option:\n");
            break;
         default:
            // printf("Choose an option:\n");
            scanf(" %c%c", &option, &temp);
            break;
         case 'a':
            printf("ADD ITEM TO CART\n");
            printf("Enter the item name:\n");
            fgets(item_name, 50, stdin);
            item_name[strlen(item_name) - 1] = '\0';
            strcpy(item.itemName, item_name);
            
            printf("Enter the item description:\n");
            fgets(item_desc, 100, stdin);
            item_desc[strlen(item_desc) - 1] = '\0';
            strcpy(item.itemDescription, item_desc);
            
            printf("Enter the item price:\n");
            scanf("%d", &item_price);
            item.itemPrice = item_price;
            
            printf("Enter the item quantity:\n\n");
            scanf("%d", &item_qty);
            item.itemQuantity = item_qty;
            cart = AddItem(item, cart);
            printOptions();
            printf("Choose an option:\n");
            scanf(" %c%c", &option, &temp);
            
            break;
         case 'r':
            printf("REMOVE ITEM FROM CART\n");
            printf("Enter name of item to remove:\n");
            fgets(name, 50, stdin);
            name[strlen(name) - 1] = '\0';
            cart = RemoveItem(name, cart);
            printOptions();
            scanf(" %c%c", &option, &temp);
            printf("Choose an option:\n");
            break;
         case 'c':
            printf("CHANGE ITEM QUANTITY\n");
            printf("Enter the item name:\n");
            fgets(name, 50, stdin);
            name[strlen(name) - 1] = '\0';
            printf("Enter the new quantity:\n");
            cart = ModifyItem(name, cart);
            printOptions();
            scanf(" %c%c", &option, &temp);
            printf("Choose an option:\n");
            break;
         case 'i':
            printf("OUTPUT ITEMS' DESCRIPTIONS\n");
            PrintDescriptions(cart);
            printOptions();
            scanf(" %c%c", &option, &temp);
            //printf("Choose an option:\n");
            printf("Choose an option:\n");
            break;
         case 'o':
            printf("OUTPUT SHOPPING CART\n");
            PrintTotal(cart);
            printOptions();
            scanf(" %c%c", &option, &temp);
            printf("Choose an option:\n");
            //printf("Choose an option:\n");
            break;
      }
   }
   // if(option == 'q'){
   //    printf("Choose an option:\n");
   // }
   return 0;
}