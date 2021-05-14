/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Shuyi Shi
Student Number: 216816555
Course Section: M
eecs user id: zoeshi
*/

#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>

#define SIZE 30
#define fieldLength 200


#define diskFile "diskFile.dat"
#define courseFile "course.txt"

struct db_type
{
   char name[fieldLength];
   int age;
   char course1[fieldLength];
   char course2[fieldLength];
   char status[fieldLength];
 };

struct courseInfo
{ 
  char code [20]; // e.g., EECstart2030
  char title [fieldLength];
  char  date [20];
  char time_start [20];
  char time_end [20];
  char  location [20]; 
};
 
 
struct courseInfo courseArr[SIZE]; // global variable  array of struc

char prompt_menu(void);
void init_list(struct db_type * pArr[]); 
void clearDB(struct db_type * pArr[]);
void init_courseArr(void);

void writeDisk(struct db_type * pArr[]); 
void emptyDisk(void); 
void loadDisk(struct db_type * pArr[]);

void displayCourses(void);
void enterNew(struct db_type * pArr[]);
void removeRecord (struct db_type * pArr[]);
void swap(struct db_type * pArr[]);
void displayDB(struct db_type * pArr[]);
void sort(struct db_type * pArr[]);





int main(int argc, char *argv[])
{
    
    struct db_type * db_pArr[SIZE];  // main db storage

    init_list(db_pArr);  // set to NULL
    
    init_courseArr();  // load course from diskfile
    
    char choice;
    for(; ;){
      choice = prompt_menu();
      switch (choice)
      {
         case 'n': enterNew(db_pArr); break;
         case 'd': displayDB(db_pArr); break;
         case 'w': writeDisk(db_pArr);  break;    
         case 'l': loadDisk(db_pArr); break;
         case 's': sort(db_pArr); break;
	   
         case 'c': clearDB(db_pArr); break;  
         case 'e': emptyDisk();break;

         case 'v': displayCourses();break;
         case 'p': swap(db_pArr); break;
         case 'r': removeRecord(db_pArr);break;
         
         case 'q': exit(1); // terminate the whole program
       }
	
     }
     return 0;
}

void init_list(struct db_type * pArr[]){
  int t;
  for (t=0; t<SIZE; t++)
  { 
     pArr[t]= NULL;
  }
}

void clearDB(struct db_type * pArr[]){
   char c3[3];
   printf("are you sure to clear db? (y) or (n)? ");
 
   fgets(c3,3,stdin);
   
   if(! strcmp(c3, "y\n"))  
      init_list(pArr);
}


char prompt_menu(void){
  char s[80];
  while(1){
    printf("\n-----------------------------------------------------------------\n");
    printf("|    %-20s","(N)ew record");
    printf("%-20s","(R)emove record");
    printf("Swa(p) records\t|\n");
    printf("|    %-20s","(S)ort database");
    printf("%-20s","(C)lear database");
    printf("(D)isplay db\t|\n");
  
    printf("|    %-20s","(L)oad disk");
    printf("%-20s","(W)rite disk");
    printf("(E)mpty disk\t|\n");
  
    printf("|    %-20s", "(V)iew courses");//|\tSwa(p) record\t(Q)uit\t\t\t\t|\n");
    printf("%-20s","(Q)uit");
    printf("*Case Insensitive*\t|\n");
    printf("-----------------------------------------------------------------\n");
    printf("choose one: ");
  
    fgets(s,50, stdin); // \n added
   
    if (strlen(s) == 2 && strchr("edlsuqrcwnvpr", tolower(*s))) 
       return tolower(*s); // s[0], return the first character of s  
    //else
    printf("not a valid input!\n");
	 
 }
}

/* display all or specified course */
void displayCourses(void){   
  char courseCode[SIZE]; // the provide Pend2.out uses "%s\t%-40s%-5s %s-%s   %s\n" as formatting string for printing each course info
  printf("%s", "course code (or 'a')? ");
  fgets(courseCode, 50, stdin);
  courseCode[strlen(courseCode) - 1] = '\0';
  //printf("%s", courseCode);
  if(strcmp(courseCode, "a") == 0){
    int i = 0;
    printf("\n%s\n","=================================================================================");
    while(strcmp(courseArr[i].code, "EECS0000") != 0){
      printf("%s\t%-40s%-5s %s-%s   %s\n", courseArr[i].code, courseArr[i].title, courseArr[i].date, courseArr[i].time_start, courseArr[i].time_end, courseArr[i].location);
      i++;
    }
    printf("%s\n","===================================================================================");
  }
  else{
    int flag = 0;
    int j;
    char eecs[50];
    strcpy(eecs, "EECS");
    strcat(eecs, courseCode);
    for(j = 0; strcmp(courseArr[j].code, "EECS0000") != 0 && flag == 0; j++){
      if(strcmp(courseCode, courseArr[j].code) == 0 || strcmp(eecs, courseArr[j].code) == 0){
        flag++;
        printf("%s\t%-40s%-5s %s-%s   %s\n", courseArr[j].code, courseArr[j].title, courseArr[j].date, courseArr[j].time_start, courseArr[j].time_end, courseArr[j].location);
      }
    }
    if(flag == 0){
      printf("%s\n", "error! course does not exist");
    }
  }
  
}

int findCourse(char course[50]){
  char eecs[50];
  strcpy(eecs, "EECS");
  strcat(eecs, course);
  int j;
  int flag = 0;
  for(j = 0; strcmp(courseArr[j].code, "EECS0000") != 0 && flag == 0; j++){
    if(strcmp(course, courseArr[j].code) == 0 || strcmp(eecs, courseArr[j].code) == 0){
      flag = j;
      return flag;
    }
  }
  if(flag == 0){
    printf("%s", "course does not exist, enter again: ");
    fgets(course, 50, stdin);
    course[strlen(course) - 1] = '\0';
    findCourse(course);
  }
}

int timeConflict(int start1, int end1, int start2, int end2) {
    if((start1 <= start2 && start2 <= end1) || (start2 <= start1 && start1 <= end2)){
      return 1;
    }
    else{
      return 0;
    }
}

int ifConflict(int c1, int c2) {
  int i;
  int j;
  int startHour1, startMinutend1, endHour1, endMinutend1, startHour2, startMinutend2, endHour2, endMinutend2;
  char d1[50];
  strcpy(d1, courseArr[c1].date);
  char d2[50];
  strcpy(d2, courseArr[c2].date);
  char c;
  sscanf(courseArr[c1].time_start, "%d:%d", &startHour1, &startMinutend1);
  sscanf(courseArr[c1].time_end, "%d:%d", &endHour1, &endMinutend1);
  sscanf(courseArr[c2].time_start, "%d:%d", &startHour2, &startMinutend2);
  sscanf(courseArr[c2].time_end, "%d:%d", &endHour2, &endMinutend2);
  for(i = 0; i < strlen(d1); i++) {
    for (j = 0; j < strlen(d2); j++) {
      if (d1[i] == d2[j] && timeConflict(startHour1*100 + startMinutend1, endHour1*100 + endMinutend1, startHour2*100 + startMinutend2, endHour2*100 + endMinutend2)) {
        return 1;  
      }
    }
  }
  return 0;
}

int count;
/* input items into the list */
void enterNew(struct db_type * pArr[]){  
	char name[50];
  int age;
  char course1[50];
  char course2[50];
  char c;
  int c1, c2, i;
  for (i = 0; ; i++) {
    if (pArr[i] == NULL) {
      break;
    }
  }
  count = i;

  pArr[count] = (struct db_type*)malloc(sizeof(struct db_type));
  printf("%s", "name: ");
  fgets(name, 50, stdin); 
  name[strlen(name) - 1] = '\0';
  strcpy(pArr[count]->name, name);
  
  printf("%s", "age: ");
  scanf("%d", &age);
  pArr[count]->age = age;
  c = getchar();
  while(c != '\n' && c != EOF){
    c = getchar();
  }
  printf("%s", "course-1: ");
  fgets(course1, 50, stdin);
  course1[strlen(course1) - 1] = '\0';
  c1 = findCourse(course1);
  sprintf(pArr[count]->course1, "%s\t%-40s%-5s %s-%s   %s\n", courseArr[c1].code, courseArr[c1].title, courseArr[c1].date, courseArr[c1].time_start, courseArr[c1].time_end, courseArr[c1].location);
  
  printf("%s", "course-2: ");
  fgets(course2, 50, stdin);
  course2[strlen(course2) - 1] = '\0';
  c2 = findCourse(course2);
  sprintf(pArr[count]->course2, "%s\t%-40s%-5s %s-%s   %s\n", courseArr[c2].code, courseArr[c2].title, courseArr[c2].date, courseArr[c2].time_start, courseArr[c2].time_end, courseArr[c2].location);
  
  if(ifConflict(c1, c2) == 1){
    strcpy(pArr[count]->status, "ATTENTION! time conflict\n");
    pArr[count]->status[strlen(pArr[count]->status) - 1] = '\0';
    printf("%s\n", pArr[count]->status);
  }
  else{
    strcpy(pArr[count]->status, "SUCCESSFUL! no time conflict\n");
    pArr[count]->status[strlen(pArr[count]->status) - 1] = '\0';
    printf("%s\n", pArr[count]->status);
  }
  count++;
}




/* display records */
void displayDB(struct db_type * pArr[]){
  int i;
  printf("%s", "===============================\n");
  for(i = 0; i < count; i++){
    if(i == 0){
      printf("\n");
    }
    printf("%-10s%s\n","name: ", pArr[i]->name);
    printf("%-10s%d\n", "age: ", pArr[i]->age);
    printf("%-10s%s", "course1:", pArr[i]->course1);
    printf("%-10s%s", "course2: ", pArr[i]->course2);
    printf("%-10s%s\n\n", "remarks: ", pArr[i]->status);
  }
  printf("========== %d records ==========\n", count);
 
}
int findTarget(struct db_type * pArr[], char target[50]){
  int i;
  for(i = 0; pArr[i] != NULL; i++){
    if(strcmp(pArr[i]->name, target) == 0){
      return i;
    }
  }
  return -1;
}

/* remove an existing item */
void removeRecord (struct db_type * pArr[]){
  char target[50];
  int i, flag;
  printf("%s", "enter full name to remove: ");
  fgets(target, 50, stdin);
  target[strlen(target) - 1] = '\0';
  flag = findTarget(pArr, target);
  if(flag == -1){
    puts("record not found");
  }
  else{
    for(i = flag; i < count; i++){
      if(pArr[i + 1] == NULL){
        pArr[i] = NULL;
        count--;
        break;
      }
      pArr[i] = pArr[i + 1];
    }
    printf("record [%s] removed successfully.\n",  target);
  }
}

/* swap records */
void swap(struct db_type * pArr[]){
   int i;
   struct db_type * temp[SIZE];
   init_list(temp);
   for(i = 1; i < count && pArr[i] != NULL; i = i + 2){
     temp[0] = pArr[i - 1];
     pArr[i - 1] = pArr[i];
     pArr[i] = temp[0];
   }
} 

/* load from course.txt, store into (global) array of courses  */
void init_courseArr(void){ 
 
   FILE *fr; //file pointer
   fr = fopen (courseFile, "r");
   char arr[50];  
   int count = 0;
   while ((fgets(arr,100,fr)) != NULL)
   {  
     strncpy(courseArr[count].code,  arr, strlen(arr)-1); // remove \n  
     courseArr[count].code[strlen(arr)-1] = '\0';  //to be safe
	 
     fgets(arr,100,fr);  
     strncpy(courseArr[count].title ,  arr, strlen(arr)-1);
     courseArr[count].title[strlen(arr)-1] = '\0';  //to be safe
     
          
     fgets(arr,100,fr); 
     strncpy(courseArr[count].date,  arr, strlen(arr)-1);
     courseArr[count].date[strlen(arr)-1] = '\0';  //to be safe
	   
     // other ways, remove \n before
     fgets(arr,100,fr);
     arr[strlen(arr)-1] = '\0';
     strcpy(courseArr[count].time_start,  arr);
      
     fgets(arr,100,fr);
     arr[strlen(arr)-1] = '\0';
     strcpy(courseArr[count].time_end,  arr);
      
     fgets(arr,100,fr);
     arr[strlen(arr)-1] = '\0';
     strcpy(courseArr[count].location,  arr); 
	  
     count++;
     fgets(arr,100,fr); // read the empty line
   }

   strcpy(courseArr[count].code, "EECS0000"); // a terminator token structure

   fclose(fr);
	 
 }
    
/************************ DISK IO *****************************************************************/

void writeDisk(struct db_type * pArr[]){
  FILE *fp;
  int i;

  if ( (fp=fopen(diskFile,"ab")) == NULL)
  {
    printf("cannot open file\n");
    return;
  }

  
  for (i=0; i< SIZE ; i++)
  {
     if ( pArr[i] != NULL)
     {  
       if (fwrite( pArr[i], sizeof(struct db_type), 1, fp) != 1)
       { 
          printf("file write error\n");
       }
     } 
   }
   fclose(fp);

}

void emptyDisk(void){

  FILE *fp;
  
  char c3[3];
  printf("are you sure to empty disk? (y) or (n)? ");
  fgets(c3,3,stdin);
  if(strcmp(c3, "y\n"))  
     return;
 
  //else
  if ( (fp = fopen(diskFile,"w")) == NULL)
  {
     printf("no file to open\n");
     return;
  }
  fclose(fp); // open close, will empty the file
}


void loadDisk(struct db_type * pArr[]){
  FILE *fp;
  int i;
  char c3[3];
  printf("will overwrite current records. are you sure to load disk? (y) or (n)? ");
  fgets(c3,3,stdin);
  if(strcmp(c3, "y\n"))  
     return;

  struct db_type * tmp;  
  
  if ( (fp = fopen(diskFile,"r")) == NULL)
  {
    printf("cannot open file\n");
    return;
  }

  init_list(pArr);
  for (i=0; i < SIZE ; i++)
  {    
     
     tmp =  (struct db_type *) malloc (sizeof(struct db_type));   
	   
     if (fread( tmp, sizeof(struct db_type), 1, fp) != 1)
     {
       if (feof(fp))
       { fclose(fp); 
         return;
       }
       printf("file read error\n");
     }
     else pArr[i] = tmp;
  }
}

/****bonus*************************************************************************************/

/* sort the records by ages */
void sort(struct db_type * pArr[]){
  int i, j;
  struct db_type * temp[SIZE];
  init_list(temp);
  for(i = 0; i - 1 < count; i++){
    for(j = i + 1; j < count; j++){
      if(pArr[i]->age > pArr[j]->age){
        temp[0] = pArr[j];
        pArr[j] = pArr[i];
        pArr[i] = temp[0];
      }
    }
  }
}  

 
 
