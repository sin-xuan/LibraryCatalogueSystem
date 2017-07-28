## Library Users
**Librarian / Member**  
* ID number  - int - <font color= #ffc0cb> PK </font>
* Last Name - String
* First Name - String
* Email   - String
* Password - String
* Type - String -<font color=#ffe4c4> Librarian or Member</font>   
* Address - String
* Phone number  - String
>unique ID number for each users.  
 Last / first name must not contain numeric value.  
 User must be in one of the two types: librarian or member.   
 Email address / phone number must be in a valid format.  

 ****  

## Book
 * BID - int - <font color= #ffc0cb> PK </font>
 * ISBN - String  
 * Call number - String
 * Title - String
 * Authod(s) - String  
 * Publisher  - String
 * Type - String - <font color=#ffe4c4>General or Reserved</font>  
 * Thumbnail - URL - String
 * Description -
 * Preview URL -
 >  A book must be in one of the two categories, either general or reserved.  
Each book is associated with an ISBN(A unique identifier for the books with the same name).  
 Each book is associated with a unique Call number. The format can refer to the eletric Library online.  

 ****

## Loan  
* ID number  - int - <font color= #ffc0cb> PK </font>
* ID number of member - int -<font color= #afeeee> FK </font>   
* Date when the loan is made - Date
* Date when the loan is due - Date
* The book(s) that the loan includes - int -<font color= #afeeee> FK </font>   
>  A loan can have a maximum loan period of 4 weeks.  
A member can have unlimited number of loans, and a loan must be associated to one and only one member.  
A member cannot make any new loan if he/she has an overdue loan(s) on their account.   
A member can only borrow the book(s) that have at least one physical copy available.
