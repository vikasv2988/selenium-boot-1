package selenium.boot.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public class Util
{
    //region initialization and constructors section

    private static final Logger log = LoggerFactory.getLogger( Util.class );

    private Map<String, String> languagesMap = new TreeMap<String, String>();

    public Util()
    {
        initLanguageMap();
    }
    //endregion

    public static void main( String[] args )
    {
        Util obj = new Util();
        obj.getListOfCountries();


    }
    public void getListOfCountries() {

        String[] countries = Locale.getISOCountries();

        int supportedLocale = 0, nonSupportedLocale = 0;


        for (String countryCode : countries) {

            Locale obj = null;
            if (languagesMap.get(countryCode) == null) {

                obj = new Locale("", countryCode);
                nonSupportedLocale++;

            } else {

                //create a Locale with own country's languages
                obj = new Locale(languagesMap.get(countryCode), countryCode);

                supportedLocale++;

            }

            Locale obj3 = Locale.ENGLISH;
            System.out.println("Country Code = " + obj.getCountry()
                                       + ", Country Name = " + obj.getDisplayCountry(obj3)
                                       + ", Country Name = " + obj.getDisplayCountry(obj)
                                       + ", Languages = " + obj.getDisplayLanguage());

        }

        System.out.println("nonSupportedLocale : " + nonSupportedLocale);
        System.out.println("supportedLocale : " + supportedLocale);

    }

    // create Map with country code and languages
    public void initLanguageMap() {

        Locale[] locales = Locale.getAvailableLocales();

        for (Locale obj : locales) {

            if ((obj.getDisplayCountry() != null) && (!"".equals(obj.getDisplayCountry()))) {
                languagesMap.put(obj.getCountry(), obj.getLanguage());
            }

        }

    }

}
