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
    public String[] readWrite(Mode mode, String dataWrite[]) {

        String filePath = "C:\\Users\\Haris\\Desktop\\test.txt";
        BufferedReader readerData;
        String fileReadData;
        String loginData[] = { "", "" };

        int readCount = 0;

        if (mode == Mode.READ) {
            try {
                readerData = new BufferedReader(new FileReader(new File(filePath)));
                while ((fileReadData = readerData.readLine()) != null) {
                    // System.out.println(fileReadData);

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

            // TODO: return the data and let Login page do the comparison

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

        return loginData;
    }
}
