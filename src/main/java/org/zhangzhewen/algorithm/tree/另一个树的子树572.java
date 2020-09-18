package org.zhangzhewen.algorithm.tree;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1:
 * 给定的树 s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 2:
 * 给定的树 s：
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 false。
 *
 * @author zhangzhewen
 * @date 2020/9/14
 */
public class 另一个树的子树572 {

    public static void main(String[] args) {
        /*new 两数之和IV_输入BST653().findTarget(new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2,
                                        null,
                                        null
                                )
                                ,
                                new TreeNode(4,
                                        null,
                                        null
                                )
                        )
                        ,
                        new TreeNode(6,
                                null,
                                new TreeNode(7,
                                        null,
                                        null
                                )
                        )
                ), 9
        );*/
        /*new 两数之和IV_输入BST653().findTarget(new TreeNode(2,
                        new TreeNode(1,
                                null, null
                        )
                        ,
                        new TreeNode(3,
                                null, null
                        )
                ), 4
        );*/
        new 另一个树的子树572().isSubtree(
                new TreeNode(3,
                        new TreeNode(4,
                                new TreeNode(1,
                                        null,
                                        null
                                ),
                                new TreeNode(2,
                                        null,
                                        null
                                )
                        )
                        ,
                        new TreeNode(5,
                                null,
                                null
                        )
                ),
                new TreeNode(4,
                        new TreeNode(1,
                                null,
                                null
                        ),
                        new TreeNode(2,
                                null,
                                null
                        )
                )
        );
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        String s1 = convertString(s);
        String t1 = convertString(t);
        return s1.contains(t1);
    }

    String convertString(TreeNode s){
        if(s==null){
            return "";
        }
        return s.val+"("+convertString(s.left)+")"+"("+convertString(s.right)+")";
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
