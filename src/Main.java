import java.io.File; // File sınıfını import eder, dosya işlemleri için kullanılır.
import java.util.Scanner; // Scanner sınıfını import eder, kullanıcı girdisi almak için kullanılır.

public class Main {
    private static Kart[][] kartlar = new Kart[4][4]; // 4x4'lük Kart tipinde bir dizi tanımlar.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Kullanıcı girdisi almak için Scanner nesnesi oluşturur.

        // Kartları başlangıç durumuna getirir.
        kartlar[0][0] = new Kart('E');
        kartlar[0][1] = new Kart('A');
        // ... Diğer kartlar da benzer şekilde tanımlanır ...

        // Oyun bitene kadar devam eden döngü.
        while (oyunBittiMi() == false) {
            oyunTahtasi(); // Oyun tahtasını gösterir.
            tahminEt(); // Kullanıcıdan tahmin alır.
        }
    }

    // Kullanıcının tahminlerini alır ve kontrol eder.
    public static void tahminEt() {
        Scanner scanner = new Scanner(System.in); // Yeni bir Scanner nesnesi oluşturur.

        // Birinci tahmin için kullanıcıdan iki sayı alır.
        System.out.print("Birinci Tahmin (i ve j değerlerini bir boşluklu girin...): ");
        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();

        kartlar[i1][j1].setTahmin(true); // İlk tahminin durumunu günceller.
        oyunTahtasi(); // Oyun tahtasını tekrar gösterir.

        // İkinci tahmin için kullanıcıdan iki sayı daha alır.
        System.out.print("İkinci Tahmin (i ve j değerlerini bir boşluklu girin...): ");
        int i2 = scanner.nextInt();
        int j2 = scanner.nextInt();

        // Eğer tahminler doğruysa, ikinci tahminin durumunu da günceller.
        if (kartlar[i1][j1].getDeger() == kartlar[i2][j2].getDeger()) {
            System.out.println("Doğru Tahmin. Tebrikler!");
            kartlar[i2][j2].setTahmin(true);
        }
        else {
            System.out.println("Yanlış Tahmin..."); // Tahminler yanlışsa, ilk tahminin durumunu geri alır.
            kartlar[i1][j1].setTahmin(false);
        }
    }

    // Oyunun bitip bitmediğini kontrol eder.
    public static boolean oyunBittiMi() {
        for (int i =  0 ; i < 4; i++){
            for (int j = 0 ; j < 4 ; j++) {
                if (kartlar[i][j].isTahmin() == false) { // Eğer tahmin edilmemiş bir kart varsa, oyun devam eder.
                    return false;
                }
            }
        }
        return true; // Tüm kartlar doğru tahmin edildiyse, oyun biter.
    }

    // Oyun tahtasını konsola yazdırır.
    public static void oyunTahtasi(){
        for (int i = 0 ;  i < 4 ; i++) {
            System.out.println("____________________"); // Tahtanın her satırını ayırır.
            for (int j = 0 ; j < 4 ; j++) {
                if (kartlar[i][j].isTahmin()) { // Eğer kart tahmin edilmişse, değerini gösterir.
                    System.out.print(" |" + kartlar[i][j].getDeger() + "| ");
                }
                else {
                    System.out.print(" | | "); // Tahmin edilmemişse, boş bir yer gösterir.
                }
            }
            System.out.println(""); // Her satırdan sonra yeni bir satıra geçer.
        }
        System.out.println("____________________"); // Tahtanın altını çizer.
    }
}
