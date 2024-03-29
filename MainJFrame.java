package rs.itcentar.katalog_proizvoda;

import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Java
 */
public class MainJFrame extends javax.swing.JFrame {

    private TableRowSorter<KatalogProizvodaTableModel> sorter;
    private KatalogProizvodaTableModel model;

    public MainJFrame() {
        initComponents();
        //Kreirammo tabelu sa nasim modelom i sorterom.
        model = new KatalogProizvodaTableModel();
        sorter = new TableRowSorter<>(model);
        tableProizvodi.setModel(model);
        tableProizvodi.setRowSorter(sorter);

        //Svaki put kad se polje tfFilterSearch promeni, poziva se filter metoda.
        tfFilterSearch.getDocument().addDocumentListener(
                new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filter();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfFilterSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProizvodi = new javax.swing.JTable();
        buttonAdd = new javax.swing.JButton();
        buttonRemove = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        l1 = new javax.swing.JLabel();
        bClearSearch = new javax.swing.JButton();
        bPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableProizvodi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableProizvodi);

        buttonAdd.setText("Add");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonRemove.setText("Remove");
        buttonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveActionPerformed(evt);
            }
        });

        buttonEdit.setText("Edit");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        l1.setText("Search:");

        bClearSearch.setText("clear search");
        bClearSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearSearchActionPerformed(evt);
            }
        });

        bPrint.setText("Print");
        bPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(tfFilterSearch))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bClearSearch))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bPrint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEdit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFilterSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(bClearSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEdit)
                    .addComponent(buttonRemove)
                    .addComponent(buttonAdd)
                    .addComponent(bPrint))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveActionPerformed
        int viewRow = tableProizvodi.getSelectedRow();

        if (viewRow >= 0) {
            int row = tableProizvodi.convertRowIndexToModel(viewRow);
            int result = JOptionPane.showConfirmDialog(this, "Da li zelite da izbrisete izabrani element", "Brisi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            System.out.println(result);

            if (result == JOptionPane.YES_OPTION) {
                // filtriranje i sortiranje mogu promeniti indexe redova u tabeli,
                // tako da se index reda u prikazu tabele razlikuje od onog u
                // modelu; da ne bi selekcija prikazala pogresan
                // proizvod,selektovani index je konvertovan u index modela

                model.removeProizvod(row);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nije nista selektovano", "Greska", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buttonRemoveActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        
        AddProizvodiPanel panel = new AddProizvodiPanel();
        int result = JOptionPane.showConfirmDialog(this, panel, "Dodaj proizvod", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            model.addProizvod(panel.getProizvodi());
        }
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed

        // filtriranje i sortiranje mogu promeniti indexe redova u tabeli, tako
        // da se index reda u prikazu tabele razlikuje od onog u modelu; da ne
        // bi selekcija prikazala pogresan proizvod,selektovani index je
        // konvertovan u index modela
        int viewRow = tableProizvodi.getSelectedRow();
        if (viewRow >= 0) {
            
            int modelRow = tableProizvodi.convertRowIndexToModel(viewRow);
            EditProizvodiPanel panel = new EditProizvodiPanel(model.getProizvodByIndex(modelRow));
            int result = JOptionPane.showConfirmDialog(this, panel, "Edit", JOptionPane.CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                model.updateProizvod(panel.getProizvodi(), modelRow);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nije nista selektovano", "Greska", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_buttonEditActionPerformed

    private void bClearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearSearchActionPerformed
        tfFilterSearch.setText("");
    }//GEN-LAST:event_bClearSearchActionPerformed

    private void bPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPrintActionPerformed
        try {
            tableProizvodi.print();
        } catch (PrinterException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_bPrintActionPerformed

    //  Filtrira tabelu prema unetom tekstu iz tfFilterSearch polja. 
    //  Index, ili vise njih, koji prosledimo u regexFilter metod odnosi se na 
    //  kolonu koja ce biti filtrirana, ako ne unesemo index cela tabela se filtrira
    private void filter() {
        RowFilter<KatalogProizvodaTableModel, Object> rf = null;
        try {
            //filter je case insensitive(?i) i filtrira se tek posle 2 uneta karaktera
            if (tfFilterSearch.getText().trim().length() > 2) {
                rf = RowFilter.regexFilter("(?i)" + tfFilterSearch.getText(), 0);
            }
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClearSearch;
    private javax.swing.JButton bPrint;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l1;
    private javax.swing.JTable tableProizvodi;
    private javax.swing.JTextField tfFilterSearch;
    // End of variables declaration//GEN-END:variables
}
