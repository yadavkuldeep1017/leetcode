class Solution {

    public List<String> solve(int index, String s, Set<String> set) {

        // valid completion
        if(index == s.length()) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        List<String> ans = new ArrayList<>();

        StringBuilder temp = new StringBuilder();

        for(int i = index; i < s.length(); i++) {

            temp.append(s.charAt(i));

            String word = temp.toString();

            if(set.contains(word)) {

                // solve remaining part
                List<String> rest = solve(i + 1, s, set);

                // combine current word with recursive answers
                for(String str : rest) {

                    if(str.equals("")) {
                        ans.add(word);
                    } else {
                        ans.add(word + " " + str);
                    }
                }
            }
        }

        return ans;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        return solve(0, s, new HashSet<>(wordDict));
    }
}