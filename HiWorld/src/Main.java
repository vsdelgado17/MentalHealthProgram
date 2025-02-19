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

        CognitiveDistortion[] cognitiveDistortions = new CognitiveDistortion [10];
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
            while(myFile.hasNextLine())
            {
                String line = myFile.nextLine();
                String [] parts = line.split(";");
                if (cntr <= 10)
                {
                    number = cntr;
                    name = parts[0];
                    definition = parts[1];
                    distortionPresent = false;

                    cognitiveDistortions[index] = new CognitiveDistortion(number, name, definition, distortionPresent);
                    cntr++;
                    index++;
                }
            }
            myFile.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Error creating file.");
            return;
        }

        System.out.printf("%s%n%n","Mental Health Program - Identifying Cognitive Distortions");
        System.out.println("This program is meant to determine which, if any, cognitive distortions are present in your thinking.");
        System.out.println("Cognitive distortions are ways of thinking that lead us to have a negative view our life.");
        System.out.printf("%n%s%n", "You will be asked a set of questions. Please respond with 'Yes' or 'No' to each question.");

        for (CognitiveDistortion cognitiveDistortion : cognitiveDistortions){
                System.out.println(cognitiveDistortion.definition);
                checkResponse(cognitiveDistortion, keyboard);
        }

        System.out.println("Thank you for completing this exercise. Please view the new text file created.");
        System.out.println("Source: THE CBT WORKBOOK FOR MENTAL HEALTH");

        int numDistortions = 0;

        try
        {
            outFile = new PrintWriter("cognitiveDistortionJournal.txt");
            outFile.printf("Cognitive Distortions Found:");
            outFile.println();
            for (CognitiveDistortion cognitiveDistortion: cognitiveDistortions)
            {
                if(cognitiveDistortion.getDistortionPresent())
                {
                    numDistortions += 1;
                }
            }
            if(numDistortions == 0)
            {
                outFile.printf("No cognitive distortions were identified, but feel free to return to work on the offered exercises.");
            }
            else{
                for (CognitiveDistortion cognitiveDistortion: cognitiveDistortions)
                {
                    if(cognitiveDistortion.getDistortionPresent())
                    {
                        outFile.printf(cognitiveDistortion.getName());
                        outFile.println();
                    }
                }
            }
            outFile.printf("Exercises to complete: ");
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
        String response = keyboard.next();
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