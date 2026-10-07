var minAddToMakeValid = function(s) {
    let bal = 0, ans = 0;

    for (const c of s) {
        if (c === '(') {
            bal++;
        } else if (bal > 0) {
            bal--;
        } else {
            ans++;
        }
    }

    return ans + bal;
};