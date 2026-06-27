class TimeMap {
    record Data(String val , int time){}
    Map<String,List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key , k -> new ArrayList<>()).add(new Data(value , timestamp));
        // [foo:[[bar,1]]]
    }
    
    public String get(String key, int timestamp) {
        List<Data> data = map.get(key); // [bar,1]
        String res = "";

        if(data == null) return "";

        int low = 0; // 0
        int high = data.size() - 1; // 0
        while(low <= high){
            int mid = low + high >>> 1; // 0

            if(timestamp >= data.get(mid).time){ // possible solution
                res = data.get(mid).val; // res = bar
                low = mid + 1; // trying to find another solution
            } else{
                high = mid - 1;
            }
        }
        return res; // bar
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */