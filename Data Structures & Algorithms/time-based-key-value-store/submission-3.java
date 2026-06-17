class TimeMap {
    HashMap<String,ArrayList<Pair>> map1;

    public TimeMap() {
        map1 = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map1.putIfAbsent(key , new ArrayList<>());
        map1.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map1.containsKey(key)) {return "";}
        int r = map1.get(key).size()-1;
        int l = 0;
        int mid = (l + r)/2; 
        int fin = -1;
        while(l <= r ) {
            mid = (l + r)/2;
            if(map1.get(key).get(mid).timestamp == timestamp) {
                return map1.get(key).get(mid).value;
            }
             else if (map1.get(key).get(mid).timestamp < timestamp) {
                l = mid+1;
                fin = mid;
            } else if (map1.get(key).get(mid).timestamp > timestamp) {
                r = mid-1;
            }
        }
        if(fin == -1 ) {
            return "";
        }

        return map1.get(key).get(fin).value;


    }
    class Pair {
        String value;
        int timestamp; 

        Pair(String value , int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
