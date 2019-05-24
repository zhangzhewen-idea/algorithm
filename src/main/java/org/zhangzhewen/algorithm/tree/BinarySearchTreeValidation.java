package org.zhangzhewen.algorithm.tree;

/**
 * 描述
 *
 * @author zhangzhewen
 * @date 2019/5/21
 */
public class BinarySearchTreeValidation {

    public static void main(String[] args) {
//        System.out.println(byInorder(BinaryTreeNode.buildTrees()));
//        System.out.println(recurse(BinaryTreeNode.buildTrees(), null, null));
    }

















































    private static BinaryTreeNode prev;
    public static boolean byInorder(BinaryTreeNode n){
        if(n==null){
            return true;
        }
        if(!byInorder(n.left)){
            return false;
        }
        else if(prev!=null&&prev.val>=n.val){
            return false;
        }
        prev = n;
        return byInorder(n.right);
    }

    public static boolean recurse(BinaryTreeNode n,Integer min,Integer max){
        if(n==null){
            return true;
        }
        if( (min!=null && n.val<=min) || (max!=null && n.val>=max)){
            return false;
        }
        return recurse(n.left,min,n.val) && recurse(n.right,n.val,max);
    }


}
