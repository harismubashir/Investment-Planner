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
    public String[] readWrite(Mode mode, String dataReference[]) {

        String filePath = "C:\\Users\\Haris\\Desktop\\test.txt";
        BufferedReader readerData;
        String fileReadData;
        String returnData[] = { "", "" };

        int readCount = 0;

        if (mode == Mode.READ) {
            try {
                readerData = new BufferedReader(new FileReader(new File(filePath)));
                while ((fileReadData = readerData.readLine()) != null) {
                    // Else if used to limit array limit to first two file lines only
                    if (readCount == 0) {
                        returnData[0] = fileReadData;
                    } else if (readCount == 1) {
                        returnData[1] = fileReadData;
                    }
                    /*
                     * loginData[readCount] = fileReadData;
                     */
                    readCount++;

                }
            } catch (FileNotFoundException e1) {
                showMessageDialog(null, "File " + filePath + " not found. Program will be closed");

            } catch (IOException e1) {
                showMessageDialog(null, "File " + filePath + " could not be read");
            }

            // TODO: return the data and let Login page do the comparison
            return returnData;
        }

        if (mode == Mode.WRITE) {

            int i = 0;
            try {
                Writer output = new FileWriter("investmentplan.txt");
                while (i != dataReference.length) {
                    output.write(dataReference[i]);
                    i++;
                }

                output.close();
                returnData[0] = "ok";

            }

            catch (Exception e) {
                e.getStackTrace();
            }

        }

        return returnData;
    }
}
