/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sst.softfacture.views;

import com.sst.softfacture.controller.FichFactureJpaController;
import com.sst.softfacture.controller.exceptions.PreexistingEntityException;
import com.sst.softfacture.db.DBHandler;
import com.sst.softfacture.model.FichDetailFacture;
import com.sst.softfacture.model.FichFacture;
import com.sst.softfacture.utils.FrenchNumberToWords;
import java.awt.Frame;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Neji Med Walid << medwalid.neji@bitaka.com.tn >>
 */
public class Luncher extends javax.swing.JFrame {

    private static Luncher instance;
    private List<FichDetailFacture> listFichDetailsFacture;
    private FichFacture fichFacture;
    private float mnt_ht = 0, mnt_ttc = 0, tva_12 = 0, tva_18 = 0, base_12 = 0, base_18 = 0, base_6 = 0, tva_6 = 0;
    private int numFacture;
    private NumberFormat formatter = null;
    private static final String REPORT_NAME= "./reports/original_facture.jrxml";

    private Luncher() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Luncher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
        this.setTitle("SOFTFACTURE ...~GENERER FACTURE");
        fichFacture = new FichFacture();
        listFichDetailsFacture = new ArrayList<>();
        formatter = java.text.NumberFormat.getInstance(java.util.Locale.FRENCH);
        FichFactureJpaController ffjc = new FichFactureJpaController(DBHandler.instance());
        FichFacture fct = ffjc.lastNumFacture();
        if (fct != null) {
            numFacture = fct.getNumFact() + 1;
        } else {
            numFacture = 1;
        }
        jLabel10.setText(String.valueOf(numFacture));
        this.setExtendedState(Frame.MAXIMIZED_BOTH);

    }

    public static Luncher getInstance() {
        if (Luncher.instance == null) {
            Luncher.instance = new Luncher();
        }
        return Luncher.instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        date_facture = new com.toedter.calendar.JDateChooser();
        client_zone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        produit_zone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PU_zone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jButton3 = new javax.swing.JButton();
        tva_zone = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        qte_zone = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(89, 6, 105));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Facture SST SOFT");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "En tête Facture", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel2.setText("Date Facture :");

        jLabel3.setText("Libelle client :");

        jLabel9.setText("NUMERO FACTURE SUIVANTE :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(date_facture, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(client_zone, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addGap(67, 67, 67)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(client_zone)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date_facture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Corps de la Facture", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel4.setText("Libelle Produit :");

        jLabel5.setText("Quantite :");

        jLabel6.setText("PU. HT :");

        jLabel7.setText("TVA :");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 153));
        jButton1.setText("Ajouter PRODUIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESIGNATION", "QTE", "P.U.H TVA", "TVA", "TOTAL H TVA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jXTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jXTable1);

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 0, 0));
        jButton3.setText("Supprimer Produit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tva_zone.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "6", "12", "18" }));

        jLabel8.setText("DT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(produit_zone, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(qte_zone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PU_zone, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tva_zone, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(54, 54, 54)
                .addComponent(jButton1)
                .addContainerGap(250, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addComponent(jButton3))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(produit_zone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(qte_zone, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PU_zone)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tva_zone)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton2.setBackground(new java.awt.Color(102, 204, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 153));
        jButton2.setText("GENERER FACTURE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(102, 102, 255));
        jButton4.setText("APERCU");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jMenu1.setText("Fenetres");

        jMenuItem1.setText("HISTORIQUE FACTURES");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void viderZone() {
        produit_zone.setText("");
        qte_zone.setText("0");
        PU_zone.setText("");
        tva_zone.setSelectedIndex(0);

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!produit_zone.getText().isEmpty() && !PU_zone.getText().isEmpty()) {
            formatter = new DecimalFormat("#0.000");
            FichDetailFacture detailFacture = new FichDetailFacture();
            detailFacture.setLibelleProduit(produit_zone.getText());
            detailFacture.setFkFacture(fichFacture);
            detailFacture.setPuHt(Float.parseFloat(PU_zone.getText()));
            detailFacture.setQte(Float.parseFloat(qte_zone.getText()));
            detailFacture.setTva(Integer.parseInt(tva_zone.getSelectedItem().toString()));
            DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
            model.addRow(new Object[]{"" + produit_zone.getText() + "", "" + qte_zone.getText() + "",
                "" + formatter.format(Double.parseDouble(PU_zone.getText())) + "", "" + tva_zone.getSelectedItem() + "",
                "" + formatter.format(Double.parseDouble(String.valueOf(detailFacture.getQte() * detailFacture.getPuHt()))) + ""});

            listFichDetailsFacture.add(detailFacture);
            switch (tva_zone.getSelectedItem().toString()) {
                case "12":
                    tva_12 += 0.12 * (detailFacture.getQte() * detailFacture.getPuHt());
                    base_12 += (detailFacture.getQte() * detailFacture.getPuHt());
                    break;
                case "18":
                    tva_18 += 0.18 * (detailFacture.getQte() * detailFacture.getPuHt());
                    base_18 += (detailFacture.getQte() * detailFacture.getPuHt());
                    break;
                case "6":
                    tva_6 += 0.06 * (detailFacture.getQte() * detailFacture.getPuHt());
                    base_6 += (detailFacture.getQte() * detailFacture.getPuHt());
                    break;
                default:
                    break;
            }
            mnt_ht += (detailFacture.getQte() * detailFacture.getPuHt());
            produit_zone.requestFocusInWindow();
            viderZone();
        } else {
            JOptionPane.showMessageDialog(null, "VEUILLEZ REMPLISSEZ LES CHAMPS !");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    public String formatNumber(float number) {
        return formatter.format(Double.parseDouble(String.valueOf(number)));
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (listFichDetailsFacture.size() > 0) {
            int choix = JOptionPane.showConfirmDialog(null, "Vous êtes sur de génerer une facture ?", "CONFIRMATION FACTURE", JOptionPane.YES_NO_OPTION);
            if (choix == 0) {
                try {
                    // TODO add your handling code here:
                    calclulNumFact();
                    SimpleDateFormat sf = new SimpleDateFormat("dd/MM/YYYY");
                    fichFacture.setNumFact(numFacture);
                    fichFacture.setLibelleClient(client_zone.getText());
                    fichFacture.setDateFactureD(date_facture.getDate());
                    fichFacture.setDateFacture(sf.format(date_facture.getDate()));
                    fichFacture.setMntHt(mnt_ht);
                    fichFacture.setTotTva(tva_12 + tva_18 + tva_6);
                    fichFacture.setTimbre(Float.parseFloat("0.500"));
                    mnt_ttc = tva_12 + tva_18 + tva_6 + mnt_ht + fichFacture.getTimbre();
                    int pos = String.valueOf(mnt_ttc).indexOf(".");
                    if (String.valueOf(mnt_ttc).substring(pos).length() > 3) {
                        mnt_ttc = Float.parseFloat(String.valueOf(String.valueOf(mnt_ttc).subSequence(0, pos + 4)));
                    }
                    fichFacture.setMntTtc(mnt_ttc);
                    fichFacture.setFichDetailFactureList(listFichDetailsFacture);

                    FichFactureJpaController ffjc = new FichFactureJpaController(DBHandler.instance());
                    ffjc.create(fichFacture);

                    String lettre_mnt_ttc = FrenchNumberToWords.convert(mnt_ttc);
                    try {
                        // TODO add your handling code here:

                        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM yyyy");
                        DefaultTableModel de = (DefaultTableModel) jXTable1.getModel();
                        JRTableModelDataSource datasource = new JRTableModelDataSource(de);
                        JasperReport jr = JasperCompileManager.compileReport(REPORT_NAME);
                        Map<String, Object> params = new HashMap<>();
                        params.put("societe", client_zone.getText().toUpperCase());
                        params.put("date_chiffre", sf.format(date_facture.getDate()));
                        params.put("date_lettre", "FACTURE MOIS " + dateFormat.format(date_facture.getDate()).toUpperCase());
                        params.put("facture_numero", "FACTURE N :° " + numFacture);
                        params.put("tot_h_tva", formatNumber(mnt_ht));
                        params.put("tot_tva", formatNumber(tva_12 + tva_18 + tva_6));
                        params.put("timbre", "0.500");
                        params.put("tot_ttc", formatNumber(mnt_ttc));
                        params.put("tva_12", formatNumber(tva_12));
                        params.put("tva_18", formatNumber(tva_18));
                        params.put("tva_6", formatNumber(tva_6));
                        params.put("base_12", formatNumber(base_12));
                        params.put("base_6", formatNumber(base_6));
                        params.put("base_18", formatNumber(base_18));
                        params.put("mnt_lettre", lettre_mnt_ttc);
                        JasperPrint jp = JasperFillManager.fillReport(jr, params, datasource);
                        JasperViewer.viewReport(jp, false);
                        SimpleDateFormat sff = new SimpleDateFormat("dd_MM_YYYY");
                        String client;
                        if (client_zone.getText().contains(" ")) {
                            client = client_zone.getText().replaceAll(" ", "_");
                        } else {
                            client = client_zone.getText();
                        }
                        String chemain = ".\\reports\\" + numFacture + "_" + sff.format(date_facture.getDate()) + "_" + client + ".pdf";
                        JasperExportManager.exportReportToPdfFile(jp, chemain);

                    } catch (JRException ex) {
                        Logger.getLogger(Luncher.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }

                    DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
                    while (model.getRowCount() > 0) {
                        model.removeRow(0);
                    }
                    listFichDetailsFacture = new ArrayList<>();
                    fichFacture = new FichFacture();
                    numFacture++;
                    jLabel10.setText(String.valueOf(numFacture));
                    client_zone.setText("");
                    mnt_ttc = 0;
                    mnt_ht = 0;
                    tva_12 = 0;
                    tva_18 = 0;
                    base_12 = 0;
                    base_18 = 0;
                    base_6 = 0;
                    tva_6 = 0;
                } catch (PreexistingEntityException ex) {
                    Logger.getLogger(Luncher.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Luncher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "VEUILLEZ AJOUTER DES PRODUITS !");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int row = jXTable1.getSelectedRow();
        if (row < 0) {
            JOptionPane.showConfirmDialog(null, "VEUILLEZ SERLECTIONNER UNE LIGNE !");
        } else {
            DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
            switch (Integer.parseInt(model.getValueAt(row, 3).toString())) {
                case 12:
                    tva_12 -= 0.12 * (Integer.parseInt(model.getValueAt(row, 1).toString()) * Float.parseFloat(model.getValueAt(row, 2).toString().replace(",", ".")));
                    base_12 -= Integer.parseInt(model.getValueAt(row, 1).toString()) * Float.parseFloat(model.getValueAt(row, 2).toString().replace(",", "."));
                    break;
                case 18:
                    tva_18 -= 0.18 * (Integer.parseInt(model.getValueAt(row, 1).toString()) * Float.parseFloat(model.getValueAt(row, 2).toString().replace(",", ".")));
                    base_18 -= Integer.parseInt(model.getValueAt(row, 1).toString()) * Float.parseFloat(model.getValueAt(row, 2).toString().replace(",", "."));
                    break;
                case 6:
                    tva_6 -= 0.06 * (Integer.parseInt(model.getValueAt(row, 1).toString()) * Float.parseFloat(model.getValueAt(row, 2).toString().replace(",", ".")));
                    base_6 -= Integer.parseInt(model.getValueAt(row, 1).toString()) * Float.parseFloat(model.getValueAt(row, 2).toString().replace(",", "."));
                    break;
                default:
                    break;
            }
            mnt_ht -= Float.parseFloat(model.getValueAt(row, 4).toString().replace(",", "."));
            model.removeRow(row);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        HistoFacture.getInstance().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void calclulNumFact() {
        FichFactureJpaController ffjc = new FichFactureJpaController(DBHandler.instance());
        FichFacture fct = ffjc.lastNumFacture();
        if (fct != null) {
            numFacture = fct.getNumFact() + 1;
        } else {
            numFacture = 1;
        }
        jLabel10.setText(String.valueOf(numFacture));
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        calclulNumFact();
        mnt_ttc = tva_12 + tva_18 + tva_6 + mnt_ht + (float) (0.500);
        int pos = String.valueOf(mnt_ttc).indexOf(".");
        if (String.valueOf(mnt_ttc).substring(pos).length() > 3) {
            mnt_ttc = Float.parseFloat(String.valueOf(String.valueOf(mnt_ttc).subSequence(0, pos + 4)));
        }
        String lettre_mnt_ttc = FrenchNumberToWords.convert(mnt_ttc);
        try {
            // TODO add your handling code here:
            SimpleDateFormat sf = new SimpleDateFormat("dd/MM/YYYY");
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM yyyy");
            DefaultTableModel de = (DefaultTableModel) jXTable1.getModel();
            JRTableModelDataSource datasource = new JRTableModelDataSource(de);
            JasperReport jr = JasperCompileManager.compileReport(REPORT_NAME);
            Map<String, Object> params = new HashMap<>();
            params.put("societe", client_zone.getText().toUpperCase());
            params.put("date_chiffre", sf.format(date_facture.getDate()));
            params.put("date_lettre", "FACTURE MOIS " + dateFormat.format(date_facture.getDate()).toUpperCase());
            params.put("facture_numero", "FACTURE N :° " + numFacture);
            params.put("tot_h_tva", formatNumber(mnt_ht));
            params.put("tot_tva", formatNumber(tva_12 + tva_18 + tva_6));
            params.put("timbre", "0.500");
            params.put("tva_6", formatNumber(tva_6));
            params.put("tot_ttc", formatNumber(mnt_ttc));
            params.put("tva_12", formatNumber(tva_12));
            params.put("tva_18", formatNumber(tva_18));
            params.put("base_12", formatNumber(base_12));
            params.put("base_18", formatNumber(base_18));
            params.put("base_6", formatNumber(base_6));
            params.put("mnt_lettre", lettre_mnt_ttc);

            JasperPrint jp = JasperFillManager.fillReport(jr, params, datasource);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(Luncher.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PU_zone;
    private javax.swing.JTextField client_zone;
    private com.toedter.calendar.JDateChooser date_facture;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTable jXTable1;
    private javax.swing.JTextField produit_zone;
    private javax.swing.JTextField qte_zone;
    private javax.swing.JComboBox tva_zone;
    // End of variables declaration//GEN-END:variables
}
