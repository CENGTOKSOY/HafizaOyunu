import java.io.Serializable; // Serializable arayüzünü import eder, nesnelerin seri hale getirilmesini sağlar.

public class Kart implements Serializable { // Kart sınıfı Serializable arayüzünü uygular, bu sayede nesneler dosyaya yazılabilir veya ağ üzerinden gönderilebilir.

    private char deger; // 'deger' adında bir char tipinde özel bir değişken tanımlar.
    private boolean tahmin = false; // 'tahmin' adında bir boolean tipinde özel bir değişken tanımlar ve başlangıç değeri olarak 'false' atar.

    public Kart(char deger) { // Kart sınıfının yapıcı metodudur. Bir karakter alır ve 'deger' değişkenine atar.
        this.deger = deger;
    }

    public char getDeger() { // 'deger' değişkeninin değerini döndüren bir metod.
        return deger;
    }

    public void setDeger(char deger) { // 'deger' değişkenine yeni bir değer atayan bir metod.
        this.deger = deger;
    }

    public boolean isTahmin() { // 'tahmin' değişkeninin değerini döndüren bir metod.
        return tahmin;
    }

    public void setTahmin(boolean tahmin) { // 'tahmin' değişkenine yeni bir değer atayan bir metod.
        this.tahmin = tahmin;
    }
}
