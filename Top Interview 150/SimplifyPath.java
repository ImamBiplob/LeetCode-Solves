import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder res = new StringBuilder();
        String[] p = path.split("/");

        for (int i = 0; i < p.length; i++) {
            if (!s.isEmpty() && p[i].equals(".."))
                s.pop();
            else if (!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
                s.push(p[i]);
        }

        if (s.isEmpty())
            return "/";
        while (!s.isEmpty()) {
            res.insert(0, s.pop()).insert(0, "/");
        }

        return res.toString();
    }

    public String simplifyPathUsingDeque(String path) {
        Deque<String> q = new ArrayDeque<>();

        for (String in : path.split("/")) {
            if (in.length() == 0 || in.equals("."))
                continue;
            else if (in.equals("..")) {
                if (!q.isEmpty())
                    q.removeLast();
            } else {
                q.addLast(in);
            }
        }

        if (q.isEmpty())
            return "/";

        StringBuilder res = new StringBuilder();

        while (!q.isEmpty()) {
            res.append("/").append(q.removeFirst());
        }

        return res.toString();
    }
}
