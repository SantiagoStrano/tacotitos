/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ar.com.tacotitos.views;

import ar.com.tacotitos.controller.IngredienteController;
import ar.com.tacotitos.controller.PedidoController;
import ar.com.tacotitos.controller.TacoController;
import ar.com.tacotitos.controller.TipoIngredienteController;
import ar.com.tacotitos.dto.IngredienteDTO;
import ar.com.tacotitos.dto.IngredienteTacoDTO;
import ar.com.tacotitos.dto.PedidoDTO;
import ar.com.tacotitos.dto.TacoDTO;
import ar.com.tacotitos.dto.TipoIngredienteDTO;
import ar.com.tacotitos.validator.ValidationMessage;
import ar.com.tacotitos.validator.Validator;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Due
 */
public class NuevoPedidoView extends javax.swing.JFrame {

    private List<TipoIngredienteDTO> listaTipoIngrediente = new ArrayList<TipoIngredienteDTO>();
    private List<IngredienteTacoDTO> listaIngredientesTaco = new ArrayList<IngredienteTacoDTO>();
    private List<IngredienteDTO> listaIngredientes = new ArrayList<IngredienteDTO>();
    private List<IngredienteDTO> listaIngredientesSelected = new ArrayList<IngredienteDTO>();
    
    private IngredienteDTO ingredientePreCargado = new IngredienteDTO();
    
    private Validator validator = new Validator();
    
    private PedidoDTO pedidoSelected = null;
    private Integer precioTotalIngredientes = 0;
    private Integer precioTotalPedido = 0;
    
    IngredienteController ingredienteController = new IngredienteController();
    PedidoController pedidoController = new PedidoController();
    TipoIngredienteController tipoIngredienteController = new TipoIngredienteController();
    TacoController tacoController = new TacoController();
    
    protected List<TipoIngredienteDTO> getLista() {
        return listaTipoIngrediente;
    }
    protected void setLista (List<TipoIngredienteDTO> lista) {
        this.listaTipoIngrediente = lista;
    }
    /**
     * Creates new form NuevoPedido
     */
    public NuevoPedidoView() {
        initComponents();
        listaTipoIngrediente = tipoIngredienteController.getTiposDeIngrediente();
        pedidoSelected = pedidoController.getNuevoPedido();
        System.out.println(pedidoSelected.getId()
                + ", " + pedidoSelected.getFecha()
                + ", " + pedidoSelected.getPrecioTotal());
        popularListaTipoIngredientes(listaTipoIngrediente);
        
        this.setLocationRelativeTo(null);
    }
    public void popularListaTipoIngredientes(List<TipoIngredienteDTO> lista) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) listaTiposDeIngrediente.getModel();
        if (lista != null || !lista.isEmpty()) {
        Object[] data;
        Integer i = 0;
            for (TipoIngredienteDTO dto : lista) {
                model.insertElementAt(dto.getNombre(), i);
                i++;
            }
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIngredientesSeleccionados = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        agregarTacoEnTablaDeTacos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        listaTiposDeIngrediente = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();
        seleccionarIngrediente = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDeTacosDelPedido = new javax.swing.JTable();
        quitarIngredienteDeTablaSeleccionada = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        precioTotalDeIngredientesSeleccionados = new javax.swing.JLabel();
        labelPrecioTotalPedido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pedido");

        tablaIngredientesSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Nombre", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tablaIngredientesSeleccionados);

        jLabel4.setText("Precio");

        agregarTacoEnTablaDeTacos.setText("Agregar Taco");
        agregarTacoEnTablaDeTacos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTacoAlPedido(evt);
            }
        });

        jLabel5.setText("Tipo de Ingrediente");

        listaTiposDeIngrediente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--" }));
        listaTiposDeIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarTipoIngrediente(evt);
            }
        });

        tablaIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio"
            }
        ));
        tablaIngredientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaIngredientesMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablaIngredientes);

        seleccionarIngrediente.setText(" ->");
        seleccionarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aniadirIngredienteAlTaco(evt);
            }
        });

        tablaDeTacosDelPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID del Taco", "Precio"
            }
        ));
        jScrollPane3.setViewportView(tablaDeTacosDelPedido);

        quitarIngredienteDeTablaSeleccionada.setText("Quitar");
        quitarIngredienteDeTablaSeleccionada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarIngredienteDelTaco(evt);
            }
        });

        jButton5.setText("Quitar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarTacoDelPedido(evt);
            }
        });

        jButton6.setText("Finalizar pedido");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarPedido(evt);
            }
        });

        jButton7.setText("Cancelar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarNuevoPedido(evt);
            }
        });

        jLabel3.setText("Total");

        precioTotalDeIngredientesSeleccionados.setText("0");

        labelPrecioTotalPedido.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(331, 331, 331)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(44, 44, 44)
                                .addComponent(precioTotalDeIngredientesSeleccionados))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(76, 76, 76)
                                            .addComponent(labelPrecioTotalPedido))
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(27, 27, 27)
                                        .addComponent(listaTiposDeIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton5)
                                    .addComponent(jButton6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(seleccionarIngrediente)))
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(agregarTacoEnTablaDeTacos)
                            .addComponent(quitarIngredienteDeTablaSeleccionada))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(listaTiposDeIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(seleccionarIngrediente))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quitarIngredienteDeTablaSeleccionada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agregarTacoEnTablaDeTacos)
                        .addGap(128, 128, 128)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(259, 259, 259))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(labelPrecioTotalPedido)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(precioTotalDeIngredientesSeleccionados))))
                        .addContainerGap(151, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarTipoIngrediente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarTipoIngrediente
        // TODO add your handling code here:
        String idTipoIngrediente = listaTiposDeIngrediente.getSelectedItem().toString(); //Trae dato seleccionado del combo   
        TipoIngredienteDTO tiDto = listaTipoIngrediente.stream()
                        .filter(tipoIngredienteDTO -> idTipoIngrediente.equals(tipoIngredienteDTO.getNombre()))
                        .findAny()
                        .orElse(null);
        if (!idTipoIngrediente.equals("--Seleccione--")) {
            listaIngredientes = ingredienteController.getIngredientesPorId(tiDto.getId());
            Object rowData[] = new Object[2];
            DefaultTableModel model = (DefaultTableModel) tablaIngredientes.getModel();
            model.setRowCount(0);//quita los elementos para mostrar los nuevos
            for(IngredienteDTO dto : listaIngredientes) {
                rowData[0] = dto.getNombre();
                rowData[1] = dto.getPrecio();
                model.addRow(rowData);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un tipo de ingrediente valido.");
        }
    }//GEN-LAST:event_buscarTipoIngrediente

    private void tablaIngredientesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaIngredientesMouseReleased
        /*
        SELECCION DEL INGREDIENTE Y ALMACENAR DATO EN CACHE
        */
        int selectedRow = tablaIngredientes.getSelectedRow();
        final String nombreValue = (String)tablaIngredientes.getValueAt(selectedRow, 0);
        final Integer precioValue = (Integer)tablaIngredientes.getValueAt(selectedRow, 1);
        IngredienteDTO iDto = listaIngredientes.stream()
                        .filter(ingredienteDTO -> nombreValue.equals(ingredienteDTO.getNombre()))
                        .findAny()
                        .orElse(null);
        ingredientePreCargado = new IngredienteDTO(
            iDto.getId(),
            iDto.getNombre(),
            iDto.getIdTipoIngrediente(),
            iDto.getPrecio()
        );

    }//GEN-LAST:event_tablaIngredientesMouseReleased

    private void aniadirIngredienteAlTaco(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aniadirIngredienteAlTaco
        // Aprieto boton y mando al taco
        String tipoIngrediente = listaTiposDeIngrediente.getSelectedItem().toString(); //Trae dato seleccionado del combo
        Object rowData[] = new Object[3];
        DefaultTableModel model = (DefaultTableModel) tablaIngredientesSeleccionados.getModel();
                rowData[0] = tipoIngrediente;
                rowData[1] = ingredientePreCargado.getNombre();
                rowData[2] = ingredientePreCargado.getPrecio();
                model.addRow(rowData);  
        
        listaIngredientesSelected.add(ingredientePreCargado);    

        precioTotalIngredientes+=ingredientePreCargado.getPrecio();
        precioTotalDeIngredientesSeleccionados.setText(precioTotalIngredientes.toString());
        //ingredientePreCargado = new IngredienteDTO();
    }//GEN-LAST:event_aniadirIngredienteAlTaco

    private void cancelarNuevoPedido(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarNuevoPedido
        pedidoController.cancelarPedido(pedidoSelected);
        MainView ni= new MainView();
        ni.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cancelarNuevoPedido

    private void quitarIngredienteDelTaco(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarIngredienteDelTaco
        // boton para quitar cosas del taco
        int selectedRow = tablaIngredientesSeleccionados.getSelectedRow();
        Integer precioValue = (Integer)tablaIngredientesSeleccionados.getValueAt(selectedRow, 2);
        DefaultTableModel model = (DefaultTableModel) tablaIngredientesSeleccionados.getModel();
        model.removeRow(selectedRow);
        listaIngredientesSelected.remove(selectedRow);
        precioTotalIngredientes -= precioValue;
        precioTotalDeIngredientesSeleccionados.setText(precioTotalIngredientes.toString());
    }//GEN-LAST:event_quitarIngredienteDelTaco

    private void agregarTacoAlPedido(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarTacoAlPedido
        // BOTON PARA GUARDAR EL TACO
        ValidationMessage validationResult = validator.esValido(listaIngredientesSelected);
        if (!validationResult.getIsValid()) {
            JOptionPane.showMessageDialog(null, validationResult.getMessage());
        } else {
            try {
                System.out.println("Entrando a guardar taco!");
                TacoDTO tdto = tacoController.saveTaco(listaIngredientesSelected, pedidoSelected, Integer.parseInt(precioTotalDeIngredientesSeleccionados.getText()));
                Object rowData[] = new Object[2];
                DefaultTableModel model = (DefaultTableModel) tablaDeTacosDelPedido.getModel();
                    rowData[0] = tdto.getId();
                    rowData[1] = tdto.getCosto();
                    model.addRow(rowData); 
                precioTotalPedido += tdto.getCosto();
                labelPrecioTotalPedido.setText(precioTotalPedido.toString());
                DefaultTableModel model2 = (DefaultTableModel) tablaIngredientesSeleccionados.getModel();
                model2.setRowCount(0);
                ingredientePreCargado = new IngredienteDTO();
                listaIngredientesSelected.clear();
                precioTotalDeIngredientesSeleccionados.setText("0");
                precioTotalIngredientes = 0;
                JOptionPane.showMessageDialog(null, validationResult.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar el taco :( revisar el sistema. " + e);
                e.printStackTrace();
            }
        }
            
        
                
    }//GEN-LAST:event_agregarTacoAlPedido

    private void quitarTacoDelPedido(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarTacoDelPedido
        int selectedRow = tablaDeTacosDelPedido.getSelectedRow();
        Integer precioValue = (Integer)tablaDeTacosDelPedido.getValueAt(selectedRow, 1);
        Long idTaco = (Long)tablaDeTacosDelPedido.getValueAt(selectedRow, 0);
        DefaultTableModel model = (DefaultTableModel) tablaDeTacosDelPedido.getModel();
        model.removeRow(selectedRow);
        tacoController.deleteTaco(idTaco);
        precioTotalPedido -= precioValue;
        labelPrecioTotalPedido.setText(precioTotalPedido.toString());
    }//GEN-LAST:event_quitarTacoDelPedido

    private void confirmarPedido(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarPedido
        // TODO add your handling code here:
        pedidoController.confirmarNuevoPedido(pedidoSelected, precioTotalPedido);
        JOptionPane.showMessageDialog(null, "Pedido ingresado correctamente! ");
        MainView ni= new MainView();
        ni.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_confirmarPedido

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
            java.util.logging.Logger.getLogger(NuevoPedidoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoPedidoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoPedidoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoPedidoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoPedidoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarTacoEnTablaDeTacos;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JLabel labelPrecioTotalPedido;
    private javax.swing.JComboBox<String> listaTiposDeIngrediente;
    public javax.swing.JLabel precioTotalDeIngredientesSeleccionados;
    private javax.swing.JButton quitarIngredienteDeTablaSeleccionada;
    private javax.swing.JButton seleccionarIngrediente;
    private javax.swing.JTable tablaDeTacosDelPedido;
    private javax.swing.JTable tablaIngredientes;
    private javax.swing.JTable tablaIngredientesSeleccionados;
    // End of variables declaration//GEN-END:variables
}
