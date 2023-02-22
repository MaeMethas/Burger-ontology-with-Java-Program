/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BurgerPack;

import org.apache.jena.query.QuerySolution;
import org.apache.jena.rdf.model.RDFNode;
import java.nio.charset.Charset;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.*;



/**
 *
 * @author CCS
 */
public class DisplayFrame extends javax.swing.JFrame {
	// method for remove redundancy Array
	
	public static ArrayList<String> removeDuplicates(ArrayList<String> arr) {
	    ArrayList<String> nonRedundantArr = new ArrayList<>();

	    for (String str : arr) {
	        if (!nonRedundantArr.contains(str)) {
	            nonRedundantArr.add(str);
	        }
	    }

	    return nonRedundantArr;
	}

    
    public ArrayList<String> ListCheese = new ArrayList<String>();  // for cheese list
    public ArrayList<String> ListBun = new ArrayList<String>();  // for bun list
    public ArrayList<String> ListPatty = new ArrayList<String>();  // for patty list
    public ArrayList<String> ListVeg = new ArrayList<String>();  // for veg list
    public ArrayList<String> ListCondiment = new ArrayList<String>();  // for Condiment list
    /**
     * Creates new form DisplayFrame
     */
    public DisplayFrame() {
        initComponents();
        
        
        try {
            // OntModel model = OpenOWL.OpenConnectOWL();

           System.out.println("Get Component");
           
           String queryString;
           queryString = "PREFIX ex: <http://www.semanticweb.org/burger#> "
                         +"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                         +"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
                         + "SELECT (str(?nameBurger) as ?NameBurger) (str(?bunDis) as ?BunDis) (str(?patty) as ?Patty) (str(?veg) as ?Veg) (str(?cheese) as ?Cheese) (str(?condiment) as ?Condiment)"
                         + "where {?x ex:name ?bun."
                         + "FILTER regex(?bun, \""+""+"\")"
                         + "?y ex:hasBun ?x." // เอาไว้เทียบ query
                         + "?y ex:hasBun ?b."
                         + "?y ex:hasPatty ?p."
                         + "OPTIONAL {?y ex:hasCheese ?c. ?c ex:name ?cheese.}"
                         + "OPTIONAL {?y ex:hasVegetable ?v. ?v ex:name ?veg.}"
                         + "OPTIONAL {?y ex:hasCondiment ?con. ?con ex:name ?condiment.}"
                         + "?y ex:name ?nameBurger."
                         + "?b ex:name ?bunDis."
                         + "?p ex:name ?patty."
                         + " }";
		    System.out.println(queryString);
		    org.apache.jena.query.ResultSet results = OpenOWL.ExecSparQl(queryString); //all method ExecSparQl from OpenOWL class
		    
		    while (results.hasNext()) {
		
		        QuerySolution sol = results.nextSolution();
		        RDFNode Name = sol.get("NameBurger");
		        RDFNode Bun = sol.get("BunDis"); 
		        RDFNode Patty = sol.get("Patty");
		        RDFNode Veg = sol.get("Veg");
		        RDFNode Cheese = sol.get("Cheese");
		        RDFNode Condiment = sol.get("Condiment");
		        
		        String CheeseString = "";
		        String BunString = "";
		        String PattyString = "";
		        String VegString = "";
		        String CondimentString = "";
		        
		        if(Cheese != null) {
		        	CheeseString = Cheese.toString();
		        }
		        
		        if(Bun != null) {
		        	BunString = Bun.toString();
		        }
		        
		        if(Patty != null) {
		        	PattyString = Patty.toString();
		        }
		        
		        if(Veg != null) {
		        	VegString = Veg.toString();
		        }
		        
		        if(Condiment != null) {
		        	CondimentString = Condiment.toString();
		        }
		        
		        ListCheese.add(CheeseString);
		        ListBun.add(BunString);
		        ListPatty.add(PattyString);
		        ListVeg.add(VegString);
		        ListCondiment.add(CondimentString);
            }
		    ListCheese = removeDuplicates(ListCheese);
		    ListBun = removeDuplicates(ListBun);
		    ListPatty = removeDuplicates(ListPatty);
		    ListVeg = removeDuplicates(ListVeg);
		    ListCondiment = removeDuplicates(ListCondiment);
		    
            CheeseList.removeAllItems(); //  combobox nameList
            for (int i = 0; i < ListCheese.size(); i++) {

                CheeseList.addItem(ListCheese.get(i));
            }
            
            BunList.removeAllItems(); //  combobox nameList
            for (int i = 0; i < ListBun.size(); i++) {

            	BunList.addItem(ListBun.get(i));
            }
            
            PattyList.removeAllItems(); //  combobox nameList
            for (int i = 0; i < ListPatty.size(); i++) {

            	PattyList.addItem(ListPatty.get(i));
            }
            
            VegetableList.removeAllItems(); //  combobox nameList
            for (int i = 0; i < ListVeg.size(); i++) {

            	VegetableList.addItem(ListVeg.get(i));
            }
            
            CondimentList.removeAllItems(); //  combobox nameList
            for (int i = 0; i < ListCondiment.size(); i++) {

            	CondimentList.addItem(ListCondiment.get(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableComputer = new javax.swing.JTable();
        CondimentList = new javax.swing.JComboBox<>();
        CheeseList = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        KeywordField = new javax.swing.JTextField();
        SearchBunButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Semantic Search: Burger");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TableComputer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
            		"Burger Name","Bun","Patty","Vegtable","Cheese","Condiment"
            }
        ));
        jScrollPane1.setViewportView(TableComputer);

        CondimentList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CondimentList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameListActionPerformed(evt);
            }
        });

        CheeseList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CheeseList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComponentListActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cheese:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Condiment:");

        KeywordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        SearchBunButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SearchBunButton.setText("Bun");
        SearchBunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Keyword:");
        
		PattyList = new JComboBox();
        PattyList.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JLabel lblPatty = new JLabel();
        lblPatty.setText("Patty:");
        lblPatty.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JLabel jLabel1_1_1 = new JLabel();
        jLabel1_1_1.setText("Vegetable:");
        jLabel1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        VegetableList = new JComboBox();
        VegetableList.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        BunList = new JComboBox();
        BunList.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        jLabel1_1 = new JLabel();
        jLabel1_1.setText("Bun:");
        jLabel1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        SearchCheeseButton = new JButton();
        SearchCheeseButton.setText("Cheese");
        SearchCheeseButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        SearchCheeseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheeseActionPerformed(evt);
            }
        });
        
        SearchCondimentButton = new JButton();
        SearchCondimentButton.setText("Condiment");
        SearchCondimentButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        SearchCondimentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CondimentActionPerformed(evt);
            }
        });
        
        SearchPattyButton = new JButton();
        SearchPattyButton.setText("Patty");
        SearchPattyButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        SearchPattyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PattyActionPerformed(evt);
            }
        });
        
        SearchVegetableButton = new JButton();
        SearchVegetableButton.setText("Vegetable");
        SearchVegetableButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        SearchVegetableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VegetableActionPerformed(evt);
            }
        });
        
        JLabel lblNewLabel = new JLabel("Search By :");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        									.addComponent(jLabel2, Alignment.TRAILING)
        									.addComponent(jLabel1))
        								.addComponent(lblNewLabel, 0, 0, Short.MAX_VALUE))
        							.addPreferredGap(ComponentPlacement.RELATED))
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addComponent(jLabel3)
        							.addGap(80)))
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(KeywordField, GroupLayout.PREFERRED_SIZE, 726, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        							.addGroup(jPanel2Layout.createSequentialGroup()
        								.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        									.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        										.addComponent(CheeseList, Alignment.TRAILING, 0, 275, Short.MAX_VALUE)
        										.addComponent(CondimentList, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        									.addGroup(jPanel2Layout.createSequentialGroup()
        										.addComponent(SearchBunButton)
        										.addPreferredGap(ComponentPlacement.RELATED)
        										.addComponent(SearchCheeseButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        										.addPreferredGap(ComponentPlacement.RELATED)
        										.addComponent(SearchPattyButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        									.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        										.addComponent(SearchCondimentButton, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
        										.addGap(18)
        										.addComponent(SearchVegetableButton, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
        										.addGap(203)
        										.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        									.addGroup(jPanel2Layout.createSequentialGroup()
        										.addGap(30)
        										.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        											.addComponent(lblPatty, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
        											.addComponent(jLabel1_1_1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
        										.addPreferredGap(ComponentPlacement.UNRELATED)
        										.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        											.addComponent(VegetableList, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        											.addComponent(PattyList, 0, 280, Short.MAX_VALUE)))))
        							.addGroup(jPanel2Layout.createSequentialGroup()
        								.addComponent(jLabel1_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
        								.addGap(18)
        								.addComponent(BunList, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
        								.addGap(27)
        								.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
        								.addGap(160))))))
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(KeywordField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
        			.addGap(10)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(20)
        					.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        							.addComponent(SearchCondimentButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
        							.addComponent(SearchVegetableButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        							.addComponent(SearchCheeseButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
        							.addComponent(SearchPattyButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        							.addComponent(SearchBunButton)
        							.addComponent(lblNewLabel)))))
        			.addGap(16)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(CheeseList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel1)
        				.addComponent(lblPatty, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(PattyList, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addGap(12)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(CondimentList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2)
        				.addComponent(jLabel1_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(VegetableList, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(BunList, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton2))
        			.addGap(61)
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Search BY Combobox
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String selectCheese = CheeseList.getSelectedItem().toString();
        System.out.println(selectCheese);
        
        String selectCondiment = CondimentList.getSelectedItem().toString();
        System.out.println(selectCondiment);
        
        String selectPatty = PattyList.getSelectedItem().toString();
        System.out.println(selectPatty);
        
        String selectBun = BunList.getSelectedItem().toString();
        System.out.println(selectBun);
        
        String selectVegetable = VegetableList.getSelectedItem().toString();
        System.out.println(selectVegetable);
        
        try{
        	
        	ArrayList<String> ImgBurgerName = new ArrayList<String>();
            ArrayList<String> ImgListCheese = new ArrayList<String>();  // for cheese list
            ArrayList<String> ImgListBun = new ArrayList<String>();  // for bun list
            ArrayList<String> ImgListPatty = new ArrayList<String>();  // for patty list
            ArrayList<String> ImgListVeg = new ArrayList<String>();  // for veg list
            ArrayList<String> ImgListCondiment = new ArrayList<String>();  // for Condiment list
            
        	ArrayList<String> ImgBurgerName2 = new ArrayList<String>();
            ArrayList<String> ImgListCheese2 = new ArrayList<String>();  // for cheese list
            ArrayList<String> ImgListBun2 = new ArrayList<String>();  // for bun list
            ArrayList<String> ImgListPatty2 = new ArrayList<String>();  // for patty list
            ArrayList<String> ImgListVeg2 = new ArrayList<String>();  // for veg list
            ArrayList<String> ImgListCondiment2 = new ArrayList<String>();  // for Condiment list
            
        	ArrayList<String> ImgBurgerName3 = new ArrayList<String>();
            ArrayList<String> ImgListCheese3 = new ArrayList<String>();  // for cheese list
            ArrayList<String> ImgListBun3 = new ArrayList<String>();  // for bun list
            ArrayList<String> ImgListPatty3 = new ArrayList<String>();  // for patty list
            ArrayList<String> ImgListVeg3 = new ArrayList<String>();  // for veg list
            ArrayList<String> ImgListCondiment3 = new ArrayList<String>();  // for Condiment list
        	
            String[] tableColumnsName = {"Burger Name","Bun","Patty","Vegtable","Cheese","Condiment"}; 
            DefaultTableModel aModel = (DefaultTableModel) TableComputer.getModel();
            aModel.setColumnIdentifiers(tableColumnsName);
            aModel.setRowCount(0);
            // the query
            System.out.println("Getting Burger Detail");  // get 
            String queryString;
                    queryString = "PREFIX ex: <http://www.semanticweb.org/burger#> "
                            +"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                            +"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
                            + "SELECT DISTINCT (str(?nameBurger) as ?NameBurger) (str(?bunDis) as ?BunDis) (str(?patty) as ?Patty) (str(?veg) as ?Veg) (str(?cheese) as ?Cheese) (str(?condiment) as ?Condiment)"
                            + "where {?x1 ex:name ?bun."
                            + "?x2 ex:name ?selectPattyQL."
                            + "?x3 ex:name ?selectCheeseQL."
                            + "?x4 ex:name ?selectVegetableQL."
                            + "?x5 ex:name ?selectCondimentQL."
                            + "FILTER (regex(?bun, \""+selectBun+"\") && regex(?selectPattyQL, \""+selectPatty+"\") && regex(?selectCheeseQL, \""+selectCheese+"\") && regex(?selectVegetableQL, \""+selectVegetable+"\") && regex(?selectCondimentQL, \""+selectCondiment+"\"))"
                            + "?y ex:hasBun ?x1." // เอาไว้เทียบ query
                            + "?y ex:hasPatty ?x2." // เอาไว้เทียบ query
                            + "?y ex:hasCheese ?x3." // เอาไว้เทียบ query
                            + "?y ex:hasVegetable ?x4." // เอาไว้เทียบ query
                            + "?y ex:hasCondiment ?x5." // เอาไว้เทียบ query
                            + "?y ex:hasBun ?b. ?b ex:name ?bunDis."
                            + "?y ex:hasPatty ?p. ?p ex:name ?patty."
                            + "?y ex:hasCheese ?c. ?c ex:name ?cheese."
                            + "?y ex:hasVegetable ?v. ?v ex:name ?veg."
                            + "?y ex:hasCondiment ?con. ?con ex:name ?condiment."
                            + "?y ex:name ?nameBurger."
                            + " }";
            System.out.println(queryString);
            org.apache.jena.query.ResultSet results = OpenOWL.ExecSparQl(queryString); //all method ExecSparQl from OpenOWL class

            while (results.hasNext()) {
                QuerySolution sol = results.nextSolution();
                RDFNode Name = sol.get("NameBurger");
                RDFNode Bun = sol.get("BunDis"); 
                RDFNode Patty = sol.get("Patty");
                RDFNode Veg = sol.get("Veg");
                RDFNode Cheese = sol.get("Cheese");
                RDFNode Condiment = sol.get("Condiment");

                aModel.addRow(new Object[]{ Name, Bun, Patty, Veg, Cheese, Condiment});

                TableComputer.setModel(aModel); 
                
                String NameString = "";
		        String CheeseString = "";
		        String BunString = "";
		        String PattyString = "";
		        String VegString = "";
		        String CondimentString = "";
		        
		        if(Name != null) {
		        	NameString = Name.toString();
		        }
		        
		        if(Cheese != null) {
		        	CheeseString = Cheese.toString();
		        }
		        
		        if(Bun != null) {
		        	BunString = Bun.toString();
		        }
		        
		        if(Patty != null) {
		        	PattyString = Patty.toString();
		        }
		        
		        if(Veg != null) {
		        	VegString = Veg.toString();
		        }
		        
		        if(Condiment != null) {
		        	CondimentString = Condiment.toString();
		        }
		        
		        ImgBurgerName.add(NameString);
		        ImgListCheese.add(CheeseString);
		        ImgListBun.add(BunString);
		        ImgListPatty.add(PattyString);
		        ImgListVeg.add(VegString);
		        ImgListCondiment.add(CondimentString);
            }
            
            String FirstImgBurgerName = ImgBurgerName.get(0);
            
            for(int i = 0;i <= ImgBurgerName.size()-1;i++) {
            	if(ImgBurgerName.get(i).equals(FirstImgBurgerName)) {
            		ImgBurgerName2.add(ImgBurgerName.get(i));
            		ImgListCheese2.add(ImgListCheese.get(i));
                    ImgListBun2.add(ImgListBun.get(i));
                    ImgListPatty2.add(ImgListPatty.get(i));
                    ImgListVeg2.add(ImgListVeg.get(i));
                    ImgListCondiment2.add(ImgListCondiment.get(i));
            	}else {
            		ImgBurgerName3.add(ImgBurgerName.get(i));
            		ImgListCheese3.add(ImgListCheese.get(i));
                    ImgListBun3.add(ImgListBun.get(i));
                    ImgListPatty3.add(ImgListPatty.get(i));
                    ImgListVeg3.add(ImgListVeg.get(i));
                    ImgListCondiment3.add(ImgListCondiment.get(i));
            	}
            }
            
            if(ImgBurgerName3.size() == 0) { // handle index out of bound
            	ImgBurgerName3.add("");
            }
            
            ImgBurgerName2 = removeDuplicates(ImgBurgerName2);
            ImgListCheese2 = removeDuplicates(ImgListCheese2);
            ImgListBun2 = removeDuplicates(ImgListBun2);
            ImgListPatty2 = removeDuplicates(ImgListPatty2);
            ImgListVeg2 = removeDuplicates(ImgListVeg2);
            ImgListCondiment2 = removeDuplicates(ImgListCondiment2);
            
            ImgBurgerName3 = removeDuplicates(ImgBurgerName3);
            ImgListCheese3 = removeDuplicates(ImgListCheese3);
            ImgListBun3 = removeDuplicates(ImgListBun3);
            ImgListPatty3 = removeDuplicates(ImgListPatty3);
            ImgListVeg3 = removeDuplicates(ImgListVeg3);
            ImgListCondiment3 = removeDuplicates(ImgListCondiment3);
            
            System.out.println(ImgBurgerName2);
            System.out.println(ImgListCheese2);
            System.out.println(ImgListBun2); //
            System.out.println(ImgListPatty2);
            System.out.println(ImgListVeg2);
            System.out.println(ImgListCondiment2);
            
            System.out.println("==========================");
            
            System.out.println(ImgBurgerName3);
            System.out.println(ImgListCheese3);
            System.out.println(ImgListBun3);
            System.out.println(ImgListPatty3);
            System.out.println(ImgListVeg3);
            System.out.println(ImgListCondiment3);
            
            System.out.println("==========================");
            
            // ImgBurgerName2 ImgBurgerName2 ImgBurgerName2 ImgBurgerName2
            
            if(ImgBurgerName2.get(0).equals("Slider burger")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun2 + "<br>" +
                        "Cheese: " + ImgListCheese2 + "<br>" +
                        "Patty: " + ImgListPatty2 + "<br>" +
                        "Vegetable: " + ImgListVeg2 + "<br>" +
                        "Condiment: " + ImgListCondiment2 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Slider_Burger.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName2.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName2.get(0).equals("Patty melt")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun2 + "<br>" +
                        "Cheese: " + ImgListCheese2 + "<br>" +
                        "Patty: " + ImgListPatty2 + "<br>" +
                        "Vegetable: " + ImgListVeg2 + "<br>" +
                        "Condiment: " + ImgListCondiment2 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Patty_melt.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName2.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName2.get(0).equals("Bacon cheese burger")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun2 + "<br>" +
                        "Cheese: " + ImgListCheese2 + "<br>" +
                        "Patty: " + ImgListPatty2 + "<br>" +
                        "Vegetable: " + ImgListVeg2 + "<br>" +
                        "Condiment: " + ImgListCondiment2 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Bacon_cheese_burger.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName2.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName2.get(0).equals("Beef cheese burger")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun2 + "<br>" +
                        "Cheese: " + ImgListCheese2 + "<br>" +
                        "Patty: " + ImgListPatty2 + "<br>" +
                        "Vegetable: " + ImgListVeg2 + "<br>" +
                        "Condiment: " + ImgListCondiment2 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Beef_cheese_burger.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName2.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName2.get(0).equals("Black and blue burger")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun2 + "<br>" +
                        "Cheese: " + ImgListCheese2 + "<br>" +
                        "Patty: " + ImgListPatty2 + "<br>" +
                        "Vegetable: " + ImgListVeg2 + "<br>" +
                        "Condiment: " + ImgListCondiment2 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Black_and_blue_burger.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName2.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName2.get(0).equals("Double cheese burger")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun2 + "<br>" +
                        "Cheese: " + ImgListCheese2 + "<br>" +
                        "Patty: " + ImgListPatty2 + "<br>" +
                        "Vegetable: " + ImgListVeg2 + "<br>" +
                        "Condiment: " + ImgListCondiment2 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Double_cheese_burger.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName2.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName2.get(0).equals("Juicy lucy burger")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun2 + "<br>" +
                        "Cheese: " + ImgListCheese2 + "<br>" +
                        "Patty: " + ImgListPatty2 + "<br>" +
                        "Vegetable: " + ImgListVeg2 + "<br>" +
                        "Condiment: " + ImgListCondiment2 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Juicy_lucy_burger.jpeg");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName2.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName2.get(0).equals("Mushroom and Swiss")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun2 + "<br>" +
                        "Cheese: " + ImgListCheese2 + "<br>" +
                        "Patty: " + ImgListPatty2 + "<br>" +
                        "Vegetable: " + ImgListVeg2 + "<br>" +
                        "Condiment: " + ImgListCondiment2 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Mushroom_and_Swiss.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName2.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName2.get(0).equals("The Works")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun2 + "<br>" +
                        "Cheese: " + ImgListCheese2 + "<br>" +
                        "Patty: " + ImgListPatty2 + "<br>" +
                        "Vegetable: " + ImgListVeg2 + "<br>" +
                        "Condiment: " + ImgListCondiment2 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\The_Works.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName2.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName2.get(0).equals("Beef patty burgur")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun2 + "<br>" +
                        "Cheese: " + ImgListCheese2 + "<br>" +
                        "Patty: " + ImgListPatty2 + "<br>" +
                        "Vegetable: " + ImgListVeg2 + "<br>" +
                        "Condiment: " + ImgListCondiment2 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Beef_patty_burgur.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName2.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName2.get(0).equals("Chicken patty burgur")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun2 + "<br>" +
                        "Cheese: " + ImgListCheese2 + "<br>" +
                        "Patty: " + ImgListPatty2 + "<br>" +
                        "Vegetable: " + ImgListVeg2 + "<br>" +
                        "Condiment: " + ImgListCondiment2 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Chicken_patty_burger.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName2.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            // ImgBurgerName3 ImgBurgerName3 ImgBurgerName3 ImgBurgerName3 ==========================================================
            
            if(ImgBurgerName3.get(0).equals("Slider burger")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun3 + "<br>" +
                        "Cheese: " + ImgListCheese3 + "<br>" +
                        "Patty: " + ImgListPatty3 + "<br>" +
                        "Vegetable: " + ImgListVeg3 + "<br>" +
                        "Condiment: " + ImgListCondiment3 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Slider_Burger.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName3.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName3.get(0).equals("Patty melt")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun3 + "<br>" +
                        "Cheese: " + ImgListCheese3 + "<br>" +
                        "Patty: " + ImgListPatty3 + "<br>" +
                        "Vegetable: " + ImgListVeg3 + "<br>" +
                        "Condiment: " + ImgListCondiment3 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Patty_melt.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName3.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName3.get(0).equals("Bacon cheese burger")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun3 + "<br>" +
                        "Cheese: " + ImgListCheese3 + "<br>" +
                        "Patty: " + ImgListPatty3 + "<br>" +
                        "Vegetable: " + ImgListVeg3 + "<br>" +
                        "Condiment: " + ImgListCondiment3 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Bacon_cheese_burger.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName3.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName3.get(0).equals("Beef cheese burger")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun3 + "<br>" +
                        "Cheese: " + ImgListCheese3 + "<br>" +
                        "Patty: " + ImgListPatty3 + "<br>" +
                        "Vegetable: " + ImgListVeg3 + "<br>" +
                        "Condiment: " + ImgListCondiment3 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Beef_cheese_burger.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName3.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName3.get(0).equals("Black and blue burger")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun3 + "<br>" +
                        "Cheese: " + ImgListCheese3 + "<br>" +
                        "Patty: " + ImgListPatty3 + "<br>" +
                        "Vegetable: " + ImgListVeg3 + "<br>" +
                        "Condiment: " + ImgListCondiment3 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Black_and_blue_burger.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName3.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName3.get(0).equals("Double cheese burger")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun3 + "<br>" +
                        "Cheese: " + ImgListCheese3 + "<br>" +
                        "Patty: " + ImgListPatty3 + "<br>" +
                        "Vegetable: " + ImgListVeg3 + "<br>" +
                        "Condiment: " + ImgListCondiment3 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Double_cheese_burger.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName3.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName3.get(0).equals("Juicy lucy burger")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun3 + "<br>" +
                        "Cheese: " + ImgListCheese3 + "<br>" +
                        "Patty: " + ImgListPatty3 + "<br>" +
                        "Vegetable: " + ImgListVeg3 + "<br>" +
                        "Condiment: " + ImgListCondiment3 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Juicy_lucy_burger.jpeg");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName3.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName3.get(0).equals("Mushroom and Swiss")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun3 + "<br>" +
                        "Cheese: " + ImgListCheese3 + "<br>" +
                        "Patty: " + ImgListPatty3 + "<br>" +
                        "Vegetable: " + ImgListVeg3 + "<br>" +
                        "Condiment: " + ImgListCondiment3 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Mushroom_and_Swiss.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName3.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName3.get(0).equals("The Works")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun3 + "<br>" +
                        "Cheese: " + ImgListCheese3 + "<br>" +
                        "Patty: " + ImgListPatty3 + "<br>" +
                        "Vegetable: " + ImgListVeg3 + "<br>" +
                        "Condiment: " + ImgListCondiment3 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\The_Works.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName3.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName3.get(0).equals("Beef patty burgur")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun3 + "<br>" +
                        "Cheese: " + ImgListCheese3 + "<br>" +
                        "Patty: " + ImgListPatty3 + "<br>" +
                        "Vegetable: " + ImgListVeg3 + "<br>" +
                        "Condiment: " + ImgListCondiment3 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Beef_patty_burgur.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName3.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            if(ImgBurgerName3.get(0).equals("Chicken patty burgur")) {
	            // Create a JLabel with a message
            	JLabel messageLabel = new JLabel("<html>Bun: " + ImgListBun3 + "<br>" +
                        "Cheese: " + ImgListCheese3 + "<br>" +
                        "Patty: " + ImgListPatty3 + "<br>" +
                        "Vegetable: " + ImgListVeg3 + "<br>" +
                        "Condiment: " + ImgListCondiment3 + "</html>");
	            
	            // Create an ImageIcon object
	            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\Chicken_patty_burger.png");
	            
	            // Create a JLabel object with the ImageIcon
	            JLabel imglabel = new JLabel(icon);
	            
	            // Create a JPanel to combine the message and the image
	            JPanel panel = new JPanel(new BorderLayout());
	            panel.add(messageLabel, BorderLayout.NORTH);
	            panel.add(imglabel, BorderLayout.CENTER);
	            
	            // Show the JOptionPane with the JLabel as its message
	            JOptionPane.showOptionDialog(null, panel, ImgBurgerName3.get(0), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
            
            // Pop Up burger
        }catch(Exception e){
            e.printStackTrace();
            JLabel messageLabel = new JLabel("We don't have any burger that suit to your eating style");
            // Create an ImageIcon object
            ImageIcon icon = new ImageIcon("C:\\Users\\Methas\\eclipse-workspace\\Burger\\src\\BurgerPack\\!!!.png");
            
            // Create a JLabel object with the ImageIcon
            JLabel imglabel = new JLabel(icon);
            
            // Create a JPanel to combine the message and the image
            JPanel panel = new JPanel(new BorderLayout());
            panel.add(messageLabel, BorderLayout.NORTH);
            panel.add(imglabel, BorderLayout.CENTER);
            
            // Show the JOptionPane with the JLabel as its message
            JOptionPane.showOptionDialog(null, panel, "!!!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void NameListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameListActionPerformed

    // no use
    private void ComponentListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComponentListActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_ComponentListActionPerformed

    // Search ALL
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String KeywordFieldValue = KeywordField.getText();
        System.out.println(KeywordFieldValue);
        
        String[] tableColumnsName = {"Burger Name","Bun","Patty","Vegtable","Cheese","Condiment"}; 
        DefaultTableModel aModel = (DefaultTableModel) TableComputer.getModel();
        aModel.setColumnIdentifiers(tableColumnsName);
        aModel.setRowCount(0);
        // the query
        
        
        System.out.println("Getting Burger Detail");  // get 
        String queryString;
               queryString = "PREFIX ex: <http://www.semanticweb.org/burger#> "
                             +"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                             +"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
                             + "SELECT (str(?nameBurger) as ?NameBurger) (str(?bunDis) as ?BunDis) (str(?patty) as ?Patty) (str(?veg) as ?Veg) (str(?cheese) as ?Cheese) (str(?condiment) as ?Condiment)"
                             + "where {?x ex:name ?bun."
                             + "FILTER regex(?bun, \""+KeywordFieldValue+"\")"
                             + "?y ex:hasBun ?x." // เอาไว้เทียบ query
                             + "?y ex:hasBun ?b. ?b ex:name ?bunDis."
                             + "?y ex:hasPatty ?p. ?p ex:name ?patty."
                             + "?y ex:hasCheese ?c. ?c ex:name ?cheese."
                             + "?y ex:hasVegetable ?v. ?v ex:name ?veg."
                             + "?y ex:hasCondiment ?con. ?con ex:name ?condiment."
                             + "?y ex:name ?nameBurger."
                             + " }";
        System.out.println(queryString);
        org.apache.jena.query.ResultSet results = OpenOWL.ExecSparQl(queryString); //all method ExecSparQl from OpenOWL class

        while (results.hasNext()) {

            QuerySolution sol = results.nextSolution();
            RDFNode Name = sol.get("NameBurger");
            RDFNode Bun = sol.get("BunDis"); 
            RDFNode Patty = sol.get("Patty");
            RDFNode Veg = sol.get("Veg");
            RDFNode Cheese = sol.get("Cheese");
            RDFNode Condiment = sol.get("Condiment");

            aModel.addRow(new Object[]{ Name, Bun, Patty, Veg, Cheese, Condiment});

            TableComputer.setModel(aModel); 

                }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void CheeseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String KeywordFieldValue = KeywordField.getText();
        System.out.println(KeywordFieldValue);
        
        String[] tableColumnsName = {"Burger Name","Bun","Patty","Vegtable","Cheese","Condiment"}; 
        DefaultTableModel aModel = (DefaultTableModel) TableComputer.getModel();
        aModel.setColumnIdentifiers(tableColumnsName);
        aModel.setRowCount(0);
        // the query
        
        
        System.out.println("Getting Burger Detail");  // get 
        String queryString;
               queryString = "PREFIX ex: <http://www.semanticweb.org/burger#> "
                             +"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                             +"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
                             + "SELECT (str(?nameBurger) as ?NameBurger) (str(?bunDis) as ?BunDis) (str(?patty) as ?Patty) (str(?veg) as ?Veg) (str(?cheese) as ?Cheese) (str(?condiment) as ?Condiment)"
                             + "where {?x ex:name ?search."
                             + "FILTER regex(?search, \""+KeywordFieldValue+"\")"
                             + "?y ex:hasCheese ?x." // เอาไว้เทียบ query
                             + "?y ex:hasBun ?b. ?b ex:name ?bunDis."
                             + "?y ex:hasPatty ?p. ?p ex:name ?patty."
                             + "?y ex:hasCheese ?c. ?c ex:name ?cheese."
                             + "?y ex:hasVegetable ?v. ?v ex:name ?veg."
                             + "?y ex:hasCondiment ?con. ?con ex:name ?condiment."
                             + "?y ex:name ?nameBurger."
                             + " }";
        System.out.println(queryString);
        org.apache.jena.query.ResultSet results = OpenOWL.ExecSparQl(queryString); //all method ExecSparQl from OpenOWL class

        while (results.hasNext()) {

            QuerySolution sol = results.nextSolution();
            RDFNode Name = sol.get("NameBurger");
            RDFNode Bun = sol.get("BunDis"); 
            RDFNode Patty = sol.get("Patty");
            RDFNode Veg = sol.get("Veg");
            RDFNode Cheese = sol.get("Cheese");
            RDFNode Condiment = sol.get("Condiment");

            aModel.addRow(new Object[]{ Name, Bun, Patty, Veg, Cheese, Condiment});

            TableComputer.setModel(aModel); 

                }
    }
    
    private void CondimentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String KeywordFieldValue = KeywordField.getText();
        System.out.println(KeywordFieldValue);
        
        String[] tableColumnsName = {"Burger Name","Bun","Patty","Vegtable","Cheese","Condiment"}; 
        DefaultTableModel aModel = (DefaultTableModel) TableComputer.getModel();
        aModel.setColumnIdentifiers(tableColumnsName);
        aModel.setRowCount(0);
        // the query
        
        
        System.out.println("Getting Burger Detail");  // get 
        String queryString;
               queryString = "PREFIX ex: <http://www.semanticweb.org/burger#> "
                             +"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                             +"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
                             + "SELECT (str(?nameBurger) as ?NameBurger) (str(?bunDis) as ?BunDis) (str(?patty) as ?Patty) (str(?veg) as ?Veg) (str(?cheese) as ?Cheese) (str(?condiment) as ?Condiment)"
                             + "where {?x ex:name ?search."
                             + "FILTER regex(?search, \""+KeywordFieldValue+"\")"
                             + "?y ex:hasCondiment ?x." // เอาไว้เทียบ query
                             + "?y ex:hasBun ?b. ?b ex:name ?bunDis."
                             + "?y ex:hasPatty ?p. ?p ex:name ?patty."
                             + "?y ex:hasCheese ?c. ?c ex:name ?cheese."
                             + "?y ex:hasVegetable ?v. ?v ex:name ?veg."
                             + "?y ex:hasCondiment ?con. ?con ex:name ?condiment."
                             + "?y ex:name ?nameBurger."
                             + " }";
        System.out.println(queryString);
        org.apache.jena.query.ResultSet results = OpenOWL.ExecSparQl(queryString); //all method ExecSparQl from OpenOWL class

        while (results.hasNext()) {

            QuerySolution sol = results.nextSolution();
            RDFNode Name = sol.get("NameBurger");
            RDFNode Bun = sol.get("BunDis"); 
            RDFNode Patty = sol.get("Patty");
            RDFNode Veg = sol.get("Veg");
            RDFNode Cheese = sol.get("Cheese");
            RDFNode Condiment = sol.get("Condiment");

            aModel.addRow(new Object[]{ Name, Bun, Patty, Veg, Cheese, Condiment});

            TableComputer.setModel(aModel); 

                }
    }
    
    private void PattyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String KeywordFieldValue = KeywordField.getText();
        System.out.println(KeywordFieldValue);
        
        String[] tableColumnsName = {"Burger Name","Bun","Patty","Vegtable","Cheese","Condiment"}; 
        DefaultTableModel aModel = (DefaultTableModel) TableComputer.getModel();
        aModel.setColumnIdentifiers(tableColumnsName);
        aModel.setRowCount(0);
        // the query
        
        
        System.out.println("Getting Burger Detail");  // get 
        String queryString;
               queryString = "PREFIX ex: <http://www.semanticweb.org/burger#> "
                             +"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                             +"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
                             + "SELECT (str(?nameBurger) as ?NameBurger) (str(?bunDis) as ?BunDis) (str(?patty) as ?Patty) (str(?veg) as ?Veg) (str(?cheese) as ?Cheese) (str(?condiment) as ?Condiment)"
                             + "where {?x ex:name ?search."
                             + "FILTER regex(?search, \""+KeywordFieldValue+"\")"
                             + "?y ex:hasPatty ?x." // เอาไว้เทียบ query
                             + "?y ex:hasBun ?b. ?b ex:name ?bunDis."
                             + "?y ex:hasPatty ?p. ?p ex:name ?patty."
                             + "?y ex:hasCheese ?c. ?c ex:name ?cheese."
                             + "?y ex:hasVegetable ?v. ?v ex:name ?veg."
                             + "?y ex:hasCondiment ?con. ?con ex:name ?condiment."
                             + "?y ex:name ?nameBurger."
                             + " }";
        System.out.println(queryString);
        org.apache.jena.query.ResultSet results = OpenOWL.ExecSparQl(queryString); //all method ExecSparQl from OpenOWL class

        while (results.hasNext()) {

            QuerySolution sol = results.nextSolution();
            RDFNode Name = sol.get("NameBurger");
            RDFNode Bun = sol.get("BunDis"); 
            RDFNode Patty = sol.get("Patty");
            RDFNode Veg = sol.get("Veg");
            RDFNode Cheese = sol.get("Cheese");
            RDFNode Condiment = sol.get("Condiment");

            aModel.addRow(new Object[]{ Name, Bun, Patty, Veg, Cheese, Condiment});

            TableComputer.setModel(aModel); 

                }
    }
    
    private void VegetableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String KeywordFieldValue = KeywordField.getText();
        System.out.println(KeywordFieldValue);
        
        String[] tableColumnsName = {"Burger Name","Bun","Patty","Vegtable","Cheese","Condiment"}; 
        DefaultTableModel aModel = (DefaultTableModel) TableComputer.getModel();
        aModel.setColumnIdentifiers(tableColumnsName);
        aModel.setRowCount(0);
        // the query
        
        
        System.out.println("Getting Burger Detail");  // get 
        String queryString;
               queryString = "PREFIX ex: <http://www.semanticweb.org/burger#> "
                             +"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                             +"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
                             + "SELECT (str(?nameBurger) as ?NameBurger) (str(?bunDis) as ?BunDis) (str(?patty) as ?Patty) (str(?veg) as ?Veg) (str(?cheese) as ?Cheese) (str(?condiment) as ?Condiment)"
                             + "where {?x ex:name ?search."
                             + "FILTER regex(?search, \""+KeywordFieldValue+"\")"
                             + "?y ex:hasVegetable ?x." // เอาไว้เทียบ query
                             + "?y ex:hasBun ?b. ?b ex:name ?bunDis."
                             + "?y ex:hasPatty ?p. ?p ex:name ?patty."
                             + "?y ex:hasCheese ?c. ?c ex:name ?cheese."
                             + "?y ex:hasVegetable ?v. ?v ex:name ?veg."
                             + "?y ex:hasCondiment ?con. ?con ex:name ?condiment."
                             + "?y ex:name ?nameBurger."
                             + " }";
        System.out.println(queryString);
        org.apache.jena.query.ResultSet results = OpenOWL.ExecSparQl(queryString); //all method ExecSparQl from OpenOWL class

        while (results.hasNext()) {

            QuerySolution sol = results.nextSolution();
            RDFNode Name = sol.get("NameBurger");
            RDFNode Bun = sol.get("BunDis"); 
            RDFNode Patty = sol.get("Patty");
            RDFNode Veg = sol.get("Veg");
            RDFNode Cheese = sol.get("Cheese");
            RDFNode Condiment = sol.get("Condiment");

            aModel.addRow(new Object[]{ Name, Bun, Patty, Veg, Cheese, Condiment});

            TableComputer.setModel(aModel); 

                }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DisplayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayFrame().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CheeseList;
    private javax.swing.JTextField KeywordField;
    private javax.swing.JComboBox<String> CondimentList;
    private javax.swing.JTable TableComputer;
    private javax.swing.JButton SearchBunButton;
    private javax.swing.JButton SearchCheeseButton;
    private javax.swing.JButton SearchCondimentButton;
    private javax.swing.JButton SearchPattyButton;
    private javax.swing.JButton SearchVegetableButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private JComboBox BunList;
    private JComboBox PattyList;
    private JComboBox VegetableList;
    private JLabel jLabel1_1;
}
