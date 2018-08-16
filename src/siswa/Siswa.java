
package siswa;


import com.j256.ormlite.field.DatabaseField;

import com.j256.ormlite.table.DatabaseTable;


/**
 *
 * @author ketikanMD
 */
//tablename harus sama dengan nama tabel yang didatabase
@DatabaseTable(tableName = "tb_siswa")
public class Siswa {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String nama;
    @DatabaseField
    private String kelas;
    @DatabaseField
    private String alamat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
   
  
   
   
    

}
