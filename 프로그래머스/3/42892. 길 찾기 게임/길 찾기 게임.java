import java.util.ArrayList;

class Solution {
    private static class Node{
        int x, y;
        int num;
        
        Node left;
        Node right;
        
        public Node(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    private static ArrayList<Node> tree;
    private static int orderIdx;
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        
        tree = new ArrayList<>();
        
        // 노드 모두 추가해주기
        for(int i=0; i<nodeinfo.length; i++){
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            
            tree.add(new Node(x, y, i+1));
        }
        tree.sort((o1,o2) -> o2.y-o1.y);
        
        Node root = tree.get(0);
        
        // 이진 트리로 만들기 (왼쪽, 오른쪽 자식 연결해주기)
        for(int i=1; i<nodeinfo.length; i++){
            link(root, tree.get(i));
        }
        
        answer = new int[2][nodeinfo.length];
        
        // 전위 순회
        preOrder(root, answer[0]);
        orderIdx = 0;
        
        // 후위 순회
        postOrder(root, answer[1]);
        
        return answer;
    }
    
    private static void link(Node parent, Node child){
        // 왼쪽
        if(parent.x > child.x){
            // 왼쪽이 비어있으면
            if(parent.left == null) parent.left = child;
            else link(parent.left, child);
        }
        
        // 오른쪽
        else {
            if(parent.right == null) parent.right = child;
            else link(parent.right,child);
        }
    }
    
    // 전위 순회
    private static void preOrder(Node node, int[] arr){
        if(node != null){
            arr[orderIdx++] = node.num;
            preOrder(node.left, arr);
            preOrder(node.right, arr);
        }
    }
    
    // 후위 순회
    private static void postOrder(Node node, int[] arr){
        if(node != null){
            postOrder(node.left, arr);
            postOrder(node.right, arr);
            arr[orderIdx++] = node.num;
        }
    }
}