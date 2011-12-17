/*
Copyright (C) 2007 Alex Billingsley, email@abillingsley.co.uk
www.dragmath.bham.ac.uk

This file is part of DragMath

    DragMath is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation.

    DragMath is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with DragMath.  If not, see <http://www.gnu.org/licenses/>
 */

package Display;
import Tree.*;
import javax.swing.tree.*;
import javax.swing.*;

/**
 * Class to show graphical representation of tree structure of the expression in the display
 * @author  Alex Billingsley
 */
public class TreeDisplay extends javax.swing.JFrame {
    
    private DefaultMutableTreeNode root;
    private InputComponent[] inputComponents;
    
    /** Creates new form TreeDisplay */
    public TreeDisplay(MathObject start, InputComponent[] inputComponents) {
        initComponents();
        
        this.inputComponents=inputComponents;
        root = new DefaultMutableTreeNode("Expression");
        
        if (start != null) {
            traverse(start, root);
        }
        
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        javax.swing.JTree jTree1 = new javax.swing.JTree(root);
        jScrollPane1.setViewportView(jTree1);
        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        for (int i=0 ; i<jTree1.getRowCount() ; i++) {
            jTree1.expandRow(i);
        }
        
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DragMath");
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 1000));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 300));
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Traverses the tree left-to-right, adding nodes into the JTree at each stage
    public void traverse(MathObject start, DefaultMutableTreeNode currentNode) throws java.lang.NullPointerException {
        
        if (start.getClass().getName().equals("Tree.Text")) {
            Tree.Text textObj = (Tree.Text)start;
            DefaultMutableTreeNode text = new DefaultMutableTreeNode(textObj.getText());
            currentNode.add(text);
        }
        
        if (start.getClass().getName().equals("Tree.Variable")) {
            Tree.Variable variableObj = (Tree.Variable)start;
             DefaultMutableTreeNode var = new DefaultMutableTreeNode(String.valueOf(variableObj.getVarName()));
            currentNode.add(var);
        }
        
        if (start.getClass().getName().equals("Tree.RealNumber")) {
            Tree.RealNumber numberObj = (Tree.RealNumber)start;
            DefaultMutableTreeNode number = new DefaultMutableTreeNode(numberObj.getNumber(true));
            currentNode.add(number);
        }
        
        if (start.getClass().getName().equals("Tree.BinaryOperator")) {
            BinaryOperator binaryObj = (BinaryOperator)start;
            DefaultMutableTreeNode binary = new DefaultMutableTreeNode(inputComponents[binaryObj.getID()].getDisplayText());
            currentNode.add(binary);
            traverse(binaryObj.getRightChild(), binary);
            traverse(binaryObj.getLeftChild(), binary);
        }
        
        if (start.getClass().getName().equals("Tree.Function")) {
            Function functionObj = (Function)start;
            DefaultMutableTreeNode function = new DefaultMutableTreeNode(inputComponents[functionObj.getID()].getDisplayText());
            currentNode.add(function);
            traverse(functionObj.getChild(), function);
            
        }
        
        if (start.getClass().getName().equals("Tree.NaryFunction")) {
            NaryFunction naryFunctionObj = (NaryFunction)start;
            DefaultMutableTreeNode nary = new DefaultMutableTreeNode(inputComponents[naryFunctionObj.getID()].getDisplayText());
            currentNode.add(nary);
            int i=0;
            while (i < naryFunctionObj.getSize()) {
                traverse(naryFunctionObj.getChild(i), nary);
                i++;
            }
        }
        
        if (start.getClass().getName().equals("Tree.Matrix")) {
            Matrix matrixObj = (Matrix)start;
            DefaultMutableTreeNode matrix = new DefaultMutableTreeNode(inputComponents[matrixObj.getID()].getDisplayText());
            currentNode.add(matrix);
        }
        
        if (start.getClass().getName().equals("Tree.Grouping")) {
            Grouping groupingObj = (Grouping)start;
            DefaultMutableTreeNode grouping = new DefaultMutableTreeNode(inputComponents[groupingObj.getID()].getDisplayText());
            currentNode.add(grouping);
            traverse(groupingObj.getChild(), grouping);
            
        }
        
        if (start.getClass().getName().equals("Tree.NaryOperator")) {
            NaryOperator naryObj = (NaryOperator)start;
            DefaultMutableTreeNode nary = new DefaultMutableTreeNode(inputComponents[naryObj.getID()].getDisplayText());
            currentNode.add(nary);
            int i=0;
            while (i < naryObj.getSize()) {
                traverse(naryObj.getChild(i), nary);
                i++;
            }
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
}
