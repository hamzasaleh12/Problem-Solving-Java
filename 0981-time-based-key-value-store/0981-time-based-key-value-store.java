class TimeMap {
    Map<String , List<Data>> map;

    class Data{
        int timestamp;
        String value;

        public Data(String value , int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
}
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key , k -> new ArrayList<>()).add(new Data(value , timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Data> history = map.get(key);

        if(history == null) return "";
        
            String val = "";
            int low = 0;
            int high = history.size() - 1;
            while(low <= high){
                int mid = low + high >>> 1;

                if(history.get(mid).timestamp <= timestamp){
                    val = history.get(mid).value;
                    low = mid + 1;
                } 
                else high = mid - 1;
            }

        return val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */