	/**
	 *
	 * @author
	 */
	
	import java.io.BufferedReader;
	import java.io.DataInputStream;
	import java.io.DataOutput;
	import java.io.DataOutputStream;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.net.ServerSocket;
	import java.net.Socket;
	import java.util.HashMap;
	import java.util.Scanner;
	import javax.swing.JTextField;
	
public class Client extends javax.swing.JFrame {
  
	 static Socket socket;  
	 static DataInputStream dIs;  
	 static DataOutputStream dOs;  
	 public Client() {  
	  initComponents();  
	 }  
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	    private void initComponents() {

	        label1 = new java.awt.Label();
	        label2 = new java.awt.Label();
	        jTextField2 = new javax.swing.JTextField();
	        jButton1 = new javax.swing.JButton();
	        jScrollPane1 = new javax.swing.JScrollPane();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        label1.setText("Client");

	        label2.setText("Type your message here");

	        jTextField2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jTextField2ActionPerformed(evt);
	            }
	        });

	        jButton1.setText("Send");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jTextArea1.setColumns(20);
	        jTextArea1.setRows(5);
	        jScrollPane1.setViewportView(jTextArea1);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
	                        .addGap(214, 214, 214)
	                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(0, 229, Short.MAX_VALUE))
	                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
	                        .addGap(29, 29, 29)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                                .addComponent(jTextField2)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(jButton1))
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(0, 0, Short.MAX_VALUE)))))
	                .addGap(26, 26, 26))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(jTextField2)
	                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
	                .addContainerGap(20, Short.MAX_VALUE))
	        );

	        pack();
	    }// </editor-fold>                        

	    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
	        // TODO add your handling code here:
	    }                                           

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        try {  
	            String msgout = "";  
	            msgout = jTextField2.getText().trim();  
	            dOs.writeUTF(msgout);
	            jTextField2.setText("");
	            }catch (Exception e) {}  
	    }                                        
	  
	  public static void main(String args[]) {
	   java.awt.EventQueue.invokeLater(new Runnable() {  
	   public void run() {  
	    new Client().setVisible(true);  
	   }  
	  });  
	  try {  
	   socket = new Socket("127.0.0.1", 12000);  
	   dIs = new DataInputStream(socket.getInputStream());  
	   dOs = new DataOutputStream(socket.getOutputStream());  
	   String msgin = "";  
	   while (!msgin.equals("Exit")) {  
	    msgin = dIs.readUTF();
	    jTextArea1.setText(jTextArea1.getText().trim() + msgin);
	      
	   }  
	  } catch (Exception e) {}  
	 } 
	        
	    // Variables declaration - do not modify                     
	    private javax.swing.JButton jButton1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private static final javax.swing.JTextArea jTextArea1 = new javax.swing.JTextArea();
	    private javax.swing.JTextField jTextField2;
	    private java.awt.Label label1;
	    private java.awt.Label label2;
	    // End of variables declaration                   

}
