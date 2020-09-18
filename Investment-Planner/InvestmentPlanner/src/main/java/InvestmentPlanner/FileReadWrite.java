package InvestmentPlanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import static javax.swing.JOptionPane.showMessageDialog;

public class FileReadWrite {
    public Boolean readWrite(Mode mode, String dataWrite[]) {

        String filePath = "C:\\Users\\Haris\\Desktop\\test.txt";
        BufferedReader readerData;
        String fileReadData;
        String loginData[] = { "", "" };
        Boolean loginMatch = false;

        int readCount = 0;

        if (mode == Mode.READ) {
            try {
                readerData = new BufferedReader(new FileReader(new File(filePath)));
                while ((fileReadData = readerData.readLine()) != null) {
                    System.out.println(fileReadData);

                    if (readCount == 0) {
                        loginData[0] = fileReadData;

                    } else {
                        loginData[1] = fileReadData;
                    }
                    readCount++;

                }
            } catch (FileNotFoundException e1) {
                showMessageDialog(null, "File " + filePath + " not found. Program will be closed");

            } catch (IOException e1) {
                showMessageDialog(null, "File " + filePath + " could not be read");
            }

            if (loginData[0] == dataWrite[0] && loginData[1] == dataWrite[1])
                loginMatch = true;

        }

        if (mode == Mode.WRITE) {

            int i = 0;
            try {
                Writer output = new FileWriter("investmentplan.txt");
                while (i != dataWrite.length) {
                    output.write(dataWrite[i]);
                    i++;
                }

                output.close();
            }

            catch (Exception e) {
                e.getStackTrace();
            }

        }

        return (loginMatch);
    }
}
