package day02_webelement_locators;

public class C06_XPath {

    public static void main(String[] args) {

        /*
            XPath en guclu locator'dir
            XPath her turlu WebElement'i locate edebilir

            2 cesit XPath vardir

            1- Absolute XPath (Cok kullanilmaz- Kullanmamaniz tavsiye edilir)

                /html/body/header/div/div/div/div[2]/div/ul/li[3]/a
                //header//li[3]/a

                / ile // arasindaki fark :
                / kullandigimizda sadece child html kodlara bakar
                // kullandigimizda asagi dogru tum sulaleye bakar

            2- Relative XPath :Cok Gucludur ve her zaman kullanilabilir

                (//i[@class='fa fa-shopping-cart'])[1]

                Temel fikir her WebElement'de mutlaka bulunan
                Tag, Attribute ve Attribute Value'yu birlestirerek unique locate'e ulasmaktir


         */
    }
}
