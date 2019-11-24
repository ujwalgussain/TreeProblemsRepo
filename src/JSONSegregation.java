import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class JSONSegregation {

    public static byte[] stringToBytesASCII(String str) {
        char[] buffer = str.toCharArray();
        byte[] b = new byte[buffer.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) buffer[i];
        }
        return b;
    }
    public static void main(String args[]) throws Exception
    {
       execute();
    }

        public static void execute() throws Exception {
            ArrayList<StringBuilder> list = new ArrayList<>();
            LinkedList<Character> stack = new LinkedList<>();
            BufferedInputStream br = new BufferedInputStream(new FileInputStream("C:\\Users\\capiot\\Documents\\testjsonseg.txt"));
            //BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\capiot\\Documents\\testjsonseg.txt")));
            int i;
            char c;
            StringBuilder jsonSTR = new StringBuilder("");
            File f = new File("D:\\AdvancePartner");
            f.mkdir();
            while((i=br.read())!=-1)
            {
                if(i == 65535)
                {
                    jsonSTR.append(i);
                    continue;
                }
                c = (char)i;
                /*if(count>=5)
                    System.out.print((int)c+" ");
*/
                if(c==' ')
                    continue;
                jsonSTR.append(c);

                if(c=='{' || c=='[')
                {
                    stack.push(c);
                }
                if(c=='}' || c == ']')
                {
                    char c1 = stack.pop();
                    if(c=='{' && c1!='}')
                    {
                        throw new Exception("{} not matched");
                    }
                    else
                    {
                        if(c=='[' && c1!=']')
                        {
                            throw new Exception("{} not matched");
                        }
                    }
                }
                //System.out.println(stack);
                if(stack.isEmpty())
                {
                    System.out.println("Got Json");
                    createFile(jsonSTR.toString());
                }

            }
            br.close();
        }

    static int count = 0;
    static void createFile(String str) throws FileNotFoundException {
        JSONObject j = new JSONObject(str);
        if(j.getString("_index").equals("edi_replayprd")||j.getString("_index").equals("edi_retryprd"))
        {
            PrintWriter pw =  new PrintWriter(new File("D:\\AdvancePartner\\"+j.getString("_index")+".txt"));
            pw.println(j.toString());
            pw.flush();
            pw.close();
            System.out.println("file "+ (count++)+ " written " + j.getString("_index"));
        }
        else
        {
            PrintWriter pw =  new PrintWriter(new File("D:\\AdvancePartner\\"+j.getString("LogMessage").substring(0,15)+".txt"));
            pw.println(j.toString());
            pw.flush();
            pw.close();
            System.out.println("file "+ (count++)+ " written " + j.getString("LogMessage").substring(0,15));
        }
    }
}
