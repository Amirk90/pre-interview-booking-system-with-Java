
import java.io.Serializable;

public class MCQ_Quiz extends Quiz implements Serializable {

    //declaring sub class attributes
    private String answerString;
    private String[] options;

    //initialize values by parametric constructor
    public MCQ_Quiz(String answerString, String[] options, String question) {
        super(question);
        this.answerString = answerString;
        this.options = options;
    }

    public String getAnswerString() {
        return answerString;
    }

    public String[] getOptions() {
        return options;
    }

}
