import java.io.FileWriter;
import java.io.IOException;

public class Class1  implements {
    public static void main(String[] args) {
            try {
                FileWriter leagueTeamsFile = new FileWriter("file1.txt");
//                both files have been successfully read
                        leagueTeamsFile.write("works");
                    System.out.println("League Teams have been saved successfully");
                    leagueTeamsFile.close();

//                writting match history if its only 1 matc
                } catch (IOException e) {
                    e.printStackTrace();
                }


        }
}
