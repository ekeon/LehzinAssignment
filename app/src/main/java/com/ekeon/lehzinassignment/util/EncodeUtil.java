package com.ekeon.lehzinassignment.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by ekeon on 2017. 4. 10..
 */

public class EncodeUtil {

    public static String koreanEncode(String uri) {
        char[] txtChar = uri.toCharArray();
        for (int j = 0; j < txtChar.length; j++) {
            if (txtChar[j] >= '\uAC00' && txtChar[j] <= '\uD7A3') {
                String targetText = String.valueOf(txtChar[j]);
                try {
                    uri = uri.replace(targetText, URLEncoder.encode(targetText, "euc-kr"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return uri;
    }
}
