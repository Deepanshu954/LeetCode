class Solution {
    public List<String> fizzBuzz(int n)
    {
        List<String> arr = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            int val = i + 1;
            if(val % 15 == 0) arr.add("FizzBuzz");
            else if(val % 3 == 0) arr.add("Fizz");
            else if(val % 5 == 0) arr.add("Buzz");
            else
            {
                String str = "" + val;
                arr.add(str);
            }
        }

        return arr;
    }
}