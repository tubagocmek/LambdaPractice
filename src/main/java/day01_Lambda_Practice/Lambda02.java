package day01_Lambda_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda02 {
    public static void main(String[] args) {

        List<String>meyve =new ArrayList<>(Arrays.asList("elma","portakal","üzüm","cilek","greyfurt","nar",
                "mandalina","armut","elma","keçiboynuzu","elma"));
        ilkHarfEveyaC(meyve);
        System.out.println("\n************");
        basinaVeSonunaYildiz(meyve);
        System.out.println("\n************");
        icindeEharfi(meyve);
        System.out.println("\n************");
        lHarfiniSil(meyve);
        System.out.println("\n************");
        karakterSayisinaGoreKucuktenBuyuge(meyve);
        System.out.println("\n************");
        karakterSayisinaGoreKucBuyMethodRef(meyve);
        System.out.println("\n************");
    }

    // SORU1 : List elemanlarının ilk harfi 'e' veya 'c' olanlari,
// Method References ile aralarında bosluk bırakarak yazdıralım
    public static void ilkHarfEveyaC (List<String>meyve){
        meyve.stream().filter(t->t.startsWith("e")|| t.startsWith("c")).forEach(Utils::yazdir);
    }
// SORU2 : List elemanlarının hepsinin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void basinaVeSonunaYildiz (List<String>meyve){
        meyve.stream().map(t->"*"+t+"*").forEach(Utils::yazdir);
    }
// SORU3 : List elemanlarının icinde 'e' harfi olanları yazdırın
    public static void icindeEharfi (List<String>meyve){
        meyve.stream().filter(t->t.contains("e")).forEach(Utils::yazdir);
    }
//Soru4: List elemanlarındaki "l" harflerini silip yazdırınız
    public static void lHarfiniSil (List<String>meyve){
        meyve.stream().map(t->t.replaceAll("l","")).forEach(Utils::yazdir);
    }
// SORU5 : List elemanlarini, Lambda Expression kullanarak
// karakter sayisina göre kucukten buyuge dogru sıralayarak yazdırınız
    public static void karakterSayisinaGoreKucuktenBuyuge (List<String >meyve){
        meyve.stream().
                sorted(Comparator.comparing(t->t.length())).//comparator comparing bir şart belirtmemiz gerektiğinde kullanıyoruz
                 forEach(Utils::yazdir);
    }
    // SORU6 : List elemanlarini, Method References kullanarak
// karakter sayisina göre buyukten kucuge dogru sıralayarak yazdırınız
    public  static void karakterSayisinaGoreKucBuyMethodRef (List<String >meyve){
        meyve.
                stream().
                sorted(Comparator.comparing(String::length).reversed()).
                forEach(Utils::yazdir);

}
    }
