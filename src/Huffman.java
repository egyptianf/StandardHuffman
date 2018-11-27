
import java.util.*;

@SuppressWarnings("ALL")
public class Huffman {
    ArrayList<Node> mylist;
    HuffmanTree myTree;
    Huffman()
    {
        mylist = new ArrayList<>();
        myTree = new HuffmanTree();
    }

    private int found(ArrayList<Node> list, Node n)
    {
        int size = list.size();
        for(int i = 0; i < size; i++)
            if (list.get(i).value.equals(n.value))
                return i;
        return -1;
    }

    class FreqSort implements Comparator<Node>
    {
        public int compare(Node n1, Node n2)
        {
            return Integer.valueOf(n2.freq).compareTo(n1.freq);
        }
    }

    public void sort()
    {
        Collections.sort(mylist, new FreqSort());
    }
    public void parse(String usrStream)
    {
        ArrayList<Node> list = new ArrayList<>();
        int streamSize = usrStream.length();
        for(int i = 0; i< streamSize; i++)
        {
            String value = "";
            value+= usrStream.charAt(i);
            Node temp = new Node(value, 1);
            int tempIndex = found(list, temp);
            if(tempIndex != -1)
            {
                list.get(tempIndex).freq++;
            }
            else
            {
                list.add(temp);
            }
        }
        this.mylist = list;
    }


    public void createTree()
    {

        while(mylist.size() > 2)
        {
            int listSize = mylist.size();
            sort();



            //Creating temp for leftnode and rightnode to attach them to the parent


            Node tmpLeft = new Node(mylist.get(listSize-2));

            Node tmpRight = new Node(mylist.get(listSize-1));



            Node parent = new Node();
            parent.addLeft(tmpLeft);
            parent.addRight(tmpRight);

            //Remove last 2 nodes
            mylist.remove(listSize-1);
            mylist.remove(listSize-2);

            mylist.add(parent);
        }




        Node tmpLeft = new Node(mylist.get(mylist.size()-2));
        Node tmpRight = new Node(mylist.get(mylist.size()-1));

        Node root = new Node();
        root.addLeft(tmpLeft);
        root.addRight(tmpRight);


        myTree = new HuffmanTree(root);
        myTree.assignCodes(root);

    }
    public ArrayList<codeword> compress()
    {
        return myTree.codewords;
    }

}
