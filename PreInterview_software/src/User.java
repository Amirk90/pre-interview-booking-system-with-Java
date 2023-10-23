
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class User { 
    //declare variables
    private String userName;
    private String password;
    private String firstName;
    private String surName;
    private String Gender;
    private String DOB;
    //parametric constructor for user login with linkedin
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    //parametric constructor for user login with Email
    public User(String userName, String password, String firstName, String surName, String Gender, String DOB) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.surName = surName;
        this.Gender = Gender;
        this.DOB = DOB;
    }
    //register user by linkedin
    public void register() {
        try {
            //save details in file using filewriter and bufferedwriter
            FileWriter fw = new FileWriter("Users.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(userName + ":" + password);
            bw.newLine();
            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //register user by email
    public void registerByEmail() {
        try {
            //save details in file
            FileWriter fw = new FileWriter("Users.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(userName + ":" + password + ":" + firstName + ":" + surName + ":" + Gender + ":" + DOB);
            bw.newLine();
            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //validate if valid user
    public boolean isLogin() {
        boolean flag = false;
        
        try {
            //read data from file
            FileReader fr = new FileReader("Users.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            String parts[];
           
            while ((line = br.readLine()) != null) {
                parts = line.split(":");
                //compare username and password
                if (userName.equals(parts[0]) && password.equals(parts[1])) {
                    flag = true;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }
    
    
    //method tp send user answers to admin for review
    public void sentToAdmin(ArrayList<String> answers) {
        try {
            //open file to write data
            FileWriter fw = new FileWriter("UserAnswers.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(userName);
            bw.write(":");
            //save user answers in file
            for (String answer : answers) {
                bw.write(answer);
                bw.write(",");
            }
            bw.newLine();
            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    //method to read meeting data from file
    public static ArrayList<String> meetings() {
        ArrayList<String> meetings = new ArrayList<>();
        try {
            //open file
            FileReader fr = new FileReader("Meetings.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                //read and store data into arraylist
                meetings.add(line);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return meetings;    //return data
    }
    //method to notify applicants about meeting or quiz result
    public static void notifyUser(String userID, String message) {
        try {
            FileWriter fw = new FileWriter("Messages.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(userID);
            bw.write(",");
            bw.write(message);
            bw.newLine();
            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //method to step meeting details
    public void setMeetings(String dateTime) {
        try {
            FileWriter fw = new FileWriter("Meetings.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(userName);
            bw.write(",");
            bw.write(dateTime);
            bw.newLine();
            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //method to get user answers from file to review by employee
    public static ArrayList<String> getUserAnswers() {
        ArrayList<String> answers = new ArrayList<>();
        try {
            FileReader fr = new FileReader("UserAnswers.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            String parts[];
            while ((line = br.readLine()) != null) {
                answers.add(line);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return answers;

    }
    //method to upload resumes of applicants
    public String uploadResume(String path) {
        String data = "";
        try {

            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                data = data + "\n" + line;
            }
        } catch (Exception e) {
            System.out.println("Invalid Path or invalid File");
        }
        return data;
    }
    //method to check user messages
    public static ArrayList<String> checkMessage(String userID) {
        ArrayList<String> messages = new ArrayList<>();
        try {
            FileReader fr = new FileReader("Messages.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String parts[] = line.split(",");
                if (parts[0].equals(userID)) {
                    messages.add(parts[1]);

                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return messages;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getGender() {
        return Gender;
    }

    public String getDOB() {
        return DOB;
    }

}
