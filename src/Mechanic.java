import java.util.List;
import java.util.Random;

public class Mechanic
{
    private List<String[]> fWords;
    private String [] words;
    private String slowo;

    private void setDictionary()
    {
        fWords = Dictionary.readFile("dictionary.txt");
    }

    public String[] random()
    {
        Random crazy = new Random();
        int index = crazy.nextInt(fWords.size());
        words = fWords.get(index);
        return words;
    }

    public String getWord()
    {
        setDictionary();
        random();
        slowo = words[0];
        return slowo;
    }

    public boolean[] OkButton(String f1, String f2, String f3)
    {
        boolean[] tab = {false,false,false};
        if (f1.equals(words[1]))
            tab[0] = true;
        if (f2.equals(words[2]))
            tab[1] = true;
        if (f3.equals(words[3]))
            tab[2]= true;
        return tab;
    }


    public String NextButton ()
    {
        random();
        getWord();
        return slowo;

    }
}

