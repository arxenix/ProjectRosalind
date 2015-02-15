package me.ankur.rosalind.util;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.List;

/**
 * Created by Sundara on 12/19/14.
 */
public class GenericUtil {

    public static String arrayJoin(Object[] arr, String joiner) {
        StringBuilder sb = new StringBuilder();
        for (Object o : arr) {
            sb.append(o.toString());
            sb.append(joiner);
        }
        sb.delete(sb.length()-joiner.length(),sb.length());
        return sb.toString();
    }

    public static String arrayJoin(int[] arr, String joiner) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
            sb.append(joiner);
        }
        sb.delete(sb.length()-joiner.length(),sb.length());
        return sb.toString();
    }

    public static String arrayJoin(char[] arr, String joiner) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
            sb.append(joiner);
        }
        sb.delete(sb.length()-joiner.length(),sb.length());
        return sb.toString();
    }

    public static String listJoin(List list, String joiner) {
        StringBuilder sb = new StringBuilder();
        for (Object o : list) {
            sb.append(o.toString());
            sb.append(joiner);
        }
        sb.delete(sb.length() - joiner.length(), sb.length());
        return sb.toString();
    }

    public static void pasteData(List<String> text) {
        pasteData(text.toArray(new String[text.size()]));
    }

    //Paste raw data to pastebin.com and open in browser
    public static void pasteData(String... text) {
        String toPaste = arrayJoin(text, "\n");
        try {
            String url = "http://pastebin.com/api/api_post.php";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            String urlParameters = "api_dev_key=" + Util.readStringFile("pastebin_api_key") +
                    "&api_option=paste" +
                    "&api_paste_private=1" +
                    "&api_paste_expire_date=10M" +
                    "&api_paste_code=" + URLEncoder.encode(toPaste, "UTF-8");

            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            //int responseCode = con.getResponseCode();
            //System.out.println("\nSending 'POST' request to URL : " + url);
            //System.out.println("Post parameters : " + urlParameters);
            //System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder responseURL = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                responseURL.append(inputLine);
            }
            in.close();


            String[] split = responseURL.toString().split("/");
            String id = split[split.length - 1];
            //open in browser
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI("http://www.pastebin.com/raw.php?i=" + id));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
