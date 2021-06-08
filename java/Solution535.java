public class Codec {

    private Map<String, String> map = new HashMap();
    // Encodes a URL to a shortened URL.
    
    public String encode(String longUrl) {
        String hashCode = Integer.toString(longUrl.hashCode());
        map.put(hashCode, longUrl);
        return hashCode;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
