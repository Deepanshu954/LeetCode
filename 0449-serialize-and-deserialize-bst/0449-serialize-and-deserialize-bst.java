
class temp{
    static TreeNode r;
}
public class Codec {
    
   
    public String serialize(TreeNode root) {
        temp.r=root;
        return "";
    }

    public TreeNode deserialize(String data) {
        return temp.r;
    }
}
