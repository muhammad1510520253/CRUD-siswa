
package siswa;


import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.DAO;
import database.Koneksi;

import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ketikanMD
 */
public class SiswaDAOImp implements DAO {

    Dao<Siswa, Integer> dao;

    public SiswaDAOImp() {
        try {
            dao = DaoManager.createDao(Koneksi.cs(), Siswa.class);
        } catch (SQLException ex) {
            Logger.getLogger(SiswaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Object o) {
        try {
            dao.create((Siswa) o);
            JOptionPane.showMessageDialog(null, "Simpan data berhasil !");
        } catch (SQLException ex) {
            Logger.getLogger(SiswaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object o) {
        try {
            dao.update((Siswa) o);
            JOptionPane.showMessageDialog(null, "Update data berhasil !");
        } catch (SQLException ex) {
            Logger.getLogger(SiswaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            dao.deleteById(Integer.valueOf(id));
            JOptionPane.showMessageDialog(null, "Hapus data berhasil !");
            
        } catch (SQLException ex) {
            Logger.getLogger(SiswaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DefaultTableModel selectAll() {
        DefaultTableModel dtm;
        String[] title = {"ID", "Nama", "Kelas","Alamat"};
        dtm = new DefaultTableModel(null, title);
        try {
            List<Siswa> siswa = dao.queryForAll();
            for (Siswa b : siswa) {
                Object[] o = new Object[4];
                o[0] = b.getId();
               
                o[1] = b.getNama();
                o[2] = b.getKelas();
                o[3] = b.getAlamat();
             

                dtm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SiswaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        //kembalikan hasil dtm
        return dtm;
    }

    @Override
    public DefaultTableModel search(String key) {
        DefaultTableModel dtm;
         String[] title = {"ID", "Nama", "Kelas","Alamat"};
        dtm = new DefaultTableModel(null, title);
        try {
             List<Siswa> siswa = dao.queryBuilder().where().
                    like("nama", "%" + key + "%").query();
            for (Siswa b : siswa) {
                Object[] o = new Object[4];
                o[0] = b.getId();
               
                o[1] = b.getNama();
                o[2] = b.getKelas();
                o[3] = b.getAlamat();
             

                dtm.addRow(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SiswaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        //kembalikan hasil dtm
        return dtm;
    }    
}

