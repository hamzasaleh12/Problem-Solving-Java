class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();

        Map<String,String> map = new HashMap<>();
        for(List<String> pair :  knowledge){
            map.put(pair.get(0) , pair.get(1));
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < n){
            if(s.charAt(i) == '('){
                StringBuilder curr = new StringBuilder();
                i++;
                while(i < n && s.charAt(i) != ')') {
                    curr.append(s.charAt(i));
                    i++;
                }

                String key = curr.toString();
                System.out.println(key);

                if(map.containsKey(key)){
                    sb.append(map.get(key));
                } else{
                    sb.append('?');
                }
            } else{
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}