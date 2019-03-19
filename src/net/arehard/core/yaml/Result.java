package net.arehard.core.yaml;

public class Result
{
    private String channelID;
    private String title;
    
    public Result(final String channelID, final String title) {
        this.channelID = channelID;
        this.title = title;
    }
    
    public String getChannelID() {
        return this.channelID;
    }
    
    public String getTitle() {
        return this.title;
    }
}
