import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(n)
//Space Complexity: O(1)

public class LevelOrderBT {
    List<List<Integer>> result = new ArrayList<>();;
    public List<List<Integer>> levelOrder(TreeNode root) {
        int level =0;
        levelOrderH(root, level);
        return result;
    }

    public void levelOrderH(TreeNode root, int level){
        if(root == null){
            return;
        }

        if(level == result.size()){
            List<Integer> nlist = new ArrayList<>();
            nlist.add(root.val);
            result.add(nlist);
        }else{
            List<Integer> elist = result.get(level);
            elist.add(root.val);
            result.set(level, new ArrayList<>(elist));
        }
        levelOrderH(root.left, level+1);
        levelOrderH(root.right, level+1);
    }
}
