import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class Quiz {

    private String[][] ques = {
        {"What is the capital of India?", "Mumbai", "New Delhi", "Guwahati", "Indore","B","New Delhi"},
        {"Which Olympian has won the most Gold medals?", "Michael Phelps", "Neeraj Chopra", "Usain Bolt", "Dhyanchand", "A","Michael Phelps"},
        {"What is the longest river in the world?", "Ganga", "Indus", "Nile", "Bramhaputra", "C","Nile"},
        {"Who is the Prime Minister of India?", "Narendra Modi", "Rahul Gandhi", "Yogi Aadityanath", "Sharad Pawar", "A","Narendra Modi"},
        {"What is the highest mountain peak in the world?", "Mount Everest", "K2", "Mount Kilimanjaro", "Mount Kailash", "A","Mount Everest"},
        {"Which religion is the oldest?", "Islam", "Christianity", "Jainism", "Hinduism", "D","Hinduism"},
        {"Who are the current Champions of ucl?", "Man City", "FC Barcelona", "Real Madrid", "Juventus", "C","Real Madrid"},
        {"What is the name of japanese currency?", "Rupees", "Yen", "Dollar", "Taka", "B","Yen"}
    };

    private int score = 0;
    private boolean time =false;

    public void QuizTime() {
        Scanner scanner = new Scanner(System.in);
        for (String[] question : ques) {
            time =false;
            System.out.println(question[0]);
            System.out.println("A) " + question[1]);
            System.out.println("B) " + question[2]);
            System.out.println("C) " + question[3]);
            System.out.println("D) " + question[4]);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    time= true;
                    System.out.println("Time's over");
                }
            }, 20000); // 20 seconds

            String answer = scanner.nextLine();
            timer.cancel();
            
            if(time){
                System.out.println("Your ran out of time. The correct answer is " + question[5] + ": " + question[6]);
            }
            else if (answer.equalsIgnoreCase(question[5])) {
                System.out.println(question[6]);
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is " + question[5]+":"+ question[6]);
            }

        }

        System.out.println("Your final score is " + score + " out of " + ques.length);
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.QuizTime();
    }
}