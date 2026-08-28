func compare(tb []byte, sb []byte, b []int, left int)bool{
    b_copy := make([]int,0)
    b_copy = append(b_copy,b ...)
    sb_copy := make([]byte,0)
    sb_copy = append(sb_copy, sb...)
    k := 25
    for left < len(tb){
        if sb_copy[left]!=0{
            if sb_copy[left] > tb[left]{
                return true
            }else if sb_copy[left] < tb[left]{
                return false
            }
            left++
        }else{
            for k>=0 && b_copy[k]==0{
                k--
            }
            sb_copy[left] = byte(k+'a')
            sb_copy[len(sb)-1-left] =  byte(k+'a')
            b_copy[k]-=2
        }
    }
    return false
}
func arrange(sb []byte, left int, b []int){
    k:=0
    for left < len(sb){
        if sb[left] == 0{
            for k<26 && b[k]==0{
                k++
            }
            sb[left] = byte(k+'a')
            sb[len(sb)-1-left] =  byte(k+'a')
            b[k]-=2
        }else{
            return
        }
        left++
    }
}
func lexPalindromicPermutation(s string, t string) string {
    b := make([]int,26)
    sb := make([]byte,len(s))
    tb := []byte(t)
    //checking if we can create the palindrome string from s
    for _,v := range s{
        b[v-'a']++
    }
    for i,v := range b{
        if v%2!=0 && sb[len(s)/2]!=0{
            return ""
        }else if v%2!=0{
            sb[len(s)/2] = byte(i+'a')
            b[i]--
        }
    }
    left := 0
    for left < len(s){
        if sb[left]!=0{
            break
        }else{
            if b[tb[left]-'a']!=0{
                sb[left]= tb[left]
                sb[len(s)-1-left] = tb[left]
                b[tb[left]-'a']-=2
            }
            cmp := compare(tb,sb,b,left+1)
            if !cmp && sb[left]!=0{
                sb[left]= 0
                sb[len(s)-1-left] = 0
                b[tb[left]-'a'] +=2
            }
            if sb[left]==0{
               // fmt.Println(b,string(sb))
                k := tb[left]-'a'+1
                for k<26{
                    if b[k]!=0{
                        break
                    } 
                    k++
                }
                if k==26{
                    return ""
                }
                sb[left]= byte(k+'a')
                sb[len(s)-1-left] = byte(k+'a')
                b[k]-=2
                arrange(sb,left+1,b)
                break
            }
            left ++
        }
    }
    ans:= string(sb)
    if ans<=t{
        return ""
    }
    return ans

}