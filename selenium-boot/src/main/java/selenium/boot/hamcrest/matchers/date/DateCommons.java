package selenium.boot.hamcrest.matchers.date;


import lombok.experimental.UtilityClass;
import org.springframework.core.convert.TypeDescriptor;
import selenium.boot.hamcrest.matchers.date.wrapper.DateWrapper;
import selenium.boot.hamcrest.matchers.date.wrapper.LocalDateTimeWrapper;
import selenium.boot.hamcrest.matchers.date.wrapper.LocalDateWrapper;
import selenium.boot.hamcrest.matchers.date.wrapper.LocalTimeWrapper;
import selenium.boot.hamcrest.matchers.date.wrapper.ZonedDateTimeWrapper;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
@UtilityClass
class DateCommons
{
    static <T> String getDescriptionMessage( TemporalWrapper<T> expected )
    {

        if( LocalTimeWrapper.class.isInstance( expected ) )
        {
            return "time ";
        }
        else if( DateWrapper.class.isInstance( expected ) )
        {
            return "date ";
        }
        else if( LocalDateWrapper.class.isInstance( expected ) )
        {
            return "local-date ";
        }
        else if( LocalDateTimeWrapper.class.isInstance( expected ) )
        {
            return "local-datetime ";
        }
        else if( ZonedDateTimeWrapper.class.isInstance( expected ) )
        {
            return "zoned-datetime ";
        }
        else
        {
            throw new UnsupportedOperationException( "unsupported wrapper type: " + expected.getClass().getName() );
        }
    }

    static <T> String getDescriptionMessage( TemporalAdapter<T> expected )
    {
        String type = TypeDescriptor.forObject( expected ).getResolvableType().resolve().getSimpleName();
        if( type.startsWith( "DateMatchers" ) )
        {
            return "date ";
        }
        else if( type.startsWith( "LocalTimeMatchers" ) )
        {
            return "local-time ";
        }
        else if( type.startsWith( "LocalDateMatchers" ) )
        {
            return "local-date ";
        }
        else if( type.startsWith( "LocalDateTimeMatchers" ) )
        {
            return "local-datetime ";
        }
        else if( type.startsWith( "ZonedDateTimeMatchers" ) )
        {
            return "zoned-datetime ";
        }
        else
        {
            throw new UnsupportedOperationException( "unsupported adapter type: " + expected.getClass().getName() );
        }
    }
}
