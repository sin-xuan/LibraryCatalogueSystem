## user
* id  - int - PK
* lastname - String     NO NUMBER  
* firstname - String    NO NUMBER  
* email   - String     a valid email format (e.g. eddieleung@gmail.com).  
* password - String
* type - String - Librarian or Member not null
* address - String
* phonenumber  - String
>  
phone number must be in a valid format.  
 (i.e. if the phone number is a landline number, the first digit
of the phone number must be 9 and the number must be 8 digits long. On the other
hand, if the number is a mobile number, the first digit of the phone number must be 0 and
the number must be 10 digits long  
 ****  

## book
 * bid - int -  PK   
 * isbn - String    eg  1- 23- 456789- 0
 * callnumber - String    eg  1- 23- 456789- 0 - 92
 * title - String
 * authors - String  
 * publisher  - String
 * type - String -  General or Reserved not null
 * thumbnail - String
 * description - string
 * previewurl - string
 >  A book must be in one of the two categories, either general or reserved.  
Each book is associated with an ISBN(A unique identifier for the books with the same name).  
Each book is associated with a unique Call number. The format can refer to the eletric Library online.  

 ****

## loan  
* id  - int -   PK  
* memberid - int -  FK   reference colum:  user:id  not null
* startdate - Date   max period is 4 weeks  
* duedate - Date
* relatedbookids - string FK  reference colum :  book: bid  may several books, join with(",")
>  A member cannot make any new loan if he/she has an overdue loan(s) on their account.   
A member can only borrow the book(s) that have at least one physical copy available.
