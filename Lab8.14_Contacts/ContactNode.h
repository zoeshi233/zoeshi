 /* Type your code here. */
    typedef struct ContactNode_Struct{
      char contactName[50];
      char contactPhoneNum[50];
      struct ContactNode_Struct* nextNodePtr;
   }ContactNode;
    void CreateContactNode(ContactNode* thisNode, char nameInit[], char phoneNumInit[], ContactNode* nextLoc);
    void InsertContactAfter(ContactNode* thisNode, ContactNode* newNode);
    ContactNode* GetNextContact(ContactNode* thisNode);
    void PrintContactNode(const ContactNode* thisNode);