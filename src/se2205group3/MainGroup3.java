package se2205group3;

public class MainGroup3 {

    public static void main(String[] args) {
        // create Tree
        Tree<String> root = new Tree<>("/user/rt/courses/");
        
        // add nodes
        root.addChild("cs016/");
        root.getChild(0).addChild("grades/");        
        root.getChild(0).addChild("homeworks/");
        root.getChild(0).getChild(1).addChild("hw1");
        root.getChild(0).getChild(1).addChild("hw2");
        root.getChild(0).getChild(1).addChild("hw3");          
        root.getChild(0).addChild("programs/");
        root.getChild(0).getChild(2).addChild("pr1");
        root.getChild(0).getChild(2).addChild("pr2");
        root.getChild(0).getChild(2).addChild("pr3");
        root.addChild("cs252/");
        root.getChild(1).addChild("projects/");
        root.getChild(1).getChild(0).addChild("papers/");
        root.getChild(1).getChild(0).getChild(0).addChild("buylow");
        root.getChild(1).getChild(0).getChild(0).addChild("sellhigh");       
        root.getChild(1).getChild(0).addChild("demos/");        
        root.getChild(1).getChild(0).getChild(1).addChild("market");       
        root.getChild(1).addChild("grades");
       
        // preorder traversal
        System.out.println("1 - PREORDER");
        root.preorderPrint(root);
        
        // postorder traversal
        System.out.println("2 - POSTORDER");
        root.postorderPrint(root);
        
        //---------------------------------
        System.out.println("=======================");
        // BONUS POINTS
        Tree<String> bonusTree = new Tree<>();
        String pathList[] = new String[]{
            "/user/rt/courses/cs016/grades",
            "/user/rt/courses/cs016/homeworks/hw1",
            "/user/rt/courses/cs016/homeworks/hw2",
            "/user/rt/courses/cs016/homeworks/hw3",
            "/user/rt/courses/cs016/programs/pr1",
            "/user/rt/courses/cs016/programs/pr2",
            "/user/rt/courses/cs016/programs/pr3",
            
            "/user/rt/courses/cs252/projects/papers/buylow",
            "/user/rt/courses/cs252/projects/papers/sellhigh",
            "/user/rt/courses/cs252/projects/demos/market",
            "/user/rt/courses/cs252/grades"
        };

        for (String p : pathList){
            bonusTree.addThruPath(p);
        }
        
        System.out.println("bonus - PREORDER");
        bonusTree.preorderPrint(root);
        
        System.out.println("bonus - POSTORDER");
        bonusTree.postorderPrint(root);
    }
    
}
