/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul8;

/**
 *
 * @author ASUS
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel{
    private ResultSet rs;
    public ResultSetTableModel(ResultSet rs) {
        this.rs = rs;
    }
    public int getColumnCount() {
        try {
            if(rs == null)
                return 0;
            else
                return rs.getMetaData().getColumnCount();
        }catch(SQLException e) {
            System.out.println("resultset generating error while getting column count");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    public int getRowCount() {
        try {
            if(rs == null)
                return 0;
            else {
                rs.last();
                return rs.getRow();
            }
        }catch(SQLException e) {
            System.out.println("resultset generating error while getting rows count");
            System.out.println(e.getMessage());
            return 0;
        }
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex<0 || rowIndex > getRowCount() ||
                columnIndex < 0 || columnIndex > getColumnCount())
            return null;
        try {
            if(rs == null)
                return null;
            else {
                rs.absolute(rowIndex+1);
                return rs.getObject(columnIndex+1);
            }
        }catch(SQLException e) {
            System.out.println("resultset generating error while fetching rows");
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public String getColumnName(int columnIndex) {
        try {
            return rs.getMetaData().getColumnName(columnIndex+1);
        }catch (SQLException e) {
            System.out.println("resultset generating error while fetching column name");
            System.out.println(e.getMessage());
        }
        return super.getColumnName(columnIndex);
    }
}


    

