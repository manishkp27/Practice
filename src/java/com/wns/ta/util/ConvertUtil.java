/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wns.ta.util;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author u162914
 */
public class ConvertUtil {

    public static String toJavascriptArray(String[] arr) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append("\"").append(arr[i]).append("\"");
            if (i + 1 < arr.length) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String convertNullToString(Object obj) {
        if (obj == null) {
            return "";
        }

        return obj.toString();

    }

    public static String encryptSpecialCharacter(String str) {
        if (str != null) {
            if (str.indexOf("&") != -1) {
                str = str.replaceAll("&", "&amp;");
            }
            if (str.indexOf("\"") != -1) {
                str = str.replaceAll("\"", "&quot;");
            }
            if (str.indexOf("'") != -1) {
                str = str.replaceAll("'", "&apos;");
            }

            if (str.indexOf(">") != -1) {
                str = str.replaceAll(">", "&gt;");
            }
            if (str.indexOf("<") != -1) {
                str = str.replaceAll("<", "&lt;");
            }

        }

        return str;
    }

    public static String dencryptSpecialCharacter(String str) {
        if (str != null) {
            if (str.indexOf("&amp;") != -1) {
                str = str.replaceAll("&amp;", "&");
            }
            if (str.indexOf("&quot;") != -1) {
                str = str.replaceAll("&quot;", "\";");
            }
            if (str.indexOf("&apos;") != -1) {
                str = str.replaceAll("&apos;", "'");
            }

            if (str.indexOf("&gt;") != -1) {
                str = str.replaceAll("&gt;", ">");
            }
            if (str.indexOf("&lt;") != -1) {
                str = str.replaceAll("&lt;", "<");
            }

        }

        return str;
    }

    public static int convertBooleanToInt(boolean b) {
        if (b) {
            return 1;
        }

        return 0;

    }

    public static boolean convertIntToBoolean(int i) {
        if (i == 0) {
            return false;
        }

        return true;

    }

    public static String convertListToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list.isEmpty()) {
            return "";
        }

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        return sb.substring(0, sb.length() - 1);

    }

    public static String convertToUIDate(String sDate, String format) {
        String dt = "";
        if (sDate == null || sDate.equals("")) {
            return null;
        } else {
            String splitTime[] = sDate.split(" ");
            if (format.equalsIgnoreCase("mm/dd/yyyy")) {
                String str[] = splitTime[0].split("-");
                if (str.length == 3) {
                    dt = str[1] + "/" + str[2] + "/" + str[0];
                } else {
                    dt = sDate;
                }

            }

            return dt;
        }

    }

}
