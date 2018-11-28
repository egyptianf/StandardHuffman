import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;

public class HuffmanFiles {
    int pad;
    FileOutputStream out =null;
    FileInputStream in = null;
    HuffmanFiles() throws FileNotFoundException
    {
    }
    public void setBits(String comp) throws FileNotFoundException{
        out = new FileOutputStream("output.txt");
        BitSet s = new BitSet(8);
        int bitsCount=0;
        for(int i =0 ; i < comp.length();i++ ){
            if(bitsCount==7){
               SaveToFile(s); 
               s.clear();
               bitsCount=0;
            }
            if(comp.charAt(i)=='1'){
                s.set(bitsCount, true);
            }else{
                s.set(bitsCount, false);
            }
            bitsCount++;
            
            if(i== comp.length()-1 && bitsCount < 7){
                pad = 7  - bitsCount;
                SaveToFile(s);
            }
        }

    }
    public void SaveToFile(BitSet bits)
    {
        
        try  {
           
            byte[] b;
            b = bits.toByteArray();
            out.write(b);
        }catch(IOException ie) {
            ie.printStackTrace();
        }
        finally {
            /*try {
                if (out != null) {
                    out.close();
                }
            }catch (IOException ie)
            {
                ie.printStackTrace();
            }*/
        }
    }
    public ArrayList<byte[]> loadFromFile() throws FileNotFoundException
    {
        in = new FileInputStream("output.txt");
        ArrayList<byte[]> a = new ArrayList<>();
        byte[] ba = new byte[1];
        try {
            while(in.read(ba) != -1)
            {
                a.add(ba);
            }
        }catch (IOException e)
        {
            System.out.println("Some error happened, please try again later.");
        }

        return a;

    }
}
