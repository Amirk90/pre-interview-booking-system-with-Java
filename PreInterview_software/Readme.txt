2122313
--------------
Software Principles (MOD003484 TRI2 F01CAM) Element 011
Pre interview software for the company Intergence based
on the Element 010 project
--------------------
Element 010 project group members were:
Me(Amir Khezri) 2122313
Liam Hayes 2124794
Bradley Hayes 2124795

----------------
Running the Code
----------------
This program can run on all IDEs
To run the program click on file then open PreInterview_software(2122313) folder
On your left click on the src directory and open QuizApplication file
To begin the program click on the green triangle on the top right

------------------------
Functions of the program
------------------------
Programs consists of  Applicant(User) portal and Employee(Admin)
When you run the program it will display a menu with 3 options, to
login as  applicant or employee or to end the program.
For the applicant portal you can register a new account or login
to the pre-made accounts stored in users.txt. When registering the
username section is for Email.After logging in the applicant has four options,
Case 1 they can begin their quiz based on what position they would like to apply software or
administrator job. If they pass the administrator mcq than they can
book a date for their interview by inputting the date and time.
Case 2 is where the applicant read their feedback on their
coding quiz given by the employee
Case 3 is where user can upload their resume by inputting their file path.
Case 4 is to log out of the portal.

To login in the employee portal you need input the admin login
details. The login is UserName(Email):admin@gmail.com and password:admin123
After login the portal will display a menu with 5 cases
Case 1 the employee can create the mcq and coding questions
Case 2 employee can view the applicants resume file
Case 3 employee can start the meeting by inputting  the applicant's their
userID(Email)
Case 4 employee can view the code answers and send feedback by inputting the
applicants userID(Email).
Case 5 employee can log out of the portal.

---------------
File structures
---------------
Users.txt is where the applicant details are stored
the structure is username(email):password:firstname:lastname:gender:dateofbirth

MCQ.txt is where mcq questions are stored
Questions.txt is where the coding questions are stored
I have used serializable file handling for these files to store
larger number of data

UserAnswers.txt is where coding answers get stored
the structure is Applicant's email : Code answer

Messages.txt is where the feedback give by the employee to the applicant
gets stored
the structure is Applicant's email, feedback

Meetings.txt is where the applicant's appointment details are stored
the structure is applicant's email, date time

-----------------------
Changes from Element 010
-----------------------
In element 010 we designed the user to upload their resume and choose their
positions during the registration. However in my code I changed it to
upload the resume after registration and to choose their position based
on their quiz so if the applicant changes its decision they are able to
do so.

I also added a messages section for the user to view their feedback
directly from their portal to make it more convenient instead of
hoping to their mailbox.

------
ENJOY!
------
