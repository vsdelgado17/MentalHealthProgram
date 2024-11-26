//mental health program

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        CognitiveDistortion cognitiveDistortions[] = new CognitiveDistortion [10];
        int cntr = 1;
        int index = 0;
        int number;
        String name;
        String definition;
        boolean distortionPresent;
        PrintWriter outFile;

        try
        {
            Scanner myFile = new Scanner(new File("cognitiveDistortions.txt"));
            myFile.useDelimiter(";");
            while(myFile.hasNext())
            {
                if (cntr <= 10)
                {
                    number = cntr;
                    name = myFile.next();
                    definition = myFile.next();
                    distortionPresent = false;

                    cognitiveDistortions[index] = new CognitiveDistortion(number, name, definition, distortionPresent);
                    cntr++;
                }
            }
            myFile.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Error creating file.");
        }

        System.out.printf("%s%n%n","Mental Health Program - Identifying Cognitive Distortions");
        System.out.println("This program is meant to determine which, if any, cognitive distortions are present in your thinking.");
        System.out.println("Cognitive distortions are ways of thinking that lead us to have a negative view our life.");
        System.out.printf("%n%s%n", "You will be asked a set of questions. Please respond with 'Yes' or 'No' to each question.");

        for (int i = 0; i < 10; i++)
        {
            System.out.println(cognitiveDistortions[i].definition);
            checkResponse(cognitiveDistortions[i], keyboard);
        }

        System.out.println("Thank you for completing this exercise. Please view the new text file created.");
        System.out.println("Source: THE CBT WORKBOOK FOR MENTAL HEALTH");

        try
        {
            outFile = new PrintWriter("cognitiveDistortionJournal.txt");
            for (int i = 0; i < 10; i++)
            {
                if(cognitiveDistortions[i].distortionPresent)
                {
                    outFile.printf(cognitiveDistortions[i].getName());
                }
            }
            outFile.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Error creating file");
        }

        keyboard.close();
    }



    static void checkResponse(CognitiveDistortion currentDistortion, Scanner keyboard)
    {
        String response = "";
        response = keyboard.next();
        boolean invalidInput = true;
        while(invalidInput)
        {
            if (response.equals("Yes") || response.equals("No"))
            {
                if(response.equals("Yes"))
                {
                    currentDistortion.setDistortionPresent(true);
                }
                invalidInput = false;
            }
            else
            {
                System.out.println("Please enter Yes or No");
                response = keyboard.next();
            }
        }
    }
}