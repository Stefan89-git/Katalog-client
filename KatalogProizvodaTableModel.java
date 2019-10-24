package rs.itcentar.katalog_proizvoda;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class KatalogProizvodaTableModel extends DefaultTableModel {

    private String[] columnNames = {"Proizvod",
                                    "Opis Proizvoda",
                                    "Cena"};
    private List<Proizvodi> proizvodi = new ArrayList<Proizvodi>();;

    public KatalogProizvodaTableModel() {
KatalogClient client = new KatalogClient();
client.getProizvodi();
        
//        proizvodi.add(new Proizvodi("Pizza 1", "opis proizvod 1", 32));
//        proizvodi.add(new Proizvodi("Sendvic 2", "opis proizvod 2", 80));
//        proizvodi.add(new Proizvodi("Kifla 3", "opis proizvod 3", 34));
//        proizvodi.add(new Proizvodi("Pizza sendvic 4", "opis proizvod 4", 54));

    }

    @Override
    public Object getValueAt(int row, int column) {
        Proizvodi proizvod = proizvodi.get(row);
        switch (column) {
            case 0:
                return proizvod.getImeProizvoda();
            case 1:
                return proizvod.getOpisProizvoda();
            case 2:
                return proizvod.getCenaProizvoda();
            default:
                throw new IllegalArgumentException(String.format("Kolona %d ne postoji", column));
        }
        //swich po column i vracam ime opis ccena
        // return proizvod;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
      return columnNames[column] ;
         
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return proizvodi == null ? 0 : proizvodi.size();
    }

    public void removeProizvod(int index) {
        if (index >= 0 && index < proizvodi.size()) {
            proizvodi.remove(index);
        }
        fireTableDataChanged();
    }

    public void addProizvod(Proizvodi p) {
        if (p != null) {
            this.proizvodi.add(p);
            fireTableDataChanged();
        }
    }

    public Proizvodi getProizvodByIndex(int selectedRow) {

        return this.proizvodi.get(selectedRow);

    }

    public void updateProizvod(Proizvodi proizvod, int index) {
        Proizvodi p = proizvodi.get(index);//izvukli smo ga da kad menjam jedan menjam i drugi i nema potrebe da zovemo specijalno za tabelu
        p.setImeProizvoda(proizvod.getImeProizvoda());
        p.setOpisProizvoda(proizvod.getOpisProizvoda());
        p.setCenaProizvoda(proizvod.getCenaProizvoda());
        fireTableDataChanged();
    }
}
