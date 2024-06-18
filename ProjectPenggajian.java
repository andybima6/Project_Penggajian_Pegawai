

public class ProjectPenggajian {
    public static String[] nama;
    public static String[] jabatan;
    public static int[] gajiPokok;
    public static int[] tunjangan;
    public static int[] lemburan;
    public static int[] gajiBersih;

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Panjang Indeks Data : ");
        int arrayLength = scanner.nextInt();
        nama = new String[arrayLength];
        jabatan = new String[arrayLength];
        gajiPokok = new int[arrayLength];
        tunjangan = new int[arrayLength];
        lemburan = new int[arrayLength];
        gajiBersih = new int[arrayLength];

        viewMenuPenggajian();
    }

    /*Menampilkan menu penggajian*/
    static void viewMenuPenggajian(){

        while (true){
            System.out.println("===============================");
            System.out.println("||        MENU UTAMA         ||");
            System.out.println("===============================");
            System.out.println("1. Data Pegawai");
            System.out.println("2. Perhitungan Gaji");
            System.out.println("3. Cetak Slip Gaji Pegawai");
            System.out.println("4. Pencarian Pegawai");
            System.out.println("5. Pelaporan");
            System.out.println("x. Keluar");

            System.out.print("Pilih : ");
            String input = scanner.nextLine();

            if (input.equals("1")){
                dataPegawai();
            }else if (input.equals("2")){
                perhitunganGaji();
            }else if (input.equals("3")){
                slipGaji();
            }else if (input.equals("4")){
                pencarianPegawai();
            }else if (input.equals("5")){
                pelaporan();
            }else if (input.equals("x")){
                break;
            }
        }
    }

    static void addDataList() {
        System.out.println("====================================");
        System.out.println("||   MENAMBAH DATA NAMA PEGAWAI   ||");
        System.out.println("====================================");

        int a = 0;
        while (a < nama.length){
            System.out.print("Nama (x Jika Selesai Input) : ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("x")){
                break;
            }

            nama[a] = input;
            a++;

        }
    }

    static void addDataList2() {
        System.out.println("=======================================");
        System.out.println("||   MENAMBAH DATA JABATAN PEGAWAI   ||");
        System.out.println("=======================================");

        int a = 0;
        while (a < jabatan.length){
            System.out.print("Jabatan (x Jika Selesai Input) : ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("x")){
                break;
            }

            jabatan[a] = input;
            a++;

        }
    }

    static void dataPegawai(){
        System.out.println("1. Tambah Data Pegawai");
        System.out.println("2. Kembali Ke Menu Utama");

        System.out.print("Pilih : ");
        String input = scanner.nextLine();

        if (input.equals("1")){
            addDataList();
            addDataList2();
        }else if (input.equals("2")){
            viewMenuPenggajian();
        }else {
            System.out.println("Input Yang Anda Masukkan Tidak Valid");
        }
    }

    static void addGajiPokok(){
        System.out.println("==================================");
        System.out.println("||   INPUT GAJI POKOK PEGAWAI   ||");
        System.out.println("==================================");

        int b = 0;
        while (b < gajiPokok.length){
            System.out.print("Gaji Pokok : ");
            int input = scanner.nextInt();

            gajiPokok[b] = input;
            b++;

        }
    }

    static void addTunjangan(){
        System.out.println("===================================");
        System.out.println("||    INPUT TUNJANGAN PEGAWAI    ||");
        System.out.println("===================================");

        int c = 0;
        while (c < tunjangan.length){
            System.out.print("Tunjangan : ");
            int input = scanner.nextInt();

            tunjangan[c] = input;
            c++;

        }
    }

    static void addLemburan(){
        System.out.println("==================================");
        System.out.println("||    INPUT LEMBURAN PEGAWAI    ||");
        System.out.println("==================================");

        int d = 0;
        while (d < lemburan.length){
            System.out.print("Total Jam Lembur : ");
            int inputJam = scanner.nextInt();
            System.out.print("Harga Per Jam : ");
            int inputHarga = scanner.nextInt();


            lemburan[d] = inputJam * inputHarga;

            gajiBersih[d] = gajiPokok[d] + lemburan[d] + tunjangan[d];
            d++;
        }
    }


    static void perhitunganGaji(){
        System.out.println("1. Input Gaji Pokok");
        System.out.println("2. Input Tunjangan");
        System.out.println("3. Input Lemburan");

        System.out.print("Pilih : ");
        int input = scanner.nextInt();

        if (input == 1){
            addGajiPokok();
        }else if (input == 2){
            addTunjangan();
        }else if (input == 3){
            addLemburan();
        } else{
            System.out.println("Input Yang Anda Masukkan Tidak Valid");
        }

    }


    static void slipGaji(){
        System.out.print("Input Nama Pegawai : ");
        String input = scanner.nextLine();

        System.out.println("———————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        System.out.println("|Nama\t       |Jabatan\t        |Gaji Pokok\t        |Tunjangan\t        |Lemburan\t        |Gaji Bersih\t        |");
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");

        for (int i = 0; i < nama.length; i++){
            if (nama[i].equalsIgnoreCase(input)){
                System.out.println("|" + nama[i] + "|\t        " + jabatan[i]+ "|\t        " + gajiPokok[i]+ "|\t        " + tunjangan[i]+ "|\t        " + lemburan[i]+ "|\t        " + gajiBersih[i]+ "|\t        ");
            }
        }

        System.out.println("1. Cetak Slip Gaji Lagi");
        System.out.println("2. Kembali Ke Menu Utama");

        System.out.print("Pilih : ");
        int input2 = scanner.nextInt();

        if (input2 == 1){
            slipGaji();
        }else if (input2 == 2){
            viewMenuPenggajian();
        }else {
            System.out.println("Input Yang Anda Masukkan Tidak Valid");
        }
    }

    static void pencarianPegawai(){
        System.out.print("Input Nama Pegawai : ");
        String input = scanner.nextLine();

        System.out.println("—————————————————————————————————");
        System.out.println("|Nama\t       |Jabatan\t        |");
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");

        for (int i = 0; i < nama.length; i++){
            if (nama[i].equalsIgnoreCase(input)){
                System.out.println("|" + nama[i] + "|\t        " + jabatan[i]+ "|\t        ");
            }
        }

        System.out.println("1. Mencari Pegawai Lagi");
        System.out.println("2. Kembali Ke Menu Utama");

        System.out.print("Pilih : ");
        String input2 = scanner.nextLine();

        if (input2.equals("1")){
            pencarianPegawai();
        }else if (input2.equals("2")){
            viewMenuPenggajian();
        }else {
            System.out.println("Input Yang Anda Masukkan Tidak Valid");
        }
    }

    static void pelaporan(){

        System.out.println("———————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
        System.out.println("|Nama\t       |Jabatan\t        |Gaji Pokok\t        |Tunjangan\t        |Lemburan\t        |Gaji Bersih\t        |");
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");

        for (int i = 0; i < nama.length; i++){
            System.out.println("|" + nama[i] + "|\t        " + jabatan[i]+ "|\t        " + gajiPokok[i]+ "|\t        " + tunjangan[i]+ "|\t        " + lemburan[i]+ "|\t        " + gajiBersih[i]+ "|\t        ");
        }
    }

}
