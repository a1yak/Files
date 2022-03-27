package Files;
import java.io.Console;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Console cons = System.console();
            String temporary="123", sub1="", sub2="";
            String filename = cons.readLine("Enter filename with document numbers");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("D:\\android\\project 2\\src\\com\\oop\\src\\Files\\InvalidNumbers"));
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("D:\\android\\project 2\\src\\com\\oop\\src\\Files\\ValidNumbers"));
            boolean valid =true;
            while((temporary=bufferedReader.readLine())!=null)
            {
                sub1=temporary.substring(0,8);
                sub2=temporary.substring(0,6);
                if(temporary.length()!=15)
                {
                    bufferedWriter1.write(temporary + "  (Document number must be exactly 15 symbols long)\n");
                    bufferedWriter1.flush();
                    valid = false;
                }
                if((sub1.compareTo("contract")!=0)&&(sub2.compareTo("docnum")!=0))
                {
                    bufferedWriter1.write(temporary+"  (Document number must start with 'contract' or 'docnum')\n");
                    bufferedWriter1.flush();
                    valid = false;
                }
                if(valid)
                {
                    bufferedWriter2.write(temporary + "\n");
                    bufferedWriter2.flush();
                }
            }
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }
    }
}

