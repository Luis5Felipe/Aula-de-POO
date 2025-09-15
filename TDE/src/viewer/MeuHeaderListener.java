package viewer;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List; // Corrected import
import java.awt.event.MouseEvent; // Corrected import

import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class MeuHeaderListener extends MouseAdapter {
	private JTable tabela;
	private SortOrder ordem = SortOrder.DESCENDING;
	private int colunaSelecionada = -1;

    public MeuHeaderListener(JTable table) {
        this.tabela = table;
        this.tabela.getTableHeader().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int col = this.tabela.columnAtPoint(e.getPoint());

        if (e.getClickCount() == 1 && col != -1) {
         
            tratarCliqueNoCabecalho(col);
        }
    }

    private void tratarCliqueNoCabecalho(int columnIndex) {
    	TableModel meuTableModel = this.tabela.getModel();
     
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(meuTableModel);
        
        // This listener is typically not needed because the TableRowSorter
        // automatically updates when the model changes.
        // Keeping it here, but it's good to know.
        meuTableModel.addTableModelListener(e1 -> { 
            sorter.modelStructureChanged();
        });
        
        this.tabela.setRowSorter(sorter); 

        // Get the current sort keys
        List<RowSorter.SortKey> keys = new ArrayList<>(sorter.getSortKeys());
     
        // Check if the same column was clicked again
        if (this.colunaSelecionada == columnIndex) {
            // If the same column is clicked, toggle the sort order
            ordem = (ordem == SortOrder.ASCENDING) ? SortOrder.DESCENDING : SortOrder.ASCENDING;
        } else {
            // If a different column is clicked, start with ascending order
            this.colunaSelecionada = columnIndex;
            ordem = SortOrder.ASCENDING;
        }

        // Clear previous sort keys and add the new one
        keys.clear();
        keys.add(new RowSorter.SortKey(columnIndex, ordem));            	
        
        sorter.setSortKeys(keys);
    }
}