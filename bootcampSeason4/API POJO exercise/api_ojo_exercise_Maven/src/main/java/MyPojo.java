import com.fasterxml.jackson.databind.ObjectMapper;

public class MyPojo {

    private String ip;
    private String hostname;
    private String city;
    private String region;
    private String country;
    private String loc;
    private String org;
    private String postal;
    private String timezone;
    private String readme;

    // Getters


    public String getIp() {
        return ip;
    }

    public String getHostname() {
        return hostname;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getLoc() {
        return loc;
    }

    public String getOrg() {
        return org;
    }

    public String getPostal() {
        return postal;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getReadme() {
        return readme;
    }

    //Setters


    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setReadme(String readme) {
        this.readme = readme;
    }

    @Override
    public String toString() {
        return "Data: " + "\n" +
                "🌎Ip: " + ip + "\n" +
                "💬Hostname:" + hostname +  "\n"+
                "🌃City:" + city + "\n" +
                "🌐Region:" + region + "\n"+
                "🇪🇺Country:" + country +  "\n"+
                "📍Loc:" + loc + "\n"+
                "👔Org:" + org + "\n" +
                "📫Postal:" + postal + "\n"+
                "⏰Timezone:" + timezone +  "\n"+
                "📜Readme:" + readme + "\n";
    }
}

