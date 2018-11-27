import java.io.IOException;
import java.io.*;
import java.lang.Object;

import java.util.ArrayList;
import java.util.BitSet;

public class Main {

    public static void main(String[] args) throws IOException {

        /*
         * Read input from file then put it in String
         */

        /*
         * Testing the algorithm
         */



        //Test 1

        /*
        String usrStream = "ABbcccfssssafa";
        Huffman h = new Huffman();
        h.parse(usrStream);

        int size = h.mylist.size();
        System.out.println("UNSORTED: ");
        for(int j = 0; j < size; j++)
        {
            System.out.print(h.mylist.get(j).value + "  ");
            System.out.println(h.mylist.get(j).freq);
        }
        System.out.println("SORTED");
        h.sort();
        for(int j = 0; j < size; j++)
        {
            System.out.print(h.mylist.get(j).value + " ");
            System.out.println(h.mylist.get(j).freq);
        }
        */

        //Test 2
        /*String usrStream = "EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE" +
                "TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                "OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO" +
                "IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII" +
                "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN" +
                "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS" +
                "RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR" +
                "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH" +
                "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL" +
                "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD" +
                "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC" +
                "UUUUUUUUUUUUUUUUUUUUUUUUUUU";
        */
        String usrStream = "vvvvvvvvvvvvvvhhhhhhhhhhhhhhcxxx";
        Huffman h = new Huffman();
        h.parse(usrStream);
        h.createTree();
        ArrayList<codeword> list = new ArrayList<>();
        list = h.compress();
        for(codeword c: list)
            c.print();


        String text ="";
        int usrSize = usrStream.length();
        for(int i = 0; i < usrSize; i++)
        {
            if(h.myTree.findCharInCodewords(usrStream.charAt(i)) != -1)
            {//This char is found in the codewords array list
                System.out.println(usrStream.charAt(i));
                text+=list.get(h.myTree.findCharInCodewords(usrStream.charAt(i))).code;
            }

        }
        HuffmanFiles hf = new HuffmanFiles();
        hf.setBits(text);
        System.out.println(text);
        //Testing working with files
        /*FileInputStream in = null;
        FileOutputStream out = null;



        try {
            out = new FileOutputStream("/home/nerdo/FCI/Third Year/First Term/Multimedia/StandardHuffman/output.txt");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }*/
        //End testing in files.
    }
}
