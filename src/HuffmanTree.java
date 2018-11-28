import java.util.ArrayList;

public class HuffmanTree {
    private Node root;
    private String tempCode = "";
    ArrayList<codeword> codewords = new ArrayList<>();
    HuffmanTree()
    {
        root = null;
    }
    HuffmanTree(Node root)
    {
        this.root = root;
    }
    void treetraverse()
    {
        traverse(root);
    }
    private void traverse(Node root)
    {
        if(root.left != null)
            traverse(root.left);

        root.print();
        if(root.right != null)
            traverse(root.right);
    }
    public void assignCodes(Node root)
    {

        if(root.left != null)
        {
            tempCode+="0";
            assignCodes(root.left);
        }

        if(root.right != null)
        {
            tempCode+="1";
            assignCodes(root.right);
        }

        //To put the code word just for leaf nodes
        if(root.value.length()==1) {
            root.code = tempCode;
            codeword cw = new codeword();
            cw.c = root.value.charAt(0);
            cw.code = tempCode;
            codewords.add(cw);
        }
        //To reduce the temp every time you get out of one of the recursive functions
        if(tempCode.length() > 0)
            tempCode = tempCode.substring(0, tempCode.length()-1);
    }

    public int findCharInCodewords(char c)
    {
        for(codeword cc: codewords)
            if (cc.c == c)
                return codewords.indexOf(cc);
        return -1;
    }

    public String toString(ArrayList<byte[]> a)
    {
        String realText;
        for(int i = 0; i< a.size(); i++)
        {

        }
    }
}
