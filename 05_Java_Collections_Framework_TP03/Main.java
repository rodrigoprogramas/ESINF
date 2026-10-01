package topi127.learn;


import java.util.*;

public class Main {
    public class Message{
        String senderEmail;
        Set<String> recipientlist;
        String text;

        String getSender(){
            return senderEmail;
        }
        
        Set<String> getrecipientlist(){
            return recipientlist;
        }


    }

    public class Server {
        List<Message> Inbox;
        List<Message> Outbox;

        public List<Message> getInbox() {
            return Inbox;
        }

        public List<Message> getOutbox() {
            return Outbox;
        }

        public Map<String, Map<String, Integer>> NumberMessagesSent(){
            Map<String, Map<String,Integer>> m = new HashMap<>();

            fillMap(Inbox,m);
            fillMap(Outbox,m);
            return m;

        }
        public void fillMap(List<Message> l, Map<String, Map<String,Integer>> m){
            for(Message msg: l){
                String sender = msg.getSender();
                m.putIfAbsent(sender,new HashMap<>());
                Set<String> recp = msg.getrecipientlist();
                if(recp!=null){
                    for(String rec: msg.getrecipientlist()){
                        m.get(sender).put(rec,m.get(sender).getOrDefault(rec,0)+1);
                    }
                }
            }

        }
    }

    public static boolean validateTags(String[] tags){
        Stack<String> s = new Stack<>();
        for(String tag: tags){
            if (!tag.startsWith("</")){
                s.push(tag);
            }else{
                if(s.isEmpty() || !(s.pop().equals(tag.replace("/","")))){
                    return false;
                }
            }
        }
        return s.isEmpty();
    }
    public static void main(String[] args) {
        String[] tags = {"<body>", "<h1>", "</h1>", "<p>", "<a>", "</a>", "</p>", "</body>"};
        String[] tagsw1 = {"<body>","<h1>","</h1>","<p>","<a>","</p>","</a>","</p>","<body>"};
        String[] tagsw2 = {"<body>","<h1>","</h1>","<p>","<a>","</a>","</p>"};
        System.out.println("Tags are: " + validateTags(tags));
        System.out.println("Tags are: " + validateTags(tagsw1));
        System.out.println("Tags are: " + validateTags(tagsw2));

    }
}