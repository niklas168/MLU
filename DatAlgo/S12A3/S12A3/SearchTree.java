import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchTree<KeyType extends Comparable<KeyType>,DataType>
{

        public static void main(String[] args) throws IOException {
        SearchTree<Integer,String> myTree = new SearchTree<Integer, String>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        String eing;
        System.out.println("Befehle: insert, remove, search, min, max, pred, succ, clear, print, exit");
        while(true) {
            System.out.print("Bitte geben Sie den naechsten Befehel ein: ");
            temp = in.readLine();
            switch(temp) {
                case "i":
                case "insert":
                    System.out.print("Geben Sie den Datenwert an:      ");
                    eing = in.readLine();
                    System.out.print("Geben Sie den Schluesselwert an: ");
                    myTree.insert(eing, Integer.parseInt(in.readLine()));
                    break;
                case "r":
                case "remove":
                    System.out.print("Geben Sie den Schluesselwert an: ");
                    myTree.remove(Integer.parseInt(in.readLine()));
                    break;
                case "s":
                case "search":
                    System.out.print("Geben Sie den Schluesselwert an: ");
                    TreeNode<Integer, String> result = myTree.search(Integer.parseInt(in.readLine()));
                    if (result == null){
                        System.out.println("Nicht gefunden.");
                    }
                    else {
                        System.out.println(result);
                    }
                    break;
                case "p":
                case "print":
                    System.out.println(myTree);
                    break;
                case "min":
                    System.out.println(myTree.minimum());
                    break;
                case "max":
                    System.out.println(myTree.maximum());
                    break;
                case "c":
                case "clear":
                    myTree.clear();
                    break;
                case "size":
                    System.out.println(myTree.size());
                    break;
                case "d":
                case "depth":
                    System.out.println(myTree.depth());
                    break;
                case "intervall":
                    System.out.println("Geben Sie die untere Grenze an:");
                    int lb = Integer.parseInt(in.readLine());
                    System.out.println("Geben Sie die obere Grenze an:");
                    int ub = Integer.parseInt(in.readLine());
                    //System.out.println(myTree.toString(lb, ub));
                    break;
                case "member":
                    System.out.print("Geben Sie den Schluesselwert an: ");
                    String res = myTree.isMember(Integer.parseInt(in.readLine()));
                    if (res == null){
                        System.out.println("Nicht gefunden.");
                    }
                    else {
                        System.out.println(res);
                    }
                    break;
                case "e":
                    in.close();
                    return;
                default:
                    break;
            }
        }
    }
    protected TreeNode<KeyType, DataType> root;

    public TreeNode<KeyType, DataType> search( KeyType k ){
        TreeNode<KeyType, DataType> currentNode = root;
        while (currentNode != null){
            if (k.compareTo(currentNode.key)== 0)
                return currentNode;
            if (k.compareTo(currentNode.key) < 0)
                currentNode = currentNode.left;
            else    
                currentNode = currentNode.right;
        } // end while
        return null;
        }

    public DataType isMember( KeyType k ){

        TreeNode<KeyType,DataType> node = search( k );
            if ( node == null ) 
                return null;
        return node.data;
    }

    public boolean insert ( DataType d, KeyType k ){
        TreeNode<KeyType, DataType> node = new TreeNode<KeyType,DataType>(k,d);
        if (root==null){
            root = node; return true;
        } //Baum bisher leer
        TreeNode<KeyType, DataType> currentNode = root;
        TreeNode<KeyType, DataType> parentNode = null;
        while (currentNode != null){
            parentNode = currentNode;
            if (k.compareTo(currentNode.key) == 0) return false;
            if (k.compareTo(currentNode.key) < 0){
                currentNode = currentNode.left;
            }
            else
                currentNode = currentNode.right; 
        } // end while
        node.parent = parentNode;
        if (k.compareTo(parentNode.key) > 0)
            parentNode.right = node;
        else
            parentNode.left = node;
        return true; }

        boolean remove(KeyType k){
            TreeNode<KeyType,DataType> node = search( k );
            if ( node == null ) 
                return false;
            else{
                TreeNode<KeyType,DataType> parentNode=node.parent;
                if(node.left==null && node.right==null){            // zu löschender Schlüsssel ist ein Blatt
                    if(k.compareTo(parentNode.key) > 0){            //zu löschendes Blatt ist ein rechter Sohn
                        parentNode.right=null;
                        node.parent=null;
                        
                    }
                    else{                                           //zu löschendes Blatt ist ein linker Sohn
                        parentNode.left=null;
                        node.parent=null;
                        
                    }
                
                }
                
                if(node.left==null && node.right!=null){ // zu löschender Schlüssel hat genau einen Sohn, welcher rechts ist
                    node.right.parent=null;
                    node.right=null;
                    
                }
                if( node.left!=null && node.right==null){ // zu löschender Schlüssel hat genau einen Sohn, welcher links ist
                    node.left.parent=null;
                    node.left=null;
                    
                }
                else{                                   // zu löschender Schlüssel hat 2 Söhne
                    // successor Suche
                    TreeNode<KeyType,DataType> successor=minimum(node.right);
                    // zwischenkopie der Werte des successors
                    KeyType temp_key=successor.key;
                    DataType temp_data=successor.data;
                    //Löschen Successor
                    remove(successor.key); 
                    //Übertragen der Werte
                    node.key=temp_key;
                    node.data=temp_data;          
                    
                }

                return true;
            }
            
        }

       public TreeNode<KeyType, DataType> minimum() {
            return minimum(root);
        }

        private TreeNode<KeyType, DataType> minimum(TreeNode<KeyType, DataType> node) {
            if (node == null)
                return null;
            while (node.left != null)
                node = node.left;
            return node;
        }

        public TreeNode<KeyType, DataType> maximum() {
            return maximum(root);
        }

        private TreeNode<KeyType, DataType> maximum(TreeNode<KeyType, DataType> node) {
            if (node == null)
                return null;
            while (node.right != null)
                node = node.right;
            return node;
        }

        public void clear() {
            root = null;
        }

        public int size() {
            return size(root);
        }

        private int size(TreeNode<KeyType, DataType> node) {
            if (node == null)
                return 0;
            return 1 + size(node.left) + size(node.right);
        }

        public int depth() {
            return depth(root);
        }

        private int depth(TreeNode<KeyType, DataType> node) {
            if (node == null)
                return 0;
            return 1 + Math.max(depth(node.left), depth(node.right));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            toString(root, sb);
            return sb.toString();
        }

        private void toString(TreeNode<KeyType, DataType> node, StringBuilder sb) {
            if (node == null)
                return;
            sb.append(node.key).append(": ").append(node.data).append("\n");
            toString(node.left, sb);
            toString(node.right, sb);
        }


        

}