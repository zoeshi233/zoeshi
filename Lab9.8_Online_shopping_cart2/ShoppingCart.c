/* Type your code here */
#include<stdio.h>
#include<string.h>
#include "ShoppingCart.h"
#include "ItemToPurchase.h"

   ShoppingCart AddItem(ItemToPurchase item, ShoppingCart cart){
      cart.cartItems[cart.cartSize] = item;
      cart.cartSize++;
      return cart;
   }
   //Adds an item to cartItems array. Has parameters ItemToPurchase and ShoppingCart. Returns ShoppingCart object.
   ShoppingCart RemoveItem(char name[], ShoppingCart cart){
      int flag = 0;
      for(int i = 0; i < cart.cartSize && flag == 0; i++){
         if(strcmp(cart.cartItems[i].itemName, name) == 0 && flag == 0){
            flag = 1;
            cart.cartSize--;
            
            for(int j = i; j < cart.cartSize + 1; j++){
               cart.cartItems[j] = cart.cartItems[j + 1];
            }
         }
      }
      if(flag == 0){
         printf("Item not found in cart. Nothing removed.\n");
      }
      printf("\n");
      return cart;
   }
   //Removes item from cartItems array (does not just set quantity to 0; removed item will not take up a slot in array). Has a char[ ](an item's name) and a ShoppingCart parameter. Returns ShoppingCart object.
   //If item name cannot be found, output this message: Item not found in cart. Nothing removed.
   ShoppingCart ModifyItem(char name[], ShoppingCart cart){
      int flag = 0;
      int qty;
      for(int i = 0; i < cart.cartSize && flag == 0; i++){
         if(strcmp(cart.cartItems[i].itemName, name) == 0){
            scanf("%d", &qty);
            flag = 1;
            cart.cartItems[i].itemQuantity = qty;
         }
      }
      if(flag == 0){
         printf("Item not found in cart. Nothing modified.\n\n");
      }
      return cart;
   }
   //Modifies an item's description, price, and/or quantity. Has parameters ItemToPurchase and ShoppingCart. Returns ShoppingCart object.
   int GetNumItemsInCart(ShoppingCart cart){
      int num = 0;
      for(int i = 0; i < cart.cartSize; i++){
         num = num + cart.cartItems[i].itemQuantity;
      }
      return num; 
   }
   //Returns quantity of all items in cart. Has a ShoppingCart parameter.
   int GetCostOfCart(ShoppingCart cart){
      int cost = 0;
      for(int i = 0; i < cart.cartSize; i++){
         cost = cost + cart.cartItems[i].itemPrice * cart.cartItems[i].itemQuantity;
      }
      return cost;
   }
   //Determines and returns the total cost of items in cart. Has a ShoppingCart parameter.
   void PrintTotal(ShoppingCart cart){
         printf("%s's Shopping Cart - %s\n", cart.customerName, cart.currentDate);
         printf("Number of Items: %d\n\n", GetNumItemsInCart(cart));
         if(cart.cartSize == 0){
         printf("SHOPPING CART IS EMPTY\n");
      }
         for(int i = 0; i < cart.cartSize; i++){
            PrintItemCost(cart.cartItems[i]);
         }
      printf("\nTotal: $%d\n\n", GetCostOfCart(cart));
   }
   
   //Outputs total of objects in cart. Has a ShoppingCart parameter.
   //If cart is empty, output this message: SHOPPING CART IS EMPTY
   void PrintDescriptions(ShoppingCart cart){
      printf("%s's Shopping Cart - %s\n", cart.customerName, cart.currentDate);
      printf("\nItem Descriptions\n");
      for(int i = 0; i < cart.cartSize; i++){
         printf("%s: %s\n", cart.cartItems[i].itemName, cart.cartItems[i].itemDescription);
      }
      printf("\n");
   }
   //Outputs each item's description. Has a ShoppingCart parameter.