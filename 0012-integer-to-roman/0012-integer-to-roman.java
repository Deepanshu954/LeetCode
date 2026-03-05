class Solution {
    public String intToRoman(int num) {

        String[][] roman = {
            {"I","V","X"},   // ones
            {"X","L","C"},   // tens
            {"C","D","M"},   // hundreds
            {"M","",""}      // thousands
        };

        int len = (int)Math.log10(num) + 1;
        int place = (int)Math.pow(10, len - 1);

        StringBuilder sb = new StringBuilder();

        while(place > 0) {

            int digit = num / place;
            num %= place;

            int pos = (int)Math.log10(place);

            if(digit <= 3) {
                sb.append(roman[pos][0].repeat(digit));
            }
            else if(digit == 4) {
                sb.append(roman[pos][0]).append(roman[pos][1]);
            }
            else if(digit <= 8) {
                sb.append(roman[pos][1]);
                sb.append(roman[pos][0].repeat(digit - 5));
            }
            else {
                sb.append(roman[pos][0]).append(roman[pos][2]);
            }

            place /= 10;
        }

        return sb.toString();
    }
}