class Solution {
public:
    bool canEat(vector<int>&piles,int x,int h){
        int n=piles.size();
        long long hours=0;
        for(int i=0;i<n;i++){
            hours+=(piles[i]+x-1)/x;
        }
        return hours<=h;
    }
    int minEatingSpeed(vector<int>& piles, int h) {
        int n=piles.size();
        int low=1,high=*max_element(piles.begin(),piles.end());
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canEat(piles,mid,h)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
};