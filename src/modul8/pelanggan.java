package modul8;
/**
 *
 * @author ASUS
 */
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import modul5.MySQL;

public class pelanggan extends JFrame implements ActionListener {
    private JPanel jppelanggan = new JPanel();
    private JLabel lblnamapelanggan = new JLabel("Nama Pelanggan"),lbltanggalmasuk = new JLabel("Tanggal Masuk"),
            lbljenispakaian = new JLabel("Jenis Pakaian"), lblberatpakaian = new JLabel("Berat Pakaian / kg"), 
            lbljenislaundry = new JLabel("Jenis Laundry"), lbltanggalselesai = new JLabel("Tanggal Selesai"),
            lblnotelepon = new JLabel("No.Telepon");
    private JTextField txtnamapelanggan = new JTextField(),txttanggalmasuk = new JTextField(),txtjenispakaian =
            new JTextField(),txtberatpakaian = new JTextField(),txtjenislaundry = new JTextField(),
            txttanggalselesai = new JTextField(),txtnotelepon = new JTextField();
   
    private JButton btnTambah = new JButton("Tambah"),btnUbah = new JButton("Ubah"),
            btnHapus = new JButton("Hapus"),btnBersih = new JButton("Bersih");
   
    String[] strJdl={"Nama Pelanggan","Tanggal Masuk","Jenis Pakaian","Berat Pakaian / kg","Jenis Laundry",
                    "Tanggal selesai","No. Telepon"};
    //Deklarasi untuk Tabel
    JTable tabel = new JTable();
    JScrollPane skrTabel = new JScrollPane();
   
    pelanggan (){
       
        super("DATA PELANGGAN");
        setSize(550,480);
        jppelanggan.setLayout(null);
        
        lblnamapelanggan.setBounds(20, 20, 150, 25);
        lbltanggalmasuk.setBounds(20, 55, 150, 25);
        lbljenispakaian.setBounds(20, 90, 150, 25);
        lblberatpakaian.setBounds(20, 125, 150, 25);
        lbljenislaundry.setBounds(20, 160, 150, 25);
        lbltanggalselesai.setBounds(20, 195, 150, 25);
        lblnotelepon.setBounds(20, 230, 150, 25);
        
        txtnamapelanggan.setBounds(135, 20, 150, 25);
        txttanggalmasuk.setBounds(135, 55, 150, 25);
        txtjenispakaian.setBounds(135, 90, 150, 25);
        txtberatpakaian.setBounds(135, 125, 150, 25);
        txtjenislaundry.setBounds(135, 160, 150, 25);
        txttanggalselesai.setBounds(135, 195, 150, 25);
        txtnotelepon.setBounds(135, 230, 150, 25);

               
        jppelanggan.add(btnTambah);
        jppelanggan.add(btnUbah);
        jppelanggan.add(btnHapus);
        jppelanggan.add(btnBersih);

        btnTambah.setBounds(360, 20, 85, 25);
        btnUbah.setBounds(360, 55, 85, 25);
        btnHapus.setBounds(360, 90, 85, 25);
        btnBersih.setBounds(360, 125, 85, 25);
       
    skrTabel.getViewport().add(tabel);
    tabel.setEnabled(true);
    skrTabel.setBounds(15, 280, 500, 130);

    //menambahkan tabel pada panel
    jppelanggan.add(skrTabel);

        //mengatur/meletakkan objek pada objek panel
      jppelanggan.add(lblnamapelanggan);
        jppelanggan.add(lbltanggalmasuk);
        jppelanggan.add(lbljenispakaian);
        jppelanggan.add(lblberatpakaian);
        jppelanggan.add(lbljenislaundry);
        jppelanggan.add(lbltanggalselesai);
        jppelanggan.add(lblnotelepon);
        
        jppelanggan.add(txtnamapelanggan);
        jppelanggan.add(txttanggalmasuk);
        jppelanggan.add(txtjenispakaian);
        jppelanggan.add(txtberatpakaian);
        jppelanggan.add(txtjenislaundry);
        jppelanggan.add(txttanggalselesai);
        jppelanggan.add(txtnotelepon);
       
        jppelanggan.add(btnTambah);
        jppelanggan.add(btnUbah);
        jppelanggan.add(btnHapus);
        jppelanggan.add(btnBersih);
       
        //mengisi combo Jenis kelamin
       
       
        //mengatur objek agar dapat berinteraksi dengan user
        btnTambah.addActionListener(this);
        btnUbah.addActionListener(this);
        btnHapus.addActionListener(this);
        btnBersih.addActionListener(this);
       
        //menambahkan objek JPanel pada container frame
        getContentPane().add(jppelanggan);
        //menampilkan tabel siswa ke komponen tabel
        TampilTabel();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        //pengaturan Tabel
       
        skrTabel.getViewport().add(tabel);
        tabel.setEnabled(true);
        skrTabel.setBounds(15, 280, 500, 130);
       
        //menambahkan tabel pada panel
        jppelanggan.add(skrTabel);
       
        //menambahkan objek JPanel pada container frame
        getContentPane().add(jppelanggan);
        //menampilkan tabel siswa ke komponen tabel
        TampilTabel();
       
    }
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj ==btnTambah){
            Tambah();
        }
        if (obj == btnUbah){
            Ubah();
        }
        if (obj == btnHapus){
            Hapus();
        }
        Bersih();
    }
    void Bersih(){
        txtnamapelanggan.setText("");
        txttanggalmasuk.setText("");
        txtjenispakaian.setText("");
        txtberatpakaian.setText("");
        txtjenislaundry.setText("");
        txttanggalselesai.setText("");
        txtnotelepon.setText("");
    }
    void Tambah(){
       try{
            MySQL ObjKoneksi = new MySQL();
            Connection con = ObjKoneksi.bukaKoneksi();
            Statement st = con.createStatement();        
            String sql = "INSERT INTO `Pelanggan`(`Nama Pelanggan`, `Tanggal Masuk`, `Jenis Pakaian`, `Berat Pakaian / kg`, "
                    + "`Jenis Laundry`, `Tanggal Selesai`,`No. Telepon`) " + "VALUES  ('"+txtnamapelanggan.getText()+"','"+txttanggalmasuk.getText()+
                    "','"+txtjenispakaian.getText()+"','"+txtberatpakaian.getText()+"','"+txtjenislaundry.getText()+"','"+txttanggalselesai.getText()+
                    "','"+txtnotelepon.getText()+"')";
            int row = st.executeUpdate(sql);
           
            if (row ==1){
                JOptionPane.showMessageDialog(null,"Data sudah ditambahkan ke"+" database","infomasi",JOptionPane.INFORMATION_MESSAGE);
              con.close();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data tidak ditambahkan ke"+
                    e.getMessage() ,"infomasi",JOptionPane.INFORMATION_MESSAGE);
        }
        TampilTabel();
    }
    void Ubah(){
         try{
            MySQL ObjKoneksi = new MySQL();
            Connection con = ObjKoneksi.bukaKoneksi();
            Statement st = con.createStatement();
           
            String sql = "UPDATE `pelanggan` SET `Nama Pelanggan` = '"+txtnamapelanggan.getText()+"',`Tanggal Masuk`='"
                    +txttanggalmasuk.getText()+"',`Jenis Pakaian`='"+txtjenispakaian.getText()+"',`Berat Pakaian / kg`='"+txtberatpakaian.getText()+
                    "',`Jenis Laundry`='"+txtjenislaundry.getText()+"',`Tanggal Selesai`='"+txttanggalselesai.getText()+
                    "' WHERE `No. Telepon` ='"+txtnotelepon.getText()+"' ";
           
            int row = st.executeUpdate(sql);
            if (row ==1){
                JOptionPane.showMessageDialog(null,"Data sudah di update ","infomasi",JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data tidak diUbah"+
                    e.getMessage() ,"infomasi",JOptionPane.INFORMATION_MESSAGE);
        }
        TampilTabel();
    }
    void Hapus(){
        try{
            MySQL ObjKoneksi = new MySQL();
            Connection con = ObjKoneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "DELETE FROM pelanggan WHERE `Nama Pelanggan` = '"+tabel.getValueAt(tabel.getSelectedRow(),0).toString()+"'";
            int row = st.executeUpdate(sql);
            if (row ==1){
                JOptionPane.showMessageDialog(null,"Data sudah dihapus dari " + " database","infomasi",JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data tidak dihapus","infomasi",JOptionPane.INFORMATION_MESSAGE);
        }
        TampilTabel();
    }
void TampilTabel(){
        try {
            MySQL ObjKoneksi = new MySQL();
            Connection con = ObjKoneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM `pelanggan`";
            ResultSet set = st.executeQuery(sql);
            //menampilkan data ke Tabel
            ResultSetTableModel model = new ResultSetTableModel(set);
            tabel.setModel(model);

            while(set.next()){
                txtnamapelanggan.setText(set.getString("Nama Pelanggan"));
                txttanggalmasuk.setText(set.getString("Tanggal Masuk"));
                txtjenispakaian.setText(set.getString("Jenis Pakaian"));
                txtberatpakaian.setText(set.getString("Berat Pakaian / kg"));
                txtjenislaundry.setText(set.getString("Jenis Laundry"));
                txttanggalselesai.setText(set.getString("Tanggal Selesai"));
                txtnotelepon.setText(set.getString("No. Telepon"));
            }
        }
        catch(SQLException e) {
            System.out.println("gagal query");
        }
   }

    public static void main (String[] args){
        new pelanggan();
    }
}    

    

