import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] unused) {

String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
String[] wordArray = text.trim().split("\\s+");
int wordCount = wordArray.length;
System.out.println("The word count of Hamlet is = " + wordCount);

        String text2 = urlToString("https://www.bls.gov/tus/charts/chart9.txt");
        String[] wordArray2 = text2.trim().split("\\s+");
        int wordCount2 = wordArray2.length;
        System.out.println("The word count of the government data is = " + wordCount2);

        String text3 = urlToString("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt");
        String[] wordArray3 = text3.trim().split("\\s+");
        int wordCount3 = wordArray3.length;
        System.out.println("The word count of the forecast is = " + wordCount3);

        String Hamlet = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] arrayOfHamlet = Hamlet.trim().split("\\s+");
        String word = "prince";
        int princeCount = 0;
        for (int i = 0; i < arrayOfHamlet.length; i++) {
            if (arrayOfHamlet[i] == word) {
                princeCount++;
            }
        }
        System.out.println("The amount of times the word Prince appears in Hamlet = " + princeCount);
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
