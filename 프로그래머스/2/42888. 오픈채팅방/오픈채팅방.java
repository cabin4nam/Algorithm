import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    class Result{
        String id;
        String msg;
        
        public Result(String id, String msg){
            this.id = id;
            this.msg = msg;
        }
    }
    
    public String[] solution(String[] record) {
        String[] answer;
        
        HashMap<String, String> names = new HashMap<>();
        ArrayList<Result> result = new ArrayList<>();
        
        for(String command : record){
            if(command.startsWith("Enter")){
                String id = command.split(" ")[1];
                String name = command.split(" ")[2];
                names.put(id, name);
                result.add(new Result(id, "님이 들어왔습니다."));
            }
            else if(command.startsWith("Leave")){
                String id = command.split(" ")[1];
                result.add(new Result(id, "님이 나갔습니다."));
            }
            else if(command.startsWith("Change")){
                String id = command.split(" ")[1];
                String name = command.split(" ")[2];
                names.put(id, name);
            }
        }
        
        answer = new String[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = names.get(result.get(i).id) + result.get(i).msg;
        }
        
        return answer;
    }
}