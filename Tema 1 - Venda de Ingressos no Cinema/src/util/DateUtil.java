package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author lhries
 */
public class DateUtil {

    /**
     * 
     * @return Retorna a data e hora atual no formato Date
     */
    public static Date dataHoraAtual(){
        GregorianCalendar calendar = new GregorianCalendar();
        return (calendar.getTime());
    }

    /**
     * 
     * @param data
     * @return
     * @throws ParseException 
     */
    public static Date stringToDate(String data) throws ParseException {
        return (new SimpleDateFormat("dd/MM/yyyy").parse(data));
    }

    /**
     * 
     * @param data
     * @return
     * @throws ParseException 
     */
    public static Date stringToDateHour(String data) throws ParseException {
        return (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(data));
    }

    /**
     * 
     * @param data
     * @return
     * @throws ParseException 
     */
    public static Date stringToHour(String data) throws ParseException {
        return (new SimpleDateFormat("HH:mm:ss").parse(data));
    }

    /**
     * 
     * @param data
     * @return 
     */
    public static String hourToString(Date data) {
        return (new SimpleDateFormat("HH:mm:ss").format(data));
    }

    /**
     * 
     * @param data
     * @return 
     */
    public static String dateToString(Date data) {
        return (new SimpleDateFormat("dd/MM/yyyy").format(data));
    }

    /**
     * 
     * @param data
     * @return 
     */
    public static String dateHourToString(Date data) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataString = formatador.format(data);
        return (dataString);
    }

    /**
     * 
     * @param data
     * @return 
     */
    public static boolean verificaData(String data) {
        return (data.matches("\\d{2}/\\d{2}/\\d{4}"));
    }

    /**
     * 
     * @param data
     * @return 
     */
    public static boolean verificaDataHora(String data) {
        return (data.matches("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}:\\d{2}"));
    }
}
