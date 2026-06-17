class TimeMap {
    HashMap<String,Map<Integer,String>> map1;
    int last;

    public TimeMap() {
        map1 = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map1.putIfAbsent(key , new HashMap<>());
        map1.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!map1.containsKey(key)) {return "";}
        if(map1.get(key).containsKey(timestamp)) {
            return map1.get(key).get(timestamp);
        } else {
            int t = timestamp -1 ;
            while (!map1.get(key).containsKey(t) && t >=0 ) {
                t--;
            } 
            if (t > 0 ) {return map1.get(key).get(t);}
            else {return "";}

        }
    }
}
