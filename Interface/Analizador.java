package Interface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Generador.Tokenizer;
import Generador.ParserException;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;

public class Analizador extends javax.swing.JFrame {
    String Texto;
    String Archivox = "";
    String Tokin = "";
    public Analizador() {
        initComponents();
        
    }
    
    
    
    public void Cleantex(){     
        
    }
    
    
    public void GetTexto(){
        try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {  
            while((Texto=br.readLine())!=null){
                    Archivox = Archivox + Texto + "\n";
                    SetTextPlano.setText(Archivox);
                }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        Archivox = "";
    }
    public void GetToken(){
        Tokenizer tokenizer = new Tokenizer();

        tokenizer.add("\\[]", "DIMENSION");
        tokenizer.add("\\<>", "DISTINTO_QUE");
        tokenizer.add("\\>=", "MAYOR_IGUAL_QUE");
        tokenizer.add("\\<=", "MENOR_IGUAL_QUE");
        tokenizer.add("\\<--", "ASIGNACION");
        tokenizer.add("sin|cos|exp|ln|sqrt", "FUNCION");
        tokenizer.add("\\&", "CONJUNCION");
        tokenizer.add("\\|", "DISYUNCION");
        tokenizer.add("\\~", "NEGACION");
        tokenizer.add("\\(", "PAR_DER");
        tokenizer.add("\\)", "PAR_IZQ");
        tokenizer.add("\\+", "SUMA");
        tokenizer.add("\\-", "RESTA");
        tokenizer.add("\\*", "MULTIPLICACION");
        tokenizer.add("\\/", "DIVISION");
        tokenizer.add("\\^", "POTENCIA");
        tokenizer.add("\\>", "MAYOR_QUE");
        tokenizer.add("\\<", "MENOR_QUE");
        tokenizer.add("\\=", "IGUAL_QUE"); 
        tokenizer.add("[0-9]+", "NUMERO");
        tokenizer.add("ALGORITMO|algoritmo", "PALABRAS_CLAVE_ALGORITMO");
        tokenizer.add("INICIO|inicio", "PALABRAS_CLAVE_INI");
        tokenizer.add("LEER|leer", "INSTRUCCION_LEER");
        tokenizer.add("ESCRIBIR|escribir", "INSTRUCCION_ESCRIBIR");
        //tokenizer.add("DO|WHILE|FOR", "PALABRA_RESERVADA");
        tokenizer.add("SINO|sino", "CONDICIONAL_SINO");
        tokenizer.add("SI|si", "CONDICIONAL_SI");
        tokenizer.add("ENTONCES|entonces", "CONDICIONAL_ENTONCES");
        tokenizer.add("FINSI|finsi", "CONDICIONAL_FINSI");
        tokenizer.add("HACER|hacer", "CONDICIONAL_HACER");
        tokenizer.add("SEGUN|DEOTROMODO|FINSEGUN|segun|deotromodo|finsegun", "SELECCION_MULTIPLE");
        tokenizer.add("MIENTRAS|FINMIENTRAS|mientras|finmientras", "CONDICIONAL_MIENTRAS");
        tokenizer.add("REPETIR|HASTAQUE|repetir|hastaque", "CONDICIONAL_REPETIR");
        tokenizer.add("PARA|FINPARA|para|finpara", "CONDICIONAL_PARA");

        //tokenizer.add("[a-zA-Z]", "PALABRA");
        tokenizer.add("FIN|fin", "PALABRAS_CLAVE_FIN");
        tokenizer.add("[a-zA-Z][a-zA-Z0-9]*", "IDENTIFICADOR");
        //tokenizer.add("[a-zA-Z]*", "PALABRA");
        //tokenizer.add("[a-zA-Z][a-zA-Z]*", "PALABRA");
        // tokenizer.add("[\\\"a-zA-Z\\\" ]*", "STRING");
        
        
        try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
		try{	 tokenizer.tokenize(linea);
                    for (Tokenizer.Token tok : tokenizer.getTokens()){
                        //System.out.println("(" + tok.token + " , " + tok.sequence + ")");
                        Tokin = Tokin + "(" + tok.token + " , " + tok.sequence + ")" + "\n";
                        SetTextToken.setText(Tokin);
                    }
                }catch (ParserException e){
                    Tokin = Tokin + e.getMessage() + "\n";
                    SetTextToken.setText(Tokin);
                    //System.out.println(e.getMessage());   
                }				
            }

	} catch (IOException e) {
            e.printStackTrace();
	}
         Tokin = "";
      
    }
    
    public void GetTokenTexA(){
        Tokenizer tokenizer = new Tokenizer();
        Tokin = "";
        tokenizer.add("\\[]", "DIMENSION");
        tokenizer.add("\\<>", "DISTINTO_QUE");
        tokenizer.add("\\>=", "MAYOR_IGUAL_QUE");
        tokenizer.add("\\<=", "MENOR_IGUAL_QUE");
        tokenizer.add("\\<--", "ASIGNACION");
        tokenizer.add("sin|cos|exp|ln|sqrt", "FUNCION");
        tokenizer.add("\\&", "CONJUNCION");
        tokenizer.add("\\|", "DISYUNCION");
        tokenizer.add("\\~", "NEGACION");
        tokenizer.add("\\(", "PAR_DER");
        tokenizer.add("\\)", "PAR_IZQ");
        tokenizer.add("\\+", "SUMA");
        tokenizer.add("\\-", "RESTA");
        tokenizer.add("\\*", "MULTIPLICACION");
        tokenizer.add("\\/", "DIVISION");
        tokenizer.add("\\^", "POTENCIA");
        tokenizer.add("\\>", "MAYOR_QUE");
        tokenizer.add("\\<", "MENOR_QUE");
        tokenizer.add("\\=", "IGUAL_QUE"); 
        tokenizer.add("[0-9]+", "NUMERO");
        tokenizer.add("ALGORITMO|algoritmo", "PALABRAS_CLAVE_ALGORITMO");
        tokenizer.add("INICIO|inicio", "PALABRAS_CLAVE_INI");
        tokenizer.add("LEER|leer", "INSTRUCCION_LEER");
        tokenizer.add("ESCRIBIR|escribir", "INSTRUCCION_ESCRIBIR");
        //tokenizer.add("DO|WHILE|FOR", "PALABRA_RESERVADA");
        tokenizer.add("SINO|sino", "CONDICIONAL_SINO");
        tokenizer.add("SI|si", "CONDICIONAL_SI");
        tokenizer.add("ENTONCES|entonces", "CONDICIONAL_ENTONCES");
        tokenizer.add("FINSI|finsi", "CONDICIONAL_FINSI");
        tokenizer.add("HACER|hacer", "CONDICIONAL_HACER");
        tokenizer.add("SEGUN|DEOTROMODO|FINSEGUN|segun|deotromodo|finsegun", "SELECCION_MULTIPLE");
        tokenizer.add("MIENTRAS|FINMIENTRAS|mientras|finmientras", "CONDICIONAL_MIENTRAS");
        tokenizer.add("REPETIR|HASTAQUE|repetir|hastaque", "CONDICIONAL_REPETIR");
        tokenizer.add("PARA|FINPARA|para|finpara", "CONDICIONAL_PARA");

        //tokenizer.add("[a-zA-Z]", "PALABRA");
        tokenizer.add("FIN|fin", "PALABRAS_CLAVE_FIN");
        tokenizer.add("[a-zA-Z][a-zA-Z0-9]*", "IDENTIFICADOR");
        //tokenizer.add("[a-zA-Z]*", "PALABRA");
        //tokenizer.add("[a-zA-Z][a-zA-Z]*", "PALABRA");
        // tokenizer.add("[\\\"a-zA-Z\\\" ]*", "STRING");
        
        String x = SetTextPlano.getText();
        try{
            File archivo=new File("Datos.txt");
            FileWriter escribir=new FileWriter(archivo,true);
                escribir.write(x); 
                escribir.close();
        }
        catch(Exception e){
                System.out.println("Error al escribir");
            }
        x = "";
        try (BufferedReader br = new BufferedReader(new FileReader("Datos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
		try{	 tokenizer.tokenize(linea);
                    for (Tokenizer.Token tok : tokenizer.getTokens()){
                        //System.out.println("(" + tok.token + " , " + tok.sequence + ")");
                        Tokin = Tokin + "(" + tok.token + " , " + tok.sequence + ")" + "\n";
                        SetTextToken.setText(Tokin);
                    }
                }catch (ParserException e){
                    Tokin = Tokin + e.getMessage() + "\n";
                    SetTextToken.setText(Tokin);
                    //System.out.println(e.getMessage());   
                }				
            }

	} catch (IOException e) {
            e.printStackTrace();
	}
        Tokin = "";
        File archivo=new File("Datos.txt");
        archivo.delete();
    }
    
    
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        SetTextPlano = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        SetTextToken = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 204));

        SetTextPlano.setColumns(20);
        SetTextPlano.setRows(5);
        jScrollPane1.setViewportView(SetTextPlano);

        SetTextToken.setColumns(20);
        SetTextToken.setRows(5);
        jScrollPane2.setViewportView(SetTextToken);

        jButton1.setText("Iniciar desde archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Texto Plano");

        jLabel2.setText("Tokens");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Proyecto X");

        jButton2.setText("Iniciar desde TextA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("About");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2))
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SetTextPlano.setText(" ");
        SetTextToken.setText(" ");
        GetTexto();
        GetToken();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SetTextToken.setText(" ");
        GetTokenTexA();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JOptionPane.showMessageDialog(null,"Creadores :v \n Acencion Pani Aguilar \n Josue Abisai Reyes Galindo \n Alan Yair Solano Cuevas"); 
    }//GEN-LAST:event_jButton3ActionPerformed


        
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea SetTextPlano;
    private javax.swing.JTextArea SetTextToken;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
