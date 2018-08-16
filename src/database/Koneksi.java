
package database;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ketikanMD
 */
public class Koneksi {

    ConnectionSource csInit = null;

    //konfigurasi koneksi ke mysql server
    public static ConnectionSource cs() {
        String dbName = "db_siswa"; //nama database
        String dbUrl = "jdbc:mysql://localhost:3306/" + dbName;
        String user = "root"; 
        String pass = "";

        //inisiasi sumber koneksi
        ConnectionSource csInit = null;
        try {
            csInit = new JdbcConnectionSource(dbUrl, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }

        //kembalikan hasil koneksi
        return csInit;

    }


    public Connection getConnection() {
        return (Connection) csInit;
    }

}
