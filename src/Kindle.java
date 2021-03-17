package Interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
Example
Input:
topFeatures = 2
possibleFeatures = ["storage", "battery", "hover", "alexa", "waterproof", "solar"]
featureRequests = ["I wish my Kindle had even more storage!", "I wish the battery life on my Kindle lasted 2 years.",
"I read in the bath and would enjoy a waterproof Kindle", "Waterproof and increased battery are my top two requests",
"I want to take my Kindle into the shower. Waterproof please!",
"It would be neat if my Kindle would hover on my desk when not in use",
"How cool would it be if my Kindle charged in the sun via solar power?"]

Output:
["waterproof", "battery"]
 */
public class Kindle {
    public static void main(String[]args){
        String [] possibleFeatures = { "storage", "battery", "hover", "alexa", "waterproof", "solar" };
        String [] featureRequests = { "I wish my Kindle had even more storage!",
                "I wish the battery life on my Kindle lasted 2 years.",
                "I read in the bath and would enjoy a waterproof Kindle",
                "Waterproof and increased battery are my top two requests",
                "I want to take my Kindle into the shower. Waterproof please!",
                "It would be neat if my Kindle would hover on my desk when not in use",
                "How cool would it be if my Kindle charged in the sun via solar power?" };

        mostPopularFeatures(2, possibleFeatures, featureRequests);
    }
    public static void mostPopularFeatures(int topFeatures, String []  possibleFeatures, String [] featureRequests){
        List<Feature> features = new ArrayList<>();

        for(String featureName : possibleFeatures){
            features.add(new Feature(featureName, 0));
        }

        for(String req : featureRequests){
            for(int i = 0; i < features.size(); i++){
                if(req.contains(features.get(i).name)){
                    features.get(i).occurance += 1;
                }
            }
        }
        Collections.sort(features, Collections.reverseOrder());
        System.out.println(features.get(0).toString() + ", " + features.get(1).toString());
    }
}

class Feature implements Comparable<Feature> {
    String name;
    int occurance;
    public Feature(String name, int occurance){
        this.name = name;
        this.occurance = occurance;
    }

    @Override
    public int compareTo(Feature f2) {
        int result = Integer.compare(occurance, f2.occurance);
        if(result == 0){
            return name.compareTo(f2.name);
        }else{
            return result;
        }
    }

    @Override
    public String toString() {
        return "Feature{" +
                "name='" + name + '\'' +
                ", occurance=" + occurance +
                '}';
    }
}
