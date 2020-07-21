package cn.itlemon.leetcode.tree;

import cn.itlemon.leetcode.model.TreeNode;

import java.util.LinkedList;

/**
 * 297. 二叉树的序列化与反序列化（前序遍历算法）
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiangpingping
 * @date 2020/7/21 23:25
 */
public class No297SerializeAndDeserializeBinaryTree1 {

    private static final String SEP = ",";

    private static final String NULL = "#";

    /**
     * Encodes a tree to a single string.
     *
     * @param root 树根
     * @return 序列化后的字符串
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        // 前序遍历实现方式
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    /**
     * Decodes your encoded data to tree.
     *
     * @param data 字符串
     * @return 树
     */
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        for (String item : data.split(SEP)) {
            list.addLast(item);
        }
        return deserialize(list);
    }

    private TreeNode deserialize(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        // 前序遍历
        String first = list.removeFirst();
        if (NULL.equals(first)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

}
