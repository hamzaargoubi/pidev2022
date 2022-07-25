package org.esprit.ib.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

public final class TokenPlayLoadExtractor {
    private static Integer serial = 1;
    public static Map<String,String> extract(String token){
    	String[] split_string = token.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];
        String base64EncodedSignature = split_string[2];

        Base64 base64Url = new Base64(true);
        String header = new String(base64Url.decode(base64EncodedHeader));
        System.out.println("JWT Header : " + header);


        String body = new String(base64Url.decode(base64EncodedBody)); 
        Map<String, String> myMap = new HashMap<String,String>();
        String[] pairs = body.replaceAll("(\\{|\\}|\")", "").split(",");
        for (int i=0;i<pairs.length;i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split(":");
            myMap.put(keyValue[0], keyValue[1]);
        }
        return myMap;
    }
}
