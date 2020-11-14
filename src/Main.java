import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = " ";
        String[] parts = new String[4];
        //Preemptive scheduler = new Preemptive();
        Vector<Character> taskinputOrder = new Vector<>();
        boolean input = true;


        try {
            while (input) {
                line = br.readLine();
                if (line == null) input = false ;
                else if ((line).trim().equals("")) input = false;
                else if (line.matches(".,.,.,.") ||
                        line.matches(".,.,..,.") ||
                        line.matches(".,.,.,..") ||
                        line.matches(".,.,..,..")) {
                    parts = line.split(",");

                    char id = parts[0].charAt(0);
                    int priority = Integer.parseInt(parts[1]);
                    int startTime = Integer.parseInt(parts[2]) + 1;
                    int CPUTime = Integer.parseInt(parts[3]);

                    //Task t = new Task(id, priority, startTime, CPUTime);
                    taskinputOrder.add(id);
                    //scheduler.addTask(t);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
