
class Node
{
    Node left = null;
    Node right = null;
    String value;
    int freq;
    String code;
    Node() { value = ""; freq = 0; code = "";}
    Node(String value, int freq) { this.value = value; this.freq = freq;}
    Node(Node n)
    {
        this.value = n.value;
        this.freq = n.freq;
        this.left = n.left;
        this.right = n.right;
    }
    void addLeft(Node left) {
        this.left = left;
        this.value += left.value;
        this.freq += left.freq;
    }
    void addRight(Node right) {
        this.right = right;
        this.value += right.value;
        this.freq += right.freq;
    }
    void print()
    {
        System.out.println("Value: " + value + " Code: " + code);
    }

}