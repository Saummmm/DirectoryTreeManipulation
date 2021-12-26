package se2205group3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Tree<E> implements Iterable<Tree<E>> {
    
    private E data;
    private String s;
    Tree<E> parent;
    List<Tree<E>> children;

    public Tree(){
        parent = new Tree<E>((E) "");
        this.children = new ArrayList<Tree<E>>();
    }
    
    public Tree(E data) {
        this.data = data;
        this.children = new ArrayList<Tree<E>>();
    }

    public Tree<E> addChild(E child) {
        Tree<E> childNode = new Tree<E>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }
    
    public Tree<E> getChild(int index) {
        if (index < children.size()) {
            return children.get(index);
        }        
        return null;
    }
    
    public Tree<E> getChild(E data){
        for(Tree<E> n : children)
                if(n.data.equals(data))
                    return n;

        return null;
    }
    
    public List<Tree<E>> getChildren(){
        return children;
    }
    
    public E getData() {
        return data;
    }
    
    // pre-order print
    public static <E> void preorderPrint(Tree<E> rootNode){
        System.out.println(rootNode.getData());
        rootNode.getChildren().forEach(each -> preorderPrint(each));       
    }
    
    // post-order print
    public static <E> void postorderPrint(Tree<E> rootNode){
        rootNode.getChildren().forEach(each -> postorderPrint(each));
        System.out.println(rootNode.getData());               
    }

    @Override
    public Iterator<Tree<E>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    // bonus add through path
    public void addThruPath(E path) {   
        Tree<E> current = parent;
        StringTokenizer split = new StringTokenizer((String) path, "/");
        
        while(split.hasMoreElements())
        {          
            path = (E)(String)split.nextElement();
            Tree<E> child = current.getChild(path);

            if(child==null)
            {
                current.children.add(new Tree<E>(path));
                child = current.getChild(path);
            }
            current = child;
        }
    }      
}
