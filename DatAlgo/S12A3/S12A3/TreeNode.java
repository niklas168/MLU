public class TreeNode<KeyType extends Comparable<KeyType>,DataType>
{
    public KeyType key;
    public DataType data;
    public TreeNode<KeyType,DataType> parent;
    public TreeNode<KeyType,DataType> left;
    public TreeNode<KeyType,DataType> right;
    // Konstruktor:
    public TreeNode( KeyType k, DataType d ){
        key = k; data = d; left = right = parent = null; 
    }
}