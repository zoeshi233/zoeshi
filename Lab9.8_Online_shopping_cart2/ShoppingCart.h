/* Type your code here */
#include "ItemToPurchase.h"
typedef struct ShoppingCart_Struct{
   char customerName[50];
   char currentDate[50];
   ItemToPurchase cartItems[10]; // - has a maximum of 10 slots (can hold up to 10 items of any quantity)
   int cartSize; // - the number of filled slots in array cartItems [ ] (number of items in cart of any quantity)
}ShoppingCart;
   ShoppingCart AddItem(ItemToPurchase item, ShoppingCart cart);
   //Adds an item to cartItems array. Has parameters ItemToPurchase and ShoppingCart. Returns ShoppingCart object.
   ShoppingCart RemoveItem(char item[], ShoppingCart cart);
   //Removes item from cartItems array (does not just set quantity to 0; removed item will not take up a slot in array). Has a char[ ](an item's name) and a ShoppingCart parameter. Returns ShoppingCart object.
   //If item name cannot be found, output this message: Item not found in cart. Nothing removed.
   ShoppingCart ModifyItem(char name[], ShoppingCart cart);
   //Modifies an item's description, price, and/or quantity. Has parameters ItemToPurchase and ShoppingCart. Returns ShoppingCart object.
   int GetNumItemsInCart(ShoppingCart cart);
   //Returns quantity of all items in cart. Has a ShoppingCart parameter.
   int GetCostOfCart(ShoppingCart cart);
   //Determines and returns the total cost of items in cart. Has a ShoppingCart parameter.
   void PrintTotal(ShoppingCart cart);
   //Outputs total of objects in cart. Has a ShoppingCart parameter.
   //If cart is empty, output this message: SHOPPING CART IS EMPTY
   void PrintDescriptions(ShoppingCart cart);
   //Outputs each item's description. Has a ShoppingCart parameter.