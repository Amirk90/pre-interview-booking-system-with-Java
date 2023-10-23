
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class QuizApplication {

    public static void main(String[] args) {
        //declaring variables
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        boolean flag1 = true;
        String username;
        String password;
        ArrayList<String> resumes = new ArrayList<>();
        String userChoice;
        String question;
        String questionAnswer;
        ArrayList<Quiz> quiz = new ArrayList<>();
        //showing main menu
        do {
            System.out.println("----------------------------------------------");
            System.out.println("|              Quiz Application              |");
            System.out.println("|        Please Enter 1 for Applicant        |");
            System.out.println("|        Please Enter 2 for Employee         |");
            System.out.println("|        Please Enter 3 to terminate system  |");
            System.out.println("----------------------------------------------");
            System.out.print("Input:\t");
            userChoice = input.nextLine();
            //using switch case for different user choices
            switch (userChoice) {
                case "1":   //if selection is one
                    do {

                        System.out.print("\nPress 1 to Login:\t");
                        System.out.print("\nPress 2 for Registration:\t");
                        userChoice = input.nextLine();
                        //take user input
                        if (userChoice.equals("1") || userChoice.equals("2")) {
                            if (userChoice.equals("1")) {

                                do {
                                    //Take Login details
                                    System.out.println("\nEnter -1 to exit");
                                    System.out.print("\nPlease Enter Email:\t");
                                    username = input.nextLine();
                                    if (!username.equals("-1")) {
                                        System.out.print("\nPlease Enter password:\t");
                                        password = input.nextLine();
                                        User user = new User(username, password);
                                        //check if user is valid or not
                                        boolean check = user.isLogin();
                                        if (check) {
                                            //if valid user, show welcome screen
                                            System.out.println("\nLogin Successfully\n");
                                            System.out.println("Welcome Mr. or Mrs\t" + username);
                                            do {
                                                //show user menu
                                                System.out.println("----------------------------------");
                                                System.out.println("|     Press 1 to begin           |");
                                                System.out.println("|     Press 2 for messages       |");
                                                System.out.println("|     Press 3 to upload Resume   |");
                                                System.out.println("|     Press 4 to Logout          |");
                                                System.out.println("----------------------------------");
                                                System.out.print("Input:\t");
                                                userChoice = input.nextLine();
                                                //take user choice
                                                if (userChoice.equals("1")) {
                                                    //check if proctorio enabled or not
                                                    System.out.println("Proctorio enabled. Y/N");
                                                    System.out.print("Input:\t");
                                                    userChoice = input.nextLine();

                                                    if (userChoice.equalsIgnoreCase("y")) { //if proctorio is enabled
                                                        //give quiz choice
                                                        System.out.println("\nPlease Enter 1 for administration job");
                                                        System.out.println("Please Enter 2 for Software Position job");
                                                        System.out.print("Input:\t");
                                                        //input user choice for quiz type
                                                        userChoice = input.nextLine();
                                                        switch (userChoice) {
                                                            case "1":
                                                                //MCQ Quiz
                                                                quiz.clear();
                                                                quiz = Quiz.getQuiz("MCQ");
                                                                int total = 0;  //total questions
                                                                int correct = 0;    //correct questions
                                                                for (Quiz quiz1 : quiz) {   //show quiz questions and options
                                                                    if (quiz1 instanceof MCQ_Quiz) {

                                                                        System.out.println(quiz1.getQuestion());
                                                                        String[] temp = ((MCQ_Quiz) quiz1).getOptions();
                                                                        for (int i = 0; i < temp.length; i++) {
                                                                            System.out.print("Option#" + (i + 1));
                                                                            System.out.println(":\t" + temp[i] + "\n");

                                                                        }
                                                                        System.out.print("\nAnswer is: \t");

                                                                        userChoice = input.nextLine();

                                                                        if (((MCQ_Quiz) quiz1).getAnswerString().equals(userChoice)) {
                                                                            correct++;
                                                                        }
                                                                        System.out.println("\n");
                                                                        total++;
                                                                    }
                                                                }
                                                                double percentage = (Double.valueOf(correct) / Double.valueOf(total)) * 100;
                                                                System.out.println("Percentage:\t" + percentage + "");
                                                                if (percentage >= 50.0) {   //check if pass
                                                                    System.out.println("\nPassed!");
                                                                    do {
                                                                        //input meeting DateTime from user
                                                                        System.out.println("Please Enter Date&Time for Interview in format dd/mm/yyyy 00:00 am/pm");
                                                                        userChoice = input.nextLine();
                                                                        if (userChoice.matches("[0-9]{2}[/]{1}[0-1]{1}[0-9]{1}[/]{1}[0-9]{4}[ ]{1}[0-9]{2}[:]{1}[0-5]{1}[0-9]{1}[ ]{1}[a/p]{1}[m]{1}")) {
                                                                            flag1 = false;
                                                                            System.out.println("Congratulations, confirmation has been sent to your email. Good Luck");
                                                                            //save meeting details
                                                                            user.setMeetings(userChoice);
                                                                        } else {
                                                                            System.out.println("\nWrong Format. Try again");
                                                                        }

                                                                    } while (flag1);
                                                                    flag1 = true;

                                                                } else {
                                                                    if (quiz.size() != 0) {

                                                                        System.out.println("\nYou have failed the quiz therefore you may not proceed to the interview\n");
                                                                    } else {
                                                                        System.out.println("Questions not uploaded Yet");
                                                                    }
                                                                }
                                                                break;
                                                            case "2":   //Coding Questions Quiz
                                                                quiz.clear();
                                                                quiz = Quiz.getQuiz("Question");
                                                                ArrayList<String> answers = new ArrayList<>();
                                                                for (Quiz quiz1 : quiz) {   //display questions

                                                                    System.out.println(quiz1.getQuestion());

                                                                    System.out.print("\nAnswer is: \t");
                                                                    //input answers from user
                                                                    userChoice = input.nextLine();
                                                                    answers.add(userChoice);

                                                                    System.out.println("\n");

                                                                }
                                                                if (quiz.size() != 0) {

                                                                    System.out.println("Answers are sent to admin for review");
                                                                    //send to admin for review
                                                                    user.sentToAdmin(answers);
                                                                } else {
                                                                    System.out.println("Questions not uploaded Yet");
                                                                }
                                                                break;
                                                            default:
                                                                System.out.println("Invalid Choice:");
                                                                break;
                                                        }

                                                    } else if (userChoice.equalsIgnoreCase("n")) {  //if proctorio is disabled
                                                        System.out.println("\nProctorio disabled. Please enable to begin");
                                                    } else {    //if user enters invalid choice 
                                                        System.out.println("\nInvalid Choice\n");
                                                    }

                                                } else if (userChoice.equals("2")) {    //to show messages
                                                    System.out.println("Messages");
                                                    ArrayList<String> messages = new ArrayList<>();
                                                    //get stored messages for that user
                                                    messages = User.checkMessage(username);
                                                    if (messages.size() == 0) { //if no message
                                                        System.out.println("No Message yet");
                                                    } else {
                                                        //display user messages
                                                        int j = 1;
                                                        for (String message : messages) {
                                                            System.out.println(j + "# " + message);
                                                        }
                                                    }

                                                } else if (userChoice.equals("3")) {
                                                    //to upload resumes
                                                    System.out.println("Enter Resume Path");
                                                    userChoice = input.nextLine();
                                                    resumes.add(user.uploadResume(userChoice));

                                                } else if (userChoice.equals("4")) {
                                                    flag1 = false;
                                                } else {
                                                    System.out.println("\nInvalid Choice. Try again\n");

                                                }

                                            } while (flag1);
                                        } else {
                                            System.out.println("\nInvalid Details\n");

                                        }

                                    } else {
                                        flag1 = false;
                                    }
                                } while (flag1);

                            } else {
                                //Registration Criteria
                                System.out.println("Press 1 to Register by LinkedIn");
                                System.out.println("Press 2 to Register by Email");
                                userChoice = input.nextLine();
                                switch (userChoice) {
                                    case "1":
                                        //input details
                                        System.out.println("\nRegistration through Email");
                                        System.out.print("\nPlease Enter Email:\t");
                                        username = input.nextLine();
                                        System.out.print("\nPlease Enter Password:\t");
                                        password = input.nextLine();
                                        User user = new User(username, password);
                                        //call register method to register
                                        user.register();
                                        System.out.println("\nSuccessfully Registered. You can login now.");
                                        break;
                                    case "2":
                                        //registration using email
                                        //enter details
                                        System.out.println("\nRegistration through LinkedIn");
                                        System.out.print("\nPlease Enter FirstName:\t");
                                        String firstName = input.nextLine();
                                        System.out.print("\nPlease Enter surName:\t");
                                        String surName = input.nextLine();
                                        System.out.print("\nPlease Enter Gender:\t");
                                        String Gender = input.nextLine();
                                        System.out.print("\nPlease Enter DOB:\t");
                                        String DOB = input.nextLine();
                                        System.out.print("\nPlease Enter Email:\t");
                                        username = input.nextLine();
                                        System.out.print("\nPlease Enter Password:\t");
                                        password = input.nextLine();
                                        User u = new User(username, password, firstName, surName, Gender, DOB);
                                        //call register by email method to register
                                        u.registerByEmail();
                                        System.out.println("\nSuccessfully Registered. You can login now.");

                                        break;
                                    default:
                                        System.out.println("Invalid Choice");
                                        break;

                                }

                            }

                        } else {
                            //if user enter invalid option
                            System.out.println("\nInvalid Choice.\n");
                        }
                    } while (flag1);
                    flag1 = false;
                    break;
                case "2":
                    //user selects  for employee login
                    do {
                        System.out.print("\nPlease Enter UserName:\t");
                        username = input.nextLine();
                        System.out.print("\nPlease Enter Password:\t");
                        password = input.nextLine();
                        //verify user
                        if (username.equals("admin@gmail.com") && password.equals("admin123")) {
                            System.out.println("\nLogin Successfull");
                            do {
                                //show employee menu
                                System.out.println("----------------------------------------------");
                                System.out.println("|              Employee Menu                 |");
                                System.out.println("|        Please Enter 1 to create Quiz       |");
                                System.out.println("|        Please Enter 2 to view Candidate    |");
                                System.out.println("|        Please Enter 3 to start Meeting     |");
                                System.out.println("|        Please Enter 4 to Code Review       |");
                                System.out.println("|        Please Enter 5 to Exit              |");
                                System.out.println("----------------------------------------------");
                                System.out.print("Input:\t");
                                userChoice = input.nextLine();
                                //user choice for adding MCQ or coding question
                                switch (userChoice) {
                                    case "1":
                                        System.out.println("Press 1 to Add MCQ");
                                        System.out.println("Press 2 to add coding Question");
                                        System.out.print("Input:\t");
                                        userChoice = input.nextLine();
                                        if (userChoice.equals("1") || userChoice.equals("2")) {
                                            if (userChoice.equals("1")) {   //Adding MCQ's
                                                do {
                                                    //Enter Questions
                                                    System.out.println("Enter Question(-1 to terminate):\t");
                                                    question = input.nextLine();
                                                    String[] options = new String[4];
                                                    //Enter options
                                                    if (!question.equals("-1")) {
                                                        for (int i = 0; i < options.length; i++) {

                                                            System.out.println("Option#:" + (i + 1));
                                                            options[i] = input.nextLine();
                                                        }
                                                        System.out.println("\nEnter right option#:");
                                                        questionAnswer = input.nextLine();
                                                        //add question data and save
                                                        quiz.add(new MCQ_Quiz(questionAnswer, options, question));

                                                    } else {
                                                        //save MCQ in file
                                                        Quiz.saveQuiz(quiz, "MCQ");

                                                        flag1 = false;
                                                    }

                                                } while (flag1);
                                                flag1 = true;
                                            } else {
                                                do {
                                                    //enter coding question
                                                    System.out.println("Enter Question(-1 to terminate):\t");

                                                    question = input.nextLine();
                                                    if (!question.equals("-1")) {
                                                        //add question
                                                        quiz.add(new Quiz(question));
                                                    } else {    //terminate process
                                                        //save coding questions
                                                        Quiz.saveQuiz(quiz, "Question");
                                                        flag1 = false;
                                                    }

                                                } while (flag1);
                                                flag1 = true;
                                            }
                                        } else {
                                            System.out.println("\nInvalid Choice");
                                        }
                                        break;
                                    case "2":
                                        //View Candidate Resumes
                                        System.out.println("Resumes");
                                        if (resumes.size() == 0) {
                                            System.out.println("\nNo Resume Found\n");
                                        } else {
                                            //show resumes
                                            for (String resume : resumes) {
                                                System.out.println("\nResume");
                                                System.out.println(resume);
                                            }
                                        }
                                        break;
                                    case "3":   //start meeting
                                        flag1 = true;
                                        ArrayList<String> meetings = new ArrayList<>();
                                        meetings = User.meetings();
                                        if (meetings.size() == 0) {
                                            System.out.println("No Meeting Record Found");
                                        } else {
                                            //show meeting details
                                            System.out.println("Meeting Details");
                                            int i = 1;
                                            for (String meeting : meetings) {
                                                String parts[] = meeting.split(",");
                                                System.out.println(i + ": " + parts[0] + "\t\t" + parts[1]);
                                            }
                                            i = 1;
                                            boolean check = false;
                                            //start meeting
                                            System.out.println("Enter User id to Start Meeting");
                                            userChoice = input.nextLine();
                                            for (String meeting : meetings) {
                                                String parts[] = meeting.split(",");
                                                if (parts[0].equals(userChoice)) {
                                                    check = true;
                                                }
                                            }
                                            if (check) {
                                                //notify user
                                                System.out.println("User is notified for meeting");
                                                User.notifyUser(userChoice, "Meeting is started");
                                            } else {
                                                System.out.println("Invalid id entered");
                                            }

                                        }
                                        break;
                                    case "4":
                                        //review coding questions
                                        ArrayList<String> userAnswers = new ArrayList<>();
                                        userAnswers = User.getUserAnswers();
                                        ArrayList<String> users = new ArrayList<>();
                                        if (userAnswers.size() == 0) {
                                            System.out.println("\nNo Answers to review");
                                        } else {
                                            //show coding answers from users
                                            for (String userAnswer : userAnswers) {
                                                String parts[] = userAnswer.split(":");
                                                System.out.println("User ID:\t" + parts[0]);
                                                users.add(parts[0]);
                                                String parts1[] = parts[1].split(",");
                                                System.out.println("Answers");
                                                for (int i = 0; i < parts1.length; i++) {
                                                    System.out.println(parts1[i] + "\n");
                                                }

                                            }
                                        }

                                        System.out.println("Enter user ID to give remarks");
                                        System.out.print("Userinput:\t");
                                        userChoice = input.nextLine();
                                        boolean check = false;
                                        String id = null;
                                        for (String string : users) {
                                            if (string.equals(userChoice)) {
                                                check = true;
                                                id = string;
                                            }
                                        }
                                        if (check) {
                                            //give remarks
                                            System.out.println("Enter remarks. Pass/Fail");
                                            userChoice = input.nextLine();
                                            User.notifyUser(id, userChoice);
                                            System.out.println("User is notified about remarks.");
                                        } else {
                                            System.out.println("Invalid ID");
                                        }

                                        break;
                                    case "5":
                                        System.out.println("\nSuccessfully exit.\n");
                                        flag1 = false;
                                        break;
                                    default:
                                        System.out.println("\nInvalid Choice. Try again.\n");
                                        break;
                                }

                            } while (flag1);
                        } else {
                            System.out.println("\nInvalid Credentials. Please Try again.\n");
                        }

                    } while (flag1);
                    flag1 = true;
                    break;
                case "3":
                    flag = false;
                    break;
                default:
                    System.out.println("\nInvalid Choice. Please  Try again....");
                    break;
            }

        } while (flag);
    }

}
