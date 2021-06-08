class Solution {
    public boolean checkValidString(String s) {
        // trick -> this counter will be used for checking final left bracket check to make sure
        //          no extra left bracket after scan done
        int finalLeftCounter = 0;
        // trick -> this counter will be used for checking right bracket to make sure (left bracket + *) are more
        // than right bracket all the time
        int processLeftCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                finalLeftCounter++;
            } else {
                finalLeftCounter--;
            }

            // trick -> special case *************(((((
            //          finalLeftCounter needs to be reset
            //          cos we do not care the previous state
            if (finalLeftCounter < 0) finalLeftCounter = 0;

            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                processLeftCounter++;
            } else {
                processLeftCounter--;
            }

            if (processLeftCounter < 0) {
                return false;
            }
        }

        return finalLeftCounter == 0 ? true : false;
    }
}
