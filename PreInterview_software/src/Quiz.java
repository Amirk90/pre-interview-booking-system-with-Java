
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Quiz implements Serializable {

    private String question;

    public Quiz(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    //save quiz data into file
    public static void saveQuiz(ArrayList<Quiz> quiz, String type) {
        try {
            //save data into file using file/object output stream objects
            FileOutputStream fos = new FileOutputStream(type + ".txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(quiz);
            oos.close();
            fos.close();

        } catch (Exception e) {
        }
    }

    //read quiz details from text file
    public static ArrayList<Quiz> getQuiz(String type) {
        ArrayList<Quiz> q = new ArrayList<>();
        try {

            FileInputStream fis = new FileInputStream(type + ".txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            q = (ArrayList<Quiz>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {

        }
        return q;
    }
}
