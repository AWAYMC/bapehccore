package net.arehard.core.ChatUtil;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.arehard.core.config.Config;
import net.arehard.core.yaml.Result;

public class YoutubeChecker
{
    private String DISCLAIMER;
    private String DISCLAIMER2;
    
    public YoutubeChecker() {
        this.DISCLAIMER = "UWAGA! TUTAJ ZACZYNA SIE RAKOTWORCZOSC KODU!";
        this.DISCLAIMER2 = "ABY NIE ZOSTAC NARAZONYM NA RADIOAKTYWNOSC, PROSZE OPUSCIC TA STREFE.";
    }
    
    public static Result getVideoInfo(final String video) {
        String channelID;
        String title;
        try {
            final StringBuilder result = new StringBuilder();
            final URL url = new URL("https://www.googleapis.com/youtube/v3/videos?id=" + video + "&key=" + Config.apiKey + "&fields=items(snippet(channelId,title))&part=snippet,statistics");
            final HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            final String owo = result.toString();
            final Pattern codePattern = Pattern.compile("\"channelId\": \".*\"");
            final Matcher matcher = codePattern.matcher(owo);
            String found = "";
            if (matcher.find()) {
                found = matcher.group(0);
            }
            final String newx = found.replace("\"channelId\": \"", "").replace(" \"title\": \"", "");
            channelID = newx.split(",")[0].substring(0, newx.split(",")[0].length() - 1);
            title = newx.split(",")[1].substring(0, newx.split(",")[1].length() - 1);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return new Result(channelID, title);
    }
    
    public static boolean shouldVideoBeDeleted(final String video) {
        boolean exists = true;
        try {
            final StringBuilder result = new StringBuilder();
            final URL url = new URL("https://www.googleapis.com/youtube/v3/videos?id=" + video + "&key=" + Config.apiKey + "&part=status");
            final HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            if (result.toString().contains("\"items\": []}")) {
                exists = false;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return !exists;
    }
    
    public static int getChannelSubs(final String channelID) {
        int owo;
        try {
            final StringBuilder result = new StringBuilder();
            final URL url = new URL("https://www.googleapis.com/youtube/v3/channels?part=statistics&id=" + channelID + "&key=" + Config.apiKey + "&part=snippet,contentDetails,statistics,status");
            final HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            final String sowo = result.toString();
            final Pattern codePattern = Pattern.compile("\"subscriberCount\": \".*\"");
            final Matcher matcher = codePattern.matcher(sowo);
            String found = "";
            if (matcher.find()) {
                found = matcher.group(0);
            }
            owo = Integer.parseInt(found.replace("subscriberCount", "").replace("\"", "").replace(":", "").split(",")[0].substring(1));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
        return owo;
    }
}
