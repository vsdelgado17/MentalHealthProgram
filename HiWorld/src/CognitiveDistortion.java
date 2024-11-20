//cognitive distortions
public class CognitiveDistortion
{
    public int number;
    public String name;
    public String definition;
    public boolean distortionPresent;

    //constructor - method/set of instructions that sets the values for a new object
    public CognitiveDistortion(int number, String name, String definition, boolean distortionPresent)
    {
        this.number = number;
        this.name = name;
        this.definition = definition;
        this.distortionPresent = distortionPresent;
    }

    public int getNumber()
    {
        return this.number;
    }

    public String getName()
    {
        return this.name;
    }

    public String getDefinition()
    {
        return this.definition;
    }

    public boolean getDistortionPresent()
    {
        return this.distortionPresent;
    }

    //------------------------------------------------------------------------

    public void setNumber(int newNumber)
    {
        number = newNumber;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public void setDefinition(String newDefinition)
    {
        definition = newDefinition;
    }

    public void setDistortionPresent(boolean newDistortionPresent)
    {
        distortionPresent = newDistortionPresent;
    }
}