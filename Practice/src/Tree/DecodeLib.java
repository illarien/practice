package Tree;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by пк on 22.06.14.
 */
public class DecodeLib {

    public boolean isnumber (String in) {
        HashSet<String> str = new HashSet<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0"));
        return str.contains(in);
    }

    public String numToLet(String in) {
        String[] alp = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o",
                        "p","q","r","s","t","u","v","w","x","y","z"};
        return alp[Integer.valueOf(in)-1];
    }

    public String rest(int j, String[] s) {
        String out = "";
        for (int i = j+1; i < s.length; i++ ) {
            out += s[i];
        }
        return out;
    }

    public void decodeNode (Node node) {
        int k = node.getNodeKey();
        String[] v = node.getNodeValue().split("");
        String out = "";
        String out2 = "";

        for (int i = 1; i < v.length; i++) {
            if (isnumber(v[i])) {
                out += numToLet(v[i]);
                out += rest(i, v);
                Node newNode = new Node(k+1, out);
                //node.addLeft(newNode);
                decodeNode(node.addLeft(newNode));
                //return;
            } else {
                out += v[i];
            }
            if (i < v.length-1 && isnumber(v[i])&& isnumber(v[i+1]) && Integer.valueOf(v[i]+v[i+1]) < 27) {
                out2 += numToLet(v[i]+v[i+1]);
                out2 += rest(i+1, v);
                Node newNode = new Node(k+1, out2);
                //node.addRight(newNode);
                decodeNode(node.addRight(newNode));
                return;
            } else {
                out2 += v[i];
            }
            if (k > 5) return;
            System.out.println(k);
        }


    }


}
